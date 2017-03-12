package avltree;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *	ArrayList E
 *
 * 	A class that extends the functionality of list using a simple Array-data structure, implements the
 * 	interface List which states certain methods to be implemented. Supports generics to work with any homogeneous datatype.
 * 
 * 	@author Rolf Axelsson
 * 	@author Philip Ekholm
 */

public class ArrayList<E> implements List<E> {
	/**
	 *	One array elements to keep track of actual data
	 *	size used to determine current length of list
	 */
	
	private E[] elements;
	private int size;
	
	/**
	 *	grow will double the size of the current list if
	 *	number of elements exceed the number of cells available by
	 *	creating a new array twice the size 
	 */
	
	private void grow() {
		E[] temp = (E[])new Object[2 * elements.length];
		for(int i = 0; i < this.elements.length; i++){
			temp[i] = this.elements[i];
		}
		
		this.elements = temp;
	}
	
	/**
	 *	Pass default size of 20 to base constructor if no argument passed. 
	 */
	
	public ArrayList() {
		this(20);
	}
	
	/**
	 *	Base constructor for this class, creates an initial capacity of
	 *	at least 1, will be extended later if too small.
	 *
	 * 	@param initialCapacity size of the initial list
	 */
	
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}
	
	/**
	 *	Adds a new element to the list using target index.
	 *	
	 *	@param index the target position to add the element to
	 *	@param element the element to be added to the list
	 *
	 *	@throws IndexOutOfBoundsException if invalid index is passed
	 */

	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}
	
	/**
	 *	Adds a new element to the list, will be passed to {@code add(int, <E>)}
	 *	with size, meaning it will add the element to the end of the list.
	 *	
	 *	@param element the element to be added to the list
	 */

	public void add(E element) {
		add(size,element);
	}
	
	/**
	 *	Adds a new element to the list, will be passed to {@code add(int, <E>)}
	 *	with target index 0, meaning it will add the element to the 'top' of the list.
	 *
	 *	@param element the element to be added to the list
	 */

	public void addFirst(E element) {
		add(0, element);
	}
	
	/**
	 *	Same functionality as addLast.
	 *
	 *	@param element the element to be added to the list
	 */

	public void addLast(E element) {
		add(size, element);
	}
	
	/**
	 *	Will remove and return targeted object at passed index.
	 *
	 * 	@param index target index where element can be found
	 * 	@return the object to be removed from the list
	 * 	@throws IndexOutOfBoundsException if invalid index is passed
	 */

	public E remove(int index) {
		E targetObject;
		
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException("Invalid index passed to remove");
		}
		else{
			targetObject = this.get(index);
			
			for(int t = index; t < this.size; t++){
				this.elements[t] = this.elements[t + 1];
			}
			
			size--;
		}
		
		return targetObject;
	}
	
	/**
	 *	Removes the first element on the list with index 0.
	 *	
	 *	@return result from remove with argument index = 0
	 */

	public E removeFirst() {
		return this.remove(0);
	}
	
	/**
	 *	Removes the last element on the list with index size.
	 *	
	 *	@return result from remove with argument index = size
	 */

	public E removeLast() {
		return this.remove(this.size);
	}
	
	/**
	 *	Removes all elements in the list by looping through and dereferencing object references. 
	 */

	public void clear() {
		for(int i = 0; i < this.size; i++){
			this.elements[i] = null;
		}
		
		size = 0;
	}
	
	/**
	 *	Returns the object found at passed index, will throw exception if invalid index is passed.
	 *
	 *	@param index target index where element can be found
	 *	@return the object at given index
	 *	@throws IndexOutOfBoundsException if invalid index is passed
	 */

	public E get(int index) {
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException("Invalid index passed to get");
		}
		
		return this.elements[index];
	}
	
	/**
	 *	Set a new object at a given index in list.
	 *
	 *	@param index target index where element can be found
	 *	@param element the object to be set with
	 *	@return the old object that was replaced
	 *	@throws IndexOutOfBoundsException if invalid index is passed
	 */

	public E set(int index, E element) {
		E previousObj;
		
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException("Invalid index passed to set");
		}
		else{
			previousObj = this.elements[index];
			this.elements[index] = element;
		}
		
		return previousObj;
	}
	
	/**
	 *	Returns the index of a given object, will return -1 if not found.
	 *
	 *	@param element the element being searched for
	 *	@return result from method indexOf(int, E)
	 */

	public int indexOf(E element) {
		return this.indexOf(0, element);
	}
	
	/**
	 *	Will return the index of a given object that has the same reference
	 *	as passed object, give startIndex to improve search speed, will return -1 if not found.
	 *
	 * 	@param startIndex to start searching at to improve search performance
	 * 	@param element the object whos reference will be compared
	 * 	@return the index of object, -1 if not found
	 */

	public int indexOf(int startIndex, E element) {
		for(int i = startIndex; i < this.size; i++){
			if(elements[i].equals(element)){
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns the size of the element.
	 * 
	 * @return the current size of the list
	 */

	public int size() {
		return this.size;
	}
	
	/**
	 *	Overrides the toString from superclass and returns a listing of objects as a string.
	 *	This is done via StringBuilder class.
	 *	
	 *	@see StringBuilder
	 *	@return the list as a string. 
	 */
	
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}
	
	/**
	 *	A simple method to return an iterator object in order to loop the list with
	 *	other means than index arithmetics. Currently uses a private class, the lines
	 *	commented do this by passing an anonymous class implementing the interface Iterator.
	 *
	 * 	@return a new iterator object
	 */

	public Iterator<E> iterator() {
		return new Iter();
//		return new Iterator<E>() {
//			private int index=0;
//			
//			public boolean hasNext() {
//				return index<size;
//			}
//			
//			public E next() {
//				if(index==size)
//					throw new NoSuchElementException();
//				return elements[index++];
//			}
//			
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//		};
	}
	
	/**
	 *	The private Iter class for passing Iterator objects, giving means to loop through the list
	 */
	
	private class Iter implements Iterator<E> {
		private int index=0;
		
		public boolean hasNext() {
			return index<size;
		}
		
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
