package fr.emse.majeurinfo.springbootintro.dao.Room;

import fr.emse.majeurinfo.springbootintro.model.Room;
import java.util.List;

public interface RoomDaoCustom {

    public List<Room> findOnRooms();
}
