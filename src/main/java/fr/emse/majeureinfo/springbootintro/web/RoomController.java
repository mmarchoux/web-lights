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

    @GetMapping
    public RoomDto get(Long roomId) {
        Room room = roomDao.findOne(roomId);
        if(room!=null){
        RoomDto roomDto = new RoomDto(room);

            return  roomDto;}
    }

    @GetMapping
        public RoomDto switchLight(Long roomId) {
            Room room = roomDao.findOne(roomId);
            Status state = room.getLight().getStatus();
            if(state==Status.ON)
            {room.getLight().setStatus(Status.OFF);}
            else
            { room.getLight().setStatus(Status.ON);}
            room = roomDao.save(room);
            RoomDto roomDto = new RoomDto(room);
            return  roomDto;}


    }

    @GetMapping
    public RoomDto switchRinger(Long roomId) {
        Room room = roomDao.findOne(roomId);
        Status state = room.getNoise().getStatus();
        if(state==Status.ON)
        {room.getNoise().setStatus(Status.OFF);}
        else
        { room.getNoise().setStatus(Status.ON);}
        room = roomDao.save(room);
        RoomDto roomDto = new RoomDto(room);
        return  roomDto;}


}

