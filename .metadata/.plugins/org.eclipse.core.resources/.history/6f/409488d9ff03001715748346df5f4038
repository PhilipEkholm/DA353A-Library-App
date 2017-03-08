package collections;

public class LinkedQueue<E> implements Queue<E> {
	private LinkedList<E> list = new LinkedList<E>();

	/**
	 * Inserts the specified element into this queue.
	 * 
	 * @param data the object to add
	 */
	public void enqueue(E data) {
		list.add(size(), data);
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * 
	 * @return the head of this queue
	 * @throws QueueException
	 *             if this queue is empty
	 */
	public E dequeue() {
		if (isEmpty()) {
			throw new QueueException("dequeue: Queue is empty");
		}
		return list.remove(0);
	}

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * 
	 * @return the head of this queue
	 * @throws QueueException if this queue is empty             
	 */
	public E peek() {
		if (isEmpty()) {
			throw new QueueException("peek: Queue is empty");
		}
		return list.get(0);
	}

	/**
	 * Returns true if this stack contains no elements.
	 * 
	 * @return true if this stack contains no elements
	 */
	public boolean isEmpty() {
		return list.size() == 0;
	}

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in this stack
	 */
	public int size() {
		return list.size();
	}
}
