package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entidades.Numero;
import com.example.demo.modeloDao.INumero;


@Service
public class NumeroServicio implements IServicio<Numero, Integer>  {

	@Autowired
	INumero nDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Numero findById(Integer id) {
		return nDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Numero> findAll() {
		return nDAO.findAll();
	}

	@Override
	@Transactional()
	public void save(Numero t) {
		nDAO.save(t);		
	}

	@Override
	@Transactional()
	public void deleteById(Integer id) {
		nDAO.deleteById(id);
	}
}
