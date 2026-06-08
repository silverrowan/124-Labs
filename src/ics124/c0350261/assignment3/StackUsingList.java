package ics124.c0350261.assignment3;
import ics124.c0350261.assignment2.Ics124SinglyLinkedList;

public class StackUsingList implements Ics124Stack {
    private Ics124SinglyLinkedList data;
    private int used;

    public StackUsingList(int capacity) {
        data = new Ics124SinglyLinkedList();
        used = 0;
    }

    public StackUsingList() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        System.out.println("isEmpty Check");
        if ( used == 0 ) { return true; }
        else { return false; }
    }

    @Override
    public boolean isFull() {
        System.out.println("isFull Check");
        System.out.println("data.length: " + data.size() + " used: " + used);
        return false;
    }

    @Override
    public Integer peek() {
        if (used == 0) { 
            throw new StackUnderflowException("The stack is empty");
        } else {
            System.out.println("peek returns: " + data.get(used - 1));
            return (Integer) data.get(used - 1);
        }
    }

    @Override
    public Integer pop() {
        if (used == 0) { 
            throw new StackUnderflowException("The stack is empty");
        } else {
//            decrements used then
//            uses decreased used value to find the final value 
//            (used starts at 1, index starts at 0 
            Integer popVal = (Integer) data.get(--used);
            data.set(used, 0);
            //sets 'popped' position back to default
            return popVal;
        }
    }

    @Override
    public void push(Integer a) {
            data.set(used, a);
            used ++;
        }
//        throw new UnsupportedOperationException("write me!");
    

    @Override
    public int size() {
        return used;
    }

}
