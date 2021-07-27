package akademia.model.dao;

import akademia.model.dto.RoomDto;

import java.util.List;

public interface SampleRoom {
    default Room allParametersOfTheRoom(Long id, String bed, String type, String capacity, List<Hotel> hotels) {
        return new Room(id, bed, type, capacity, hotels);
    }

    default Room parametersWithoutIdRoom(String bed, String type, String capacity, List<Hotel> hotels) {
        final Room room = new Room();
        room.setBed(bed);
        room.setType(type);
        room.setCapacity(capacity);
        room.setHotels(hotels);
        return room;
    }

    default RoomDto objectRoomDtoWithoutId(String bed, String type, String capacity) {
        return new RoomDto(bed, type, capacity);
    }

    default Room singleBedKrakow() {
        return allParametersOfTheRoom(1L, "individual", "single", "2", null);
    }

    default Room apartmentBedKrakow() {
        return allParametersOfTheRoom(2L, "apartment", "twin", "2", null);
    }

    default Room deluxeBedKrakow() {
        return allParametersOfTheRoom(3L, "deluxe", "twin", "6", null);
    }


    default Room singleBedWarszawa() {
        return allParametersOfTheRoom(4L, "individual", "single", "2", null);
    }

    default Room apartmentBedWarszawa() {
        return allParametersOfTheRoom(5L, "apartment", "twin", "5", null);
    }

    default Room deluxeBedWarszawa() {
        return allParametersOfTheRoom(6L, "deluxe", "twin", "3", null);
    }


    default RoomDto singleBedKrakowDto() {
        return objectRoomDtoWithoutId("individual", "single", "2");
    }

    default RoomDto apartmentBedKrakowDto() {
        return objectRoomDtoWithoutId("apartment", "twin", "2");
    }

    default RoomDto deluxeBedKrakowDto() {
        return objectRoomDtoWithoutId("deluxe", "twin", "6");
    }


    default RoomDto singleBedWarszawaDto() {
        return objectRoomDtoWithoutId("individual", "single", "2");
    }

    default RoomDto apartmentBedWarszawaDto() {
        return objectRoomDtoWithoutId("apartment", "twin", "5");
    }

    default RoomDto deluxeBedWarszawaDto() {
        return objectRoomDtoWithoutId("deluxe", "twin", "3");
    }

    default Room apartmentBedBudapest() {
        return allParametersOfTheRoom(7L, "apartment", "twin", "10", null);
    }

    default Room deluxeBedBudapest() {
        return allParametersOfTheRoom(8L, "deluxe", "twin", "5", null);
    }

    default RoomDto apartmentBedBudapestDto() {
        return objectRoomDtoWithoutId("apartment", "twin", "10");
    }

    default RoomDto deluxeBedBudapestDto() {
        return objectRoomDtoWithoutId("deluxe", "twin", "5");
    }

    default RoomDto singleBedBudapestDto() {
        return objectRoomDtoWithoutId("individual", "single", "4");
    }

    default Room exampleOne() {
        return parametersWithoutIdRoom("single", "single", "1", null);
    }

    default Room exampleTwo() {
        return parametersWithoutIdRoom("deluxe", "superior", "2", null);
    }

    default RoomDto exampleRoomDtoOne() {
        return objectRoomDtoWithoutId("single", "single", "1");
    }

    default RoomDto exampleRoomDtoTwo() {
        return objectRoomDtoWithoutId("superior", "deluxe", "2");
    }
}
