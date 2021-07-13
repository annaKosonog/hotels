package akademia.mappers;

import akademia.model.dao.Address;
import akademia.model.dao.Hotel;
import akademia.model.dao.Room;
import akademia.model.dto.HotelDTO;
import akademia.model.dto.RoomDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class HotelMapper {

    public static HotelDTO map(Hotel from) {

        List<RoomDTO> rooms = from.getRooms()
                .stream()
                .map(RoomMapper::map)
                .collect(Collectors.toList());

        return HotelDTO.builder()
                .title(from.getTitle())
                .partnerCode(from.getPartnerCode())
                .country(from.getCountry())
                .rate(from.getRate())
                .address(AddressMapper.map(from.getAddress()))
                .roomsNumber(rooms)
                .build();
    }

    public static Hotel reverse(HotelDTO to) {
        final List<Room> roomList = to.getRoomsNumber()
                .stream()
                .map(RoomMapper::reverse)
                .collect(Collectors.toList());
        final Address address = AddressMapper.getAddressFromDTO(to.getAddress());

        final Hotel hotel = new Hotel();
        hotel.setTitle(to.getTitle());
        hotel.setPartnerCode(UUID.randomUUID().toString());
        hotel.setCountry(to.getCountry());
        hotel.setRate(to.getRate());
        hotel.setAddress(address);
        hotel.setRooms(roomList);
        hotel.setCreateDateTime(LocalDateTime.now());
        address.setHotel(hotel);
        return hotel;
    }
}
