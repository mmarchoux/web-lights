package fr.emse.majeureinfo.springbootintro.dao.Room;


import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static fr.emse.majeureinfo.springbootintro.model.Status.ON;

public class RoomDaoImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    public List<Room> findRoomsWithOnLight(){
        String jpql = "select rm from Room rm where rm.light.status = :value";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("value", Status.ON )
                .getResultList();
    }

}
