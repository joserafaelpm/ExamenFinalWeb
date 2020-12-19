package com.example.demo.modeloDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Boleta;

public interface IBoleta extends JpaRepository<Boleta, Integer> {

}
