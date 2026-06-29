package ics124.c0350261.assignment4;
import ics124.assignment4.BstNode;
import ics124.assignment4.BstMissingKeyException;
import ics124.assignment4.BstDuplicateKeyException;
import ics124.assignment4.BstBase;
import ics124.assignment4.*;

public class BinarySearchTree<T extends Comparable<T>> extends BstBase<T> {

    /**
     * Insert a new node into a given sub-tree
     * 
     * @param node root of the sub-tree
     * @param k value of the node to be inserted
     * @return root of the (modified) sub-tree
     * @throws BstDuplicateKeyException when the value already exists
     */
    @Override
    public BstNode<T> insert(BstNode<T> node, T k) 
            throws BstDuplicateKeyException {
        throw new UnsupportedOperationException("write me!");
    }

    /**
     * Delete a node from the tree
     * 
     * @param node root of sub-tree
     * @param k vale of node to remove
     * @return root of (modified) sub-tree
     * @throws BstMissingKeyException if node with value k not found
     */
    @Override
    public BstNode delete(BstNode<T> node, T k) 
            throws BstMissingKeyException {
        throw new UnsupportedOperationException("write me!");
    }

    /**
     * Perform a left rotation of a tree
     * 
     * @param tree root of (sub-)tree to rotate
     * @return new root of rotated (sub-)tree
     */
    @Override
    protected BstNode<T> rotateLeft(BstNode<T> tree) {
        throw new UnsupportedOperationException("write me!");
    }

    /**
     * Perform a right rotation of a tree
     * 
     * @param tree root of (sub-)tree to rotate
     * @return new root of rotated (sub-)tree
     */
    @Override
    protected BstNode<T> rotateRight(BstNode<T> tree) {
        throw new UnsupportedOperationException("write me!");
    }

    /**
     * Find the successor of a node
     * 
     * The successor of a node is the node with the next higher value.
     * The successor of the maximum node is null.
     * 
     * @param node starting node
     * @return next higher node (or null)
     */
    @Override
    public BstNode<T> succ(BstNode<T> node) {
        throw new UnsupportedOperationException("write me!");
    }

    /**
     * Find the predecessor of a node
     * 
     * The predecessor of a node is the node with the next lower value.
     * The predecessor of the minimum node is null.
     * 
     * @param node starting node
     * @return next lower node (or null)
     */
    @Override
    public BstNode<T> pred(BstNode<T> node) {
        throw new UnsupportedOperationException("write me!");
    }
    
}
