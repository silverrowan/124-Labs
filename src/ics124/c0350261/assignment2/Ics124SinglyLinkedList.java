package ics124.c0350261.assignment2;
import ics124.c0350261.assignment2.Ics124List;

public class Ics124SinglyLinkedList<T> implements Ics124List<T> {
    final class SLNode {
        T x;
        SLNode next;
    };
    SLNode head;
    SLNode tail;
    int n;
    
    final SLNode makeNode(T x) {
        SLNode node = new SLNode();
        node.x = x;
        return node;
    }
    
    public Ics124SinglyLinkedList() {
        head = null;
        tail = null;
        n = 0;
    }
    
    @Override
    public int size() {
        return n;
    }

    @Override
    public T get(int i) {
        if ( i >= n || n == 0 || i < 0) { throw new IndexOutOfBoundsException(); }
        else { return getNode(i).x; }
    }
    
    private SLNode getNode(int i) {
        SLNode current = head;
        for ( int j = 0 ; j <= i ; j++ ) {
            System.out.println("Before Iteration position: " + j + " NodeValue: " + current.x + " NextNode: " + current.next);
            current = current.next;
            System.out.println("After Iteration position: " + j + " NodeValue: " + current.x + " NextNode: " + current.next);
        }
        return current;
    }
    
    

    @Override
    public void set(int i, T x) {
        SLNode current = getNode(i);
        current.x = x;
    }

    @Override
    public void add(int i, T x) {
        if (i > n || i < 0) { throw new IndexOutOfBoundsException(); }
        else if (n == 0) {
            SLNode node = makeNode(x);
            head = tail = node;
            n++;
            //NOT assigning value to next as there is no next to reference
        } else { 
            //ASSIGN posn of new node to next of prev & make next w/ value of x
           SLNode prevNode = getNode( i-2 );
//            SLNode prevNode = head;
//            for ( int j = 0 ; j < i - 1 ; j++ ) {
//                System.out.println("Before Iteration position: " + j + " NodeValue: " + prevNode.x + " NextNode: " + prevNode.next);
//                prevNode = prevNode.next;
//                System.out.println("After Iteration position: " + j + " NodeValue: " + prevNode.x + " NextNode: " + prevNode.next);
//            }
            SLNode newNode = makeNode(x);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            n++;
        }
    }

    @Override
    public T remove(int i) {
        if (i > n || i < 0) { throw new IndexOutOfBoundsException(); }
//        else if (i == 0) { head = this new node }
        else {
            
        }
    }
}
