package com.innovatec.demoPanamericanos.service;

import java.util.List;

import com.innovatec.demoPanamericanos.bean.Sede;

public interface SedeService {

	public List<Sede> seleccionarTodos();
	
	public void grabar(Sede sede);
	
	public Sede seleccionarPorId(long id);
	
}
