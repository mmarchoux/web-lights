package fr.emse.majeureinfo.springbootintro.dao.Room;

import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long>,RoomDaoCustom {
    // JpaRepository génération id auto...
    // interface peut hériter de plusieurs interfaces
}

