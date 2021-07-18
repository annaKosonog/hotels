package akademia.services.DAO;

import akademia.exception.ResourceNotFoundException;
import akademia.model.dao.Hotel;
import akademia.repositories.AddressRepository;
import akademia.repositories.HotelRepository;
import akademia.repositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceDAO {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceDAO.class);
    private final HotelRepository hotelRepository;
    private final AddressRepository addressRepository;
    private final RoomRepository roomRepository;


    public HotelServiceDAO(HotelRepository hotelRepository, AddressRepository addressRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.addressRepository = addressRepository;
        this.roomRepository = roomRepository;
    }

    public List<Hotel> getHotel() {
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
                .orElseThrow(() -> new ResourceNotFoundException("Not found Hotel by id: " + id)); // zwracam hotel a jeśli nie ma zwracam wyjątek
    }

    public List<Hotel> getHotelByCountry(String country) {
        return hotelRepository.findByCountry(country);
    }

    public List<Hotel> getHotelByCountryAndRate(String country, String rate) {
        return hotelRepository.findByCountryAndRate(country, rate);
    }


}


