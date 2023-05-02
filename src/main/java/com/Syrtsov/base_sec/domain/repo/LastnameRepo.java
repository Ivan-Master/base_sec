package com.Syrtsov.base_sec.domain.repo;

import com.Syrtsov.base_sec.domain.entity.Lastname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastnameRepo extends JpaRepository<Lastname, Long> {
    Lastname findByName (String family);
}
