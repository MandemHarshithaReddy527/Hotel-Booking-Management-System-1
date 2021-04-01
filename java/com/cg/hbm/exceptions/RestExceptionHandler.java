package com.cg.hbm.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 
 * @author Harshitha
 *
 */
@ControllerAdvice
public class RestExceptionHandler {
	/**
	 * 
	 * @param ex
	 * @return 
	 */

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorMapper> exceptionHotelNotFound(Exception ex) {
        ErrorMapper error = new ErrorMapper();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMapper>(error, HttpStatus.NOT_FOUND);
    }
    /**
     * 
     * @param ex
     * @return
     */

    @ExceptionHandler(BookingDetailsNotFoundException.class)
    public ResponseEntity<ErrorMapper> exceptionHandler(Exception ex) {
        ErrorMapper error = new ErrorMapper();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMapper>(error, HttpStatus.BAD_REQUEST);
    }
    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorMapper> exceptionPaymentNotFound(Exception ex) {
        ErrorMapper error = new ErrorMapper();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorMapper>(error, HttpStatus.NOT_FOUND);
    }

}


