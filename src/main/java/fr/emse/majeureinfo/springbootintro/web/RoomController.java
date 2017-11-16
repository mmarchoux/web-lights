package fr.emse.majeureinfo.springbootintro.web;


import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDao;

import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDaoImpl;

import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;


    @Autowired
    RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> list()
    {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }


    @GetMapping(value = "/list-with-on-light")
    public List<RoomDto> listWithOnLight() {
        return roomDao.findRoomsWithOnLight().stream().map(RoomDto::new).collect(Collectors.toList());
    }


    @GetMapping(value="/{roomId}")
    public RoomDto get(@PathVariable Long roomId) {
        Room room = roomDao.findOne(roomId);
        RoomDto roomDto = null;
        if(room!=null){
        roomDto = new RoomDto(room);}

        return  roomDto;
    }

    @PutMapping(value="/{roomId}/switchlight")
        public List<RoomDto>  switchLight( @PathVariable Long roomId) {
            Room room = roomDao.findOne(roomId);
            room.switchLight();
            RoomDto roomDto = new RoomDto(roomDao.save(room));
            return  roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PutMapping(value="/{roomId}/switchringer")
    public  List<RoomDto> switchRinger(@PathVariable Long roomId) {
        Room room = roomDao.findOne(roomId);
        room.switchRinger();
        RoomDto roomDto = new RoomDto(roomDao.save(room));
        return  roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

}


