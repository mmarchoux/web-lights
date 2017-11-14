package fr.emse.majeureinfo.springbootintro.dao.Light;

import fr.emse.majeureinfo.springbootintro.model.Light;
import java.util.List;

public interface LightDaoCustom {

    public List<Light> findOnLights();
}
