package akademia.services;

import akademia.exception.ResourceNotFoundException;
import akademia.mappers.HotelMapper;
import akademia.model.dao.Hotel;
import akademia.model.dto.HotelDTO;
import akademia.repositories.AddresRepository;
import akademia.repositories.HotelRepository;
import akademia.repositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    // Logger widzimy co się dzieje w naszych plikach
    private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    private HotelRepository hotelRepository;
    private AddresRepository addresRepository;
    private HotelMapper hotelMapper;
    private RoomRepository roomRepository;


    public HotelService(HotelRepository hotelRepository, AddresRepository addresRepository, HotelMapper hotelMapper, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.addresRepository = addresRepository;
        this.hotelMapper = hotelMapper;
        this.roomRepository = roomRepository;
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        logger.debug("Hotels: {}", hotels);
        MDC.clear(); // usuwa sesje dziennika z pamięci
        return hotels;
    }

    public Hotel getHotelById(Long id) {
   //     Optional<Hotel> hotelOptional = hotelRepository.findById(id);
   //     Hotel hotel = new Hotel();
     // zmiana parametrów obiektu pobrane z bazy jako jednego sposobów działania na obiektach wewnątrz Optional'a
     //   hotelOptional.ifPresent(h -> h.setTitle(h.getTitle().toUpperCase())); // (System.out::printl); lambda
     //    return null;
        return hotelRepository.findById(id) // zwraca Optional
                .orElseThrow(()-> new ResourceNotFoundException("Not found Hotel by id: " + id)); // zwracam hotel a jeśli nie ma zwracam wyjątek
    }

    public List<Hotel> getHotelsByCountry(String country){
        return hotelRepository.findByCountry(country);
    }

    public List<Hotel> getHotelsByCountryAndRate(String country, String rate){
        return hotelRepository.findByCountryAndRate(country, rate);
    }

    /** ---------------------- Hotele DTO -------------------------------------------------------------------------------- **/

    public List<HotelDTO> getHotelsDTO() {
        List<Hotel> hotels = hotelRepository.findAll();
      return   hotels.stream().map(hotelMapper::map)
                .collect(Collectors.toList());
    }
}


