package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Klass som implementerar List-interfacet, används för att enklare kunna lägga till och hantera arrayer.
 * 
 * @author Anas Abu Al-Soud
 */
public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;


	private void grow() {
		E[] temp = (E[])new Object[elements.length*2];
		for(int i=0; i<elements.length;i++){
			temp[i] = elements[i];
		}
		elements = temp;

	}

	/**
	 * Konstruktor skapar en tom lista med total 20-platser i arrayen.
	 */
	public ArrayList() {
		this(20);
	}

	/**
	 * Konstruktor tar emot en int och skapar en lista lika stor som det värdet.
	 * @param initialCapacity storlek på listan.
	 */
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	/**
	 * 
	 * Lägger till ett objekt i ett specifikt index i arrayen.
	 * @param index var i arrayn ett objekt ska stoppas
	 * @param element objektet som ska stoppas in.
	 */
	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length){
			System.out.println("test");
			grow();
		}
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 
	 * Tar emot ett objekt och stoppas in längst bak i listan.
	 * @param element objekt som ska stoppas i listan.
	 */
	public void add(E element) {
		add(size,element);
	}

	/**
	 * Tar emot ett objekt och stoppar i början av listan
	 * @param element objekt som ska stoppas i början av listan.
	 */
	public void addFirst(E element) {
		add(0, element);
	}

	/**
	 * Tar emot ett objekt och stoppas in längst bak i listan.
	 * @param element objekt som ska stoppas längst bak i listan
	 */
	public void addLast(E element) {
		add(size, element);
	}

	/**
	 * Tar bort ett objekt i arrayen på ett valt index.
	 * @param index index på objektet som ska tas bort ur listan.
	 */
	public E remove(int index) {
		if(index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}
		E temp = elements[index];
		size--;
		for(int i=index; i<size;i++){
			elements[i] = elements[i+1];
		}
		return temp;
	}

	/**
	 * Tar bort första objektet i listan och returnerar objektet
	 * @return E returnerar objektet som tas bort.
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Tar bort det sista objektet i listan
	 * @return  E returnerar objektet som tagits bort ur listan
	 */
	public E removeLast() {
		return remove(size-1);
	}

	/**
	 * Tömmer listan
	 */
	public void clear() {
		int initialCapacity= elements.length;
		elements = (E[])new Object[initialCapacity];
		size=0;
	}

	/**
	 * Hämtar ett objekt i ett valt index
	 * @param index index på objektet som ska returneras
	 * @return E returnerar objektet som söktes.
	 */
	public E get(int index) {
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		return elements[index];
	}

	/**
	 * Skriver över ett objekt i ett specifikt index
	 * @param index position som ska skrivas över
	 * @param element objekt som ska skrivas över
	 * @return E objektet som tagits bort
	 */
	public E set(int index, E element) {
		if(index<0 || index>=size){
			throw new IndexOutOfBoundsException();
		}
		E temp = elements[index];
		elements[index] = element;
		return temp;
	}

	/**
	 * Metod söker efter ett element och returnerar index av objektet
	 * @param element tar emot ett objekt som ska sökas efter i listan
	 * @return int returnerar indexet av det sökta objektet
	 */
	public int indexOf(E element) {
		return indexOf(0, element);
	}

	/**
	 * Söker efter ett objekt. Sökningen börjar från ett specifikt index och går sedan uppåt.
	 * @param startIndex, element tar emot objekt som ska sökas och ett int som bestämmer sökningens start.
	 * @return int returnerar indexet av objektet
	 */
	public int indexOf(int startIndex, E element) {
		if(startIndex<0 || startIndex>=size){
			throw new IndexOutOfBoundsException();
		}
		for(int i=startIndex; i<size; i++){
			if(elements[i].equals(element)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returnerar storleken av listan
	 * @return int returnerar storleken av listan
	 */
	public int size() {
		return size;
	}

	/**
	 * Returnerar alla objekt i Strong-format
	 * @return String returnerar alla objekt i Strong-format
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
	 * Returnerar en Iterator av listan
	 * @return Iterator returnerar en Iterator av listan
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}

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
