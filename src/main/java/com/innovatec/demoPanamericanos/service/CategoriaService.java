package com.innovatec.demoPanamericanos.service;

import java.util.List;

import com.innovatec.demoPanamericanos.bean.Categoria;

public interface CategoriaService {

	public List<Categoria> seleccionarTodos();
	
	public void grabar(Categoria categoria);
	
	public Categoria buscarPorId(long id);
	
}
