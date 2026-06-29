package ics124.assignment4;

/*
 * Abstract base class for your BinarySearchTree class.
 * 
 * This holds helper functions and useful fields for you.
 * 
 */
public abstract class BstBase<T extends Comparable<T>> implements BST<T> {
    /**
     * The root node of the tree.
     */
    public BstNode<T> root;
    
    /**
     * Factory function to create a tree node.
     * 
     * This allows test cases to hand-craft nodes in a tree without
     * access to the BstNode constructor (which they cannot access).
     * 
     * @param x the value of the node's payload
     * @return a freshly-constructed node
     */
    public BstNode<T> makeTreeNode(T x) {
        return new BstNode<>(x);
    }
    
    /**
     * Insert a node into the tree
     * 
     * Syntactic sugar around insert(BstNode node, T k).  Will
     * return false if the node would result in duplicate values.
     * 
     * @param k value of node's payload
     * @return true on success
     */
    @Override
    public boolean insert(T k) {
        try {
        root = insert(root, k);
        } catch (BstDuplicateKeyException e) {
            return false;
        }
        return true;
    }
    /**
     * Insert a new node into a given subtree
     * 
     * @param node root of the subtree
     * @param k value of the node to be inserted
     * @return root of the (modified) subtree
     * @throws BstDuplicateKeyException when the value already exists
     */
    public abstract BstNode<T> insert(BstNode<T> node, T k)
            throws BstDuplicateKeyException;
    
    /**
     * Delete a node from the tree
     * 
     * Syntactic sugar around delete(BstNode node, T k).  Will
     * return false if the node with the given value is not found.
     * 
     * @param k value of node to remove
     * @return true on success
     */
    @Override
    public boolean delete(T k) {
        try {
            root = delete(root, k);
        } catch (BstMissingKeyException e) {
            return false;
        }
        return true;
    }
    
    /**
     * Delete a node from the tree
     * @param node root of subtree
     * @param k vale of node to remove
     * @return root of (modified) subtree
     * @throws BstMissingKeyException if node with value k not found
     */
    public abstract BstNode delete(BstNode<T> node, T k)
            throws BstMissingKeyException;
    
    /**
     * Perform a left rotation of a tree
     * 
     * @param tree root of tree to rotate
     * @return new root of rotated tree
     */
    protected abstract BstNode<T> rotateLeft(BstNode<T> tree);
    
    /**
     * Perform a right rotation of a tree
     * 
     * @param tree root of tree to rotate
     * @return new root of rotated tree
     */
    protected abstract BstNode<T> rotateRight(BstNode<T> tree);

    /**
     * Find the successor of a node
     * 
     * The successor of a node is the node with the next higher value.
     * The successor of the maximum node is null.
     * 
     * @param node starting node
     * @return next higher node (or null)
     */
    public abstract BstNode<T> succ(BstNode<T> node);
    
    /**
     * Find the predecessor of a node
     * 
     * The predecessor of a node is the node with the next lower value.
     * The predecessor of the minimum node is null.
     * 
     * @param node starting node
     * @return next lower node (or null)
     */
    public abstract BstNode<T> pred(BstNode<T> node);

    /**
     * Constructor.  Called by BinarySearchTree's constructor.
     */
    public BstBase() {
        root = null;
    }
    
    /**
     * Find a node by value
     * 
     * @param x value to find
     * @return node with value (or null)
     */
    @Override
    public BstNode<T> find(T x) {
        return findIterative(root, x);
    }
    
    /**
     * Find a node by value, recursively
     * 
     * @param tree subtree to examine
     * @param x value searched for
     * @return node with value (or null)
     */
    public BstNode<T> findRecursive(BstNode<T> tree, T x) {
        if (tree == null || x.compareTo(tree.x) == 0)
            return tree;
        else if (x.compareTo(tree.x) < 0)
            return findRecursive(tree.left, x);
        else 
            return findRecursive(tree.right, x);
    }
    
    /**
     * Find a node by value, iteratively
     * 
     * @param root subtree to examine
     * @param x value to search for
     * @return node with value (or null)
     */
    public BstNode<T> findIterative(BstNode<T> root, T x) {
        BstNode<T> runner = root;
        while (runner != null && x.compareTo(runner.x) != 0) {
            if (x.compareTo(runner.x) < 0)
                runner = runner.left;
            else
                runner = runner.right;
        }
        return runner;
    }
    
    /**
     * Find the minimum node in the tree
     * 
     * @return node with minimum value
     */
    public BstNode<T> min() {
        return min(root);
    }
    
    /**
     * Find the minimum node in a subtree
     * 
     * @param tree the subtree to examine
     * @return node with minimum value
     */
    public BstNode<T> min(BstNode<T> tree) {
        if (tree == null) return tree;
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /**
     * Find the maximum node in the tree
     * 
     * @return node with the maximum value
     */
    public BstNode<T> max() {
        return max(root);
    }
    
    /**
     * Find the maximum node in a tree
     * 
     * @param tree subtree to examine
     * @return node with maximum value
     */
    public BstNode<T> max(BstNode<T> tree) {
        if (tree == null) return tree;
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /*
     * The following are useful debugging tools for 
     * displaying the structure of a tree (or subtree).  Preorder
     * allows us to easily show the 2-D structure in a 1-D form.
     * Inorder shows us the lexicographic ordering.  Postorder is
     * only here for completeness.
     */
    
    public String inOrder(BstNode<T> tree) {
        if (tree == null) return "";
        
        return String.format("%s %s %s", 
            inOrder(tree.left),
            tree.x.toString(),
            inOrder(tree.right));
    }

    public String preOrder(BstNode<T> tree) {
        if (tree == null) return "";
        
        return String.format("%s <%s> <%s>", 
                tree.x.toString(),
                preOrder(tree.left),
                preOrder(tree.right));
    }

    public String postOrder(BstNode<T> tree) {
        if (tree == null) return "";
        
        return String.format("%s %s %s", 
            postOrder(tree.left),
            postOrder(tree.right),
            tree.x.toString());
    }
    
}
