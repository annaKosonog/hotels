package akademia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND) // oznacza
public class ResourceNotFoundException extends EntityNotFoundException {


    public ResourceNotFoundException(String message) {
        super(message);
    }
}
