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
        else if ( i == n-1 ) { 
            DLNode current = boundary.prev; 
            return current;
        }
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
        return n;
    }

    @Override
    public T get(int i) { return getNode(i).x; }

    @Override
    public void set(int i, T x) {
        if (i == n) { add(i, x); }
        else { getNode(i).x = x; }
    }
 

    @Override
    public void add(int i, T x) {
        if (i < 0 || i > n) { throw new IndexOutOfBoundsException(); } //accepts i = 0 & i = n

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
        n++;
    }       

    @Override
    public T remove(int i) {
        if (i < 0 || i >= n) { throw new IndexOutOfBoundsException(); } //accepts i = 0 & i = n
        else {
            DLNode currNode = getNode(i);
// because maintaining the boundary node the links to the BN should remain - so 
// doesnt matter which posn being removed, .next & .prev will be correct one
            DLNode prevNode;
            DLNode nextNode;     
                prevNode = currNode.prev;
                nextNode = currNode.next;
            prevNode.next = currNode.next;
            nextNode.prev = currNode.prev;
            n--;
        return currNode.x; //
        }
    }
}
