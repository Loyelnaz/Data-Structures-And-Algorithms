### Sliding Window
####Subarray
* A contiguous section of the array. 
* All the elements must be adjacent to each other in the original array and in their original order.
* SW can be applied on problems asking for valid subarray or longest subarray
  * Find the longest subarray with a sum less than or equal to k (constraint metric = sum)
  * Find the longest substring that has at most one "0" (constraint metric = number of zeroes)
  * Find the number of subarrays that have a product less than k (constraint metric = product)

#### Algorithm for a sliding window problem having variable window size:
* Define a pointer for the left and right bound that represents the current window, usually both of them starting at 0.
* Iterate over the array with the right bound to "add" elements to the window.
* Whenever the constraint is broken, then "remove" elements from the window by incrementing the left bound until the condition is satisfied again.

#### Pseudocode
````
function fn(arr):
left = 0
for right in [0, arr.length - 1]:
    Do some logic to "add" element at arr[right] to window

    while left < right AND condition from problem not met:
        Do some logic to "remove" element at arr[left] from window
        left++

    Do some logic to update the answer
````

#### Algorithm for a sliding window problem having fixed window size:
To build the initial window (from index 0 to k - 1), you can either build it outside of the main loop or you can factor the logic inside your main loop to only consider the window for the answer once it reaches size k.

#### Pseudocode:
````
// first approach
function fn(arr, k):
    curr = some data type to track the window

    // build the first window
    for i in [0, k - 1]:
        Do something with curr or other variables to build first window

    ans = answer variable, might be equal to curr here depending on the problem
    for i in [k, arr.length - 1]:
        Add arr[i] to window
        Remove arr[i - k] from window
        Update ans

    return ans

// second approach
function fn(arr, k):
    curr = some data type to track the window
    ans = answer variable
    for i in range(len(arr)):
        if i >= k:
            Update ans
            Remove arr[i - k] from window
        Add arr[i] to window

    Update ans    
    return ans // Alternatively, you could do something like return max(ans, curr) if the problem is asking for a maximum value and curr is tracking that.
````

### Problems
1. [Longest Subarray Sum Less Than K](LongestSubarraySumLessThanK.java)
2. [Longest Substring After At Most One Operation](LongestSubstringAfterAtMostOneOperation.java)
3. [Number Of Subarray Product Less Than K](NumberOfSubarrayProductLessThanK.java)