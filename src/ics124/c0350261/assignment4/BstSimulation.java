package ics124.c0350261.assignment4;
import ics124.assignment4.BstNode;
import ics124.assignment4.*;
import java.util.Random;

public class BstSimulation {

    public static void main(String[] args) {
        final int NODES = 1024;
        final int MAX = 32768;
        assert(MAX > NODES);
        
        Random random = new Random();
        
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AvlTree<Integer> avl = new AvlTree<>();
            
        for (int i = 0; i < NODES; i += 1) {
            int x;
            // Easier to examine if they're all positive and not too large.
            x = Math.abs(random.nextInt()) % MAX;
            // x = i; // insert them in order
            if (avl.insert(x) == false) {
                // Try again.  This random value already in tree.
                i -= 1;
            } else {
                // AVL insert succeeded.  Insert into BST too.
                bst.insert(x);
            }
        }
        System.out.println("Number of nodes: " + NODES);
        System.out.println("Theoretical minimum height: " 
                + (int)(Math.floor(Math.log(NODES)/Math.log(2))));
        System.out.println("Height is number of links to get to the deepest leaf");
        System.out.println("BST height: " + treeHeight(bst));
        System.out.println("AVL height: " + treeHeight(avl));
        
    }
    
    public static int treeHeight(BinarySearchTree bst) {
        int maxDepth = -1;
        BstNode runner = bst.min();
        while (runner != null) {
            maxDepth = Math.max(maxDepth, getDepth(runner));
            runner = bst.succ(runner);
        }
        return maxDepth;
    }
    public static int getDepth(BstNode node) {
        int i = -1;
        while (node != null) {
            i += 1;
            node = node.parent;
        }
        return i;
    }
}