package akademia.mappers;

import akademia.model.dao.Address;
import akademia.model.dao.Room;
import akademia.model.dto.AddressDTO;
import akademia.model.dto.RoomDTO;
import akademia.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomDTO> {

    @Override
    public RoomDTO map(Room from) {
        return RoomDTO.builder()
                .bed(from.getBed())
                .capacity(from.getCapacity())
                .type(from.getType())
                .build();
    }

    @Override
    public Room reverse(RoomDTO to) {
        return null;
    }


}
