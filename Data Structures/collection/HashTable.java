package collection;

import java.util.LinkedList;

/**
 * A Java implementation of Hash Table data structure.
 * with chaining technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashTable {
    private Object[] ht;
    private int size;

    public HashTable(int size) {
        this.ht = new Object[size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            ht[i] = new LinkedList<>();
        }
    }

    public void put(int key, String value) {
        int digest = hash(key);

        cast(ht[digest]).add(value);
    }

    public LinkedList<String> get(int key) {
        int digest = hash(key);

        return cast(ht[digest]);
    }

    public void remove(int key) {
        int digest = hash(key);

        cast(ht[digest]).clear();
    }

    public int hash(int key) {
        return key % size;
    }

    @SuppressWarnings("unchecked")
    private LinkedList<String> cast(Object obj) {
        return (LinkedList<String>) obj;
    }
}