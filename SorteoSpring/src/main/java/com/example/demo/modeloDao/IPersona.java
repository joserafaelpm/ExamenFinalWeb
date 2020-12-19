package com.example.demo.modeloDao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Persona;

public interface IPersona extends JpaRepository<Persona, Integer> {

}
