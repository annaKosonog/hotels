package akademia.mappers;

import akademia.model.dao.Address;
import akademia.model.dto.AddressDTO;
import akademia.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressDTO> {
    @Override
    public AddressDTO map(Address from) {
        return AddressDTO
                .builder()
                .email(from.getEmail())
                .phone(from.getPhone())
                .url(from.getUrl())
                .postalAddress(from.getCity() + ", " +  from.getStreet() + ", " + from.getStreetNo())
                .build();

    }

    @Override
    public Address reverse(AddressDTO to) {
        return null;
    }
}
