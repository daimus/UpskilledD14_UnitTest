package id.daimus.unittest.shared.exception;

public class DataNotFoundException extends Exception {
    public DataNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
