package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Room;

public class RoomDto {

    private final Long id;

    private final LightDto light;
    private final NoiseDto noise;
    private final Long buildingID ;
   // private final BuildingDto building;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.light = room.getLight()==null ? null:new LightDto(room.getLight());
        this.noise = room.getNoise()==null ? null:new NoiseDto(room.getNoise());

        this.buildingID= room.getBuilding().getId() ;
       // this.building =room.getBuilding()==null ? null:new BuildingDto(room.getBuilding());

    }

    public Long getId() {
        return id;
    }

    public LightDto getLight() {
        return light;
    }
    public NoiseDto getNoise() {
        return noise;

    }

    public long getBuildingID(){return buildingID;}
}
