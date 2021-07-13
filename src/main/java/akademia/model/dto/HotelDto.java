package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class HotelDto {
    private String title;
    private String partnerCode;
    private String country;
    private String rate;
    private AddressDto address;
    private List<RoomDto> roomsNumber;
}
