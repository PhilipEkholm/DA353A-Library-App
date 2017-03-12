package collections;

/**
*   LinkedQueue
*
*   A class that implements the interface Queue, which defined how
*   a queue datastructure should communicate with other objects. The
*   LinkedQueue is an implementation of a Queue using linkning to other
*   objects (nodes) which can be added/removed. The LinkedQueue works by
*   other Queue implementations (specifically through the FiFo-structure).
*
*   @author Philip Ekholm
*   @created 2017-03-04
*   
*/

public class LinkedQueue<E> implements Queue<E>{
	private LinkedList<E> elements;
    private int size;

    /**
    *   Constructor without arguments, which will instantiate
    *   a new LinkedQueue object. This implementation uses
    *   a LinkedList to store nodes.
    */
    
    public LinkedQueue() {
        elements = new LinkedList<E>();
        size = 0;
    }

    /**
    *   Enqueue (insert) new elements (data-objects) to the queue
    *   by adding them to the end of the list.
    *   
    *   @param elem data-object to insert into the queue
    */
    
    public void enqueue( E elem ) {
        elements.addLast(elem);
        size++;
    }

    /**
    *   Dequeue (remove) the element (data-object) currently first up
    *   ("first in line") on the list and return it wherever
    *   the method was called.
    *
    *   If an attempt is made to dequeue an empty queue QueueException
    *   will be thrown.
    *
    *   @return the element currently first in the queue
    *   @throws QueueException if the queue is empty while attempting to dequeue
    */
    
    public E dequeue() throws QueueException{
        if(size==0) {
            throw new QueueException("dequeue: Queue is empty");
        }
        E value = elements.removeFirst();
        size--;
        return value;
    }

    /**
    *   Peek (get) the element (data-object) currently first up
    *   ("first in line") on the list. If an attempt is made to peek at
    *   an empty queue QueueException will be thrown.
    *
    *   @return the element currently first in the queue.
    *   @throws QueueException if the queue is empty while attempting to peek.
    */
    
    public E peek() throws QueueException{
        if( size==0 ) {
            throw new QueueException("peek: Queue is empty");
        }
        return elements.get(0);
    }

    /**
    *   Check whether the queue is empty or not.
    *
    *   @return true if the queue is empty, otherwise false.
    */
    
    public boolean isEmpty() {
        return (size<=0);
    }

    /**
    *   Return the size (length) of the list.
    *
    *   @return the current size of the list.
    */
    
    public int size() {
        return size;
    }

    /**
    *   The toString-method will return a string-object containing a print
    *   of objects containing properties (among else). The current
    *   implementation will use the toString of the LinkedList instead of
    *   of a new implementation.
    *
    *   @return the toString return value of LinkedList
    */
    
    public String toString(){
    	return elements.toString();
    }

}

























