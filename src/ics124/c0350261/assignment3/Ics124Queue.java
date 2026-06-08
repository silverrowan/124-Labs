package ics124.c0350261.assignment3;

import ics124.c0350261.assignment2.Ics124DoublyLinkedList;

/**
 *
 * @author Mariah Malczewska
 */
public class Ics124Queue<E> {

    Ics124DoublyLinkedList<E> queue;

    public Ics124Queue() {
        Ics124DoublyLinkedList queue = new Ics124DoublyLinkedList();
    }

    public void enqueue(E e) {
        queue.add(0, e); //CURRENTLY ADDS TO HEAD - CORRECT
    } // insert at tail 

    public E dequeue() {
        return queue.remove(0);
    } //remove from head

    public E first() {
        return queue.get(0);
    }

    public boolean isEmpty() {
        return (queue.size() == 0);
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return queue.size();
    }
}
