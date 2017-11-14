package fr.emse.majeurinfo.springbootintro.dao.Light;

import fr.emse.majeurinfo.springbootintro.model.Light;
import java.util.List;

public interface LightDaoCustom {

    public List<Light> findOnLights();
}
