package fr.emse.majeurinfo.springbootintro.dao.Noise;


import fr.emse.majeurinfo.springbootintro.model.Noise;
import fr.emse.majeurinfo.springbootintro.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class NoiseDaoImpl implements NoiseDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Noise> findOnNoises() {
        String jpql = "select ns from Noise ns where ns.status = :value";
        TypedQuery<Noise> query = em.createQuery(jpql, Noise.class);
        return query.setParameter("value", Status.ON)
                .getResultList();
    }
}
