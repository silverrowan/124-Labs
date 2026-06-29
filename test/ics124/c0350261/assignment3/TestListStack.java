/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ics124.c0350261.assignment3;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Mariah Malczewska
 */
public class TestListStack {
    
    @Test
    public void testEmptyStackResponses(){
        StackUsingList s2 = new StackUsingList();
        
        assertEquals(true, s2.isEmpty());
        assertEquals(false, s2.isFull());
        assertThrows(StackUnderflowException.class, () -> s2.peek());
        assertThrows(StackUnderflowException.class, () -> s2.pop());
        assertEquals(0, s2.size());
    }

    @Test
    public void testNewStack(){
        StackUsingList s = new StackUsingList();
        
        assertEquals(true, s.isEmpty());
        s.push(123);
        assertEquals(1, s.size());
        assertEquals(false, s.isEmpty());
        assertEquals(123, (int)s.peek());
        assertEquals(123, (int)s.pop());
        assertEquals(0, s.size());
        assertThrows(StackUnderflowException.class, () -> s.peek());
        assertThrows(StackUnderflowException.class, () -> s.pop());
    }

    @Test
    public void testStackOrder(){
        StackUsingList s = new StackUsingList();
       s.push(123);
       s.push(456);
       s.push(789);
       
       assertEquals(3, s.size());
       assertEquals(789, (int)s.peek());
       assertEquals(789, (int)s.pop());
       
       s.push(159);
       s.push(48);
       
       assertEquals(48, (int)s.peek());
       assertEquals(48, (int)s.pop());
       assertEquals(159, (int)s.peek());
       assertEquals(159, (int)s.pop());
       assertEquals(456, (int)s.peek());
       assertEquals(456, (int)s.pop());
       assertEquals(1, s.size());
       assertEquals(123, (int)s.peek());
       assertEquals(123, (int)s.pop());
       
       assertEquals(0, s.size());
       assertThrows(StackUnderflowException.class, () -> s.peek());
       assertThrows(StackUnderflowException.class, () -> s.pop());
    }
    
        @Test
    public void testSize() {
       Ics124Stack s = new StackUsingList();
       assertEquals(0, (int) s.size());
       s.isEmpty();
       s.isFull();
       assertEquals(0, (int) s.size());       
       s.push(123);
       s.push(456);
       s.push(789);
       assertEquals(3, (int)s.size());
       s.peek();
       assertEquals(3, (int)s.size());
       s.pop();
       assertEquals(2, (int)s.size());
       s.pop();
       s.pop();
       assertEquals(0, (int)s.size());
       assertThrows(StackUnderflowException.class, () -> s.pop());
   }
    
        @Test
    public void testPop() {
       Ics124Stack s = new StackUsingList();
       assertThrows(StackUnderflowException.class, () -> s.pop());
       s.push(123);
       assertEquals(123, (int)s.pop());
       assertThrows(StackUnderflowException.class, () -> s.pop());
   }
   
   @Test
   public void testIsEmpty(){
       Ics124Stack s = new StackUsingList();
       assertTrue(s.isEmpty());
       s.push(123);
       assertFalse(s.isEmpty());
       s.peek();
       assertFalse(s.isEmpty());
       s.pop();
       assertTrue(s.isEmpty());       
   }
}
