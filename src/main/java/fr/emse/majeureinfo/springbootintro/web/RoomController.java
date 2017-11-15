package fr.emse.majeureinfo.springbootintro.web;


import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDao;

import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDaoImpl;

import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> list()
    {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }


    @GetMapping(value = "/list-with-on-lights")
    public List<RoomDto> listWithOnLight() {
        return new RoomDaoImpl().findRoomsWithOnLight().stream().map(RoomDto::new).collect(Collectors.toList());
    }


    @GetMapping(value="/{roomId}")
    public RoomDto get(Long roomId) {
        Room room = roomDao.findOne(roomId);
        RoomDto roomDto = null;
        if(room!=null){
        roomDto = new RoomDto(room);}

        return  roomDto;
    }

    @PutMapping(value="/{roomID}/switchlight")
        public RoomDto switchLight(Long roomId) {
            Room room = roomDao.findOne(roomId);
            room.switchLight();
            RoomDto roomDto = new RoomDto(roomDao.save(room));
            return  roomDto;
    }

    @PutMapping(value="/{roomID}/switchRinger")
    public RoomDto switchRinger(Long roomId) {
        Room room = roomDao.findOne(roomId);
        room.switchRinger();
        RoomDto roomDto = new RoomDto(roomDao.save(room));
        return  roomDto;}

}


