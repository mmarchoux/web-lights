package fr.emse.majeurinfo.springbootintro.dao.Room;

import fr.emse.majeurinfo.springbootintro.dao.Room.RoomDaoCustom;
import fr.emse.majeurinfo.springbootintro.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long>,RoomDaoCustom {
    // JpaRepository génération id auto...
    // interface peut hériter de plusieurs interfaces
}

