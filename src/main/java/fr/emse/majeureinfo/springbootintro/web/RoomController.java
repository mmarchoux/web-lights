package fr.emse.majeureinfo.springbootintro.web;


import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDao;
import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDaoImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }


    @GetMapping(value = "/api/rooms/list-with-on-lights")
    public List<RoomDto> listWithOnLight() {
        return new RoomDaoImpl().findRoomsWithOnLight().stream().map(RoomDto::new).collect(Collectors.toList());
    }

}