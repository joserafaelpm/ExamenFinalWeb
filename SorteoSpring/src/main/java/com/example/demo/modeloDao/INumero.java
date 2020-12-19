package com.example.demo.modeloDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Numero;

public interface INumero extends JpaRepository<Numero, Integer> {

}
