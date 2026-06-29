package ics124.c0350261.assignment4;
import ics124.assignment4.BstNode;
import ics124.assignment4.BstMissingKeyException;
import ics124.assignment4.BstDuplicateKeyException;
import ics124.assignment4.AvlNode;
import ics124.assignment4.*;

/**
 * Implementation of an AVL tree, a self-balancing BST.
 * 
 * @param <T> the class of the payload
 */
public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    /**
     * The height of the whole AVL tree.  By definition the height of a
     * null (empty) tree is -1, the height is defined as how far away is a 
     * leaf node.
     * 
     * @return height
     */
    public int height() {
        if (root == null) return -1;
        return ((AvlNode)root).height;
    }
    
    /**
     * Factory function to create a tree node.
     * 
     * This allows test cases to hand-craft nodes in a tree without
     * access to the AvlNode constructor (which they cannot access).
     * 
     * @param x the value of the node's payload
     * @return a freshly-constructed node
     */
    @Override
    public BstNode<T> makeTreeNode(T x) {
        return new AvlNode<T>(x);
    }
    
    /**
     * Delete a node from the tree
     * 
     * Wraps the delete method in the superclass (BinarySearchTree)
     * 
     * @param root root of sub-tree
     * @param x vale of node to remove
     * @return root of (modified) sub-tree
     * @throws BstMissingKeyException if node with value k not found
     */
    @Override
    public BstNode<T> delete(BstNode<T> root, T x)
            throws BstMissingKeyException
    {
        return rebalance(super.delete(root, x));
    }
    
    private BstNode<T> insertRecursive(BstNode<T> root, T x)
            throws BstDuplicateKeyException
    {
        if (root == null) {
            return makeTreeNode(x);
        } else if (x.compareTo(root.x) < 0) {
            root.left = insert(root.left, x);
            root.left.parent = root;
        } else if (x.compareTo(root.x) > 0) {
            root.right = insert(root.right, x);
            root.right.parent = root;
        } else {
            throw new BstDuplicateKeyException(x.toString());
        }
        return root;
    }

    
    /**
     * Insert a new node into a given sub-tree
     * 
     * Normally wraps the insert method in the superclass (BinarySearchTree).
     * But in case the student implemented an iterative insert method we
     * supply our own recursive version and use that instead.
     * 
     * @param root root of the sub-tree
     * @param x value of the node to be inserted
     * @return root of the (modified) sub-tree
     * @throws BstDuplicateKeyException when the value already exists
     */   
    @Override
    public BstNode<T> insert(BstNode<T> root, T x) 
            throws BstDuplicateKeyException
    {
        return rebalance(insertRecursive(root, x));
    }
    
    /**
     * Perform a left rotation of a tree
     * 
     * Wraps the rotateLeft method in the superclass (BinarySearchTree)
     * 
     * @param tree root of (sub-)tree to rotate
     * @return new root of rotated (sub-)tree
     */
    @Override
    protected BstNode<T> rotateLeft(BstNode<T> tree) {
        tree = super.rotateLeft(tree);
        updateHeight(tree.left);
        updateHeight(tree);
        
        return tree;
    }

    /**
     * Perform a right rotation of a tree
     * 
     * Wraps the rotateRight method in the superclass (BinarySearchTree)
     * 
     * @param tree root of (sub-)tree to rotate
     * @return new root of rotated (sub-)tree
     */
    @Override
    protected BstNode<T> rotateRight(BstNode<T> tree) {
        tree = super.rotateRight(tree);
        updateHeight(tree.right);
        updateHeight(tree);
        
        return tree;
    }

    /**
     * Keep tree balanced
     * 
     * Called after any insert or delete to ensure the heights
     * of the sub-trees of every node in the tree only differ in height 
     * by at most 1.
     * 
     * @param root root of sub-tree to re-balance
     * @return new root of (modified) sub-tree
     */
    BstNode<T> rebalance(BstNode<T> root) {
        if (root == null) return null;
        
        updateHeight(root);
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases:
        // * Left Left: left child of left child is heavy
        // * Left Right: right child of left child is heavy
        // * Right Left: left child of right child is heavy
        // * Right Right: right child of right child is heavy
        //
        if (balance < -1 && getBalance(root.left) <= 0) {
            // Left Left
            root = rotateRight(root);
        } else if (balance < -1 && getBalance(root.left) > 0) {
            // Left Right
            root.left = rotateLeft(root.left);
            root = rotateRight(root);
        } else if (balance > 1 && getBalance(root.right) < 0) {
            // Right Left
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
        } else if (balance > 1 && getBalance(root.right) >= 0) {
            // Right Right
            root = rotateLeft(root);
        }
        
        return root;
    }
    
    /**
     * Update the height of a node
     * 
     * The height of a node is one greater than the maximum height of
     * its sub-trees (by definition).
     * 
     * @param node node to update
     */
    void updateHeight(BstNode<T> node) {
        ((AvlNode<T>)node).height = 1 + Math.max(getHeight(node.left), 
                                                 getHeight(node.right));
    }
    
    /**
     * Get the balance of a node
     * 
     * The balance is the difference in height between its left and right
     * subtrees.  Pick a direction and stick with it.  We use RIGHT-LEFT.
     * 
     * @param node node to examine
     * @return balance
     */
    int getBalance(BstNode<T> node) {
        return getHeight(node.right) - getHeight(node.left);
    }
    
    /**
     * Get the height of a node
     * 
     * A leaf node has a height of 0.  If a node is missing, return -1
     * @param child node to examine
     * @return height of node (or -1)
     */
    int getHeight(BstNode<T> child) {
        if (child == null) return -1;
        return ((AvlNode<T>)child).height;
    }

    /*
     *   Helper functions for debugging and testing.
     */
    
    /**
     * Show the height and balance of each node as well.
     * 
     * @param tree
     * @return 
     */
    @Override
    public String preOrder(BstNode<T> tree) {
        if (tree == null) return "";
        
        int height = getHeight(tree);
        int balance = getBalance(tree);
        return String.format("%s(H%d,%d) {%s} {%s}", 
                tree.x.toString(), height, balance,
                preOrder(tree.left),
                preOrder(tree.right));
    }

}
