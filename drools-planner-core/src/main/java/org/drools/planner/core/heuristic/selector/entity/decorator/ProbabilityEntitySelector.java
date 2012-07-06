/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.planner.core.heuristic.selector.entity.decorator;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.drools.planner.core.domain.entity.PlanningEntityDescriptor;
import org.drools.planner.core.heuristic.selector.common.SelectionCacheLifecycleBridge;
import org.drools.planner.core.heuristic.selector.common.SelectionCacheLifecycleListener;
import org.drools.planner.core.heuristic.selector.common.SelectionCacheType;
import org.drools.planner.core.heuristic.selector.common.decorator.SelectionProbabilityWeightFactory;
import org.drools.planner.core.heuristic.selector.entity.AbstractEntitySelector;
import org.drools.planner.core.heuristic.selector.entity.EntitySelector;
import org.drools.planner.core.solution.Solution;
import org.drools.planner.core.solver.DefaultSolverScope;
import org.drools.planner.core.util.RandomUtils;

public class ProbabilityEntitySelector extends AbstractEntitySelector implements SelectionCacheLifecycleListener {

    protected final EntitySelector childEntitySelector;
    protected final SelectionCacheType cacheType;
    protected final SelectionProbabilityWeightFactory entityProbabilityWeightFactory;

    protected NavigableMap<Double, Object> cachedEntityMap = null;
    protected double probabilityWeightTotal = -1.0;

    public ProbabilityEntitySelector(EntitySelector childEntitySelector, SelectionCacheType cacheType,
            SelectionProbabilityWeightFactory entityProbabilityWeightFactory) {
        this.childEntitySelector = childEntitySelector;
        this.cacheType = cacheType;
        this.entityProbabilityWeightFactory = entityProbabilityWeightFactory;
        if (childEntitySelector.isNeverEnding()) {
            throw new IllegalStateException("The childEntitySelector (" + childEntitySelector + ") has neverEnding ("
                    + childEntitySelector.isNeverEnding() + ") on a class (" + getClass().getName() + ") instance.");
        }
        solverPhaseLifecycleSupport.addEventListener(childEntitySelector);
        if (cacheType.isNotCached()) {
            throw new IllegalArgumentException("The cacheType (" + cacheType
                    + ") is not supported on the class (" + getClass().getName() + ").");
        }
        solverPhaseLifecycleSupport.addEventListener(new SelectionCacheLifecycleBridge(cacheType, this));
    }

    // ************************************************************************
    // Worker methods
    // ************************************************************************

    public void constructCache(DefaultSolverScope solverScope) {
        cachedEntityMap = new TreeMap<Double, Object>();
        Solution solution = solverScope.getWorkingSolution();
        double probabilityWeightOffset = 0L;
        for (Object entity : childEntitySelector) {
            double probabilityWeight = entityProbabilityWeightFactory.createProbabilityWeight(
                    solution, entity);
            cachedEntityMap.put(probabilityWeightOffset, entity);
            probabilityWeightOffset += probabilityWeight;
        }
        probabilityWeightTotal = probabilityWeightOffset;
    }

    public void disposeCache(DefaultSolverScope solverScope) {
        probabilityWeightTotal = -1.0;
    }

    public PlanningEntityDescriptor getEntityDescriptor() {
        return childEntitySelector.getEntityDescriptor();
    }

    public boolean isContinuous() {
        return false;
    }

    public boolean isNeverEnding() {
        return false;
    }

    public long getSize() {
        return cachedEntityMap.size();
    }

    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            public boolean hasNext() {
                return true;
            }

            public Object next() {
                double randomOffset = RandomUtils.nextDouble(workingRandom, probabilityWeightTotal);
                Map.Entry<Double, Object> entry = cachedEntityMap.floorEntry(randomOffset);
                // entry is never null because randomOffset < probabilityWeightTotal
                return entry.getValue();
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove is not supported.");
            }
        };
    }

    @Override
    public String toString() {
        return "Probability(" + childEntitySelector + ")";
    }

}
