package daaw.examen_app.exceptions.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(CarNotFoundException.class) 
    public ResponseEntity<String> handleNotFound(CarNotFoundException ex) { 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found"); 
    } 
 
    @ExceptionHandler(CarIdMismatchException.class) 
    public ResponseEntity<String> handleIdMismatch(CarIdMismatchException ex) { 
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car ID mismatch"); 
    } 
}
