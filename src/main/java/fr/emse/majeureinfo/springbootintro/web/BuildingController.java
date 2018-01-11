package fr.emse.majeureinfo.springbootintro.web;
import fr.emse.majeureinfo.springbootintro.dao.Building.BuildingDao;
import fr.emse.majeureinfo.springbootintro.dao.Room.RoomDao;
import fr.emse.majeureinfo.springbootintro.model.Building;
import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/buildings")
@Transactional
public class BuildingController {
    private final BuildingDao buildingDao ;
    private final RoomDao roomDao;

    @Autowired
    BuildingController(BuildingDao buildingDao ,RoomDao roomDao){this.buildingDao=buildingDao;
        this.roomDao = roomDao;}

    @GetMapping
    public List<BuildingDto> list()
    { return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }




    @GetMapping(value="/{buildingId}")
    public List<RoomDto>  getlistrooms(@PathVariable Long buildingId) {
        Building building = buildingDao.findOne(buildingId);
        BuildingDto buildingDto = new BuildingDto(building);
        List<RoomDto> result =buildingDto.getListeroomsdto();
        return  result;
    }
    @PutMapping(value="/{roomId}/switchlight")
    public List<RoomDto>  switchLight( @PathVariable Long roomId) {
        Room room = roomDao.findOne(roomId);
        Building building = buildingDao.findOne(room.getBuilding().getId());
        room.switchLight();
        BuildingDto buildingDto = new BuildingDto(building);
        return  buildingDto.getListeroomsdto();
    }
    @PutMapping(value="/{roomId}/switchringer")
    public  List<RoomDto> switchRinger(@PathVariable Long roomId) {
        Room room = roomDao.findOne(roomId);
        Building building = buildingDao.findOne(room.getBuilding().getId());
        room.switchRinger();
        BuildingDto buildingDto = new BuildingDto(building);
        return  buildingDto.getListeroomsdto();
    }


}
