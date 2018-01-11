package fr.emse.majeureinfo.springbootintro.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity     //objet java mapper avec base SQL
@SuppressWarnings("serial")
public class Building {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Room> listerooms = new ArrayList<Room>();
    public Building() {

    }


    public Building(List<Room> listerooms) {
        this.listerooms = listerooms;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getListerooms() {
        return listerooms;
    }

    public void setListerooms(List<Room> listerooms) {
        this.listerooms = listerooms;
    }
}
