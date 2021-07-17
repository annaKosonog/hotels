package akademia.exception;

public interface ResourceNotFoundExceptionTest {
    default ResourceNotFoundException resourceNotFoundExceptionTest(String partnerCode) {
        return new ResourceNotFoundException(partnerCode);
    }
}

