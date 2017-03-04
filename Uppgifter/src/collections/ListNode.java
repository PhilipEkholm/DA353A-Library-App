package collections;

/**
 * Klass som används av Linked-klasser.
 * 
 *
 */
public class ListNode<E> {
    private E data;
    private ListNode<E> next;
    
    /**
     * Konstruktor som tar emot ett objekt och nästa ListNode-objektet.
     * @param data objekt som ska hållas
     * @param next nästa ListNode i länken.
     */
    public ListNode( E data, ListNode<E> next ) {
        this.data = data;
        this.next = next;
    }
    
    /**
     * Hämtar objektet i denna ListNode
     * @return E objektet som lagras i denna ListNode
     */
    public E getData() {
        return this.data;
    }
    
    /**
     * Ändrar objektet i denna ListNode
     * @param data objekt som ska lagras i denna ListNode
     */
    public void setData( E data ) {
        this.data = data;
    }
    
    /**
     * Returnerar nästa LinkNode
     * @return ListNode returnerar nästa LinkNode
     */
    public ListNode<E> getNext() {
        return this.next;
    }
    
    /**
     * Sätter nästa LinkNode
     * @param next nästa LinkNode som ska kopplas till denna.
     */
    public void setNext( ListNode<E> next ) {
        this.next = next;
    }
    
    /**
     * Returnerar en String-representation av objekten i denna och de följande ListNode.
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