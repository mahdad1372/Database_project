package com.Springpro.Springpro_database22.Repository;

import com.Springpro.Springpro_database22.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT s FROM Student s")
    public List<Student> fetchallfromcustomers();
    @Query("SELECT u FROM Student u WHERE u.name = ?1")
    public List<Student> fetchallfromcustomerswithName(String name);
//    @Query(value = "insert into Student (mark,name) VALUES (:mark,:name)",nativeQuery = true)
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM student_db  WHERE name = :name AND st_mark = :mark ", nativeQuery = true)
    public List<Student> logURI(@Param("mark") Integer mark, @Param("name") String name);
    @Modifying
    @Transactional
    @Query(
            value =
                    "insert into student_db (id,st_mark, name) values (7,:mark, :name)",
            nativeQuery = true)
    void insertUser(@Param("mark") Integer mark, @Param("name") String name);
//    @Query(
//            value =
//                    "insert into Users (name, age, email, status) values (:name, :age, :email, :status)",
//            nativeQuery = true)
//    void insertUser(@Param("name") String name, @Param("age") Integer age,
//                    @Param("status") Integer status, @Param("email") String email);
}
