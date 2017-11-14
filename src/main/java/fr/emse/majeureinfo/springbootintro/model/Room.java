package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;

@Entity     //objet java mapper avec base SQL
//@SuppressWarnings("serial")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Light light;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Noise noise;

    @SuppressWarnings("unused")
    public Room() {
    }


    public Room(Light light, Noise noise) {
        this.light = light;
        this.noise = noise;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public Noise getNoise() {
        return noise;
    }

    public void setNoise(Noise noise)
    {
        this.noise = noise;
    }

    public void switchLight(){

    }Status state = this.getLight().getStatus();
            if(state==Status.ON)
    {this.getLight().setStatus(Status.OFF);}
            else
    { this.getLight().setStatus(Status.ON);}


    public void switchRinger(){

        Status state = this.getNoise().getStatus();
        if(state==Status.ON)
        {this.getNoise().setStatus(Status.OFF);}
        else
        { this.getNoise().setStatus(Status.ON);}

    }
}
