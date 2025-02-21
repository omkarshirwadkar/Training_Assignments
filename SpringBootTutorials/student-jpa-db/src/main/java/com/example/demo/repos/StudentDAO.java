package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	public List<Student> findBySchool(String school);
	
	@Query("SELECT s FROM Student s WHERE s.percentage >= 40")
    List<Student> findPassedStudents();
 
    @Query("SELECT s FROM Student s WHERE s.percentage < 40")
    List<Student> findFailedStudents();
    
	long countByStd(int std);
	long countBySchool(String school);
	
	@Query("SELECT s FROM Student s ORDER BY s.percentage DESC LIMIT 5")
    List<Student> findTop5ByPercentage();
 
    @Query("SELECT s FROM Student s WHERE s.std = ?1  ORDER BY s.percentage DESC LIMIT 1")
    Optional<Student> findTopperByStandard(int std);
    
    @Query("SELECT t FROM Teacher t WHERE t.std = (SELECT s.std FROM Student s where s.rollNo =?1)")
    Optional<Teacher> findTeacherByRollNo(int rollNo);
}
