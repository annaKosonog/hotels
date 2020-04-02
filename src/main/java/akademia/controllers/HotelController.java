package akademia.controllers;

import akademia.model.dao.Hotel;
import akademia.model.dto.HotelDTO;
import akademia.services.DAO.HotelServiceDAO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController czyli API

@RestController
@RequestMapping("/v1")
public class HotelController {
    private static  final Logger logger = LoggerFactory.getLogger(HotelController.class);

    private HotelServiceDAO hotelServiceDAO;

    public HotelController(HotelServiceDAO hotelServiceDAO) {
        this.hotelServiceDAO = hotelServiceDAO;
    }

//    @GetMapping("/hotele")
//    public List<Hotel> getHotels(HttpServletRequest httpServletRequest){
//        MDC.put("session",httpServletRequest.getSession().getId());
//        logger.debug("Received new request", httpServletRequest.getRemoteAddr()); // getRemoteAddr - skąd przyszło zapytanie
//        return hotelService.getHotels();
//    }


    @GetMapping("/hotele/{id}/id")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){ // wartość jest inna to dopisujemy value=""
 //        return new ResponseEntity<>(hotelService.getHotelById(id), HttpStatus.NOT_FOUND); // I wersja ResponseEntity<>
        return ResponseEntity.ok(hotelServiceDAO.getHotelById(id)); // II wersja zwracamy ciało, status 404
    }

    @GetMapping("/hotele/{country}/country")
    public ResponseEntity<List<Hotel>> getHotelByCountry(@PathVariable String country){
        return ResponseEntity.ok(hotelServiceDAO.getHotelByCountry(country)); // II wersja zwracamy ciało, status 404
    }

    @GetMapping("/hotele")
    public ResponseEntity<List<Hotel>> getHotelByCountryAndRate(
            @RequestParam (required = false) String country,
            @RequestParam (required = false)  String rate){
        if(StringUtils.isNotBlank(country) && StringUtils.isNotBlank(rate)){
        return ResponseEntity.ok(hotelServiceDAO.getHotelByCountryAndRate(country, rate)); // II wersja zwracamy ciało, status 404
        }
        return ResponseEntity.ok(hotelServiceDAO.getHotel());
    }




//    @GetMapping("/hotele/dto")
//    public ResponseEntity<List<HotelDTO>> getHotels(){
//        return ResponseEntity.ok(hotelServiceDAO.getHotelDTO());
//        }
    }
