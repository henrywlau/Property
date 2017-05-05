package org.launchcode.models.data;

import org.launchcode.models.forms.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by henry on 5/4/17.
 */
@Repository
@Transactional
public interface TenantDao extends CrudRepository<Tenant, Integer> {
}
