/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ics124.c0350261.assignment3;

/**
 *
 * @author Mariah Malczewska
 */
public class StackUsingArrayTest {
    public static void main(String[] args) {
        StackUsingArray sa = new StackUsingArray();
        sa.push(1);
        sa.push(2);
        sa.push(3);
        sa.push(4);
        sa.push(5);
        
        sa = reverseStack(sa);
    }
    
    public static StackUsingArray reverseStack(StackUsingArray stack){
        int size = stack.size();
        StackUsingArray revStack = new StackUsingArray(stack.size());
        for (int i = 1; i <= size; i++) {
            revStack.push( stack.pop() );
            System.out.println("rev stack curr top: " + revStack.peek());
        }
        return revStack;
    }
}