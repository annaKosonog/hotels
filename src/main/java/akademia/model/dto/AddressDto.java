package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String postalAddress;
    private String email;
    private String phone;
    private String url;

    //todo dodać dane geograficzne z google maps

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("postalAddress", postalAddress)
                .append("email", email)
                .append("phone", phone)
                .append("url", url)
                .toString();
    }
}

