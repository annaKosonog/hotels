package akademia.exception.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
@ControllerAdvice
public class ValidationErrorControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse validationErrorResponse(ConstraintViolationException exception) {
        ValidationErrorResponse response = new ValidationErrorResponse();

        for (ConstraintViolation error : exception.getConstraintViolations()) {
            response.addError(
                    new ValidationError(
                            error.getPropertyPath().toString(),
                            error.getMessage()));
        }

        return response;
    }
}
