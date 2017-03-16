package avltree;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import arraylist.ArrayList;
import arraylist.List;

/**
*   AVLTree
*
*   AVLTree is a written datastructure class for storing data in a non-linear
*   structure, while AVLTree is based on binary search trees it has the 
*   ability to auto balance the tree whenever the structure degenerates more
*   than a balance factor of -1 or +1. Uses wrapper objects AVLNode for storing
*   data in.
*
*   @author Philip Ekholm
*   @created 2017-03-04
*/

public class AVLTree<K,V> implements SearchTree<K,V> {
    private Comparator<K> comparator;
    private AVLNode<K,V> tree;

    /**
    *   If no custom comparator implementation has been made
    *   a default comparator as inner class will be instantiated.
    */
    
    public AVLTree() {
        comparator = new Comp();
    }

    /**
    *   Custom comparator can be implemented depending
    *   on how keys should be compared against each other.
    *
    *   @param comp class that implements Comparator with overridden compare.
    */
    
    public AVLTree( Comparator<K> comp ) {
        comparator = comp;
    }

    /**
    *   Return the root of the whole AVL-structure.
    *   
    *   @return root of the AVL-Structure.
    */
    
    public AVLNode<K,V> root() {
        return tree;
    }

    /**
    *   find a certain AVLNode using passed key, if found the value of the
    *   node will be returned, otherwise null will be returned.
    *
    *   @param key key of the target node to be obtained.
    *   @return the value of the node if found, otherwise null.
    */
    
    public V get(K key) {
    	AVLNode<K,V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
    
    /**
    *   put (insert) a new node into the AVL-structure using a unique key
    *   as well as a value (data). Make sure the key is unique to the 
    *   AVL-structure to avoid errors.
    * 
    *   @param key key identifier unique for the created node.
    *   @param value the data value to pass to the newly created node.
    */
    
    public void put(K key, V value) {
        tree = put(tree,key,value);
    } 

    /**
    *   Remove a node from the AVL-structure by passing the key of the target node.
    *   
    *   @param key key identifier unique for the created node.
    *   @return the value of the node that was removed if successful, otherwise 
    *   returns null.
    */
    
    public V remove(K key) {
        V value = get( key );
        if(value!=null) {
            tree = remove(tree,key);
        }
        return value;
    }
    
    /**
     *	Check if a certain node with passed key can be found in the AVL-structure.
     *
     * 	@param key key identifier unique for the created node.
     * 	@return true if the node with specific key could be found, otherwise false.
     */
    
    public boolean contains( K key ) {
        return find( key ) != null;
    }
    
    /**
     *	Returns the height of the AVL-structure.
     *	
     *	@return the height of the AVL-structure. 
     */
    
    public int height() {
        return height( tree );
    }
    
    private int height( AVLNode<K,V> node ) {
	    if( node == null )
	        return -1;
	    return 1 + Math.max( height( node.left ), height( node.right ));
	}
    
    /**
     *	Return a new instance of an iterator for iterating all the values of
     *	nodes in the AVL-structure.
     *
     *	@return new instance of iterator for values.
     */

	public Iterator<V> iterator() {
        return new IterValues();
    }
	
	/**
	 *	Return a new instance of an iterator for iterating all the keys of
	 *	nodes in the AVL-structure.
	 *
	 *	@return new instance of iterator for keys.
	 */
	
	public Iterator<K> iteratorKeys(){
		return new IterKeys();
	}
    
    private AVLNode<K,V> find(K key) {
        int res;
        AVLNode<K,V> node=tree;
        while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
            if( res < 0 )
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }
    
    private AVLNode<K,V> put(AVLNode<K,V> node, K key, V value) {
        if( node == null ) {
            node = new AVLNode<K,V>( key, value, null, null );
        } else {
            if(comparator.compare(key,node.key)<0) {
                node.left = put(node.left,key,value);
                node = this.balanceLeft(node);
            } else if(comparator.compare(key,node.key)>0) {
                node.right = put(node.right,key,value);
                node = this.balanceRight(node);
            }
        }
        return node;
    }
    
    private AVLNode<K,V> remove(AVLNode<K,V> node, K key) {
        int compare = comparator.compare(key,node.key);
        if(compare==0) {
            if(node.left==null && node.right==null)
                node = null;
            else if(node.left!=null && node.right==null)
                node = node.left;
            else if(node.left==null && node.right!=null)
                node = node.right;
            else {
                AVLNode<K,V> min = getMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node = min;
            }
        } else if(compare<0) {
            node.left = remove(node.left,key);
        } else {
            node.right = remove(node.right,key);
        }
        node = this.balanceNode(node);
        return node;
    }
    
    private AVLNode<K,V> getMin(AVLNode<K,V> node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
    
    /**
     *	Return the size ("length") of the AVL-structure, will be
     *	calculated using recursion.
     *
     *	@return the size of the tree.
     */
        
    @Override
	public int size() {
		return this.size(tree);
	}

	// Laboration 13
    private int size(AVLNode<K, V> node) {
    	int l = 0, r = 0;
    	
    	if(this.tree == null){
    		return 0;
    	}
    	if(node.left != null){
    		l = this.size(node.left);
    	}
    	if(node.right != null){
    		r = this.size(node.right);
    	}
    	
    	return 1 + r + l;
    }
    
    
    public List<K> keys(){
        ArrayList<K> list = new ArrayList<K>();
        
        Iterator<K> iter = new IterKeys();
        
        while(iter.hasNext()){
        	list.add(iter.next());
        }
        
        return list;
    }
    
    public List<V> values(){
    	ArrayList<V> list = new ArrayList<V>();
        
        Iterator<V> iter = new IterValues();
        
        while(iter.hasNext()){
        	list.add(iter.next());
        }
        
        return list;
    }
    /**
     *	Operation not supported in this implementation.
     *	
     *	@throws UnsupportedOperationException since operation is unsupported.
     */
    public V first() throws UnsupportedOperationException{
    	throw new UnsupportedOperationException();
    }
    
    /**
     *	Operation not supported in this implementation.
     *
     * 	@throws UnsupportedOperationException since operation is unsupported.
     */
    
    public V last() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    
    /**
     *	When the tree is instantiated either a class that implements
     *	Comparator can be passed to constructor, otherwise this class
     *	will be passed which tries to typecast the passed arguments
     *	to Comparable. 
     *
     *	If typecasting fails then ClassCastException will be thrown.
     */
    
    private class Comp implements Comparator<K> {
        public int compare( K key1, K key2 ) {
            Comparable<K> k1 = ( Comparable<K> )key1;
            return k1.compareTo( key2 );
        }
    }
    
    private AVLNode<K,V> balanceNode(AVLNode<K,V> node) {
    	if(node!=null) {
    	    node = balanceLeft(node);
    	    node = balanceRight(node);
    	}
    	return node;
    }
    
    private AVLNode<K,V> balanceLeft(AVLNode<K,V> node) {
    	if((this.height(node.left) - this.height(node.right) == 2)){
			if(this.height(node.left.left) - this.height(node.left.right) == -1){
				node.left = this.rotateLeft(node.left);
				node = this.rotateRight(node);
			}
			else{
				node = this.rotateRight(node);
			}
		}
		
		return node;
    }
    
    private AVLNode<K,V> balanceRight(AVLNode<K,V> node) {
    	if(this.height(node.left) - this.height(node.right) == -2){
        	if(this.height(node.right.left) - this.height(node.right.right) == 1){
        		node.right = this.rotateRight(node.right);
        		node = this.rotateLeft(node);
        	}
        	else{
        		node = this.rotateLeft(node);
        	}
        }
        
        return node;
    }
    
    private AVLNode<K,V> rotateLeft(AVLNode<K,V> node) {
    	AVLNode<K, V> newRoot = node.right;
        AVLNode<K, V> leftChild = newRoot.left;
        
        newRoot.left = node;
        node.right = leftChild;
        
        return newRoot;
    }
    
    private AVLNode<K,V> rotateRight(AVLNode<K,V> node) {
    	AVLNode<K, V> newRoot = node.left;
        AVLNode<K, V> rightChild = newRoot.right;
        newRoot.right = node;
        node.left = rightChild;
        
        return newRoot;
    }
    
    /**
     *	The iteration class for iterating values. 
     */
      
    private class IterValues implements Iterator<V> {
        ArrayList<V> list = new ArrayList<V>();
        int index = -1;
        
        public IterValues() {
            inOrder(tree);
        }
        
        private void inOrder(AVLNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.value);
                inOrder(node.right);
            }
        }
        
        public boolean hasNext() {
            return index<list.size()-1;
        }
        
        public V next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     *	The iteration class for iterating values. 
     */
    
    private class IterKeys implements Iterator<K> {
        ArrayList<K> list = new ArrayList<K>();
        int index = -1;
        
        public IterKeys() {
            inOrder(tree);
        }
        
        private void inOrder(AVLNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.key);
                inOrder(node.right);
            }
        }
        
        public boolean hasNext() {
            return index<list.size()-1;
        }
        
        public K next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}










