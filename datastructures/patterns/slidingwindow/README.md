Like two pointers, sliding windows work the same with arrays and strings - the important thing is that they're iterables with ordered elements.

The idea behind the sliding window technique is to efficiently find the "best" window that fits some constraint. Usually, the problem description will define what makes a window "better" (shorter length, larger sum etc.) and the constraint. Imagine that a problem wanted the length of the longest subarray with a sum less than or equal to k for an array with positive numbers. In this case, the constraint is sum(window) <= k, and the longer the window, the better it is. The general algorithm behind sliding window is:

* Define a pointer for the left and right bound that represents the current window, usually both of them starting at 0.
* Iterate over the array with the right bound to "add" elements to the window.
* Whenever the constraint is broken, in this example if the sum of the window exceeds k, then "remove" elements from the window by incrementing the left bound until the condition is satisfied again.

function fn(arr):
left = 0
for right in [0, arr.length - 1]:
while left < right AND condition from problem not met:
Do some logic to "remove" element at arr[left] from window
left++
Do some logic to "add" element at arr[right] to window
