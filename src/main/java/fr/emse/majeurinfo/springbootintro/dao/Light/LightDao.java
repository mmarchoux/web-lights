package fr.emse.majeurinfo.springbootintro.dao.Light;

import fr.emse.majeurinfo.springbootintro.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao  extends JpaRepository<Light, Long>,LightDaoCustom {
    // JpaRepository génération id auto...
    // interface peut hériter de plusieurs interfaces
}

