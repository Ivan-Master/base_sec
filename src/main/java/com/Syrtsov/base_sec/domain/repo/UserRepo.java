package com.Syrtsov.base_sec.domain.repo;

import com.Syrtsov.base_sec.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
