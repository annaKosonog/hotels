package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressDto {

    @Valid
    @NotBlank(message = "{postalAddress.not.blank}")
    private String postalAddress;
    @Email
    private String email;
    @NotBlank(message = "{phone.not.blank}")
    @Size(max = 13)
    private String phone;
    @URL
    private String url;

    //todo dodać dane geograficzne z google maps
}

