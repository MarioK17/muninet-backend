package com.innovatec.demoPanamericanos.service;

import java.util.List;

import com.innovatec.demoPanamericanos.bean.Disciplina;

public interface DisciplinaService {

	public List<Disciplina> seleccionarTodos();

	public void grabar(Disciplina disciplina);

	public Disciplina buscarPorId(long id);
	
	public List<Disciplina> seleccionarPorCategoria();

}
