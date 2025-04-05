package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Alumno;
import com.coderhouse.repositories.AlumnoRepository;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@GetMapping
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		try {
			List<Alumno> alumnos = alumnoRepository.findAll();
			return ResponseEntity.ok(alumnos); // 200
			
		}catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}

	}

	@GetMapping("/{alumnoId}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long alumnoId) {
		try {
			if (alumnoRepository.existsById(alumnoId)) {
				Alumno alumno = alumnoRepository.findById(alumnoId).get();
				return ResponseEntity.ok(alumno); // 200
			} else {
				return ResponseEntity.notFound().build(); // 404
			}
		} catch (Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
		try {
			Alumno alumnoCreado = alumnoRepository.save(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado); //201
			
		}catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

}
