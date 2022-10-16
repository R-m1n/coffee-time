package collection;

import java.util.LinkedList;

/**
 * A Java implementation of Hash Table data structure.
 * with chaining technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashTable implements Map {

    /**
     * A container for holding the key - value pair.
     */
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    private LinkedList<Entry>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.entries = new LinkedList[size];
        this.size = size;
    }

    public void put(int key, String value) {
        var entry = getEntry(key);

        if (entry != null) {
            entry.setValue(value);
            return;
        }

        initNullBucket(key);
        getBucket(key).add(new Entry(key, value));
    }

    public String get(int key) {
        return (getEntry(key) == null) ? null : getEntry(key).getValue();
    }

    public String get(int key, String defaulValue) {
        return (getEntry(key) == null) ? defaulValue : getEntry(key).getValue();
    }

    public void remove(int key) {
        var entry = getEntry(key);

        if (entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    private int hash(int key) {
        return Math.abs(key) % size;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);

        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.getKey() == key)
                    return entry;
            }
        }

        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private void initNullBucket(int key) {
        int index = hash(key);

        if (entries[index] == null)
            entries[index] = new LinkedList<>();
    }
}