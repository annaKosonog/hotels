package akademia.model.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private String type;
    private String bed;
    private String capacity;
}
