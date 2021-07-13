package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDto {
    private String title;
    private String partnerCode;
    private String country;
    private String rate;
    private AddressDto address;
    private List<RoomDto> roomsNumber;

    @Override
    public String toString() {
        return new ToStringBuilder(this.getClass().getName())
                .append("title", title)
                .append("partnerCode", partnerCode)
                .append("country", country)
                .append("rate", rate)
                .append("address", address)
                .append("rooms", roomsNumber)
                .toString();
    }

}
