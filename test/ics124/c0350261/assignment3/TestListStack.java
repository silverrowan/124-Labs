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
        s.push(345);
        s.push(678);
        s.push(910);
        
        assertEquals(910, (int)s.peek());
        assertEquals(4, s.size());
        assertEquals(910, (int)s.pop());
        assertEquals(678, (int)s.peek());
        assertEquals(678, (int)s.pop());
        assertEquals(345, (int)s.pop());
        assertEquals(123, (int)s.peek());
        assertEquals(1, s.size());
        
        assertEquals(123, (int)s.pop());
        assertEquals(0, s.size());
        assertThrows(StackUnderflowException.class, () -> s.peek());
        assertThrows(StackUnderflowException.class, () -> s.pop());
    }
}
