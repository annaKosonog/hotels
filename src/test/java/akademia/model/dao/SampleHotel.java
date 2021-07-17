package akademia.model.dao;

import akademia.model.dao.Hotel;
import akademia.model.dto.AddressDto;
import akademia.model.dto.HotelDto;
import akademia.model.dto.RoomDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SampleHotel implements SampleAddress, SampleRoom {


    public Hotel allParameterForHotel(Long id, String partnerCode, String title, String country, String rate, Address address, List<Room> rooms, LocalDateTime createDateTime, LocalDateTime updateTime) {
        return new Hotel(id, partnerCode, title, country, rate, address, rooms, createDateTime, updateTime);
    }

    public Hotel parametersHotelWithoutIdAndPartnerCode(String title, String country, String rate, Address address, List<Room> rooms, LocalDateTime createDateTime) {
        final Hotel hotel = new Hotel();
        hotel.setTitle(title);
        hotel.setCountry(country);
        hotel.setRate(rate);
        hotel.setAddress(address);
        hotel.setRooms(rooms);
        hotel.setCreateDateTime(createDateTime);
        return hotel;
    }

    public HotelDto allParameterForHotelDto(String title, String partnerCode, String country, String rate, AddressDto addressDTO, List<RoomDto> roomDTOList) {
        return new HotelDto(title, partnerCode, country, rate, addressDTO, roomDTOList);
    }

    public HotelDto parametersHotelWithoutIdAndPartnerCode(String title, String country, String rate, AddressDto addressDTO, List<RoomDto> rooms) {
        final HotelDto hotelDTO = new HotelDto();
        hotelDTO.setTitle(title);
        hotelDTO.setCountry(country);
        hotelDTO.setRate(rate);
        hotelDTO.setAddress(addressDTO);
        hotelDTO.setRoomsNumber(rooms);
        return hotelDTO;
    }


    public Hotel energyLandia() {
        return allParameterForHotel(1L, "a372b512-9a48-4107-8d4e-3fbc3fa22ccd", "EnergyLandia", "Poland", "5",
                krakow(), Arrays.asList(singleBedKrakow(), apartmentBedKrakow(),
                        deluxeBedKrakow()), LocalDateTime.now(), null);

    }

    public Hotel sobieskiHotel() {
        return allParameterForHotel(2L, "d36b7579-39ff-488d-8551-d811c4f1c0b9", "Sobieski Hotel", "Poland", "4",
                warszawa(), Arrays.asList(singleBedWarszawa(), deluxeBedWarszawa(), apartmentBedWarszawa()),
                LocalDateTime.now(), null);
    }

    public Hotel clarkHotel() {
        return allParameterForHotel(4L, "0b25d2b9-5573-4d38-a81f-de982bb554b6", "Hotel Clark Budapest", "Hungary", "4",
                budapest(), Arrays.asList(deluxeBedBudapest(), apartmentBedBudapest()),
                LocalDateTime.now(), null);
    }

    public Hotel valamarPadovaHotel() {
        return allParameterForHotel(5L, "a9fb6a88-8b82-4778-a3e3-0fd41e60e61d", "Valamar Padova Hotel", "Croatia", "4", benjol(), Arrays.asList(exampleOne(), exampleTwo()), LocalDateTime.now(), LocalDateTime.now());
    }

    public HotelDto newValamarPadovaHotelDto() {
        return allParameterForHotelDto("Valamar Padova Hotel", "a9fb6a88-8b82-4778-a3e3-0fd41e60e61d", "Croatia", "4", benjolWithoutId(), Arrays.asList(exampleRoomDtoOne(), exampleRoomDtoTwo()));
    }

    public HotelDto valamarPadovaHotelDtoValidation() {
        return allParameterForHotelDto(null, "a9fb6a88-8b82-4778-a3e3-0fd41e60e61d", null, null, benjolWithoutCityAndPhone(), Arrays.asList(exampleRoomDtoOne(), exampleRoomDtoTwo()));
    }

    public HotelDto energylandiaDto() {
        return allParameterForHotelDto("EnergyLandia", "a372b512-9a48-4107-8d4e-3fbc3fa22ccd", "Poland", "5", krakowWithoutId(),
                Arrays.asList(singleBedKrakowDto(), apartmentBedKrakowDto(), deluxeBedKrakowDto()));
    }

    public HotelDto sobieskiHotelDto() {
        return allParameterForHotelDto("Sobieski Hotel", "d36b7579-39ff-488d-8551-d811c4f1c0b9", "Poland", "4", warszawaWithoutId(),
                Arrays.asList(singleBedWarszawaDto(), deluxeBedWarszawaDto(), apartmentBedWarszawaDto()));
    }

    public HotelDto clarkHotelDto() {
        return allParameterForHotelDto("Hotel Clark Budapest", "0b25d2b9-5573-4d38-a81f-de982bb554b6", "Hungary", "4", budapestWithoutId(),
                Arrays.asList(deluxeBedBudapestDto(), apartmentBedBudapestDto()));
    }

    public HotelDto updateClarkHotelDto() {

        List<RoomDto> roomList = new ArrayList<>();
        roomList.add(singleBedBudapestDto());

        HotelDto newClarkHotel = clarkHotelDto();
        newClarkHotel.setTitle("Prestige Hotel Budapest");
        newClarkHotel.setPartnerCode("0b25d2b9-5573-4d38-a81f-de982bb554b6");
        newClarkHotel.setCountry("Hungary");
        newClarkHotel.setRate("4");
        newClarkHotel.getAddress().setPostalAddress("Budapeszt, Kraviec, 10/13");
        newClarkHotel.getAddress().setEmail("reservation@hotelclarkbudapest.hu");
        newClarkHotel.getAddress().setPhone("+36 1611 4890");
        newClarkHotel.getAddress().setUrl("https://hotelclarkbudapest.hu/en/");
        newClarkHotel.setRoomsNumber(roomList);
        return newClarkHotel;
    }
}
