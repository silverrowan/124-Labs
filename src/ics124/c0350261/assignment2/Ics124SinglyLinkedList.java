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
        else {
         return getNode(i).x; 
        }
    }
    
    private SLNode getNode(int i) {
        SLNode current = head;
        for ( int j = 0 ; j < i ; j++ ) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void set(int i, T x) {
        if (i > n || i < 0) { throw new IndexOutOfBoundsException(); }
        else if (i == n) { add(i, x); }
        else {
        SLNode current = getNode(i);
        current.x = x;
        }
    }

    @Override
    public void add(int i, T x) {
        if (i > n || i < 0) { throw new IndexOutOfBoundsException(); }
        SLNode newNode = makeNode(x);
        if (n == 0) {
            head = tail = newNode;
            //NOT assigning value to next as there is no next to reference
        } else if (i == 0) { 
            newNode.next = head;
            head = newNode;
        } else { 
            SLNode prevNode = getNode( i-1 );
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            if (i == n) { tail = newNode; }          
        }
        n++;
    }

    @Override
    public T remove(int i) { 
        if (i >= n || i < 0) { throw new IndexOutOfBoundsException(); }
        SLNode currNode;
        if (i == 0) {
            currNode = head;
            head = head.next;
            if(n == 1) {
                tail = null; 
            }
        } else {
            //set tail to prevNode, and prevNode.next to Null
            SLNode prevNode = getNode(i - 1);
            currNode = prevNode.next; 
            if (i == n-1) {
                tail = prevNode;
                prevNode.next = null;
            } else {
                SLNode nextNode = currNode.next;
                prevNode.next = nextNode;
            }
        }
        n--;
        return currNode.x;
    }
}