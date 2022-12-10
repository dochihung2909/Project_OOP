package exception;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String mess) {
        super(mess);
    }
}
