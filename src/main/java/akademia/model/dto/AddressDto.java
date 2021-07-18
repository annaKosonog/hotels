package akademia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressDto implements Serializable {

    private static final long serialVersionUID = -4856846361193249489L;
    @Valid
    @NotBlank(message = "{postalAddress.not.blank}")
    private String postalAddress;
    @Email
    private String email;
    @NotBlank(message = "{phone.not.blank}")
    @Size(max = 15)
    private String phone;
    @URL
    private String url;
}

//todo dodać dane geograficzne z google maps



