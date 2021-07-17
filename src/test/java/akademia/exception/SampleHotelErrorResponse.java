package akademia.exception;

import org.springframework.http.HttpStatus;

public interface SampleHotelErrorResponse {
    default HotelErrorResponse  sampleHotelErrorResponse(){
        return new HotelErrorResponse(HttpStatus.NOT_FOUND, "Hotel not found about given partner_code: ");
    }
}
