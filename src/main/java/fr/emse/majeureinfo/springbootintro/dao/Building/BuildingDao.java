package fr.emse.majeureinfo.springbootintro.dao.Building;

import fr.emse.majeureinfo.springbootintro.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDao extends JpaRepository<Building, Long>, BuildingDaoCustom  {

}
