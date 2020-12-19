package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entidades.Boleta;
import com.example.demo.modeloDao.IBoleta;

@Service
public class BoletaServicio implements IServicio<Boleta, Integer> {
	@Autowired
	IBoleta bDAO;

	@Override
	@Transactional(readOnly = true)
	public Boleta findById(Integer id) {
		return bDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Boleta> findAll() {
		return bDAO.findAll();
	}

	@Override
	@Transactional()
	public void save(Boleta t) {
		bDAO.save(t);
	}

	@Override
	@Transactional()
	public void deleteById(Integer id) {
		bDAO.deleteById(id);
	}
}
