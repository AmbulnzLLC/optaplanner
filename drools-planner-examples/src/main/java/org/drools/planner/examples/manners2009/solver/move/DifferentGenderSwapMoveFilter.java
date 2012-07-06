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

package org.drools.planner.examples.manners2009.solver.move;

import org.drools.planner.core.heuristic.selector.common.decorator.SelectionFilter;
import org.drools.planner.core.move.generic.GenericSwapMove;
import org.drools.planner.core.score.director.ScoreDirector;
import org.drools.planner.examples.manners2009.domain.SeatDesignation;

public class DifferentGenderSwapMoveFilter implements SelectionFilter<GenericSwapMove> {

    public boolean accept(ScoreDirector scoreDirector, GenericSwapMove move) {
        SeatDesignation leftSeatDesignation = (SeatDesignation) move.getLeftPlanningEntity();
        SeatDesignation rightSeatDesignation = (SeatDesignation) move.getRightPlanningEntity();
        return leftSeatDesignation.getGuest().getGender()
                == rightSeatDesignation.getGuest().getGender();
    }

}
