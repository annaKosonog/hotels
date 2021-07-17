package akademia.services.DTO;

import akademia.exception.ResourceNotFoundException;
import akademia.mappers.HotelMapper;
import akademia.model.dao.Hotel;
import akademia.model.dto.HotelDto;
import akademia.repositories.AddressRepository;
import akademia.repositories.HotelRepository;
import akademia.repositories.RoomRepository;
import akademia.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceDto implements HotelService<HotelDto> {

    private final Logger logger = LoggerFactory.getLogger(HotelServiceDto.class);
    private final HotelRepository hotelRepository;
    private final AddressRepository addressRepository;
    private final RoomRepository roomRepository;

    public HotelServiceDto(HotelRepository hotelRepository, AddressRepository addressRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.addressRepository = addressRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public List<HotelDto> getHotels() {
        return hotelRepository.findAllHotel()
                .stream()
                .map(HotelMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelDto> getHotelsByCountry(String country) {
        return hotelRepository.findByCountry(country)
                .stream()
                .map(HotelMapper::map)
                .collect(Collectors.toList());
    }


    @Override
    public List<HotelDto> getHotelsByCity(String city) {
        return hotelRepository.findHotelByAddress_City(city)
                .stream()
                .map(HotelMapper::map)
                .collect(Collectors.toList());
    }


    @Override
    public List<HotelDto> getHotelsByRate(String rate) {
        return hotelRepository.findHotelByRate(rate)
                .stream()
                .map(HotelMapper::map)
                .collect(Collectors.toList());
    }


    @Override
    public List<HotelDto> getHotelsByRoomType(String type) {
        return null;
    }

    @Override
    public HotelDto getHotelByPartnerCode(String partnerCode) {
        Optional<Hotel> hotel = hotelRepository.findHotelByPartnerCode(partnerCode);
        hotel.orElseThrow(() -> new ResourceNotFoundException(partnerCode));
        return HotelMapper.map(hotel.get());

    }


    @Override
    public String deleteHotelByPartnerCode(String partnerCode) {
        hotelRepository.deleteHotelByPartnerCode(partnerCode);
        return partnerCode;
    }


    public HotelDto updateHotel(HotelDto hotelDto, String partnerCode) {
        Optional<Hotel> before = hotelRepository.findHotelByPartnerCode(partnerCode);
        logger.debug("Original hotel {} ", before.get());
        before.orElseThrow(() -> new ResourceNotFoundException("Hotel not found about given partner_code: " + hotelDto.getPartnerCode()));
        before.get().setTitle(hotelDto.getTitle());
        before.get().setCountry(hotelDto.getCountry());
        before.get().setRate(hotelDto.getRate());
        before.get().setUpdateDateTime(LocalDateTime.now());
        before.get().getAddress().setEmail(hotelDto.getAddress().getEmail());
        before.get().getAddress().setPhone(hotelDto.getAddress().getPhone());
        before.get().getAddress().setUrl(hotelDto.getAddress().getUrl());
        for (int i = 0; i < hotelDto.getRoomsNumber().size(); i++) {
            before.get().getRooms().get(i).setType(hotelDto.getRoomsNumber().get(i).getType());
            before.get().getRooms().get(i).setBed(hotelDto.getRoomsNumber().get(i).getBed());
            before.get().getRooms().get(i).setCapacity(hotelDto.getRoomsNumber().get(i).getCapacity());
        }
         hotelRepository.save(before.get());
        logger.debug("Modified hotel {} ", before.get());
        return HotelMapper.map(before.get());
    }

    @Override
    public HotelDto addHotel(HotelDto hotelDTO) {
        final Hotel hotel = HotelMapper.reverse(hotelDTO);
        final Hotel idHotel = hotelRepository.save(hotel);
        addressRepository.save(idHotel.getAddress());
        roomRepository.saveAll(hotel.getRooms());
        return HotelMapper.map(hotel);
    }
}
