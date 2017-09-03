package com.innovatec.demoPanamericanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovatec.demoPanamericanos.bean.Categoria;
import com.innovatec.demoPanamericanos.repositorio.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService {

	

	private CategoriaRepository categoriaRepository;
	

	@Autowired
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {

		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public List<Categoria> seleccionarTodos() {

		return categoriaRepository.findAll();
	}

	@Override
	public void grabar(Categoria categoria) {

		categoriaRepository.save(categoria);

	}

	public Categoria buscarPorId(long id) {

		return categoriaRepository.findOne(id);
	}

}
