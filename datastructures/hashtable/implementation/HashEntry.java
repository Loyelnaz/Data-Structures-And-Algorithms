package datastructures.hashtable.implementation;

public class HashEntry {
    protected String key;
    protected int value;

    protected HashEntry next;

    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
