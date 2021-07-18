package akademia.exception.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<ValidationError> errors = new ArrayList<>();


    public ValidationErrorResponse addError(ValidationError error) {
        this.errors.add(error);
        return this;
    }
}
