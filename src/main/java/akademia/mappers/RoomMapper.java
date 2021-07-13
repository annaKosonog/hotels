package akademia.mappers;

import akademia.model.dao.Room;
import akademia.model.dto.RoomDTO;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {


    public static RoomDTO map(Room from) {
        return RoomDTO.builder()
                .bed(from.getBed())
                .capacity(from.getCapacity())
                .type(from.getType())
                .build();
    }

    public static Room reverse(RoomDTO to) {
        return Room.builder()
                .bed(to.getBed())
                .capacity(to.getCapacity())
                .type(to.getType())
                .build();
    }


}
