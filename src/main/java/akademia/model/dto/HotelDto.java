package akademia.model.dto;

import lombok.*;

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
