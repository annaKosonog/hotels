package akademia.model.dto;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RoomDto implements Serializable {

    private static final long serialVersionUID = -4856846361193249489L;
    private String type;
    private String bed;
    private String capacity;
}
