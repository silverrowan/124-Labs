package ics124.assignment4;

/**
 * A node in the binary search tree.
 * 
 * This is a container class, so all the fields are public.
 */
public class BstNode<T> {
    /**
     * The value of this node (the "key").  Will be unique.
     */
    public T x;

    /**
     * Parent node (one level up in tree).  Parent of root is null.
     */
    public BstNode<T> parent;
    /**
     * Root of left sub-tree.  All values in this tree are (strictly) less than 
     * the value of this node.
     */
    public BstNode<T> left;
    /**
     * Root of right sub-tree.  All values in this tree are (strictly)
     * greater than the value of this node.
     */
    public BstNode<T> right;

    /* Package-visible constructor.  Use BST::makeTreeNode instead */
    BstNode(T x) {
        this(x, null);
    }
    /* Package-visible constructor.  Use BST::makeTreeNode instead */
    BstNode(T x, BstNode<T> parent) {
        this.x = x;
        this.parent = parent;
        left = right = null;
    }

    /**
     * Pretty printer.
     * 
     * @return string representation for debugging
     */
    @Override
    public String toString() {
        return "<Node: "+x.toString()+">";
    }   
}
