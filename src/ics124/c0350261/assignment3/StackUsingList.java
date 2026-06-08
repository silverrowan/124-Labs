package ics124.c0350261.assignment3;
import ics124.c0350261.assignment2.Ics124SinglyLinkedList;

public class StackUsingList implements Ics124Stack {
    private Ics124SinglyLinkedList data;
//    private int used;

    public StackUsingList(int capacity) {
        data = new Ics124SinglyLinkedList();
//        used = 0;
    }

    public StackUsingList() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        System.out.println("isEmpty Check");
        if ( data.size() == 0 ) { return true; }
        else { return false; }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Integer peek() {
        if (data.size() == 0) { 
            throw new StackUnderflowException("The stack is empty");
        } else {
            return (Integer) data.get(0);
        }
    }

    @Override
    public Integer pop() {
        if (data.size() == 0) { 
            throw new StackUnderflowException("The stack is empty");
        } else {
            return (Integer) data.remove(0);
        }
    }

    @Override
    public void push(Integer a) {
            data.add(0, a);
        }    

    @Override
    public int size() {
        return data.size();
    }

}
