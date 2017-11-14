package fr.emse.majeurinfo.springbootintro.dao.Noise;

import fr.emse.majeurinfo.springbootintro.model.Noise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoiseDao extends JpaRepository<Noise, Long>,NoiseDaoCustom {
    // JpaRepository génération id auto...
    // interface peut hériter de plusieurs interfaces
}

