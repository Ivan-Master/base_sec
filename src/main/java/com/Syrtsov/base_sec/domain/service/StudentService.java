package com.Syrtsov.base_sec.domain.service;

import com.Syrtsov.base_sec.domain.entity.Firstname;
import com.Syrtsov.base_sec.domain.entity.Lastname;
import com.Syrtsov.base_sec.domain.entity.Secondname;
import com.Syrtsov.base_sec.domain.entity.Student;
import com.Syrtsov.base_sec.domain.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public Student saveIntoStudent(Student student){
        if (student == null) {
            return null;
        }
        Student fromDBstudent = findByFirstnameAndSecondnameAndLastname(
                student.getFirstname(),  student.getSecondname(), student.getLastname() );
        if (fromDBstudent == null)
        {
            fromDBstudent = studentRepo.save( student );
        }
        return  fromDBstudent;
    }

    public Student findByFirstnameAndSecondnameAndLastname(
            Firstname firstname, Secondname secondname, Lastname lastname){
        return studentRepo.findByFirstname_IdAndSecondnameIdAndLastnameId(firstname.getId(),
                secondname.getId(), lastname.getId());
    }

    public List<Student> findAll()
    {
         return studentRepo.findAll();
    }

    public List<Student> findByGroupp(int group){
        return (List<Student>) studentRepo.findByGroupp( group );
    }

}
