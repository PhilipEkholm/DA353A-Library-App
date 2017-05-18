package collections;

/**
*   AVLNode
*
*   A wrapper class for storing data in a tree data-structure, works
*   by linking together nodes in an hierarchy, should be used together with
*   AVLTree.
*
*   @author Rolf Axelsson
*   @author Philip Ekholm
*/

class AVLNode<K,V> {
    K key;
    V value;
    AVLNode<K,V> left;
    AVLNode<K,V> right;
    int height=0;

    /**
    *   Basic constructor for the class, assigns data stored together with a key
    *   as well as left and right children (does not need to be set explicitly).
    *
    *   @param key key in which the node is identified with.
    *   @param value the data object to be stored in the node.
    *   @param left the left node to be assigned as left-child to this node.
    *   @param right the right node to be assigned as right-child to this node.
    */
    
    public AVLNode( K key, V value, AVLNode<K,V> left, AVLNode<K,V> right ) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
    *   Get the height from this node all the way down to the leaves of
    *   the hierarchy, uses a recursive implementation to count the depth
    *   of the structure.
    *
    *   @return the height of the structure downwards.
    */
    
    public int height() {
        int leftD = -1, rightD = -1;
        if( left != null )
            leftD = left.height();
        if( right != null )
            rightD = right.height();
        return 1 + Math.max( leftD, rightD );
    }

    /**
    *   Get the number of nodes from this node all the way down to the 
    *   leaves of the hierarchy, uses a recursive implementation to count 
    *   the number of nodes in the structure.
    *
    *   @return the number of nodes in the structure downwards.
    */
    
    public int size() {
        int leftS = 0, rightS = 0;
        if( left != null )
            leftS = left.size();
        if( right != null )
            rightS = right.size();
        return 1 + leftS + rightS;
    }

    /**
    *   Get a console print of the current node (key and value) as well as
    *   for all the nodes downwards in the hierarchy. Algorithm uses a recursive
    *   implementation to print all the nodes in the structure.
    */
    
    public void print() {
        if( left != null)
            left.print();
        System.out.println(key + ": " + value);
        if( right != null )
            right.print();
    }
}
