package collection;

import java.util.LinkedList;

/**
 * A Java implementation of Hash Table data structure.
 * with chaining technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashTable {

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
    }

    private LinkedList<Entry>[] ht;
    private Entry entry;
    private int size;
    private int digest;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.ht = new LinkedList[size];
        this.size = size;
    }

    public void put(int key, String value) {
        entry = new Entry(key, value);
        digest = this.hash(key);

        if (ht[digest] == null)
            ht[digest] = new LinkedList<>();

        ht[digest].add(entry);
    }

    public String get(int key) {
        digest = this.hash(key);

        if (ht[digest] != null)
            for (Entry entry : ht[digest]) {
                if (entry.getKey() == key)
                    return entry.getValue();
            }

        return "";
    }

    public String remove(int key) {
        String value = "";
        digest = this.hash(key);

        for (Entry entry : ht[digest]) {
            if (entry.getKey() == key) {
                value = entry.getValue();
                ht[digest].remove(entry);
            }
        }

        return value;
    }

    public int hash(int key) {
        return key % size;
    }

}