package com.example.exercisejparelationi1.Repository;

import com.example.exercisejparelationi1.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


    Teacher findTeacherById(Integer id);
}
