package akademia.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class HotelControllerErrorHandler {

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class, ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public HotelErrorResponse hotelNotFoundHandler(ResourceNotFoundException exception){
        String message = "Hotel not found about given partner_code: " + exception.getInfoRequestPartnerCode();
        log.info(message);
        log.error("404 Status Code", exception);
        return new HotelErrorResponse(HttpStatus.NOT_FOUND, message);
    }



}
