Approach 1:
* Start one pointer at the first index 0 and the other pointer at the last index input.length - 1.
* Use a while loop until the pointers are equal to each other.
* At each iteration of the loop, move the pointers towards each other. This means either increment the pointer that started at the first index, decrement the pointer that started at the last index, or both. Deciding which pointers to move will depend on the problem we are trying to solve.

Pseudocode:
    function fn(arr):
    left = 0
    right = arr.length - 1

    while left < right:
        Do some logic here depending on the problem
        Do some more logic here to decide on one of the following:
            1. left++
            2. right--
            3. Both left++ and right--

The strength of this technique is that we will never have more than O(n) iterations for the while loop. Therefore, if we can keep the work inside each iteration at O(1), this technique will result in a linear runtime.

Approach 2: The following method is applicable when the problem has two iterables in the input, for example, two arrays.
* Create two pointers, one for each iterable. Each pointer should start at the first index.
* Use a while loop until one of the pointers reaches the end of its iterable.
* At each iteration of the loop, move the pointers forwards. This means incrementing either one of the pointers or both of the pointers. Deciding which pointers to move will depend on the problem we are trying to solve.
  Because our while loop will stop when one of the pointers reaches the end, the other pointer will not be at the end when the loop finishes. Sometimes, we need to iterate through all elements - if this is the case, you will need to write extra code here to make sure both iterables are exhausted.

Pseudocode:
    function fn(arr1, arr2):
    i = j = 0
    while i < arr1.length AND j < arr2.length:
        Do some logic here depending on the problem
        Do some more logic here to decide on one of the following:
          1. i++
          1. j++
          2. Both i++ and j++

             // Step 4: make sure both iterables are exhausted
             while i < arr1.length:
                 Do some logic here depending on the problem
                 i++

             while j < arr2.length:
                 Do some logic here depending on the problem
                 j++

Similar to the first method we looked at, this method will have a linear time complexity of O(n + m), where n = arr1.length and m = arr2.length if the work inside the while loop is O(1).