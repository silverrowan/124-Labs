package ics124.c0350261.assignment2;

import ics124.c0350261.assignment2.Ics124List;
import org.junit.Test;
import static org.junit.Assert.*;

public class Assignment2Marking {
    Ics124List<Integer> sll;
    Ics124List<Integer> dll;    
    
    public Assignment2Marking() {
        sll = new Ics124SinglyLinkedList<>();
        dll = new Ics124DoublyLinkedList<>();
    }

    @Test
    public void testEmptySll() {
        assertEquals(0, sll.size());
    }
    @Test
    public void testEmptyDll() {
        assertEquals(0, dll.size());
    }
    @Test
    public void testRemoveFinalSll() {
        sll.add(0, 123);
        
        Integer result = sll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(0, sll.size());
    }
    @Test
    public void testRemoveFinalDll() {
        dll.add(0, 123);
        
        Integer result = dll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(0, dll.size());
    }
    @Test
    public void testRemoveFrontSll() {
        sll.add(0, 123);
        sll.add(1, 456);

        Integer result = sll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(1, sll.size());
        assertEquals((Integer)456, sll.get(sll.size()-1));
    }
    @Test
    public void testRemoveFrontDll() {
        dll.add(0, 123);
        dll.add(1, 456);

        Integer result = dll.remove(0);
        
        assertEquals((Integer)123, result);
        assertEquals(1, dll.size());
        assertEquals((Integer)456, dll.get(dll.size()-1));
    }
    @Test
    public void testRemoveRearSll() {
        sll.add(0, 123);
        sll.add(1, 456);

        Integer result = sll.remove(1);
        
        assertEquals((Integer)456, result);                
        assertEquals(1, sll.size());
        assertEquals((Integer)123, sll.get(sll.size()-1));
    }
    @Test
    public void testRemoveRearDll() {
        dll.add(0, 123);
        dll.add(1, 456);

        Integer result = dll.remove(1);
        
        assertEquals((Integer)456, result);                
        assertEquals(1, dll.size());
        assertEquals((Integer)123, dll.get(dll.size()-1));
    }
    @Test
    public void testRemoveFromMiddleSll() {
        sll.add(0, 123);
        sll.add(1, 456);
        sll.add(2, 789);

        Integer result = sll.remove(1);
        
        assertEquals((Integer)456, result);
        assertEquals(2, sll.size());
    }
    @Test
    public void testRemoveFromMiddleDll() {
        dll.add(0, 123);
        dll.add(1, 456);
        dll.add(2, 789);

        Integer result = dll.remove(1);
        
        assertEquals((Integer)456, result);
        assertEquals(2, dll.size());
    }
    @Test
    public void testSetOverwritesSll() {
        sll.add(0, 123);
        sll.add(1, 456);
        sll.add(2, 789);
        
        sll.set(2, 8910);
        
        assertEquals(3, sll.size());
        assertEquals((Integer) 8910, sll.get(sll.size()-1));
    }
    @Test
    public void testSetOverwritesDll() {
        dll.add(0, 123);
        dll.add(1, 456);
        dll.add(2, 789);
        
        dll.set(2, 8910);
        
        assertEquals(3, dll.size());
        assertEquals((Integer) 8910, dll.get(dll.size()-1));
    }
    @Test
    public void testSetOnEmptySll() {
        
        sll.set(0, 123);
        
        assertEquals(1, sll.size());
        assertEquals((Integer)123, sll.get(sll.size()-1));
    }
    @Test
    public void testSetOnEmptyDll() {
        
        dll.set(0, 123);
        
        assertEquals(1, dll.size());
        assertEquals((Integer)123, dll.get(dll.size()-1));
    }
    @Test
    public void testSetExtendsSll() {
        sll.add(0, 123);
        
        sll.set(1, 456);
        
        assertEquals(2, sll.size());
        assertEquals((Integer)123, sll.get(0));
        assertEquals((Integer)456, sll.get(sll.size()-1));
    }
    @Test
    public void testSetExtendsDll() {
        dll.add(0, 123);
        
        dll.set(1, 456);
        
        assertEquals(2, dll.size());
        assertEquals((Integer)123, dll.get(0));
        assertEquals((Integer)456, dll.get(dll.size()-1));
    }
    @Test
    public void testAddInMiddleSll() {
        sll.add(0, 123);
        sll.add(1, 345);
        
        sll.add(1, 567);
        
        assertEquals(3, sll.size());
        assertEquals((Integer) 567, sll.get(1));
        assertEquals((Integer) 345, sll.get(sll.size()-1));
    }
    @Test
    public void testAddInMiddleDll() {
        dll.add(0, 123);
        dll.add(1, 345);
        
        dll.add(1, 567);
        
        assertEquals(3, dll.size());
        assertEquals((Integer) 567, dll.get(1));
        assertEquals((Integer) 345, dll.get(dll.size()-1));
    }
    @Test
    public void testAddBeforeTailSll() {
        sll.add(0, 123);
        sll.add(1, 456);
        sll.add(2, 789);
        
        sll.add(1, 1011);
        
        assertEquals(4, sll.size());
        assertEquals((Integer) 1011, sll.get(1));
        assertEquals((Integer) 456, sll.get(2));
    }
    @Test
    public void testAddBeforeTailDll() {
        dll.add(0, 123);
        dll.add(1, 456);
        dll.add(2, 789);
        
        dll.add(1, 1011);
        
        assertEquals(4, dll.size());
        assertEquals((Integer) 1011, dll.get(1));
        assertEquals((Integer) 456, dll.get(2));
    }
    @Test
    public void testAddToHeadSll() {
        sll.add(0, 123);
        
        sll.add(0, 456);
        
        assertEquals(2, sll.size());
        assertEquals((Integer) 456, sll.get(0));
        assertEquals((Integer) 123, sll.get(sll.size()-1));
    }
    @Test
    public void testAddToHeadDll() {
        dll.add(0, 123);
        
        dll.add(0, 456);
        
        assertEquals(2, dll.size());
        assertEquals((Integer) 456, dll.get(0));
        assertEquals((Integer) 123, dll.get(dll.size()-1));
    }
    @Test
    public void testAddToEndSll() {
        sll.add(0, 123);
        
        sll.add(1, 456);
        
        assertEquals((Integer) 456, sll.get(sll.size()-1));
        assertEquals(2, sll.size());
    }
    @Test
    public void testAddToEndDll() {
        dll.add(0, 123);
        
        dll.add(1, 456);
        
        assertEquals((Integer) 456, dll.get(dll.size()-1));
        assertEquals(2, dll.size());
    }
    @Test
    public void testAddToEmptySll() {
        
        sll.add(0, 123);
        
        assertEquals((Integer) 123, sll.get(sll.size()-1));
        assertEquals(1, sll.size());
    }
    @Test
    public void testAddToEmptyDll() {
        
        dll.add(0, 123);
        
        assertEquals((Integer) 123, dll.get(dll.size()-1));
        assertEquals(1, dll.size());
    }
    @Test
    public void testGetOutOfBoundsIsErrorSll() {
        assertThrows(IndexOutOfBoundsException.class, () -> sll.get(0));
    }
    @Test
    public void testGetOutOfBoundsIsErrorDll() {
        assertThrows(IndexOutOfBoundsException.class, () -> dll.get(0));
    }
    @Test
    public void testSetOutOfBoundsIsErrorSll() {
        // set(0, T) is OK -- we can extend by one.  set(1, T) should throw
        assertThrows(IndexOutOfBoundsException.class, () -> sll.set(1, 456));
    }
    @Test
    public void testSetOutOfBoundsIsErrorDll() {
        // set(0, T) is OK -- we can extend by one.  set(1, T) should throw
        assertThrows(IndexOutOfBoundsException.class, () -> dll.set(1, 456));
    }
    @Test
    public void testAddOutOfBoundsIsErrorSll() {
        // add(0, T) is OK -- we can extend by one.  add(1, T) should throw
        assertThrows(IndexOutOfBoundsException.class, () -> sll.add(1, 456));
    }
    @Test
    public void testAddOutOfBoundsIsErrorDll() {
        // add(0, T) is OK -- we can extend by one.  add(1, T) should throw
        assertThrows(IndexOutOfBoundsException.class, () -> dll.add(1, 456));
    }
    @Test
    public void testRemoveOutOfBoundsIsErrorSll() {
        assertThrows(IndexOutOfBoundsException.class, () -> sll.remove(0));
    }
    @Test
    public void testRemoveOutOfBoundsIsErrorDll() {
        assertThrows(IndexOutOfBoundsException.class, () -> dll.remove(0));
    }  

}
