/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics124.c0350261.assignment3;

import ics124.assignment3.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mariah
 */
public class TestStackList {
   public TestStackList(){}
   
   @Test
   public void testInitialState(){
       Ics124Stack s = new StackUsingList();
       assertTrue(s.isEmpty());
       assertFalse(s.isFull());
       assertThrows(StackUnderflowException.class, () -> s.peek());
       assertThrows(StackUnderflowException.class, () -> s.pop());
       assertEquals(0, (int)s.size());
   }
   
   @Test
   public void testPushPopPeekOrder(){
       Ics124Stack s = new StackUsingList();
       s.push(123);
       s.push(456);
       s.push(789);
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
       assertEquals(123, (int)s.peek());
       assertEquals(123, (int)s.pop());
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
   public void testPush() {
       Ics124Stack s = new StackUsingList();
       assertThrows(Exception.class, () -> s.push(true));
       assertThrows(Exception.class, () -> s.push("string"));
       Object o = new Object();
       assertThrows(Exception.class, () -> s.push(o));
       s.push(123);
       assertEquals(123, (int)s.peek());
       assertEquals(123, (int)s.pop());       
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
