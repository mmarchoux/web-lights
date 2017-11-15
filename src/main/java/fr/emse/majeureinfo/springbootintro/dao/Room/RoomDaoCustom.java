package fr.emse.majeureinfo.springbootintro.dao.Room;

import fr.emse.majeureinfo.springbootintro.model.Room;

import java.util.List;

public interface RoomDaoCustom {


    public List<Room> findRoomsWithOnLight();


}
