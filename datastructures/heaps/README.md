# Heap
* A specialized tree-based data structure which is an almost complete tree (filled completely) that satisfies the heap property. 
* In a max heap, for any given node C, if P is a parent node of C, then the key (the value) of P is greater than or equal to the key of C.
* Are implemented using Arrays, where element of the array corresponds to a node in the binary tree, and the value inside the node is called a "key"
* Elements of heap are not sorted - instead it holds largest or smallest element at the parent (root) node.

A priority queue is an abstract data structure and a heap is an implementation.

Java priority queue implements a min heap by default.

A heap supports the following operations:
* Add an element in O(logn)
* Remove the min element in O(logn)
* Find the min element in O(1)

### Min Heap
* Root node keys must be greater than or equal to their child node keys

### Max Heap
* Root node keys are less than or equal to their child node keys
* Create a heap
  * Initially, all elements are placed in the nodes in the same order as in the array
  * We then start the comparison from bottom-up i.e. last parent node (n/2th element) is compared with its child nodes to check max heap property
* Insertion in max-heap:
  * Create a new child node at the end of the heap.
  * Place the new key at that node.
  * Compare the value with its parent node key.
  * If the key is greater than the key at the parent node, swap values.
  * If both keys at the children nodes are greater than the parent node key, pick the larger one and see if the Heap property is satisfied.
  * Repeat until you reach the root node.
* Deletion from the heap - It is done to remove the largest element from the heap.
  * Delete the root node
  * Move the key of the last child node at the last level to the root
  * Now compare the key with its children
  * If the key is smaller than the key at any of the child nodes, swap values
  * If both keys at the children nodes are greater than the parent node key, pick the larger one and see if the heap property is satisfied
  * Repeat until you reach the last level

### Heap Implementation
* The implementation of the tree itself typically uses an array, and the parent-child relationships are done using math with the indices. 
* The first element at index 0 is the root, then the elements at indices 1 and 2 are the root's children, the elements at indices 3 and 4 are the children of the element at index 1 and the elements at indices 5 and 6 are the children of the element at index 2, and so on. 
* If a node is at index i, then its children will be at indices 2i + 1 and 2i + 2. 
* The contents of a heap with n nodes are stored in such a way that all the parent nodes occur in the first half of array (n/2), while the leaves are present at the last n/2 positions. So the last parent will be at the n/2th position.
* When elements are added or removed, operations are done to maintain the aforementioned property of parent.val <= child.val. 
* The number of operations needed scales logarithmically with the number of elements in the heap.

### Use case
* Order statistics - efficiently finding the largest or smallest element in an array
* Priority Queue - supports operations like insert()/delete() in O(logn). This is also used in Prim's/Dijistra's algorithm
* Sorting (Heap sort) - sorts the data exactly the same way as TreeSort

### Implementation
* [Heap](Heap.java)

### Problems

