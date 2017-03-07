package collections;

import java.util.EmptyStackException;

/**
 * Klass som implementerar Stack-interfacet och används för att stacka objekt.
 * 
 * @author Anas Abu Al-Soud
 *
 */
public class ArrayStack<T> implements Stack<T> {
	private T[] elements;
	private int size=0;

	/**
	 * Tar emot en int och skapar en stack lika stor som int-värdet.
	 * @param capacity storleken på den inledande storleken.
	 */
	public ArrayStack(int capacity) {
		elements = (T[])(new Object[capacity]);
	}

	/**
	 * Tar emot ett object och pushar mot stacken
	 * 
	 * @param element object som ska pushas till stacken.
	 */
	public void push(T element) {
		{
			elements[size] = element;
			size++;
		}
	}

	/**
	 * Returnerar objektet i stacken och tar bort objektet från stacken.
	 * @return objektet i stacken.
	 */
	public T pop() {
		if (empty())
			throw new EmptyStackException();
		size--;
		T result = elements[size];
		elements[size] = null;
		return result;
	}

	/**
	 * Returnerar objektet i stacken.
	 * return objektet i stacken.
	 */
	public T peek() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return elements[size-1];
	}

	/**
	 * Returnerar true om stacken är tom.
	 * return sant om stacken är tom
	 */
	public boolean empty() {
		return (size==0);
	}

	/**
	 * Returnerar antalet objekt i stacken.
	 * return antalet objekt i stacken.
	 */
	public int size() {
		return size;
	}

	private void expandCapacity() {
		T[] larger = (T[]) (new Object[elements.length * 2]);

		for (int index = 0; index < elements.length; index++)
			larger[index] = elements[index];

		elements = larger;
	}
}
