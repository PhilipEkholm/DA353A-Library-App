package collections;

/**
 *	ListNode E
 *
 * 	ListNode is what the linked list is built up on. It is able to store data of homogeneous kind,
 * 	as well as the next listnode in order to continue the chain. It has different getters and setters to these as well
 * 	as a toString method in order to be printed out as a string.
 */

public class ListNode<E> {
    private E data;
    private ListNode<E> next;
    
    /**
     *	Base constructor, takes data as well as the next object in the chain.
     *	
     *	@param data the data to be stored
     *	@param next the next object to be linked 
     */
    
    public ListNode( E data, ListNode<E> next ) {
        this.data = data;
        this.next = next;
    }
    
    /**
     *	Getter for extracting data.
     *	
     *	@return the data from this object 
     */
    
    public E getData() {
        return this.data;
    }
    
    /**
     *	Setter for setting new data.
     *
     * 	@param data data to replace the current data with
     */
    
    public void setData( E data ) {
        this.data = data;
    }
    
    /**
     *	getter for next object chained. This method is applicable for method-chaining, since
     *	this is recursive.
     *	
     *	@return the next object in line 
     */
    
    public ListNode<E> getNext() {
        return this.next;
    }
    
    /**
     *	Setter for setting the next object in the line.
     *
     * 	@param next the next object to be added after the current one
     */
    
    public void setNext( ListNode<E> next ) {
        this.next = next;
    }
    
    /**
	 *	Overrides the toString from superclass and returns the toString from data.
	 *	This is done via StringBuilder class.
	 *	
	 *	@see StringBuilder
	 *	@return the list as a string. 
	 */
    
    public String toString() {
    	StringBuilder str = new StringBuilder("[ ");
    	str.append(data.toString());
    	ListNode<E> node = next;
        while( node!=null ) {
        	str.append( "; ");
            str.append( node.getData().toString() );
            node = node.getNext();
        }
        str.append( " ]");
        return str.toString();
    }
}