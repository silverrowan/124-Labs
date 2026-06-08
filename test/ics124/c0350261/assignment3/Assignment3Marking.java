package ics124.c0350261.assignment3;

import ics124.assignment3.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Assignment3Marking {
    public Assignment3Marking() {
    }
    
    @Test
    public void testEmptyArrayStack() {
        Ics124Stack s = new StackUsingArray();
        assertTrue(s.isEmpty());
        assertFalse(s.isFull());
        assertThrows(StackUnderflowException.class, () -> s.peek());
        assertThrows(StackUnderflowException.class, () -> s.pop());
    }
    @Test
    public void testEmptyListStack() {
        Ics124Stack s = new StackUsingList();
        assertTrue(s.isEmpty());
        assertFalse(s.isFull());
        assertThrows(StackUnderflowException.class, () -> s.peek());
        assertThrows(StackUnderflowException.class, () -> s.pop());
    }
    @Test
    public void testArrayStackOverflow() {
        Ics124Stack s = new StackUsingArray(1);
        s.push(123);
        assertTrue(s.isFull());
        assertThrows(StackOverflowException.class, () -> s.push(456));
        assertEquals(123, (int)s.peek());
        assertEquals(123, (int)s.pop());
        assertTrue(s.isEmpty());
    }
    @Test
    public void testArrayPushPopOrdering() {
        Ics124Stack s = new StackUsingArray();
        
        s.push(123);
        s.push(456);
        s.push(789);
        
        assertEquals(789, (int)s.pop());
        assertEquals(456, (int)s.pop());
        assertEquals(123, (int)s.pop());
        assertTrue(s.isEmpty());
    }
    @Test
    public void testListPushPopOrdering() {
        Ics124Stack s = new StackUsingList();
        
        s.push(123);
        s.push(456);
        s.push(789);
        
        assertEquals(789, (int)s.pop());
        assertEquals(456, (int)s.pop());
        assertEquals(123, (int)s.pop());
        assertTrue(s.isEmpty());
    }    
}
