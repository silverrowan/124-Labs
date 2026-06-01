package ics124.c0350261.assignment2;
/**
 * A generic list class.  
 * 
 * Should hold an arbitrary number of elements.
 * 
 * @param <T> the class of the payloads inside the list
 */
public interface Ics124List<T> {
    int size();
    T get(int i);
    void set(int i, T x);
    void add(int i, T x);
    T remove(int i);
}
