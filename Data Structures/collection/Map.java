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
     * @return the value stored with the key, null if not found.
     */
    public String get(int key);

    /**
     * @param key
     * @param defaultValue
     * @return the value stored with the key, defaultValue if not found.
     */
    public String get(int key, String defaultValue);

    /**
     * Remove the key-value pair in the hash table stored with the key.
     * 
     * @param key
     */
    public void remove(int key);

}
