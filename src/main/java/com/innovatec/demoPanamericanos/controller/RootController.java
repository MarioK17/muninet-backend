package com.innovatec.demoPanamericanos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.innovatec.demoPanamericanos.bean.Categoria;
import com.innovatec.demoPanamericanos.bean.Sede;
import com.innovatec.demoPanamericanos.service.CategoriaService;
import com.innovatec.demoPanamericanos.service.SedeService;

@RestController
public class RootController {

	
	public CategoriaService categoriaService;
	public SedeService sedeService;
	
	@Autowired
	public RootController(CategoriaService categoriaService, SedeService sedeService) {
		
		this.categoriaService = categoriaService;
		this.sedeService = sedeService;
	}

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String index() {
		return "Hola mundo";
	}

	@RequestMapping(value = "/listarCategorias", method = RequestMethod.GET)
	public List<Categoria> seleccionarCategorias() {
		return categoriaService.seleccionarTodos();		
	}
	
	@RequestMapping(value = "/grabarCategoria", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> grabarCategoria(@RequestBody Categoria categoria, UriComponentsBuilder ucBuilder) {

//		if (categoriaService.buscarPorId((long) categoria.getId()) != null) {
//			System.out.println("El usuario existe " + categoria.getNombre());
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
		System.out.println(categoria.getId() +" " +categoria.getNombre() + " " + categoria.getDescripcion());
		categoriaService.grabar(categoria);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/seleccionarSede", method=RequestMethod.GET)
	public List<Sede> seleccionarSedes() {
		
		return sedeService.seleccionarTodos();	
	}
	
	@RequestMapping(value="/seleccionarSede/{sedeId}", method=RequestMethod.GET)
	public Sede seleccionarSede(@PathVariable long sedeId) {
		
		Sede sede = sedeService.seleccionarPorId(sedeId);
		
		return sede;
	}
	
}
