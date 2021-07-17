package akademia.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HotelControllerErrorHandlerTest implements ResourceNotFoundExceptionTest, SampleHotelErrorResponse {
    @Test
    public void should_throw_an_error_when_looking_hotel_about_partner_code_eighty_nine() {
        final String partnerCode = "89";
        HotelControllerErrorHandler hotelControllerErrorHandler = new HotelControllerErrorHandler();

        final ResourceNotFoundException exception = resourceNotFoundExceptionTest(partnerCode);
        final HotelErrorResponse expectedResponse = sampleHotelErrorResponse();
        final HotelErrorResponse actualResponse = hotelControllerErrorHandler.hotelNotFoundHandler(exception);
        assertThat(actualResponse.equals(expectedResponse));
    }
}

