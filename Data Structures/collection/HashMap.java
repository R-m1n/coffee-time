package collection;

/**
 * A Java implementation of Hash Table data structure.
 * with linear probing technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashMap implements Map {

    /**
     * A container for the key-value pair.
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

    private Entry[] entries;
    private int size;

    public HashMap(int size) {
        this.entries = new Entry[size];
        this.size = size;
    }

    /**
     * Add a key-value pair in the hash table.
     * 
     * @param key
     * @param value
     */
    public void put(int key, String value) {
        var entry = getEntry(key);

        if (entry != null) {
            entry.setValue(value);
            return;
        }

        entries[getIndex(key)] = new Entry(key, value);
    }

    /**
     * @param key
     * @return the value stored with the key, null if not found.
     */
    public String get(int key) {
        return getEntry(key) == null ? null : getEntry(key).getValue();
    }

    /**
     * @param key
     * @param defaultValue
     * @return the value stored with the key, defaultValue if not found.
     */
    public String get(int key, String defaultValue) {
        return getEntry(key) == null ? defaultValue : getEntry(key).getValue();
    }

    /**
     * Remove the key-value pair from the hash table.
     * 
     * @param key
     */
    public void remove(int key) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                continue;
            }

            if (entries[i].getKey() == key) {
                entries[i] = null;
                return;
            }
        }
    }

    /**
     * @param key
     * @return hash value of key.
     */
    private int hash(int key) {
        return key % size;
    }

    /**
     * @param key
     * @param step
     * @return linear probing value of a step.
     */
    private int probe(int key, int step) {
        return (hash(key) + step) % size;
    }

    /**
     * @param key
     * @return entry, null if not found.
     */
    private Entry getEntry(int key) {
        for (Entry entry : entries) {
            if (entry == null)
                continue;

            if (entry.getKey() == key) {
                return entry;
            }
        }

        return null;
    }

    /**
     * @param key
     * @throws IllegalStateException if there's no empty slots in the hash table.
     * @return index of an empty slot in the hash table.
     */
    private int getIndex(int key) {
        var index = hash(key);
        var step = 1;

        while (entries[index] != null) {
            if (step == size)
                throw new IllegalStateException();

            index = probe(key, step++);
        }

        return index;
    }
}
