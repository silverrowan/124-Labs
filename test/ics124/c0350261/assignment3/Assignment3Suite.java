/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package ics124.c0350261.assignment3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author C0350261
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ics124.c0350261.assignment3.StackUsingArrayTest.class, ics124.assignment3.Ics124StackExceptionTest.class, ics124.assignment3.StackUnderflowExceptionTest.class, ics124.c0350261.assignment3.Ics124StackTest.class, ics124.assignment3.StackOverflowExceptionTest.class})
public class Assignment3Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
