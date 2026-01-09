package daaw.examen_app.exceptions.exception;
 
public class CarIdMismatchException extends RuntimeException { 
 
    private static final long serialVersionUID = 1L; 
 
    public CarIdMismatchException() { 
        super(); 
    } 
 
    public CarIdMismatchException(final String message, final Throwable cause) { 
        super(message, cause); 
    } 
 
    public CarIdMismatchException(final String message) { 
        super(message); 
    } 
 
    public CarIdMismatchException(final Throwable cause) { 
        super(cause); 
    } 
} 
