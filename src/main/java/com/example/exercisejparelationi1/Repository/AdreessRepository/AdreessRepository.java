package com.example.exercisejparelationi1.Repository.AdreessRepository;

import com.example.exercisejparelationi1.Model.Addreess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdreessRepository extends JpaRepository<Addreess, Integer>{

        Addreess findAddreessById(Integer id);
}
