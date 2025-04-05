package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	Alumno findByNombre(String nombre);

	Alumno findByApellido(String apellido);

	Alumno findByNombreAndApellido(String nombre, String apellido);
}

//SELECT * FROM alumnos WHERE nombre = ?;

//SELECT * FROM alumnos WHERE apellido = ?;

//SELECT * FROM alumnos WHERE nombre = ? AND apellido = ?;