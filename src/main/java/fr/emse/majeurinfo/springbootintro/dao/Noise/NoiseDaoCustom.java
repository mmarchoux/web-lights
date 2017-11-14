package fr.emse.majeurinfo.springbootintro.dao.Noise;

import fr.emse.majeurinfo.springbootintro.model.Noise;
import java.util.List;

public interface NoiseDaoCustom {

    public List<Noise> findOnNoises();
}
