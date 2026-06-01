/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ics124.c0350261.assignment1;

import java.util.Iterator;
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
public class Ics124SetTest {
    
    public Ics124SetTest() {
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
     * Test of iterator method, of class Ics124Set.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Ics124Set instance = new Ics124Set();
        Iterator<Integer> expResult = null;
        Iterator<Integer> result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Ics124Set.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Ics124Set instance = new Ics124Set();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Ics124Set.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Ics124Set instance = new Ics124Set();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Ics124Set.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object o = null;
        Ics124Set instance = new Ics124Set();
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Ics124Set.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Integer e = null;
        Ics124Set instance = new Ics124Set();
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Ics124Set.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Ics124Set instance = new Ics124Set();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
