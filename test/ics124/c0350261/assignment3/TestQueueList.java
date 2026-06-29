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
public class TestQueueList {
   public TestQueueList(){}
   
   @Test
   public void testInitialState(){
       Ics124Queue s = new Ics124Queue();
       assertTrue(s.isEmpty());
       assertFalse(s.isFull());
       assertEquals(0, (int)s.size());
       assertThrows(StackUnderflowException.class, () -> s.first());
       assertThrows(StackUnderflowException.class, () -> s.dequeue());

   }
   
   @Test
   public void testOrder(){
       Ics124Queue s = new Ics124Queue();
       
       s.enqueue(123);
       s.enqueue(456);
       s.enqueue(789);
       assertEquals(789, (int)s.first());
       assertEquals(789, (int)s.dequeue());
       s.enqueue(159);
       s.enqueue(48);
       assertEquals(48, (int)s.first());
       assertEquals(48, (int)s.dequeue());
       assertEquals(159, (int)s.first());
       assertEquals(159, (int)s.dequeue());
       assertEquals(456, (int)s.first());
       assertEquals(456, (int)s.dequeue());
       assertEquals(123, (int)s.first());
       assertEquals(123, (int)s.dequeue());
   }
   
   @Test
   public void testSize() {
       Ics124Queue s = new Ics124Queue();
       
       assertEquals(0, (int) s.size());
       s.isEmpty();
       s.isFull();
       assertEquals(0, (int) s.size());       
       s.enqueue(123);
       s.enqueue(456);
       s.enqueue(789);
       assertEquals(3, (int)s.size());
       s.first();
       assertEquals(3, (int)s.size());
       s.dequeue();
       assertEquals(2, (int)s.size());
       s.dequeue();
       s.dequeue();
       assertEquals(0, (int)s.size());
       assertThrows(StackUnderflowException.class, () -> s.dequeue());
   }
   
   @Test
   public void testEnqueue() {
       Ics124Queue s = new Ics124Queue();
       
       assertThrows(Exception.class, () -> s.enqueue(true));
       assertThrows(Exception.class, () -> s.enqueue("string"));
       Object o = new Object();
       assertThrows(Exception.class, () -> s.enqueue(o));
       s.enqueue(123);
       assertEquals(123, (int)s.first());
       assertEquals(123, (int)s.dequeue());       
   }
   
   @Test
   public void testDequeue() {
       Ics124Queue s = new Ics124Queue();
       
       assertThrows(StackUnderflowException.class, () -> s.dequeue());
       s.enqueue(123);
       assertEquals(123, (int)s.dequeue());
       assertThrows(StackUnderflowException.class, () -> s.dequeue());
   }
   
   @Test
   public void testIsEmpty(){
       Ics124Queue s = new Ics124Queue();
       
       assertTrue(s.isEmpty());
       s.enqueue(123);
       assertFalse(s.isEmpty());
       s.first();
       assertFalse(s.isEmpty());
       s.dequeue();
       assertTrue(s.isEmpty());       
   }   
}
