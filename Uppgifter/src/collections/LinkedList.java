package collections; 

import java.util.Iterator;

/**
 * En klass som implemeneterar List och Iterable.
 * Lagrar objekt med Linked.
 * @author Anas Abu Al-Soud
 *
 * 
 */
public class LinkedList<E> implements List<E>, Iterable<E> {
	private ListNode<E> list = null;

	private ListNode<E> locate(int index) {
		ListNode<E> node = list;
		for( int i = 0; i < index; i++)
			node = node.getNext();
		return node;
	}

	/**
	 * Returnerar antalet objekt i listan
	 * @return int returnerar antalet objekt i listan
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
	 * @param index positionen i listan, där objektet ska hämtas från
	 * @return E returnerar det sökta objektet i listan
	 */
	public E get( int index ) {
		if( ( index < 0 ) || ( index >= size() ) )
			throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );

		ListNode<E> node = locate( index );
		return node.getData();
	}

	/**
	 * Lägger till ett objekt i listan med valt position
	 * @param index tar emot positionen i listan där objektet ska stoppas
	 * @param data objektet som ska stoppas in
	 */
	public void add( int index, E data ) {
		if(index<0){
			throw new IndexOutOfBoundsException();
		} else if(size()==0){
			list = new ListNode<E>(data, null);
		} else{
			ListNode<E> temp = list;
			for(int i=0; i<size()-1; i++){
				temp = temp.getNext();
			}
			temp.setNext(new ListNode<E>(data, null));
		}
	}

	/**
	 * Returnerar första objektet i listan och tar bort det
	 * @return E objektet först i listan.
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Returnerar sista objektet i listan och tar bort det
	 * @return E objektet sist i listan.
	 */
	public E removeLast() {
		return remove(size()-1);
	}

	/**
	 * Returnerar ett objekt i listan och tar bort det.
	 * @return E returnerar objektet i listan
	 * @param index positionen i listan som ska tas bort
	 */
	public E remove( int index ) {
		if( ( index < 0 ) || ( index >= size() ) )
			throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );

		E res;
		if( index == 0 ) {
			res = list.getData();
			list = list.getNext();
		} else {
			ListNode<E> node = locate( index - 1 );
			res = node.getNext().getData();
			node.setNext( node.getNext().getNext() );
		}
		return res;
	}

	/**
	 * @return int returnerar positionen i listan
	 * @param data objekt som ska sökas i listan
	 */
	public int indexOf(E data) {
		return -1;
	}

	/**
	 * Returnerar positionen av objektet i listan.
	 * @return int returnerar positionen av objektet i listan
	 */
	public int indexOf(int startIndex, E data) {
		return -1;
	}

	/**
	 * Returnerar en Iterator av listan
	 * @return Iterator returnerar Iterator av listan
	 */
	public Iterator<E> iterator() {
		ArrayList<E> iterList = new ArrayList<E>();
		for(int i =0; i<size(); i++){
			iterList.add(get(i));
		}
		return iterList.iterator();
	}    

	/**
	 * Returnerar en String-representation av listan.
	 * @return String String-representation av listan.
	 */
	public String toString() {
		if( list != null )
			return list.toString();
		else
			return "[]";
	}

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

	public void add(E element) {
		add(size(), element);

	}

	public void addFirst(E element) {
		add(0, element);

	}

	public void addLast(E element) {
		add(size(), element);
	}

	public void clear() {
		ListNode<E> node;
		for (int i = 0; i < size(); i++) {
			set(i, null);
			node = locate(i);
			node.setNext(null);
		}
		list = null;
	}

	public E set(int index, E element) {
		if( ( index < 0 ) || ( index >= size() ) )
			throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );

		ListNode<E> temp = locate(index);
		locate(index-1).setData(element);
		return temp.getData();
	}

	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		

		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println("LinkedList integers - add()-metod");
		System.out.println(list);
		System.out.println();
		
		System.out.println("LinkedList clear()-metod");
		list.clear();
		System.out.println(list);
		System.out.println();
		
		System.out.println("addFirst() metod");
		list.addFirst(10);
		System.out.println(list);
		System.out.println();
		
		System.out.println("addFirst() metod");
		list.addFirst(11);
		System.out.println(list);
		System.out.println();
		
		System.out.println("addFirst() metod");
		list.addFirst(12);
		System.out.println(list);
		System.out.println();
		
		System.out.println("addFirst() metod");
		list.addFirst(13);
		System.out.println(list);
		System.out.println();
		
		System.out.println("addLast() metod");
		list.addLast(14);
		System.out.println(list);
		System.out.println("");
		
		System.out.println("set()-metod");
		list.removeLast();
		System.out.println(list);
	}
}
