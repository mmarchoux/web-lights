package fr.emse.majeureinfo.springbootintro.dao.Room;

import fr.emse.majeureinfo.springbootintro.model.Room;

import java.util.List;

public interface RoomDaoCustom {


    public List<Room> findRoomsWithOnLight();

    public List<Room> findRoomsWithOffLight();

    public List<Room> findRoomsWithOnNoise();

    public List<Room> findRoomsWithOffNoise();


}
