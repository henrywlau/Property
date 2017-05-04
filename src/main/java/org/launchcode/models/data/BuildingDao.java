package org.launchcode.models.data;

import org.launchcode.models.forms.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by henry on 5/3/17.
 */
@Repository
@Transactional
public interface BuildingDao extends CrudRepository<Building, Integer> {
}
