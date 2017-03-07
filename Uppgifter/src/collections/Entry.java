package collections;

class Entry<K,V> {
    K key;
    V value;
    
    public Entry( K key, V value ) {
        this.key = key;
        this.value = value;
    }
    
    // jämför två nycklar, returnerar true om lika
    public boolean equals( Object obj ) {
        if( !(obj instanceof Entry) )
            return false;
        Entry<K,V> entry = ( Entry<K,V> )obj;
        return key.equals( entry.key );
    }
}
