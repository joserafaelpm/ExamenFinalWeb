package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entidades.Sorteo;
import com.example.demo.modeloDao.ISorteo;

@Service
public class SorteoServicio implements IServicio<Sorteo, Integer> {
	
	@Autowired
	ISorteo sDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Sorteo findById(Integer id) {
		return sDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sorteo> findAll() {
		return sDAO.findAll();
	}

	@Override
	@Transactional()
	public void save(Sorteo t) {
		sDAO.save(t);		
	}

	@Override
	@Transactional()
	public void deleteById(Integer id) {
		sDAO.deleteById(id);
	}
}
