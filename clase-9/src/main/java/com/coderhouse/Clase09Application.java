package com.coderhouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;

@SpringBootApplication
public class Clase09Application implements CommandLineRunner {

	@Autowired
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(Clase09Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			Categoria categoria1 = new Categoria("Programacion FrontEnd");
			Categoria categoria2 = new Categoria("Programacion BackEnd");
			Categoria categoria3 = new Categoria("Data Science");

			Curso curso1 = new Curso("Java"); // Programacion BackEnd
			Curso curso2 = new Curso("JavaScript"); // Programacion FrontEnd
			Curso curso3 = new Curso("React"); // Programacion FrontEnd
			Curso curso4 = new Curso("Angular"); // Programacion FrontEnd
			Curso curso5 = new Curso("SQL"); // Data Science
			Curso curso6 = new Curso("MongoDB"); // Data Science
			Curso curso7 = new Curso("NodeJS"); // Programacion BackEnd

			Alumno alumno1 = new Alumno("Alejandro", "Di Stefano", 22333666, "L22333666", 49);
			Alumno alumno2 = new Alumno("Luciano", "Montero", 33555888, "L33555888", 30);
			Alumno alumno3 = new Alumno("Guillermo ", "Correia", 44222333, "L44222333", 29);
			Alumno alumno4 = new Alumno("Juan", "Trillini", 25666333, "L25666333", 28);
			Alumno alumno5 = new Alumno("Tomas", "Perez", 44666777, "L44666777", 32);

			dao.persistirCategoria(categoria1);
			dao.persistirCategoria(categoria2);
			dao.persistirCategoria(categoria3);

			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);
			dao.persistirCurso(curso5);
			dao.persistirCurso(curso6);
			dao.persistirCurso(curso7);

			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);
			dao.persistirAlumno(alumno5);

			dao.asignarCategoriaACurso(curso1.getId(), categoria2.getId());
			dao.asignarCategoriaACurso(curso2.getId(), categoria1.getId());
			dao.asignarCategoriaACurso(curso3.getId(), categoria1.getId());
			dao.asignarCategoriaACurso(curso4.getId(), categoria1.getId());
			dao.asignarCategoriaACurso(curso5.getId(), categoria3.getId());
			dao.asignarCategoriaACurso(curso6.getId(), categoria3.getId());
			dao.asignarCategoriaACurso(curso7.getId(), categoria2.getId());

			List<Long> cursosIdParaAlumno1 = new ArrayList<>();
			if (curso1 != null)
				cursosIdParaAlumno1.add(curso1.getId());
			if (curso2 != null)
				cursosIdParaAlumno1.add(curso2.getId());
			if (curso3 != null)
				cursosIdParaAlumno1.add(curso3.getId());

			List<Long> cursosIdParaAlumno2 = new ArrayList<>();
			if (curso1 != null)
				cursosIdParaAlumno1.add(curso1.getId());
			if (curso2 != null)
				cursosIdParaAlumno1.add(curso2.getId());
			if (curso3 != null)
				cursosIdParaAlumno1.add(curso3.getId());
			if (curso3 != null)
				cursosIdParaAlumno1.add(curso4.getId());
			if (curso3 != null)
				cursosIdParaAlumno1.add(curso5.getId());

			dao.inscribirAUnAlumnoEnUnCursoOEnVariosCursos(alumno1.getId(), cursosIdParaAlumno1);
			dao.inscribirAUnAlumnoEnUnCursoOEnVariosCursos(alumno2.getId(), cursosIdParaAlumno2);
			dao.inscribirAUnAlumnoEnUnCursoOEnVariosCursos(alumno3.getId(), cursosIdParaAlumno1);
			dao.inscribirAUnAlumnoEnUnCursoOEnVariosCursos(alumno4.getId(), cursosIdParaAlumno2);
			dao.inscribirAUnAlumnoEnUnCursoOEnVariosCursos(alumno5.getId(), cursosIdParaAlumno2);
		
		} catch (Exception err) {
			err.getMessage();
		}

	}

}
