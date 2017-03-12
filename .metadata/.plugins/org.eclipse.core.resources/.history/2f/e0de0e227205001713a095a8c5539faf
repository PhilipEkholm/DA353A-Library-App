package structures;
import java.util.Iterator;

/**
 * 	Hash table uses open hashing.
 * 	@author Rolf Axelsson
 * 
 * 	HashtableOH
 * 
 * 	This class is an implementation of the interface Map, which
 * 	defines a map data-structure. This implementation is based
 * 	on open hashing, which means collisions are allowed 
 * 	(and possible using LinkedLists).
 * 
 * 	For storing data the container (wrapper) class Entry is used
 * 	which stores a key and value.
 * 
 * 	@author Philip Ekholm
 *	@created 2017-03-04
 */

public class HashtableOH<K,V> implements Map<K,V> { 
    private LinkedList<Entry<K,V>>[] table;
    private int size;
    
    /** 
     * 	Creates a new instance of HashtableOH with a specified
     * 	starting sized (which can be extended later on).
     * 
     * 	Constructor fills the whole map with LinkedList in order
     * 	to allow collisions between objects.
     * 
     * 	@param size the initial capacity of the hash table, will be
     * 	extended using grow if the amount of objects exceed the loading
     * 	factor of the table.
     */
    
    public HashtableOH( int size ) {
        table = (LinkedList<Entry<K,V>>[])new LinkedList[ size ];
        for( int i = 0; i < size; i++ ) {
            table[ i ] = new LinkedList<Entry<K,V>>();
        }
    }
    
    private int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        
        return Math.abs(hashCode);
    }
    
    /**
     *	Put (insert) a new data object into the table together with an
     *	identifier (key) which is unique for this structure. The two arguments
     *	will be contained within a new Entry object in the hash table. If the
     *	object overwrites another already stored the value of the old object will
     *	be returned.
     *
     *	@param key key of the entry to be entered.
     *	@param value data object to be stored in the table.
     *	@return value of the old object if entry object overrides.
     */
    
    public V put( K key, V value ) {
    	V res = null;
        int hashIndex = hashIndex( key );
        Entry<K,V> entry = new Entry<K,V>( key, value );
        int index = table[ hashIndex ].indexOf( entry );
        if( index == -1 ) {
            table[ hashIndex ].addFirst( entry );
            size++;
        }
        else {
        	res = table[hashIndex].set( index, entry ).value;
        }
        return res;
    }
    
    /**
     *	List all the following entries in the table by printing
     *	them out in the console on specified form:
     *
     * 	(number in list): <(key of current entry),(value of current entry)>\n
     */
    
    public void list() {
        Entry<K,V> entry;
        for(int i=0; i<table.length; i++) {
            System.out.print( i + ":");
            for( int j = 0; j < table[ i ].size(); j++ ) {
                entry = table[ i ].get( j );
                System.out.print(" <" + entry.key +"," + entry.value + ">" );
            }
            System.out.println();
        }
    }
    
    /**
     *	Find a certain Entry in the table using passed key, if found
     *	the value of the entry will be returned, otherwise null will
     *	be returned.
     *
     * 	@param key key of the entry to be found.
     * 	@return the value of target entry if found, otherwise null.
     */

	public V get(K key) {
		int position = this.hashIndex(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, null);
		int listIndex = table[position].indexOf(newEntry);
		
		if(listIndex == -1){
			return null;
		}
		
		Entry<K, V> ref = table[position].get(listIndex);
		
		if(ref.equals(newEntry)){
			return ref.value;
		}
		else{
			return null;
		}
	}
	
	/**
	 *	Remove a certain Entry in the table using passed key, if found
	 *	the value of the entry will be returned of the removed entry, 
	 *	otherwise null will be returned.
	 *
	 *	@param key key of the entry to be removed.
	 *	@return the value of the removed entry if found, otherwise null.
	 */

	public V remove(K key) {
		int position = this.hashIndex(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, null);
		int listIndex = table[position].indexOf(newEntry);
		
		if(listIndex == -1){
			return null;
		}
		
		Entry<K, V> ref = table[position].get(listIndex);
		
		if(ref.equals(newEntry)){
			size--;
			return table[position].remove(listIndex).value;
		}
		else{
			return null;
		}
	}
	
	/**
	 *	Return the size ("length") of this table.
	 *
	 *	@return size of the table.
	 */

	public int size() {
		return this.size;
	}
	
	/**
	 *	Check whether the table is empty or not.
	 *
	 *	@return true if the table is empty, otherwise false.
	 */

	public boolean isEmpty() {
		return (size <= 0);
	}
	
	/**
	 *	Check whether Entry with passed key can be found or not.
	 *
	 * 	@return true if the table contains Entry with specified key,
	 * 	otherwise false.
	 */

	public boolean containsKey(K key) {
		return (this.get(key) != null);
	}
	
	/**
	 *	Remove all Entries in the table by calling the clear
	 *	method of all LinkedLists in the table.
	 */

	public void clear() {
		for(int i = 0; i < table.length; i++){
			table[i].clear();
		}
	}
	
	/**
	 *	Return an ArrayList iterator of all keys of Entries
	 *	currently found in the table which can be iterated.
	 *
	 * 	@return ArrayList iterator for iterating all the keys
	 * 	in the table.
	 */

	public Iterator<K> keys() {
		ArrayList<K> list = new ArrayList<K>();
		
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].size(); j++){
				list.add(table[i].get(j).key);
			}
		}
		
		return list.iterator();
	}
	
	/**
	 *	Return an ArrayList iterator of all values of Entries
	 *	currently found in the table which can be iterated.
	 *
	 * 	@return ArrayList iterator for iterating all the values
	 * 	in the table.
	 */

	public Iterator<V> values() {
		ArrayList<V> list = new ArrayList<V>();
		
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].size(); j++){
				list.add(table[i].get(j).value);
			}
		}
		
		return list.iterator();
	}
}
