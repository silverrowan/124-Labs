/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics124.c0350261.assignment2;

import java.util.Objects;

/**
 *
 * @author C0525746
 */
public class ListTest {
    
    public static void main(String[] args) {
    
        Ics124List<Integer> sll = new Ics124SinglyLinkedList<>();
        sll.add(0, 123);
        System.out.println(Objects.equals((Integer)123, sll.get(0)));
    }
        
}
