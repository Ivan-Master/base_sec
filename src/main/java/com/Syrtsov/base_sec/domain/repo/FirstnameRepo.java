package com.Syrtsov.base_sec.domain.repo;

import com.Syrtsov.base_sec.domain.entity.Firstname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstnameRepo extends JpaRepository<Firstname, Long> {
    Firstname findByName (String name);
}
