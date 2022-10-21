## Hashing

### Need for HashMap
We know that arrays have O(1) random access, but the main constraint with the arrays is their fixed size and their indices have to be integers.

With Hashmap, we can have keys as any data type or object, given the key is immutable in nature.

A hash map is an unordered data structure (insertion order is not relevant) that stores key-value pairs. A hash map can add and remove elements in O(1), as well as update values associated with a key and check if a key exists, also in O(1). 

### Performance of hash data structure depends on:
* Hash Function - transforms a **key** into an **index** in the array
* Size of the hash table
* Collision Handling method
### Commonly used hash function:
* Arithmetic modular - take mod of the key with the size of an array
  ````
  index = key % arraySize
  ````
* Truncation - select a part of the key, instead of whole key. It could be done through modular approach too
  ````
  key = 123456, index could be 234
  ````
* Folding - divide the key into smaller chunks and apply certain strategies at each chunk
  ````
  key = 123456, index = 12+34+56 = 102
  ````

### Disadvantages of HashMap
* For smaller input sizes, the map could be slower because of the overhead. Though the operation are done in O(1), it might be deceiving as every key needs to go over the hash function, resolve any collisions before getting to the key stored or add the key.
* Hash tables are implemented using fixed-sized array, so resizing would be expensive as every key need to be re-hashed.
* If the number of elements to be stored do not match with the total size, we may end up wasting additional space.

### Complexity
For search, insertion, and deletion of an element:
* Average case - O(1)
* Worst case - O(n), assuming all the entries are under the same index, and key is the last node in the list

### Collision
The hash function might return the same index for multiple different keys causing a collision.

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

#### Other ways of resolving collisions are:
* Linear Probing (keep checking until it finds an empty slot)
* Resize the array
* Quadratic probing
* Random probing
* Bucket method
* Re-hashing the key

### When to use Trie data structure?
* If we need a fast lookup
* Have long words that share common prefix

### Trie vs HashTable
#### Common Prefix
* Irrespective of the prefix between the two elements, hashtable would store them at different locations
* In tries, the common prefix would have the same path. After the prefix, these are divided into different branches
* For example, "study" and "studying"
  * Hashtable - these would be stored in different locations
  * Trie - common nodes for "study", and "ing" would be stored in three additional nodes making it space efficient

#### Lookup for exact words
* Hashtable - can only find a exact word
* Trie - we can do spell-check easily

#### No re-hashing required
* Hashtable - re-hashing is required to generate an index
* Trie - just traverses the nodes and inserts the new node

#### Collision Resolution
* There's no collision in terms of Trie as all words act like a "key"

#### Memory Requirement
* In the average case scenario, hashtable comes handy as in Trie, we would always require to allocate 26 pointers at every node even if most of them would be null.
* In the worst case, Trie works well as it would utilize it's pointers well

### HashSet vs HashMap
#### HashMap
* Implemented using Map interface
* Stores key-value pairs
* Cannot have duplicate keys, but can have duplicate values
* Allows only one null key, and multiple null values

#### HashSet
* Implemented using Set interface, built similar to HashMap using HashTable class.
* The value of the set is added into the HashMap as a key corresponding to a dummy value object
* Stores only the values, and not key-value pairs
* No duplicate values
* Only one null value is permitted to store

