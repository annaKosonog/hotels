package akademia.controllers.DTO;

import akademia.model.dao.Hotel;
import akademia.model.dto.HotelDto;
import akademia.repositories.HotelRepository;
import akademia.services.DTO.HotelServiceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/dto")
public class HotelDtoController {

    private final static Logger log = LoggerFactory.getLogger(HotelDtoController.class);
    private final HotelServiceDto hotelServiceDTO;
    private final HotelRepository hotelRepository;

    public HotelDtoController(HotelServiceDto hotelServiceDTO, HotelRepository hotelRepository) {
        this.hotelServiceDTO = hotelServiceDTO;
        this.hotelRepository = hotelRepository;
    }


    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> getHotel() {
        return ResponseEntity.ok(hotelServiceDTO.getHotels());
    }


    @GetMapping("/hotels/country/{country}")
    public ResponseEntity<List<HotelDto>> getHotelByCountry(@PathVariable String country) {
        return ResponseEntity.ok(hotelServiceDTO.getHotelsByCountry(country));
    }


    @GetMapping("/hotels/city/{city}")
    public ResponseEntity<List<HotelDto>> getHotelByCity(@PathVariable String city) {
        return ResponseEntity.ok(hotelServiceDTO.getHotelsByCity(city));
    }


    @GetMapping("/hotels/rate/{rate}")
    public List<HotelDto> getHotelByRate(String rate) {
        return null;
    }


    public List<HotelDto> getHotelsByRoomType(String type) {
        return null;
    }


    @GetMapping("/hotels/{partnerCode}")
    public ResponseEntity<HotelDto> getHotelByPartnerCode(@PathVariable String partnerCode) {
        return ResponseEntity.ok(hotelServiceDTO.getHotelByPartnerCode(partnerCode));
    }


    @DeleteMapping("/hotels/{partnerCode}")
    public ResponseEntity<String> deleteHotelByPartnerCode(@PathVariable String partnerCode) {
        try {
            hotelServiceDTO.deleteHotelByPartnerCode(partnerCode);
            log.info("Delete hotel with partner code {} ", partnerCode);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/hotels/{partnerCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelDto hotelDto, @PathVariable String partnerCode) {
        log.info("Updating Hotel with partner code {}", hotelDto.getPartnerCode());
        final Optional<Hotel> hotelDate = hotelRepository.findHotelByPartnerCode(partnerCode);
        if (hotelDate.isPresent()) {
            final HotelDto newHotelDto = hotelServiceDTO.updateHotel(hotelDto, partnerCode);
            return new ResponseEntity<>(newHotelDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/hotels")
    public ResponseEntity<HotelDto> insertHotelByDb(@Valid @RequestBody HotelDto hotelDTO) {
        log.info("Created new hotel: " + hotelDTO);
        try {
            final HotelDto newHotel = hotelServiceDTO.addHotel(hotelDTO);
            log.info("Added new Hotel to the database:  " + hotelDTO.getTitle());
            return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(hotelDTO, HttpStatus.BAD_REQUEST);
        }
    }
}
