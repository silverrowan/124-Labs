package ics124.c0350261.assignment3;

public class StackUsingList implements Ics124Stack {

    private Integer[] data;
    private int used;

    public StackUsingList(int capacity) {
        data = new Integer[capacity];
        used = 0;
    }

    public StackUsingList() {
        data = new Integer[10];
        used = 0;
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
        System.out.println("data.length: " + data.length + " used: " + used);
        if ( used == data.length ) { return true; }
        else { return false; }
    }

    @Override
    public Integer peek() {
        if (used == 0) { 
            throw new StackUnderflowException("The stack is empty");
        } else {
            return data[used - 1];
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
            int popVal = data[--used];
            data[used] = 0; //sets 'popped' position back to default
            return popVal;
        }
    }

    @Override
    public void push(Integer a) {
        if (used == this.data.length) {
            throw new StackOverflowException("The stack is full!");
        } else {
            data[used] = a;
            used ++;
        }
//        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public int size() {
        return used;
    }

}
