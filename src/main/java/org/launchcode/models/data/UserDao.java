package org.launchcode.models.data;

import org.launchcode.models.forms.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by henry on 5/11/17.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
