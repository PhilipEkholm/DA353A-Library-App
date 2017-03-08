package collections;

import java.util.Iterator;

/**
 * Hashtabellen använder öppen hashing
 * 
 * @author Rolf Axelsson
 */
public class HashtableOH<K, V> implements Map<K, V> {
	private LinkedList<Entry<K, V>>[] table;
	private int size;

	/** Creates a new instance of HashtableOH */
	public HashtableOH(int size) {
		table = (LinkedList<Entry<K, V>>[]) new LinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<Entry<K, V>>();
		}
	}

	private int hashIndex(K key) {
		int hashCode = key.hashCode();
		hashCode = hashCode % table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}

	public V put(K key, V value) {
		V res = null;
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, value);
		int index = table[hashIndex].indexOf(entry);
		if (index == -1) {
			table[hashIndex].addFirst(entry);
			size++;
		} else {
			res = table[hashIndex].set(index, entry).value;
		}
		return res;
	}

	public void list() {
		Entry<K, V> entry;
		for (int i = 0; i < table.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < table[i].size(); j++) {
				entry = table[i].get(j);
				System.out.print(" <" + entry.key + "," + entry.value + ">");
			}
			System.out.println();
		}
	}

	public V get(K key) {
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		int index = table[hashIndex].indexOf(entry);
		if (index == -1) {
			return null;
		}
		return entry.value;
	}

	public V remove(K key) {
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		int index = table[hashIndex].indexOf(entry);
		if (index == -1) {
			return null;
		}
		table[hashIndex] = null;
		size--;
		return entry.value;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public boolean containsKey(K key) {
		int hashIndex = hashIndex(key);
		Entry<K, V> entry = new Entry<K, V>(key, null);
		int index = table[hashIndex].indexOf(entry);
		if (index == -1) {
			return false;
		}
		return true;
	}

	public void clear() {
		for (int i = 0; i < table.length; i++) {
			table[i].clear();
		}
		size = 0;
	}

	public Iterator<K> keys() {
		ArrayList<K> list = new ArrayList<K>();
		for (int i = 0; i < table.length; i++) {
			list.add(table[i].get(i).key);
		}
		return (Iterator<K>) list;
	}

	public Iterator<V> values() {
		ArrayList<V> list = new ArrayList<V>();
		for (int i = 0; i < table.length; i++) {
			list.add(table[i].get(i).value);
		}
		return (Iterator<V>) list;
	}
}
