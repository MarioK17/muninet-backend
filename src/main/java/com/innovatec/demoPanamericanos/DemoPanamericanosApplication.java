package com.innovatec.demoPanamericanos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.innovatec.demoPanamericanos.bean.Categoria;
import com.innovatec.demoPanamericanos.bean.Disciplina;
import com.innovatec.demoPanamericanos.bean.Sede;
import com.innovatec.demoPanamericanos.repositorio.CategoriaRepository;
import com.innovatec.demoPanamericanos.repositorio.DisciplinaRepository;
import com.innovatec.demoPanamericanos.repositorio.SedeRepository;



@SpringBootApplication
public class DemoPanamericanosApplication implements CommandLineRunner {

	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private SedeRepository sedeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoPanamericanosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Disciplina d1 = new Disciplina();
		d1.setNombre("Carreras de Velocidad");
		d1.setDescripcion("Descripcion de Carrera de Velocidad");
		
		Disciplina d2 = new Disciplina();
		d2.setNombre("Fondo");
		d2.setDescripcion("Descripcion de Fondo");
		
		Set<Disciplina> ds = new HashSet<>();
		ds.add(d1);
		ds.add(d2);
		
		
		Categoria c1 = new Categoria();
		c1.setNombre("Atletismo");
		c1.setDescripcion("Descripcion de Atletismo");
		c1.setDisciplinas(ds);
		d1.setCategoria(c1);
		d2.setCategoria(c1);
		
		System.out.println("---------Grabando Categorias y Disciplinas---------");
		categoriaRepository.save(c1);
		disciplinaRepository.save(d1);
		disciplinaRepository.save(d2);
		
		
		Sede s1 = new Sede();
		s1.setNombre("Estadio Nacional del Perú");
		s1.setDescripcion("El Estadio Nacional del Perú será el principal recinto de Lima 2019, pues recibirá las ceremonias de inauguracion y clausura de los juegos asi como el encendido del pebetero panamericano.");
		s1.setLatitud(-13.14);
		s1.setLongitud(12.4);

		Sede s2 = new Sede();
		s2.setNombre("Centro Deportivo Panamericano (CEDEPA)");
		s2.setDescripcion("La Villa Deportiva Nacional, más conocida como VIDENA (por las iniciales de cada palabra) es el principal centro deportivo de la ciudad de Lima. Será escenario principal durante los Juegos Panamericanos y Parapanamericanos de 2019.");
		s2.setLatitud(-11.14);
		s2.setLongitud(11.4);
		
		Sede s3 = new Sede();
		s3.setNombre("Parque Panamericano de Villa María del Triunfo");
		s3.setDescripcion("En 20 hectáreas de terreno pertenecientes al Instituto Peruano del Deportese mejorará el Parque Panamericano de Villa María del Triunfocomo parte del Plan Maestro de Lima 2019.");
		s3.setLatitud(-14.14);
		s3.setLongitud(15.4);
		
		Sede s4 = new Sede();
		s4.setNombre("Villa Deportiva del Callao");
		s4.setDescripcion("La Villa Deportiva del Callao(ex parque zonal Yahuar Huaca) es un centro deportivo ubicado en el distritode Bellavistaen la avenida Guardia Chalaca, en la Provincia Constitucional del Callao.");
		s4.setLatitud(-11.09);
		s4.setLongitud(11.4);
		
		sedeRepository.save(s1);
		sedeRepository.save(s2);
		sedeRepository.save(s3);
		sedeRepository.save(s4);
		
		
	}
}
