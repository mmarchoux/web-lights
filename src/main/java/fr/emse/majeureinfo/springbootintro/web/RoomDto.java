package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Noise;
import fr.emse.majeureinfo.springbootintro.model.Light;

public class RoomDto {

    private final Long id;
    private final Light lightDto;
    private final Noise noiseDto;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.lightDto = room.getLight();
        this.noiseDto = room.getNoise();
    }

    public Long getId() {
        return id;
    }

    public Light getLightDto() {
        return lightDto;
    }

    public Noise getNoiseDto() {
    return noiseDto;
    }
}
