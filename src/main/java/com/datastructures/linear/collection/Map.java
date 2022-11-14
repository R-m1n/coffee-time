package src.main.java.com.datastructures.linear.collection;

/**
 * Hash Table data structure interface.
 * 
 * @author R-m1n
 */
public interface Map<K, V> {

    /**
     * Add a key-value pair in the hash table.
     * 
     * @param key
     * @param value
     */
    public void put(K key, V value);

    /**
     * @param key
     * @return the value stored with the key, null if not found.
     */
    public V get(K key);

    /**
     * @param key
     * @param defaultValue
     * @return the value stored with the key, defaultValue if not found.
     */
    public V get(K key, V defaultValue);

    /**
     * Remove the key-value pair in the hash table stored with the key.
     * 
     * @param key
     */
    public void remove(K key);
}
