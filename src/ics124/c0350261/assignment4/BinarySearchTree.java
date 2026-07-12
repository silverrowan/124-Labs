package ics124.c0350261.assignment4;
import ics124.assignment4.BstIllegalOperationException;
import ics124.assignment4.BstNode;
import ics124.assignment4.BstMissingKeyException;
import ics124.assignment4.BstDuplicateKeyException;
import ics124.assignment4.BstBase;
import ics124.assignment4.*;

public class BinarySearchTree<T extends Comparable<T>> extends BstBase<T> {
    
    BstNode root;
    private int nodeCount;
    private int levelsDeep;
    
    public BinarySearchTree() {
        this.root = null;
        this.nodeCount = 0;
        this.levelsDeep = 0;
    }

    /**
     * Insert a new node into a given sub-tree
     * 
     * @param node root of the sub-tree
     * @param k value of the node to be inserted
     * @return root of the (modified) sub-tree
     * @throws BstDuplicateKeyException when the value already exists
     */
    @Override
    public BstNode<T> insert(BstNode<T> node, T k) throws BstDuplicateKeyException {
        if (nodeCount == 0) {
            root = makeTreeNode(k);
            nodeCount++;
        } else if ( node.x.compareTo(k) == 0 ) { throw new BstDuplicateKeyException("Value Already Exists"); 
        } else if ( node.x.compareTo(k) > 0 ) {
            node.left = insert(node.left, k);
            node.left.parent = node;
        } else { // x < k
            node.right = insert(node.right, k);
            node.right.parent = node;
        }
        return node;
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
    public BstNode delete(BstNode<T> node, T k) throws BstMissingKeyException {
        BstNode target = find(k); // this doesnt ever seem to report not finding value....
//        BstNode parent = target.parent;
//        if ( target.left == null && target.right == null ) {
//            if ( parent == null ) { root = null; }
//            if (parent.right == target) { parent.right = null; }
//            else { parent.left = null; }
//            nodeCount--;
//        } else if ( target.left == null ) {
//            if ( parent == null ) { root = target.right; }
//            else if ( parent.left == target ) { parent.left = target.right; }
//            else { parent.right = target.right; } // if target is in right arm of parent
//        } else if (target.right ==  null ) {
//            if ( parent == null ) { root = target.left; }
//            else if ( parent.left == target ) { parent.left = target.left; }
//            else { parent.right = target.left; }
//        } else { //target right and left are populated
//            if ( parent.left == target ) {}
        try {
            if (target.left == null || target.right == null) {
                splice(target);
            } else {
                BstNode w = min(target.right);
                target.x = w.x;
                splice(w);
            }
            return null;
        } catch(BstIllegalOperationException e) {
            System.out.println(e);
            return null;
        }
    }
    
    
    public void splice( BstNode delNode ) throws BstIllegalOperationException {
        if ( delNode.left != null && delNode.right != null ) {
            throw new BstIllegalOperationException("cannot splice with two children");
        }
        BstNode child;
        if ( delNode.left != null ) {
            child = delNode.left;
        } else { 
            child = delNode.right;
        }
        
        BstNode cParent = child.parent;
        if ( delNode == root ) {
            root = child;
            cParent = null;
        } else {
            BstNode dParent = delNode.parent;
            cParent = dParent;
            if ( dParent.left == delNode ) {
                dParent.left = child;
            } else {
                dParent.right = child;
            }
        }
        if ( child != null ) {
            child.parent = cParent;
        }
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
        if ( node.right != null ) {
            return min( node.right );
        } else {
            BstNode parentNode = node.parent;
            while ( parentNode != null && node == parentNode.right ) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
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
        if ( node.left !=null ) {
            return max( node.left );
        } else {
            BstNode parentNode = node.parent;
            while ( parentNode != null && node == parentNode.left ) {
                node = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }        
    }    
}

