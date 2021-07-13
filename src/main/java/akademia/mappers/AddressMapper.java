package akademia.mappers;

import akademia.model.dao.Address;
import akademia.model.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public static AddressDto map(Address from) {
        return AddressDto
                .builder()
                .email(from.getEmail())
                .phone(from.getPhone())
                .url(from.getUrl())
                .postalAddress(from.getCity() + ", " + from.getStreet() + ", " + from.getStreetNo())
                .build();

    }

    public static Address getAddressFromDTO(AddressDto from) {
        Address address = new Address();
        address.setEmail(from.getEmail());
        address.setUrl(from.getUrl());
        address.setPhone(from.getPhone());
        String[] addr = from.getPostalAddress().trim().split(",");
        address.setCity(addr[0]);
        address.setStreet(addr[1]);
        address.setStreetNo(addr[2]);
        return address;
    }
}
