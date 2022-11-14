package src.main.java.com.datastructures.linear.collection;

/**
 * A Java implementation of Hash Table data structure.
 * with linear probing technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashMap<K, V> implements Map<K, V> {
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

    private Array<Entry> entries;

    public HashMap(int size) {
        entries = new Array<>(size);
    }

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

        entries.insertAt(new Entry(key, value), getIndex(key));
    }

    /**
     * @param key
     * @return the value stored with the key, null if not found.
     */
    public V get(K key) {
        return getEntry(key) == null ? null : getEntry(key).value;
    }

    /**
     * @param key
     * @param defaultValue
     * @return the value stored with the key, defaultValue if not found.
     */
    public V get(K key, V defaultValue) {
        return getEntry(key) == null ? defaultValue : getEntry(key).value;
    }

    /**
     * Remove the key-value pair from the hash table.
     * 
     * @param key
     */
    public void remove(K key) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i) == null)
                continue;

            if (entries.get(i).key == key) {
                entries.insertAt(null, i);
                return;
            }
        }
    }

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
     * @param step
     * @return linear probing value of a step.
     */
    private int probe(K key, int step) {
        return (hash(key) + step) % entries.size();
    }

    /**
     * @param key
     * @return entry, null if not found.
     */
    private Entry getEntry(K key) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i) == null)
                continue;

            if (entries.get(i).key == key)
                return entries.get(i);
        }

        return null;
    }

    /**
     * @param key
     * @return index of an empty slot in the hash table.
     */
    private int getIndex(K key) {
        var index = hash(key);
        var step = 1;

        while (entries.get(index) != null) {
            if (step == entries.size())
                throw new IllegalStateException("There's no empty slot in the hash table.");

            index = probe(key, step++);
        }

        return index;
    }
}
