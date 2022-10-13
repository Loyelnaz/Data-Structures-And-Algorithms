#Hashing

##Need for HashMap
We know that arrays have O(1) random access, but the main constraint with the arrays is their fixed size and their indices have to be integers.

With Hashmap, we can have keys has any data type or object, given the key is immutable in nature.

A hash map is an unordered data structure (insertion order is not relevant) that stores key-value pairs. A hash map can add and remove elements in O(1), as well as update values associated with a key and check if a key exists, also in O(1). 

##Disadvantages of HashMap
* For smaller input sizes, the map could be slower because of the overhead. Though the operation are done in O(1), it might be deceiving as every key needs to go over the hash function, resolve any collisions before getting to the key stored or add the key.
* Hash tables are implemented using fixed-sized array, so resizing would be expensive as every key need to be re-hashed.
* If the number of elements to be stored do not match with the total size, we may end up wasting additional space.

##Collision
Without handling collisions, older keys will get overridden and data will be lost. One of the ways we could use to handle collision is through chaining.

In chaining, we store linked list nodes inside the array instead of the elements themselves. The linked list nodes store both the key and the value. 
If there are collisions, the collided key-value pairs are linked together in a linked list. Then, when trying to access one of these key-value pairs, we traverse through the linked list until the key matches.

```
class LinkedList {
    key
    value
    next
}

// Hash function converts "foo" into an integer index
x = hash("foo")
xValue = "bar"

// arr is our array
arr = [...]

if arr[x] == null:
    arr[x] = LinkedList(x, xValue, null)
else:
    curr = arr[x]
    // Traverse to the end of the linked list
    while curr.next != null:
        curr = curr.next
    curr.next = LinkedList(x, xValue)

// When we have a collision, we chain a new node to the end
// When we want to access elements, we go through the linked list
// until the keys match
```

##Set
* Implemented similar to hash tables
* Does not map it's key with anything i.e., one cannot use this to have key mapped to a value
* Does not add duplicates into the data structure
* Commonly used to check the existence of an element

