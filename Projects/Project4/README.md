Project 4
Kennedy Mays
4/27/22

Queue Class
- code dequeue method

Queue Structure
- job -> node -> queue
- each node holds a job item
- a job holds the following info: job identifier, arrival time (int), start time(int), expected execution time(int), job wait time(int), job turnaround time(int)

Operating System (OS) Class
- input queue class variable | to store job blocks before processing
- clock int class variable | starts at 1, simulates clock, increments as needed
- process queue class variable | stores job blocks when the clock reaches their start times
- output queue class variable | stores finished jobs, will be printed at end
- idle int class variable | counts time cpu isn't in use, start at 0
- usage int class variable | counts time cpu is in use, start at 0

Sample Input
name    a  r
Job 01  1  2
Job 02  2  2
Job 03  3  5
Job 04  6  1 
Job 05  8  3
Job 06  11 1
Job 07  15 6

Sample Output
name    a  s  r  w  t
Job 01  1  1  2  0  2
Job 02  2  3  2  1  3
Job 03  3  5  5  2  7
Job 04  6  10 1  4  5
Job 05  8  11 3  3  6
Job 06  11 14 1  3  4
Job 07  15 15 6  0  6

Data
- average wait time is the total wait time divided by the number of jobs
- the cpu percent usage is the usage divided by the total program time
- individual wait times are calculated by substracting arrival time from start time
- turaround time is wait time plus run time
- the start time is the previous job's start time plus run time