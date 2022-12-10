package exception;

import java.io.IOException;

public class InvalidDateException extends Exception {
    public InvalidDateException(String s) {
        super(s);
    }
}
