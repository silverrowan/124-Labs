package ics124.assignment4;

/**
 * The interface for a binary search tree
 * 
 * Nodes in the tree are required to have unique payload values.
 * 
 * @param <T> the class of the tree's payload
 */
public interface BST<T extends Comparable<T>> {
    /**
     * Insert a node into the tree.  
     * @param k the value of the node's payload
     * @return true on success
     */
    boolean insert(T k);
    /**
     * Delete a node from the tree
     * 
     * @param k the value of the node to remove
     * @return true on success
     */
    boolean delete(T k);
    /**
     * Find a node in the tree given a value
     * @param x the value to find
     * @return matching node or null
     */
    BstNode<T> find(T x);
}
