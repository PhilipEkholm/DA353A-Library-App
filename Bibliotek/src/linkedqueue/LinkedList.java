package linkedqueue;

import java.util.Iterator;

/**
 *	LinkedList E
 *
 * 	A class that offers functionality to store data in a linked list structure using chained object nodes (so called list nodes in this
 * 	implementation). Implements the interfaces List and Iterable, where list is used for ensuring certain methods will be included. Iterable is
 * 	used for looping over a list with other means than index arithmetics. Supports generics in order to work with homogeneous datatypes.
 * 
 * 	@author Rolf Axelsson
 * 	@author Philip Ekholm 
 */

public class LinkedList<E> implements List<E>, Iterable<E> {
	//The starting point of the list, with a special list object to chain other objects to.
    private ListNode<E> list = null;
    
    //Returns the node located at a certain index.
    private ListNode<E> locate(int index) {
        ListNode<E> node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }
    
    /**
     *	size will calculate the amount of elements currently in the list, unlike the arrayList implementation this is not a variable
     *	but must be counted manually by counting all chained elements.
     *
     * 	@return the number of elements linked in the list
     */
    
    public int size() {
        int n = 0;
        ListNode<E> node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }
    
    /**
     *	get the data of a certain object at a certain index. Method will first check if index is valid, otherwise an exception will be thrown. 
     *
     *	@throws IndexOutOfBoundsException if invalid index is passed
     *	@return the data at a certain object in the list.
     */
    
    public E get( int index ) {
        if( ( index < 0 ) || ( index > size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ListNode<E> node = locate( index );
        return node.getData();
    }
    
    /**
     *	Set the data of a certain object at given index. Method will first check if index is valid, otherwise an exception will be thrown.
     *
     *	@param index of the object to be manipulated
     *	@param data to be passed to object
     *	@throws IndexOutOfBoundsException if invalid index is passed
     *	@return the old data which was replaced
     */
    
    public E set( int index, E data ) { 
    	if(index < 0 || index > this.size()){
    		throw new IndexOutOfBoundsException();
    	}
    	else{
    		E oldNode = this.get(index);
    		this.remove(index);
    		this.add(index, data);
    		
    		return oldNode;
    	}
    }
    
    /**
     *	Add new data to the list, will be added to the end of the list if no index has been specified.
     *	@param data to be added to the list
     */
    
	public void add(E data) {
		this.addLast(data);
	}
	
	/**
	 *	Add new data to the "top" of the list, will be added to index 0.
	 *	@param data the data to be added to the list 
	 */

    public void addFirst( E data ) {
    	this.add(0, data);
    }
    
    /**
     *	Same as add(E)
     */
    
    public void addLast( E data ) {
    	this.add(this.size(), data);
    }
    
    /**
     *	Adds the data and creates a new object node at given index. Method will first check if index is valid, otherwise an exception will be thrown.
     *
     *	@param index the target position to add the element to
     *	@param data the data to be added to the list
     *	@throws IndexOutOfBoundsException if invalid index is passed
     */
    
    public void add( int index, E data ) {
    	if(index < 0 || index > this.size()){
    		throw new IndexOutOfBoundsException();
    	}
    	else if(index == 0){
    		list = new ListNode<E>(data, list);
    	}
    	else{
    		ListNode<E> n0 = locate(index - 1);
        	ListNode<E> n1 = new ListNode<E>(data, n0.getNext());
        	n0.setNext(n1);
    	}
    }
    
    /**
     *	Remove the very first element of the list, will call the remove(int) method with index = 0
     *
     * 	@return the data that was removed from the list
     */
    
    public E removeFirst() {
    	return this.remove(0);
    }
    
    /**
     *	Remove the very last element of the list, will call the remove(int) method with index = size() - 1
     *
     *	@return the data that was removed from the list
     */
    
    public E removeLast() {
    	return this.remove(this.size() - 1);
    }
    
    /**
     *	Remove the element of the given index and return the data that was contained in the element.
     *	Method will first check if index is valid, otherwise an exception will be thrown.
     *
     *	@param index the target position of the element to be removed
     *	@throws IndexOutOfBoundsException if invalid index is passed
     *	@return the old data stored at index
     */
    
    public E remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        E res;
        if( index == 0 ) {
            res = list.getData();
            list = setNull(list);
//            list = list.getNext();
        } else {
            ListNode<E> node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext(setNull(node.getNext()));
//            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    private ListNode<E> setNull(ListNode<E> toNull) {
    	ListNode<E> res = toNull.getNext();
    	toNull.setData(null);
    	toNull.setNext(null);
    	return res;
    }
    
    /**
     *	Removes all elements in the list by looping through every element and remove them 
     */

	public void clear() {
		while(this.size() > 0){
			this.removeLast();
		}
	}
	
	/**
	 *	Returns the index of given data, will return -1 if not found.
	 *
	 *	@param data the data being searched for
	 *	@return result from method indexOf(int, E)
	 */
	
	public int indexOf(E data) {
		return indexOf(0, data);
	}
	
	/**
	 *	Will return the index of a given object that has the same reference
	 *	as passed object, give startIndex to improve search speed, will return -1 if not found.
	 *
	 * 	@param startIndex to start searching at to improve search performance
	 * 	@param data the object who's reference will be compared
	 * 	@return the index of object, -1 if not found
	 */

	public int indexOf(int startIndex, E data) {
		for(int i = startIndex; i < this.size(); i++){
			if(data.equals(this.get(i))){
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 *	Returns an iterator object in order to loop the list with
	 *	other means than index arithmetics. The method has been simplified using
	 *	the iterator of the arraylist instead of having to develop a new algorithm to
	 *	get all the elements in the linked list.
	 *
	 * 	@return a new iterator object
	 */

	public Iterator<E> iterator() {
		ArrayList<E> iterList = new ArrayList<E>(this.size());
		
		for(int i = 0; i < this.size(); i++){
			iterList.add(this.get(i));
		}
		
		return iterList.iterator();
	}
	
	/**
	 *	Will return the toString from the ListNode class, which uses StringBuilder to manipulate strings.
	 *	If the list is dereferenced it will return empty parenthesis []. 
	 */
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    /**
     *	Not implemented in this solution, can be ignored. 
     */
    
    private class Iter implements Iterator<E> {
    	
    	public boolean hasNext() {
    		return false;
    	}
    	
    	public E next() {
    		return null;
    	}
    	
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
}
