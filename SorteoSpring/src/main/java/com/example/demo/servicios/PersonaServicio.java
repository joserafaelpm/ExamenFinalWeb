package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Persona;
import com.example.demo.modeloDao.IPersona;

@Service
public class PersonaServicio implements IServicio<Persona, Integer> {
	@Autowired
	IPersona pDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Persona findById(Integer id) {
		return pDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return pDAO.findAll();
	}

	@Override
	@Transactional()
	public void save(Persona t) {
		pDAO.save(t);		
	}

	@Override
	@Transactional()
	public void deleteById(Integer id) {
		pDAO.deleteById(id);
	}

}
