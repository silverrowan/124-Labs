package ics124.c0350261.assignment4;
import ics124.assignment4.AvlNode;
import ics124.assignment4.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class AvlTreeTest {
    
    public AvlTreeTest() {
    }

    @Test
    public void testInsertInitial() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(1);
        assertEquals(0, ((AvlNode)tree.root).height);
    }
    @Test
    public void testInsertTwo() {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(1);
        tree.insert(2);
        
        assertEquals(1, ((AvlNode<Integer>)tree.root).height);
    }
    
    @Test
    public void testNullHeight() {
        AvlTree<Integer> tree = new AvlTree<>();
        assertEquals(-1, tree.getHeight(null));
    }
    
    @Test
    public void testInsert() {
        AvlTree<Integer> tree = new AvlTree<>();
        
        tree.insert(10);
        assertEquals("10(H0,0) {} {}", tree.preOrder(tree.root));
        
        tree.insert(20);
        assertEquals("10(H1,1) {} {20(H0,0) {} {}}", tree.preOrder(tree.root));
        
        tree.insert(30);
        assertEquals("20(H1,0) {10(H0,0) {} {}} {30(H0,0) {} {}}", tree.preOrder(tree.root));
        
        tree.insert(40);
        assertEquals("20(H2,1) {10(H0,0) {} {}} {30(H1,1) {} {40(H0,0) {} {}}}", tree.preOrder(tree.root));

        tree.insert(50);
        assertEquals("20(H2,1) {10(H0,0) {} {}} {40(H1,0) {30(H0,0) {} {}} {50(H0,0) {} {}}}",
                tree.preOrder(tree.root));
    }
    
    @Test
    public void testDelete() {
        AvlTree<Integer> tree = new AvlTree<>();
        for(int i = 10; i < 60; i += 10) {
            tree.insert(i);
        }
        assertEquals("20(H2,1) {10(H0,0) {} {}} {40(H1,0) {30(H0,0) {} {}} {50(H0,0) {} {}}}",
                tree.preOrder(tree.root));
        
        tree.delete(50);
        assertEquals("20(H2,1) {10(H0,0) {} {}} {40(H1,-1) {30(H0,0) {} {}} {}}",
                tree.preOrder(tree.root));
        
        tree.insert(50);
        tree.delete(10);
        assertEquals("40(H2,-1) {20(H1,1) {} {30(H0,0) {} {}}} {50(H0,0) {} {}}",
                tree.preOrder(tree.root));
        
    }
}
