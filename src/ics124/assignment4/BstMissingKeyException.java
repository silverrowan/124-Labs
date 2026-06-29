package ics124.assignment4;

/**
 * Exception thrown when a value is not found in a BST.
 */
public class BstMissingKeyException extends Exception {

    public BstMissingKeyException() {
        super();
    }

    public BstMissingKeyException(String x) {
        super(x + " not found in tree");
    }
}
