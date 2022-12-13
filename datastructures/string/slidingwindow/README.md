### Sliding Window
#### Below is the algorithm for a sliding window problem:
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