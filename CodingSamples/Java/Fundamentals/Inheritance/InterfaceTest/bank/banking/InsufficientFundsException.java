package banking;

//a checked exception type that inherits from java.lang.Exception but
//not from java.lang.RuntimeException cannot go unreported at compile-time
//i.e it must be caught with try block or declared to be thrown by the method
public class InsufficientFundsException extends Exception {
    
}
