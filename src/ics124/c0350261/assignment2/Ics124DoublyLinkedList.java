package ics124.c0350261.assignment2;
import ics124.c0350261.assignment2.Ics124List;

public class Ics124DoublyLinkedList<T> implements Ics124List<T> {
    final class DLNode {
        T x;
        DLNode prev, next;
    };
    DLNode boundary;
    int n;
    
    final DLNode makeNode(T x) {
        DLNode node = new DLNode();
        node.x = x;
        node.prev = null;
        node.next = null;
        return node;
    }
    
    public Ics124DoublyLinkedList() {
        boundary = makeNode(null);
        boundary.prev = boundary;
        boundary.next = boundary;
        n = 0;
    }
    
    private DLNode getNode(int i) {
        if (i < 0 || i >= n) { throw new IndexOutOfBoundsException(); } //i=n doesn't exist
        else {
            DLNode current = boundary.next;
            for ( int j = 0 ; j < i ; j++ ) {
                current = current.next;
            }
        return current;
        }
    }
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public T get(int i) { return getNode(i).x; }

    @Override
    public void set(int i, T x) {
        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) { throw new IndexOutOfBoundsException(); } //accepts i = 0 & i = n

//        DLNode current = makeNode(x);
//        if (i == 0) { 
//            current.next = boundary.next;
//            current.prev = boundary;
//            boundary.next = current;
//        } else if (i == n) {
//            current.next = boundary;
//            current.prev = boundary.prev;
//            boundary.prev = current;
//        } else {
//            DLNode prevNode = getNode(i-1);
//            DLNode nextNode = getNode(i);
//            current.next = nextNode;
//            current.prev = prevNode;
//            nextNode.prev = current;
//            prevNode.next = current;
        DLNode current = makeNode(x);
        DLNode prevNode;
        DLNode nextNode;
        if (i == 0) { 
            prevNode = boundary;
            nextNode = boundary.next;
        } else if (i == n) {
            prevNode = boundary.prev;
            nextNode = boundary;
        } else {
            prevNode = getNode(i-1);
            nextNode = getNode(i);
        }
            current.prev = prevNode;
            current.next = nextNode;
            nextNode.prev = current;
            prevNode.next = current;
    }       

    @Override
    public T remove(int i) {
        throw new UnsupportedOperationException("write me!");
    }
    
}
