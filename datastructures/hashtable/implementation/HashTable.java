package datastructures.hashtable.implementation;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable() {
        bucket = new ArrayList<>();
        slots = 10;
        size = 0;

        for (int i = 0; i < slots; i++) {
            bucket.add(null);
        }
    }

    /**
     * This method inserts the key and value into the hashmap.
     * If the key is already present, we simply replace the value
     */
    public void put(String key, int value) {
        int index = getIndex(key);
        HashEntry head = bucket.get(index);

        while (head != null) {
            // If the key is already present in the bucket,
            // replace the value, and return
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        // since we did not find the key, we start again from the head node
        head = bucket.get(index);
        HashEntry newSlot = new HashEntry(key, value);
        // we append the new node to the head of the list
        newSlot.next = head;
        // replace the pointer with the new node created
        bucket.set(index, newSlot);

        // If the array gets 60% filled, we create a new array with more slots
        if (size / slots >= 0.6) {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2 * slots;
            size = 0;

            for (int i = 0; i < slots; i++) {
                bucket.add(null);
            }

            // loop through original bucket, and copy over each entry into the new bucket
            for (HashEntry headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    /**
     * Search for a given key in the hashmap. If the element is present, return the value.
     * Otherwise, return null.
     */
    public Integer get(String key) {
        // find the index based on the key
        int index = getIndex(key);
        // get the head node of the bucket
        HashEntry head = bucket.get(index);

        while (head != null) {
            // check if the element is present
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    /**
     * Removes a key from the hashmap, if the match is found.
     */
    public Integer remove(String key) {
        int index = getIndex(key);
        HashEntry head = bucket.get(index);

        // to delete a node, keep track of previous node
        HashEntry previous = null;
        while (head != null) {
            // If a match is found, we break out of the loop
            if (head.key.equals(key)) {
                break;
            }
            previous = head;
            head = head.next;
        }

        // If head is null, it either could be the first node being null or
        // we did not find any match, hence we are passed the last node
        if (head == null) {
            return null;
        }
        // since we are removing the entry, we decrement the size
        size--;

        // If previous is not null, either the key is found or we are at the last node
        if (previous != null) {
            previous = head.next;
        } else {
            // if key is found at the head node, we reset the pointer to next of head.
            // This would remove the head node from the list
            bucket.set(index, head.next);
        }

        return head.value;
    }

    private int getIndex(String key) {
        int hashcode = key.hashCode();
        int index = hashcode % slots;

        // For larger strings, there's a chance of having larger hashcode
        // which could go beyond the 32-bit integer limit.
        // Due to integer overflow, the hashcode might come out as negative
        if (index < 0) {
            index = (index + slots) % slots;
        }
        return index;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
