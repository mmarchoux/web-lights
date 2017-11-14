package fr.emse.majeureinfo.springbootintro.dao.Room;


import fr.emse.majeureinfo.springbootintro.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static fr.emse.majeureinfo.springbootintro.model.Status.ON;

public class RoomDaoImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findOnRooms() {
        String jpql = "select rm from Room rm where rm.light_id = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", 1 )
                .getResultList();
    }


    public List<Room> findRoomsWithOnLight(){
        String jpql = "select rm from Room rm join Light lt where lt.Status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", ON )
                .getResultList();
    }
}
