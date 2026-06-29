package ics124.c0350261.assignment4;

import ics124.assignment4.BstNode;
import ics124.assignment4.*;

/*
 * AvlTree with "advice" that reports all rotations
 * 
 */
public class VerboseAvlTree<T extends Comparable<T>> extends AvlTree<T> {
    @Override
    protected BstNode<T> rotateLeft(BstNode<T> tree) {
        System.out.println("Rotate left of tree at " + tree.x);
        tree = super.rotateLeft(tree);
        System.out.println("New root is now " + tree.x);
        return tree;
    }
    @Override
    protected BstNode<T> rotateRight(BstNode<T> tree) {
        System.out.println("Rotate right of tree at " + tree.x);
        tree = super.rotateRight(tree);
        System.out.println("New root is now " + tree.x);
        return tree;
    }
}
