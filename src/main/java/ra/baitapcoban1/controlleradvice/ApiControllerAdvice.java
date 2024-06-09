package ra.baitapcoban1.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.baitapcoban1.dto.DataError;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public DataError<String> handleNotSuch(NoSuchElementException e){
        return new DataError<>("error",e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataError<Map<String,String>> handleMethodError(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return new DataError<>("error",map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public DataError<Map<String, String>> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("method", ex.getMethod());
        errorDetails.put("supportedMethods", Arrays.toString(ex.getSupportedMethods()));
        return new DataError<>("errorDetails", errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public DataError<String> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new DataError<>("error", ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }




}
