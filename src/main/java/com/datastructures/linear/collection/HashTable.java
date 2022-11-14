package src.main.java.com.datastructures.linear.collection;

import java.util.LinkedList;

/**
 * A Java implementation of Hash Table data structure.
 * with chaining technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashTable<K, V> implements Map<K, V> {
    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Array<LinkedList<Entry>> entries = new Array<>();

    /**
     * Add a key-value pair in the hash table.
     * 
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        var entry = getEntry(key);

        if (entry != null) {
            entry.setValue(value);
            return;
        }

        initNullBucket(key);
        getBucket(key).add(new Entry(key, value));
    }

    /**
     * @param key
     * @return the value stored with the key, null if not found.
     */
    public V get(K key) {
        return (getEntry(key) == null) ? null : getEntry(key).value;
    }

    /**
     * @param key
     * @param defaultValue
     * @return the value stored with the key, defaultValue if not found.
     */
    public V get(K key, V defaulValue) {
        return (getEntry(key) == null) ? defaulValue : getEntry(key).value;
    }

    /**
     * Remove the key-value pair from the hash table.
     * 
     * @param key
     */
    public void remove(K key) {
        var entry = getEntry(key);

        if (entry == null)
            return;

        getBucket(key).remove(entry);
    }

    /**
     * @param key
     * @return true if hashtable contains key, else false.
     */
    public boolean contains(K key) {
        return getEntry(key) != null;
    }

    /**
     * @param key
     * @return hash value of key.
     */
    private int hash(K key) {
        return key.hashCode() % entries.size();
    }

    /**
     * @param key
     * @return entry, null if not found.
     */
    private Entry getEntry(K key) {
        var bucket = getBucket(key);

        if (bucket != null)
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry;

        return null;
    }

    /**
     * @param key
     * @return bucket, null if not initialized.
     */
    private LinkedList<Entry> getBucket(K key) {
        return entries.get(hash(key));
    }

    /**
     * Initialize a bucket if null.
     * 
     * @param key
     */
    private void initNullBucket(K key) {
        int index = hash(key);

        if (entries.get(index) == null)
            entries.insertAt(new LinkedList<>(), index);
    }
}