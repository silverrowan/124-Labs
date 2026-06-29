package ics124.assignment4;

/**
 * Exception thrown when a duplicate value is attempted to be entered
 * into a BST.
 */
public class BstDuplicateKeyException extends Exception {

    public BstDuplicateKeyException() {
        super();
    }
    
    public BstDuplicateKeyException(String x) {
        super(x + " already in tree");
    }

}
