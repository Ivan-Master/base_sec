package com.Syrtsov.base_sec.domain.repo;

import com.Syrtsov.base_sec.domain.entity.Secondname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondnameRepo extends JpaRepository<Secondname, Long> {
    Secondname findByName(String name);
}
