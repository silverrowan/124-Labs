/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ics124.c0350261.assignment3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author C0350261
 */
public class StackUsingArrayTest {
    
    public StackUsingArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class StackUsingArray.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        StackUsingArray instance = new StackUsingArray();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFull method, of class StackUsingArray.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        StackUsingArray instance = new StackUsingArray();
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class StackUsingArray.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        StackUsingArray instance = new StackUsingArray();
        Integer expResult = null;
        Integer result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class StackUsingArray.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackUsingArray instance = new StackUsingArray();
        Integer expResult = null;
        Integer result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class StackUsingArray.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Integer a = null;
        StackUsingArray instance = new StackUsingArray();
        instance.push(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class StackUsingArray.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        StackUsingArray instance = new StackUsingArray();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
