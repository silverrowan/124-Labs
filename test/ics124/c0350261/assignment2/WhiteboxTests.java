package ics124.c0350261.assignment2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WhiteboxTests {
    Ics124SinglyLinkedList<Integer> sll;
    Ics124DoublyLinkedList<Integer> dll;    

    public WhiteboxTests() {
        sll = new Ics124SinglyLinkedList<>();
        dll = new Ics124DoublyLinkedList<>();
    }

    /*
     * The following are "white box" tests.  They know the
     * internals of the classes under test.  The Marking tests
     * only look at the public API (from the interface).
     */
    
    @Test
    public void testSllEmpty() {
        assertNull(sll.head);
        assertNull(sll.tail);
        assertEquals(0, sll.n);
    }
    @Test
    public void testDllEmpty() {
        assertEquals(dll.boundary, dll.boundary.next);
        assertEquals(dll.boundary, dll.boundary.prev);
        assertEquals(0, dll.n);
    }
    @Test
    public void testSllRemoveFinal() {
        sll.add(0, 123);
        
        Integer result = sll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(0, sll.n);
        assertNull(sll.head);
        assertNull(sll.tail);
    }
    @Test
    public void testDllRemoveFinal() {
        dll.add(0, 123);
        
        Integer result = dll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(0, dll.n);
        assertEquals(dll.boundary, dll.boundary.next);
        assertEquals(dll.boundary, dll.boundary.prev);
    }
    @Test
    public void testSllRemoveFront() {
        sll.add(0, 123);
        sll.add(1, 456);
        
        Integer result = sll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(1, sll.n);
        assertEquals((Integer) 456, sll.head.x);
    }
    @Test
    public void testDllRemoveFront() {
        dll.add(0, 123);
        dll.add(1, 456);
        
        Integer result = dll.remove(0);
        
        assertEquals((Integer) 123, result);
        assertEquals(1, dll.n);
        assertEquals((Integer) 456, dll.boundary.next.x);
        assertEquals((Integer) 456, dll.boundary.prev.x);
    }
    @Test
    public void testSllRemoveRear() {
        sll.add(0, 123);
        sll.add(1, 456);

        Integer result = sll.remove(1);
              
        assertEquals((Integer) 456, result);
        assertEquals(1, sll.n);
        assertEquals((Integer) 123, sll.tail.x);
    }
    @Test
    public void testDllRemoveRear() {
        dll.add(0, 123);
        dll.add(1, 456);

        Integer result = dll.remove(1);
              
        assertEquals((Integer) 456, result);
        assertEquals(1, dll.n);
        assertEquals((Integer) 123, dll.boundary.prev.x);
    }
    @Test
    public void testSllRemoveFromMiddle() {
        sll.add(0, 123);
        sll.add(1, 456);
        sll.add(2, 789);

        Integer result = sll.remove(1);
        
        assertEquals((Integer) 456, result);
        assertEquals(2, sll.n);
        assertEquals((Integer) 123, sll.head.x);
        assertEquals((Integer) 789, sll.head.next.x);
        assertEquals((Integer) 789, sll.tail.x);
    }
    @Test
    public void testDllRemoveFromMiddle() {
        dll.add(0, 123);
        dll.add(1, 456);
        dll.add(2, 789);

        Integer result = dll.remove(1);
        
        assertEquals((Integer) 456, result);
        assertEquals(2, dll.n);
        assertEquals((Integer) 123, dll.boundary.next.x);
        assertEquals((Integer) 789, dll.boundary.next.next.x);
        assertEquals((Integer) 789, dll.boundary.prev.x);
    }
    @Test
    public void testSllSetOverwrites() {
        sll.add(0, 123);
        sll.add(1, 456);
        sll.add(2, 789);
        
        sll.set(2, 8910);
        
        assertEquals(3, sll.n);
        assertEquals((Integer) 8910, sll.tail.x);
    }
    @Test
    public void testDllSetOverwrites() {
        dll.add(0, 123);
        dll.add(1, 456);
        dll.add(2, 789);
        
        dll.set(2, 8910);
        
        assertEquals(3, dll.n);
        assertEquals((Integer) 8910, dll.boundary.prev.x);
    }
    @Test
    public void testSllSetOnEmpty() {
        sll.set(0, 123);
        
        assertEquals(1, sll.n);
        assertEquals((Integer) 123, sll.head.x);
    }
    @Test
    public void testDllSetOnEmpty() {
        dll.set(0, 123);
        
        assertEquals(1, dll.n);
        assertEquals((Integer) 123, dll.boundary.next.x);
    }
    @Test
    public void testSllSetExtends() {
        sll.add(0, 123);
        
        sll.set(1, 456);
        
        assertEquals(2, sll.n);
        assertEquals((Integer) 123, sll.head.x);
        assertEquals((Integer) 456, sll.tail.x);
    }
    @Test
    public void testDllSetExtends() {
        dll.add(0, 123);
        
        dll.set(1, 456);
        
        assertEquals(2, dll.n);
        assertEquals((Integer) 123, dll.boundary.next.x);
        assertEquals((Integer) 456, dll.boundary.prev.x);
    }
    @Test
    public void testSllAddInMiddle() {
    	sll.add(0, 123);
        sll.add(1, 345);
        
        sll.add(1, 567);
        
        assertEquals(3, sll.n);
        assertEquals((Integer) 567, sll.head.next.x);
        assertEquals(sll.tail, sll.head.next.next);
        assertNull(sll.tail.next);
    }
    @Test
    public void testDllAddInMiddle() {
    	dll.add(0, 123);
        dll.add(1, 345);
        
        dll.add(1, 567);
        
        assertEquals(3, dll.n);
        assertEquals((Integer) 567, dll.boundary.next.next.x);
        assertEquals(dll.boundary.prev, dll.boundary.next.next.next);
        assertEquals(dll.boundary, dll.boundary.prev.next);
    }
    @Test
    public void testSllAddBeforeTail() {
    	sll.add(0, 123);
        sll.add(1, 456);
        sll.add(2, 789);
        
        sll.add(1, 1011);
        
        assertEquals(4, sll.n);
        assertEquals((Integer) 1011, sll.head.next.x);
        assertEquals((Integer) 456, sll.head.next.next.x);
        assertEquals(sll.tail, sll.head.next.next.next);
        assertNull(sll.tail.next);
    }
    @Test
    public void testDllAddBeforeTail() {
    	dll.add(0, 123);
        dll.add(1, 456);
        dll.add(2, 789);
        
        dll.add(1, 1011);
        
        assertEquals(4, dll.n, 4);
        assertEquals((Integer) 1011, dll.boundary.next.next.x);
        assertEquals((Integer) 456, dll.boundary.next.next.next.x);
        assertEquals(dll.boundary.prev, dll.boundary.next.next.next.next);
        assertEquals(dll.boundary, dll.boundary.prev.next);
    }
    @Test
    public void testSllAddToHead() {
        sll.add(0, 123);
        
        sll.add(0, 456);
        
        assertEquals(2, sll.n);
        assertEquals((Integer) 456, sll.head.x);
        assertEquals((Integer) 123, sll.tail.x);
        assertEquals(sll.tail, sll.head.next);
        assertNull(sll.tail.next);
    }
    @Test
    public void testDllAddToHead() {
        dll.add(0, 123);
        
        dll.add(0, 456);
        
        assertEquals(2, dll.n);
        assertEquals((Integer) 456, dll.boundary.next.x);
        assertEquals((Integer) 123, dll.boundary.prev.x);
        assertEquals(dll.boundary.prev, dll.boundary.next.next);
    }
    @Test
    public void testSllAddToEnd() {
    	sll.add(0, 123);
        
        sll.add(1, 456);
        
        assertEquals((Integer) 456, sll.tail.x);
        assertEquals(2, sll.n);
        assertEquals(sll.tail, sll.head.next);
        assertNull(sll.tail.next);
    }
    @Test
    public void testDllAddToEnd() {
    	dll.add(0, 123);
        
        dll.add(1, 456);
        
        assertEquals((Integer) 456, dll.boundary.prev.x);
        assertEquals(2, dll.n);
        assertEquals(dll.boundary.prev, dll.boundary.next.next);
        assertEquals(dll.boundary, dll.boundary.prev.next);
    }
    @Test
    public void testSllAddToEmpty() {
    	sll.add(0, 123);
        
        assertEquals((Integer) 123, sll.tail.x);
        assertEquals(1, sll.n);
        assertEquals(sll.tail, sll.head);
        assertNull(sll.tail.next);
    }
    @Test
    public void testDllAddToEmpty() {
    	dll.add(0, 123);
        
        assertEquals((Integer) 123, dll.boundary.prev.x);
        assertEquals(1, dll.n);
        assertEquals(dll.boundary.next, dll.boundary.prev);
        assertEquals(dll.boundary, dll.boundary.prev.next);
    }
}