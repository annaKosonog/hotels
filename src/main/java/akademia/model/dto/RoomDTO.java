package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private String type;
    private String bed;
    private String capacity;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("bed", bed)
                .append("capacity", capacity)
                .toString();
    }
}
