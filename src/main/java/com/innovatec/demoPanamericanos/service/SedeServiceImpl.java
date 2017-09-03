package com.innovatec.demoPanamericanos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.innovatec.demoPanamericanos.bean.Sede;
import com.innovatec.demoPanamericanos.repositorio.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService {

	private SedeRepository sedeRepository;
	
	public SedeServiceImpl(SedeRepository sedeRepository) {
		this.sedeRepository = sedeRepository;
	}
	
	@Override
	public List<Sede> seleccionarTodos() {
		return sedeRepository.findAll();
	}
	
	@Override
	public void grabar(Sede sede) {
		sedeRepository.save(sede);		
	}
	
	@Override
	public Sede seleccionarPorId(long id) {
		
		return sedeRepository.findOne(id);
	}

	
	
}
