package akademia.services;

import akademia.model.dto.HotelDto;

import java.util.List;

public interface HotelService<T> {

    List<T> getHotels();

    List<T> getHotelsByCountry(String country);

    List<T> getHotelsByCity(String city);

    List<T> getHotelsByRate(String rate);

    List<T> getHotelsByRoomType(String type);

    HotelDto getHotelByPartnerCode(String partnerCode);

    String deleteHotelByPartnerCode(String partnerCode);

    HotelDto addHotel(HotelDto hotelDTO);

    HotelDto updateHotel(HotelDto hotelDTO, String partnerCode);

}
