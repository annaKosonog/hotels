package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressDto {

    private String postalAddress;
    private String email;
    private String phone;
    private String url;

    //todo dodać dane geograficzne z google maps
}

