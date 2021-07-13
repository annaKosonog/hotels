package akademia.mappers;

import akademia.model.dao.Room;
import akademia.model.dto.RoomDto;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {


    public static RoomDto map(Room from) {
        return RoomDto.builder()
                .bed(from.getBed())
                .capacity(from.getCapacity())
                .type(from.getType())
                .build();
    }

    public static Room reverse(RoomDto to) {
        return Room.builder()
                .bed(to.getBed())
                .capacity(to.getCapacity())
                .type(to.getType())
                .build();
    }


}
