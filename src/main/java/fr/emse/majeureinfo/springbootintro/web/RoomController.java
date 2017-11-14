package fr.emse.majeureinfo.springbootintro.web;


import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDao;
import fr.emse.majeureinfo.springbootintro.model.Light;
import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Status;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value="/{id}")
    public RoomDto get(Long roomId) {
        Room room = roomDao.findOne(roomId);
        if(room!=null){
        RoomDto roomDto = new RoomDto(room);

            return  roomDto;}
    }

    @GetMapping(value="/{id}/switchlight")
        public RoomDto switchLight(Long roomId) {
            Room room = roomDao.findOne(roomId);
            room.switchLight();
            RoomDto roomDto = new RoomDto(roomDao.save(room));
            return  roomDto;
    }


    }

    @GetMapping(value="/{id}/switchRinger")
    public RoomDto switchRinger(Long roomId) {
        Room room = roomDao.findOne(roomId);
        room.switchRinger();
        RoomDto roomDto = new RoomDto(roomDao.save(room));
        return  roomDto;}


}

