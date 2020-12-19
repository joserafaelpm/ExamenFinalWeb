package com.example.demo.modeloDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Sorteo;

public interface ISorteo extends JpaRepository<Sorteo, Integer> {

}
