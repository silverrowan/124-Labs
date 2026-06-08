package ics124.c0350261.assignment3;
import ics124.assignment3.*;

public class StackUsingArray implements Ics124Stack {
    private Integer[] data;
    private int used;

    public StackUsingArray(int capacity) {
        throw new UnsupportedOperationException("write me!");
    }
    public StackUsingArray() {
        throw new UnsupportedOperationException("write me!");
    }
    
    @Override
    public boolean isEmpty() {
        if ( used == 0 ) { return true; }
        else { return false; }
//        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public Integer peek() {
        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public Integer pop() {
        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public void push(Integer a) {
        throw new UnsupportedOperationException("write me!");
    }

    @Override
    public int size() {
        return used;
    }
    
}
