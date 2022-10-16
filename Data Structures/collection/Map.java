package collection;

/**
 * Hash Table data structure interface.
 * 
 * @author R-m1n
 */
public interface Map {

    /**
     * Add a key-value pair in the hash table.
     * 
     * @param key
     * @param value
     */
    public void put(int key, String value);

    /**
     * @param key
     * @return the value stored with the key.
     */
    public String get(int key);

    /**
     * Remove the key-value pair in the hash table stored with the key.
     * 
     * @param key
     */
    public void remove(int key);

}
