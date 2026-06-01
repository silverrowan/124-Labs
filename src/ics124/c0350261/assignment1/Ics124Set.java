package ics124.c0350261.assignment1;
import java.util.AbstractSet;
import java.util.Iterator;

public class Ics124Set extends AbstractSet<Integer>{
    private final int CAPACITY = 100;
    private int data[];
    private int next = 0; //position number/countFrom0 of the next data to be added
    
    public Ics124Set() {
        data = new int[CAPACITY];
        next = 0;
    }
    
    private class Ics124SetIterator implements Iterator<Integer> {
        private int iterPos = 0;
        
        @Override
        public boolean hasNext() {
            return iterPos < next; //if 'next' is greater than iterPos, set has a Next
        }

        @Override
        public Integer next() {
            if ( hasNext() ) {
                return data[iterPos++]; //return value of data at iterPos, then +1 to iterPos
                // throw new UnsupportedOperationException("write me!");
            }
            else {
                throw new UnsupportedOperationException ("doesn't have a next value");
            }
        }
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new Ics124SetIterator();
    }

    @Override
    public int size() {
        return next;
    }

    @Override
    public boolean isEmpty() {
        return next == 0; //if the next variable is 0 return true, else false
//        throw new UnsupportedOperationException("write me!");
    }
    
    @Override
    public boolean contains(Object o) {
    // use enhanced for loop (for each) & call iterator *indirectly*
    // why are we seraching for an object and not an int?
        boolean isIn = false;
        for (Object num : data) {
            if ( o.equals(num) ) { 
                isIn = true;
                break;
            }
        }
        return isIn;
}

    @Override
    public boolean add(Integer e) {
// should return false if 'i' is already present
// should return false if set is at capacity
// return true if add data was successful
// throw new UnsupportedOperationException("write me!");
        if (next >= CAPACITY) { 
            System.out.println("Ics124Set is full");
            return false; 
        }
        if ( this.contains(e) ) {
            System.out.println("Already contains value " + e);
            return false; 
        }
        try {
            data[next++] = e;
            return true;
        } catch (Exception ex) {
            System.out.println("cannot add "+ e + ", error: " + ex );
            return false;
        }
   }

    @Override
    public void clear() { //assuming clear all
        for (Object num : data) {
            num = 0;
        }
        next = 0;
    }
}

