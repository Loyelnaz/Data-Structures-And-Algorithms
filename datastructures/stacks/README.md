### Stack
* Termed as LIFO, which stands for <b>Last In, First Out.</b>
* Add and remove elements from the <b>same end</b>
* It is an abstract data structure, so it can be implemented with a dynamic array
* Following operations are possible on stack:
  * pop() - remove the top item from the stack
  * push(item) - add an item to the top of the stack
  * peek() - return the top of the stack
  * isEmpty() - return true if and only if the stack is empty
* All the above operations are done in O(1) complexity
* Searching an item in the stack would take O(n) complexity
* Example - UNDO option in many applications. We store the previous state of our work in such a way that last one appears first
* Other use case:
  * To backtrack to the previous task/state (Ex: recursion)
  * To store a partially completed task (Ex: when exploring two different paths on a Graph from a point while calculating the smallest path to the target)

#### Implementation
* [Stack implementation using custom data structure](StackImpl.java)
* [Stack implementation using array](StackImplUsingArray.java)

#### Problems
* [Valid Parentheses](ValidParentheses.java)
* [Remove All Adjacent Duplicates](RemoveAllAdjacentDuplicatesInString.java)
* [Backspace String Compare](BackspaceStringCompare.java)