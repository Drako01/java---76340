package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Curso;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner {

	@Autowired
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			Curso curso1 = new Curso("Java");
			Curso curso2 = new Curso("JavaScript");
			Curso curso3 = new Curso("React");
			Curso curso4 = new Curso("Angular");
			Curso curso5 = new Curso("SQL");

			Alumno alumno1 = new Alumno("Alejandro", "Di Stefano", 22333666, "L22333666", 49);
			Alumno alumno2 = new Alumno("Alejandro", "Di Stefano", 33555888, "L33555888", 49);
			Alumno alumno3 = new Alumno("Alejandro", "Di Stefano", 44222333, "L44222333", 49);
			Alumno alumno4 = new Alumno("Alejandro", "Di Stefano", 25666333, "L25666333", 49);
			Alumno alumno5 = new Alumno("Alejandro", "Di Stefano", 44666777, "L44666777", 49);

			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);
			dao.persistirCurso(curso5);

			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);
			dao.persistirAlumno(alumno5);

		} catch (Exception err) {
			err.getMessage();
		}

	}

}
