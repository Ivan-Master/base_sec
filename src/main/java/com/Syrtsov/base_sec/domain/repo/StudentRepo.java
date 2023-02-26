package com.Syrtsov.base_sec.domain.repo;

import com.Syrtsov.base_sec.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Long> {

    List<Student> findByGroupp(int groupp);

}
