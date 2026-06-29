package ics124.assignment4;

/**
 * A node in an AVL binary search tree
 * 
 * Extends the BstNode class written by the student.
 * 
 * @param <T> the class of the tree's payload
 */
public class AvlNode<T extends Comparable<T>> extends BstNode<T> {
    /**
     * The height of the tree rooted here.  
     * The furthest distance to a leaf node.
     */
    public int height;
    
    /**
     * Constructor.  Use AvlTree::makeTreeNode instead.
     * 
     * @param x payload value
     * @param parent parent node in tree
     */
    public AvlNode(T x, AvlNode<T> parent) {
        super(x, parent);
        this.height = 0;
    }
    /**
     * Constructor.  Use AvlTree::makeTreeNode instead.
     * 
     * @param x payload value
     */
    public AvlNode(T x) {
        this(x, null);
    }
}
