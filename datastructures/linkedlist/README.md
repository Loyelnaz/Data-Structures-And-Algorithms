## Linked List 

### Arrays vs Linked List
* Memory Allocation
  * For arrays, a block of memory (contiguous) is allocated when instantiated
  * For LL, a portion of memory is allocated based on the Node being created
* Insertion and Deletion
  * Insert at head, LL takes O(1), but arrays take O(n), since in arrays, you would have to shift the elements from left to right
  * Insert or delete from tail, both would take O(n)
* Searching
  * In arrays, it takes constant time to access an element, but LL might take O(n) in the worst case scenario

### Singly Linked List
* Each node holds data, and a pointer to the next node

````
//Class node having Generic data-type <T>
public class Node<T> {
  public T data; //Data to store (could be int, string, Object etc)
  public Node nextNode; //Pointer to next node in list
}
````
#### Use case:
* Implementing HashMaps, File System and Adjacency Lists
* Dynamic memory allocation: We use linked lists of free blocks
* Performing arithmetic operations on long integers
* Maintaining a directory of names

### Doubly Linked List
* Bi-directional - can be traversed forward as well as in backward direction

````
//Node inner class for DLL
public class Node<T> {
    public T data; //Stores data
    public Node nextNode; //Stores pointer to next element
    public Node prevNode; //Stores pointer to previous element
}
````

### Implementation
* [Singly Linked List](DoublyLinkedList.java)
* [Doubly Linked List](DoublyLinkedList.java)

### Problems
#### Singly Linked List
* [Reverse a linked list](ReverseLinkedList.java)
* [Find nth element from the end of the linked list](NthElementFromEnd.java)
#### Doubly Linked List
* [Check Palindrome](PalindromeInDoublyLinkedList.java)