package hashtableOH;
import java.util.Iterator;

/**
 * An object that maps keys to values.  A map cannot contain duplicate keys;
 * each key can map to at most one value.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 */
public interface Map<K,V> {

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified
     * key. 
     *
     * @param key key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified key
     */
    boolean containsKey(K key);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this map contains no mapping for the key
     */
    V get(K key);

    /**
     * Associates the specified value with the specified key in this map
     * (optional operation).  If the map previously contained a mapping for
     * the key, the old value is replaced by the specified value.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     */
    V put(K key, V value);

    /**
     * Removes the mapping for a key from this map if it is present.
     * Returns the value to which this map previously associated the key, 
	 * or <tt>null</tt> if the map contained no mapping for the key.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     */
    V remove(K key);

    /**
     * Removes all of the mappings from this map. The map will be empty
     * after this call returns.
     */
    void clear();

    /**
     * Returns an Iterator<K> view of the keys contained in this map.
     *
     * @return an Iterator<K>-view of the keys contained in this map
     */
    Iterator<K> keys();

    /**
     * Returns an Iterator<V> view of the values contained in this map.
     *
     * @return an Iterator<V>-view of the values contained in this map
     */
    Iterator<V> values();
}
