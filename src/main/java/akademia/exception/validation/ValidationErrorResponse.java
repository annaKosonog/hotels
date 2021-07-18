package akademia.exception.validation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {
    private List<ValidationError> errors = new ArrayList<>();


    public ValidationErrorResponse addError(ValidationError error) {
        this.errors.add(error);
        return this;
    }
}
