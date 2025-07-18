## Dynamic Programming
* Optimized Recursion - breaking down an optimization problem into simpler sub-problems, and storing the solution to each sub-problem so that each sub-problem is only solved once.
* To avoid repeated computation of state, we use **memoization** i.e., when we find an answer, we cache that using an array (if the range of the state is know) or hashmap. If we need the same state in the future, we can use it from the cache.

### When to use DP?
* The problem will be asking for an optimal value (max or min) of something, or the number of ways to do something. For example:
  * What is the minimum cost of doing ...
  * What is the maximum profit of ...
  * How many ways are there to ...
  * What is the longest possible ...
* At each step, you need to make a "decision", and decisions affect future decisions.
  * A decision could be picking between two elements
  * Decisions affecting future decisions could be something like "if you take this element, then you can't take that element in the future"

### Process to solve a DP problem
* Try to represent the problem in terms of the index
* Perform all the possible operations on that index according to the problem statement
* Sum up all operations (if the question say, count all possible ways) OR take minimum of all operations (if the question asks us to find minimum)

### Top Down vs Bottom Up Approach
#### Top Down (Memoization)
* Implemented using recursion and hash map (or array) for memoization
* We start at the answer, and then move downwards towards the base case
* Easy to write. It can get tricky in the case of problems involving multidimensional
* Example - [Fibonacci using Top Down Approach](FibonacciTopDownApproach.java)
#### Bottom Up (Tabulation)
* Implemented recursively and uses an array
* We start at the base case, and then move upwards towards the answer
* Faster because iteration has less overhead than recursion (can be improved if we use tail recursion)
* Example - [Fibonacci using Bottom Up Approach](FibonacciBottomUpApproach.java)

### Time/Space complexity
#### Time complexity: O(n.k)
where 'n' is the length of the input state, 'k' is the iteration that we may need to do in few of the cases
#### Space complexity: O(n)
where 'n' is the length of the memoization that we would be using, that is, it could be either a hashmap or an array

### Components to create a DP algorithm
* A function or data structure that will compute/contain the answer to the problem for any given state
* A recurrence relation to transition between states
* Base case(s)

### Resources
* https://www.freecodecamp.org/news/demystifying-dynamic-programming-3efafb8d4296

### Problems
* [Distinct ways of climbing stairs](ClimbingStairs.java)
* [Minimum cost climbing stairs](MinimumCostClimbingStairs.java)
* [Minimum path sum](MinimumPathSum.java)
* [House Robber](HouseRobber.java)