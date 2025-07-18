### Queue
* Follows FIFO (First In, First Out). That means, elements are added (rear) at one end and removed (front) from the other
* Queue can be implemented using an array, linked list or stack
* When dynamic array is used, adding or removing an element from the front of the queue are going to be O(n)
* We can use deque (double ended queue) which reduces the complexity to O(1)
* Following operations are possible on stack:
    * enqueue() - Inserts element to the end of the queue
    * dequeue(item) - Removes an element from the start of the queue
    * top() - Returns the first element of the queue
    * isEmpty() - Checks if the queue is empty
* Types of Queues:
  * Linear Queue
  * Circular Queue
  * Priority Queue
* Circular Queue:
  * Similar to linear queue, but with an exception that both ends are connected to form a circle.
  * Use case - Event Handling (Ex: Disruptor Queue)
* Priority Queue:
  * Elements are sorted in a specific order
  * Most prioritized element comes in the front of the queue
  * Use case - in an operating system to determine which programs should be given more priority.

#### Use Case:
* In routers - to store the packets 
* Priority Queue - allows operating system to switch between processes
* Messaging queue (Ex: Kafka) - messages are stored in the order they arrive

#### Implementation
* [Queue implementation using array](QueueImplUsingArray.java)

#### Problems
* [Number of Recent Calls](NumberOfRecentCalls.java)
* [Generate Binary Numbers from 1 to any given number N](GenerateBinaryNumbers.java)