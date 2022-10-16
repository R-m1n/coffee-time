package collection;

/**
 * A Java implementation of Hash Table data structure.
 * with linear probing technique to handle collision.
 * 
 * @author R-m1n
 */
public class HashMap implements Map {
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

    public void put(int key, String value) {
        var entry = getEntry(key);

        if (entry != null) {
            entry.setValue(value);
            return;
        }

        entries[getIndex(key)] = new Entry(key, value);
    }

    public String get(int key) {
        return getEntry(key) == null ? null : getEntry(key).getValue();
    }

    public String get(int key, String defaultValue) {
        return getEntry(key) == null ? defaultValue : getEntry(key).getValue();
    }

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

    private int hash(int key) {
        return key % size;
    }

    private int probe(int key, int step) {
        return (hash(key) + step) % size;
    }

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

    private int getIndex(int key) {
        var index = hash(key);
        var step = 1;

        while (entries[index] != null) {
            index = probe(key, ++step);

            if (step == size)
                throw new IllegalStateException();
        }

        return index;
    }
}
