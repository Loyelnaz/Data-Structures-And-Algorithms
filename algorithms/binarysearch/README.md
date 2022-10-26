## Binary Search
* Is a search algorithm that runs in O(logn) in the worst case.
* Base condition for this algorithm is that the array should be in a **sorted order**. There are a few variations that work on unsorted arrays too.
* Approach:
  * Declare **left = 0** and **right = arr.length - 1**
  * while **left <= right**
    * We calculate the middle element i.e. **mid = (left + right) / 2**
    * If the current element matches the search element, we have found the element we were looking for.
    * If the element to be searched is lesser than **arr[mid]** then we move to the left, that is, **right = mid - 1**
    * If it is greater than **arr[mid]**, we move to the right, that is, **left = mid + 1**
  * If we reach till here, and haven't found the element, then our search is unsuccessful

### Modified Binary Search
````
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] < key) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
````

### When to use this pattern?
* The problem requires us to find a target value (or its first or last occurrence) in a sorted list, or in a sequential range.
* We may use this pattern when portions of an input list are sorted, even if the whole list does not seem to be sorted. For example, an array has two different sorted sections.
* We are searching for a particular value in the data.

### Implementation
* [Binary Search](BinarySearch.java)
* [Modified Binary Search](LeftmostBinarySearch.java)

### Problems
* [First and last position of an element](FirstAndLastPositionOfElement.java)
* [Search Insert Position of an element](SearchInsertPosition.java)
* [Search element in sorted rotated array](SearchInSortedRotatedArray.java)
