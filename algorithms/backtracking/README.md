###Backtracking
* Most common problems that can be solved with this type of algorithm is "find all possible ways to do something"
* This is an optimization on exhaustive search
* Meaning, abondoning (pruning) a path once it is determined that the path doesn't lead to a solution
* This algo usually results in exponential time complexity, hence should be chosen only in the cases when the input size is small, i.e., n <= ~15
* It is better than brute-force as we choose only the solution that matches our criteria

####Implementation
````
// let curr represent the thing you are building
// it could be an array or a combination of variables

function backtrack(curr) {
    if (base case) {
        Increment or add to answer
        return
    }

    for (iterate over input) {
        Modify curr
        backtrack(curr)
        // this line is called backtracking
        Undo whatever modification was done to curr
    }
}
````

#### When to use backtracking?
* While constructing any single possible solution, all paths must be explored. That is, if exploring a certain path results in a deadend, we need to move back one level and explore all the other paths in the solution space.
* The problem requires us to consider all feasible solutions in order to select the best one. Doing so, not a single feasible solution may be ignored. In certain problems, even if some feasible solutions are eventually discarded, we still need to find and evaluate them.
* The problem requires us to compile a list of all feasible solutions.

#### When not to use backtracking?
* The problem structure is such that, while constructing a possible solution, failing to meet the acceptability criteria of the solution eliminates all other possibilities within that solution. So, we don’t need to check those remaining possibilities.
* It is sufficient to construct just one feasible solution to solve the problem.

#### Problems
* [All possible subsets (power set) of array elements](SubsetOfArrayElements.java)
* [All possible permutation of given array elements](PermutationOfArrayElements.java)
* [All paths from source to target node](AllPathsFromSourceToTarget.java)