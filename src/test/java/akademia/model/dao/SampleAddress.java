package akademia.model.dao;


import akademia.model.dto.AddressDto;

public interface SampleAddress {

    default Address allParametersOfTheAddress(Long id, String city, String street, String streetNo, String email, String phone, String url, Hotel hotel) {
        return new Address(id, city, street, streetNo, email, phone, url, hotel);
    }

    default Address objectAddressParametersWithoutId(String city, String street, String streetNo, String email, String phone, String url, Hotel hotel) {
        final Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setStreetNo(streetNo);
        address.setEmail(email);
        address.setPhone(phone);
        address.setUrl(url);
        address.setHotel(hotel);
        return address;
    }

    default AddressDto objectAddressDto(String postalAddress, String email, String phone, String url) {
        return new AddressDto(postalAddress, email, phone, url);
    }

    default Address krakow() {
        return allParametersOfTheAddress(2L, "Kraków", "Zator", "2/5", "energylandia@contact.pl", "852268842", "https://www.energylandia.pl", null);
    }

    default Address warszawa() {
        return allParametersOfTheAddress(3L, "Warszawa", "al. Jerozolimska", "5/7", "sobieski@contact.pl", "533286596", "https://www.sobieskihotel.pl", null);
    }

    default Address budapest() {
        return allParametersOfTheAddress(5L, "Budapeszt", "Clark Adam", "1", "hotelClarkBudapest@contact.hu", "+36 1610 4890", "https://www.hotel-clark-budapest.hu", null);
    }

    default Address benjol() {
        return allParametersOfTheAddress(1L, "Benjol", "Rab", "322", "valamar@contact.cr", "+385 52 465 000", "https://www.valamar.com/en/hotels-rab/padova-hotel", null);
    }

    default AddressDto benjolWithoutId() {
        return objectAddressDto("Benjol, Rab, 322", "valamar@contact.cr", "+385 52 465 000", "https://www.valamar.com/en/hotels-rab/padova-hotel");
    }

    default AddressDto benjolWithoutCityAndPhone() {
        return objectAddressDto(null, "valamar@contact.cr", null, "https://www.valamar.com/en/hotels-rab/padova-hotel");
    }


    default AddressDto krakowWithoutId() {
        return objectAddressDto("Kraków, Zator, 2/5", "energylandia@contact.pl", "852268842", "https://www.energylandia.pl");
    }

    default AddressDto warszawaWithoutId() {
        return objectAddressDto("Warszawa, al. Jerozolimska, 5/7", "sobieski@contact.pl", "533286596", "https://www.sobieskihotel.pl");
    }

    default AddressDto budapestWithoutId() {
        return objectAddressDto("Budapeszt, Clark Adam, 1", "hotelClarkBudapest@contact.hu", "+36 1610 4890", "https://www.hotel-clark-budapest.hu");
    }

    default AddressDto gdanskWithoutId() {
        return objectAddressDto("Gdańsk, Ołowianka, 3a", "olowianka@contact.pl", "534 407 040", "https://www.olowianka.pl");
    }

    default Address gdanskAddress() {
        return objectAddressParametersWithoutId("Gdańsk", "Ołowianka", "3a", "olowianka@contact.pl", "534 407 040", "https://www.olowianka.pl", null);
    }


}
