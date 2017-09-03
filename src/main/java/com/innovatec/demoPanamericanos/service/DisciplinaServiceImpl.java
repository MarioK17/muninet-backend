package com.innovatec.demoPanamericanos.service;

import java.util.List;
import com.innovatec.demoPanamericanos.bean.Disciplina;
import com.innovatec.demoPanamericanos.repositorio.DisciplinaRepository;


public class DisciplinaServiceImpl implements DisciplinaService {

	

	private DisciplinaRepository disciplinaRepository;
	

	@Override
	public List<Disciplina> seleccionarTodos() {
		return disciplinaRepository.findAll();
	}

	@Override
	public void grabar(Disciplina disciplina) {
		
		disciplinaRepository.save(disciplina);

	}

	@Override
	public Disciplina buscarPorId(long id) {
		// TODO Auto-generated method stub
		return disciplinaRepository.findOne(id);
	}
	
	@Override
	public List<Disciplina> seleccionarPorCategoria() {
		
		return null;
	}

}
