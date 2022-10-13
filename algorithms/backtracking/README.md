###Backtracking
* Most common problems that can be solved with this type of algorithm is "find all possible ways to do something"
* This is an optimization on exhaustive search
* Meaning, abondoning (pruning) a path once it is determined that the path doesn't lead to a solution
* This algo usually results in exponential time complexity, hence should be choosen only in the cases when the input size is small, i.e., n <= ~15

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

