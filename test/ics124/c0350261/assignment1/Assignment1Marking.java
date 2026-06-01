package ics124.c0350261.assignment1;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class Assignment1Marking {
    
    Ics124Set testee;
    
    public Assignment1Marking() {
        testee = new Ics124Set();
    }

    @Test
    public void testIterator() {
        testee.add(123);
        testee.add(456);
        Iterator<Integer> iter = testee.iterator();
        assertTrue(iter.hasNext());
        assertEquals((Integer)123, iter.next());
        assertTrue(iter.hasNext());
        assertEquals((Integer)456, iter.next());
        assertFalse(iter.hasNext());
        
    }

    @Test
    public void testSize() {
        assertEquals(0, testee.size());
        testee.add(123);
        assertEquals(1, testee.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(testee.isEmpty());
        testee.add(123);
        assertFalse(testee.isEmpty());
    }

    @Test
    public void testContains() {
        testee.add(123);
        assertTrue(testee.contains(123));
    }

    @Test
    public void testAdd() {
        assertTrue(testee.add(123));
        assertFalse(testee.add(123));
    }

    @Test
    public void testClear() {
        testee.add(123);
        testee.clear();
        assertTrue(testee.isEmpty());
    }
    
}
