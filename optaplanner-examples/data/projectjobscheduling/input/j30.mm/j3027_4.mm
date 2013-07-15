************************************************************************
file with basedata            : mf27_.bas
initial value random generator: 1025255760
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  32
horizon                       :  223
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     30      0       28       26       28
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3          13  19  31
   3        3          3           5  10  12
   4        3          3           7   8  11
   5        3          3           6   8  22
   6        3          1          14
   7        3          3           9  14  16
   8        3          2           9  24
   9        3          1          26
  10        3          3          15  17  18
  11        3          2          20  30
  12        3          2          18  27
  13        3          1          26
  14        3          1          21
  15        3          2          23  24
  16        3          3          25  26  27
  17        3          3          20  21  27
  18        3          2          23  28
  19        3          2          22  30
  20        3          1          24
  21        3          2          23  31
  22        3          1          25
  23        3          2          25  30
  24        3          2          28  31
  25        3          1          29
  26        3          1          29
  27        3          1          28
  28        3          1          29
  29        3          1          32
  30        3          1          32
  31        3          1          32
  32        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     3       7    0    6    0
         2     4       0    2    6    0
         3     9       2    0    0    9
  3      1     4       0    4    6    0
         2     5       2    0    4    0
         3     5       0    4    0    5
  4      1     3       0    2    0    8
         2     8       0    2    0    5
         3     9       0    2    0    4
  5      1     1       8    0    1    0
         2     1       2    0    0    6
         3     2       0    8    0    4
  6      1     4       9    0    0    9
         2     5       9    0    0    5
         3     6       0    8    3    0
  7      1     7       4    0    0    7
         2     8       0    6    0    5
         3     9       3    0    4    0
  8      1     1       0    9    0    6
         2     5       5    0   10    0
         3     5       0    5   10    0
  9      1     7       7    0    0    9
         2     8       3    0    0    9
         3    10       0    7    0    8
 10      1     5       0    5    0   10
         2     5       5    0    4    0
         3     6       5    0    0   10
 11      1     2       9    0    0    9
         2     2       0    9    9    0
         3     6       0    7    0    9
 12      1     3       9    0    0   10
         2     4       0    9    0    9
         3     5       0    7    6    0
 13      1     5       0   10    0    9
         2     8       4    0    4    0
         3     9       1    0    0    4
 14      1     3       0    7    7    0
         2     3       6    0    0    3
         3     4       1    0    7    0
 15      1     7       0    5    0    2
         2     8      10    0    6    0
         3     9      10    0    4    0
 16      1     5       0    4    9    0
         2     6       0    3    0   10
         3     6       0    3    5    0
 17      1     1       0    1    0    5
         2     2       7    0    7    0
         3     4       5    0    7    0
 18      1     8       9    0    0    7
         2    10       9    0    0    4
         3    10       0    8    0    4
 19      1     3       0    4    0    6
         2     8       4    0    0    3
         3     8       0    2    0    4
 20      1     4       0    6    9    0
         2     5       0    4    0    8
         3    10       0    2    6    0
 21      1     1       0    4    0    5
         2     4       0    3    5    0
         3    10       0    2    0    1
 22      1     3       0    9    0    8
         2     4       0    8    3    0
         3     8      10    0    0    4
 23      1     7       9    0    5    0
         2     8       9    0    3    0
         3     9       0    8    0    6
 24      1     2       9    0    3    0
         2     4       0    5    2    0
         3     6       6    0    2    0
 25      1     3       0    3    0    1
         2     3       7    0    9    0
         3     9       5    0    9    0
 26      1     6       5    0    7    0
         2     7       2    0    0   10
         3    10       0    5    6    0
 27      1     1       0    8    0    5
         2     1       0    9    5    0
         3     3       5    0    0    5
 28      1     5       9    0    5    0
         2     6       6    0    0    9
         3     9       0    6    4    0
 29      1     1       0    9    0    8
         2     8       0    2    5    0
         3     9       6    0    0    7
 30      1     2       8    0    3    0
         2     5       6    0    0    2
         3     8       4    0    0    2
 31      1     2       0    8    7    0
         2     6       0    7    0    8
         3    10       6    0    0    7
 32      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   38   39  148  200
************************************************************************