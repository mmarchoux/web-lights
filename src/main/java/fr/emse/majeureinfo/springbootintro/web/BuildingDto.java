package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Building;
import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Status;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class BuildingDto {

    private final Long id;
    private final List<RoomDto> listeroomsdto ;
    public  int nbrrooms ;
    public  int nbreroomslighton;
    public  int nbreroomsringeron;

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.listeroomsdto = building.getListerooms() == null ? null : maplistroomdto(building.getListerooms());
        this.nbrrooms =  building.getListerooms().size();
        this.nbreroomslighton= getNbreroomslighton(building.getListerooms());
        this.nbreroomsringeron = getNbreroomsringeron(building.getListerooms());
    }

    public Long getId() {
        return id;
    }
    public List<RoomDto> getListeroomsdto() {
        return listeroomsdto;
    }

    public List<RoomDto> maplistroomdto(List<Room> rooms){
        List<RoomDto> result = new ArrayList<RoomDto>();
        for (Room room : rooms) result.add(new RoomDto(room));
        return result;
    }

    public int getNbreroomslighton(List<Room> rooms){
        int result = 0 ;
        for (Room room : rooms) {
          if(room.getLight().getStatus()== Status.ON)  result++;
        }
        return result ;
    }

    public int getNbreroomsringeron(List<Room> rooms){
        int result = 0 ;
        for (Room room : rooms) {
            if(room.getNoise().getStatus()== Status.ON)  result++;
        }
        return result ;
    }


}
