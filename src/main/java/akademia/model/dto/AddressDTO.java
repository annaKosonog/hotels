package akademia.model.dto;

import lombok.*;

import javax.persistence.Entity;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String postalAddress;
    private String email;
    private String phone;
    private String url;

    //todo dodać dane geograficzne z google maps
}
