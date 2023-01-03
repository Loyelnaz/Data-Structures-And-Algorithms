### Two Pointers
#### Algorithm:
* Start one pointer at the first index 0 and the other pointer at the last index input.length - 1.
* Use a while loop until the pointers are equal to each other.
* At each iteration of the loop, move the pointers towards each other. This means either increment the pointer that started at the first index, decrement the pointer that started at the last index, or both. Deciding which pointers to move will depend on the problem we are trying to solve.

#### Pseudocode:
````
function fn(arr):
    left = 0
    right = arr.length - 1

    while left < right:
        Do some logic here depending on the problem
        Do some more logic here to decide on one of the following:
            1. left++
            2. right--
            3. Both left++ and right--
````
