package akademia.model.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class HotelDto implements Serializable {

    private static final long serialVersionUID = -4856846361193249489L;

    @NotBlank(message = "{title.not.blank}")
    private String title;
    private String partnerCode;
    @NotBlank(message = "{country.not.blank}")
    private String country;
    @NotBlank(message = "{rate.not.blank}")
    private String rate;
    @Valid
    private AddressDto address;
    private List<RoomDto> roomsNumber;
}
