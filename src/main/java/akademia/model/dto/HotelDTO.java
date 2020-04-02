package akademia.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {
    private String title;
    private String country;
    private String rate;
    private AddressDTO address;
    private List<RoomDTO> roomsNumber;


}
