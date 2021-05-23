package ro.ibm.bootcamp2021.Exceptions;

public class UnknownCVVCodeException extends Exception{
    public UnknownCVVCodeException(String message) {
        super(message);
    }
}
