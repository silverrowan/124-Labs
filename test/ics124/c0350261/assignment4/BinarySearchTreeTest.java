package ics124.c0350261.assignment4;
import ics124.assignment4.BstNode;
import ics124.assignment4.*;

import org.junit.Test;
import org.junit.Before;
//import org.junit.After;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    // The BinarySearchTree under test and some nodes
    // in it.  Created anew before each test.
    BinarySearchTree<Integer> bst;
    BstNode<Integer> a;
    BstNode<Integer> b;
    BstNode<Integer> c;
    BstNode<Integer> x;
    BstNode<Integer> y;
    
    /**
     * This method is called before every @Test.
     * 
     * It sets up a known tree structure that we can operate on.
     * We hand-roll the structure and assign it into the BinarySearchTree
     * object so we don't rely on .insert working correctly to set up
     * other tests.
     */
    @Before
    public void setupTestFixture() {
        bst = new BinarySearchTree<>();
        
        x = bst.makeTreeNode(20);
        a = bst.makeTreeNode(10);
        a.parent = x;
        x.left = a;
        y = bst.makeTreeNode(40);
        y.parent = x;
        x.right = y;
        b = bst.makeTreeNode(30);
        b.parent = y;
        y.left = b;
        c = bst.makeTreeNode(50);
        c.parent = y;
        y.right = c;
        
        bst.root = x;
    }
    
    /**
     * Verify that all parent pointers in the tree
     * actually point to their parent nodes.
     * 
     * @param tree the subtree to examine
     */
    public void verifyParentPointers(BstNode<Integer> tree) {
        if (tree == null) return;
        if (tree.left != null) {
            assertEquals(tree, tree.left.parent);
            verifyParentPointers(tree.left);
        }
        if (tree.right != null) {
            assertEquals(tree, tree.right.parent);
            verifyParentPointers(tree.right);
        }
    }
    
    @Test
    public void testInitial() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertNull(tree.root);
        assertEquals("", tree.preOrder(tree.root));
    }
    
    @Test
    public void testFind() {
        BstNode<Integer> twenty = bst.find(20);
        assertEquals(x, twenty);
        BstNode<Integer> ten = bst.find(10);
        assertEquals(a, ten);
        BstNode<Integer> thirty = bst.find(30);
        assertEquals(b, thirty);
        BstNode<Integer> fifty= bst.find(50);
        assertEquals(c, fifty);
        assertNull(bst.find(25));
    }
    
    @Test
    public void testInsertInitial() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        assertEquals("1 <> <>", tree.preOrder(tree.root));
    }

    @Test
    public void testInsertFurthestLeft() {
        Integer five = 5;
        bst.insert(five);
        assertEquals(five, bst.min().x);
        assertEquals("20 <10 <5 <> <>> <>> <40 <30 <> <>> <50 <> <>>>",
                bst.preOrder(bst.root));
    }
    
    @Test
    public void testInsertInnerLeft() {
        bst.insert(25);
        assertEquals("20 <10 <> <>> <40 <30 <25 <> <>> <>> <50 <> <>>>",
                bst.preOrder(bst.root));
    }

    @Test
    public void testInsertInnerRight() {
        bst.insert(15);
        assertEquals("20 <10 <> <15 <> <>>> <40 <30 <> <>> <50 <> <>>>",
                bst.preOrder(bst.root));
    }
    
    @Test
    public void testInsertFurthestRight() {
        Integer fiftyFive = 55;
        bst.insert(fiftyFive);
        assertEquals(fiftyFive, bst.max().x);
        assertEquals("20 <10 <> <>> <40 <30 <> <>> <50 <> <55 <> <>>>>",
                bst.preOrder(bst.root));
    }
    
    @Test
    public void testMin() {
        assertEquals(a, bst.min(bst.root));
    }

    @Test
    public void testNullMin() {
        // Empty tree has no min
        assertNull(bst.min(null));
    }
    @Test
    public void testMax() {
        assertEquals(c, bst.max(bst.root));
    }

    @Test
    public void testNullMax() {
        // Empty tree has no max
        assertNull(bst.max(null));
    }
    
    @Test
    public void testMinPred() {
        assertNull(bst.pred(a));        
    }
    
    @Test
    public void testPredWithLeftSubtree() {
        assertEquals(a, bst.pred(x));
    }
    
    @Test
    public void testPredNoLeftSubtree() {
        assertEquals(x, bst.pred(b));
        
    }
    
    @Test
    public void testNullPred() {
        assertNull(bst.pred(null));
    }
    
    @Test
    public void testMaxSucc() {
        assertNull(bst.succ(c));
    }
    
    @Test
    public void testSuccRightSubtree() {
        assertEquals(c, bst.succ(y));
    }
    
    @Test
    public void testSuccNoRightSubtree() {
        assertEquals(x, bst.succ(a));        
    }
    
    @Test
    public void testNullSucc() {
        assertNull(bst.succ(null));
    }

    @Test
    public void testDeleteRoot() {
        bst.delete(20);
        // Can't compare nodes, .delete() moves contents around.
        assertEquals(b.x, bst.root.x);
        assertEquals(" 10  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("30 <10 <> <>> <40 <> <50 <> <>>>",
                bst.preOrder(bst.root));
        verifyParentPointers(bst.root);
    }

    @Test
    public void testDeleteLeftLeaf() {
        bst.delete(10);
        assertEquals(" 20  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("20 <> <40 <30 <> <>> <50 <> <>>>",
                bst.preOrder(bst.root));
        verifyParentPointers(bst.root);
    }

    @Test
    public void testDeleteRightLeaf() {
        bst.delete(50);
        assertEquals(" 10  20  30  40 ", bst.inOrder(bst.root));
        assertEquals("20 <10 <> <>> <40 <30 <> <>> <>>",
                bst.preOrder(bst.root));
        verifyParentPointers(bst.root);
    }

    @Test
    public void testDeleteInnerLeaf() {
        bst.delete(30);
        assertEquals(" 10  20  40  50 ", bst.inOrder(bst.root));
        assertEquals("20 <10 <> <>> <40 <> <50 <> <>>>",
                bst.preOrder(bst.root));
        verifyParentPointers(bst.root);
    }

    @Test
    public void testDeleteInnerNode() {
        bst.delete(40);
        // Can't examine nodes, .delete moves contents around.
        assertEquals(c.x, x.right.x);
        assertEquals(" 10  20  30  50 ", bst.inOrder(bst.root));
        assertEquals("20 <10 <> <>> <50 <30 <> <>> <>>", 
                bst.preOrder(bst.root));
        verifyParentPointers(bst.root);
    }
    
    @Test
    public void testDeleteLastNode() {
        bst.delete(10);
        bst.delete(20);
        bst.delete(30);
        bst.delete(40);
        bst.delete(50);
        assertNull(bst.root);
    }

    @Test
    public void testRotateRoot() {
        // Do a left rotation around X, the root.
        // The new root should be Y, but the lexicographic
        // ordering should be unchanged.
        bst.root = bst.rotateLeft(bst.root);
        assertEquals(" 10  20  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("40 <20 <10 <> <>> <30 <> <>>> <50 <> <>>", 
                bst.preOrder(bst.root));
        assertEquals(y, bst.root);
        assertNull(y.parent);
        verifyParentPointers(bst.root);
        
        // Do a right rotation around the root (now Y)
        // This should put us back to the original condition
        bst.root = bst.rotateRight(bst.root);
        assertEquals(" 10  20  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("20 <10 <> <>> <40 <30 <> <>> <50 <> <>>>",
                bst.preOrder(bst.root));
        assertEquals(x, bst.root);
        assertNull(x.parent);
        verifyParentPointers(bst.root);
    }
    
    @Test
    public void testRotateSubtree() {
        bst.root.right = bst.rotateLeft(bst.root.right);
        assertEquals(c, bst.root.right);
        assertEquals(" 10  20  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("20 <10 <> <>> <50 <40 <30 <> <>> <>> <>>",
                bst.preOrder(bst.root));
        bst.root.right = bst.rotateRight(bst.root.right);
        // Should be back to original condition
        assertEquals(" 10  20  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("20 <10 <> <>> <40 <30 <> <>> <50 <> <>>>",
                bst.preOrder(bst.root));
    }
    
    @Test
    public void testRotateToLeafNode() {
        // We can rotate a node to a leaf child, the
        // resulting tree is all on the other side.
        bst.root = bst.rotateRight(bst.root);
        assertEquals(a, bst.root);
        assertEquals(" 10  20  30  40  50 ", bst.inOrder(bst.root));
        assertEquals("10 <> <20 <> <40 <30 <> <>> <50 <> <>>>>",
                bst.preOrder(bst.root));
    }

    @Test
    public void testRotateLeafIsError() {
        // Right child of left-rotating node cannot be null
        assertThrows(NullPointerException.class, 
                () -> bst.rotateLeft(bst.root.left));
    }
    
    @Test
    public void testRotateLeftUpdatesParent() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(40);
        tree.insert(30);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        BstNode n = tree.find(2);
        tree.rotateLeft(n);
        verifyParentPointers(tree.root);
    }
    @Test
    public void testRotateRightUpdatesParent() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        BstNode n = tree.find(10);
        tree.rotateRight(n);
        verifyParentPointers(tree.root);
    }
}
