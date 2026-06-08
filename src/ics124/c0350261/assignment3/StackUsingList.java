package ics124.c0350261.assignment3;

import ics124.assignment3.*;

public class StackUsingList implements Ics124Stack {

    private Integer[] data;
    private int used;

    public StackUsingList(int capacity) {
        throw new UnsupportedOperationException("write me!");
    }

    public StackUsingList() {
        throw new UnsupportedOperationException("write me!");
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
