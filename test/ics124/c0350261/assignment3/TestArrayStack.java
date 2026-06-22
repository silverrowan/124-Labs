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
public class TestArrayStack {
    
    @Test
    public void testEmptyStackResponses(){
        StackUsingArray s = new StackUsingArray();
        
        assertEquals(true, s.isEmpty());
        assertEquals(false, s.isFull());
        assertThrows(StackUnderflowException.class, () -> s.peek());
        assertThrows(StackUnderflowException.class, () -> s.pop());
        assertEquals(0, s.size());
    }

    @Test
    public void testFullStackResponses(){
        StackUsingArray s = new StackUsingArray(1);
        s.push(123);
        
        assertEquals(false, s.isEmpty());
        assertEquals(true, s.isFull());
        assertThrows(StackOverflowException.class, () -> s.push(123));
        assertEquals(1, s.size());
    }

    @Test
    public void testNewStack(){
        StackUsingArray s = new StackUsingArray();
        
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
        StackUsingArray s = new StackUsingArray();
        
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
