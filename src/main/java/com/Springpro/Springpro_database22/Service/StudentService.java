package com.Springpro.Springpro_database22.Service;

import com.Springpro.Springpro_database22.Entity.Student;
import com.Springpro.Springpro_database22.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public void saveDetails(Student student){
        studentRepo.save(student);

    }
    public List<Student> fetchAll(){
        return studentRepo.fetchallfromcustomers();
    }
    public List<Student> fetchstudentswithname(String name){
        return studentRepo.fetchallfromcustomerswithName(name);
    }

    public List<Student> newstudent(Integer mark, String name) {
        return studentRepo.logURI(mark,name);

    }
    public void saveDetails2(Integer mark, String name){
        studentRepo.insertUser(mark,name);
//        return studentRepo.addStudent(student.getName(),student.getMark());
    }

}
