package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.InscripcioAlumnoDTO;
import com.coderhouse.models.Alumno;
import com.coderhouse.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		try {
			List<Alumno> alumnos = alumnoService.findAll();
			return ResponseEntity.ok(alumnos); // 200
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}

	}

	@GetMapping("/{alumnoId}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long alumnoId) {
		try {
			Alumno alumno = alumnoService.findById(alumnoId);
			return ResponseEntity.ok(alumno); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
		try {
			Alumno alumnoCreado = alumnoService.save(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado); // 201

		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@PutMapping("/{alumnoId}")
	public ResponseEntity<Alumno> updateAlumnoById(@PathVariable Long alumnoId, @RequestBody Alumno alumnoActualizado) {
		try {
			Alumno alumno = alumnoService.update(alumnoId, alumnoActualizado);
			return ResponseEntity.ok(alumno);
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	@DeleteMapping("/{alumnoId}")
	public ResponseEntity<Void> deleteAlumnoById(@PathVariable Long alumnoId) {
		try {
			alumnoService.deleteById(alumnoId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	@PostMapping("/inscribir")
	public ResponseEntity<?> inscribirAlumnoACursos(@RequestBody InscripcioAlumnoDTO dto) {
		try {
			Alumno alumno = alumnoService.inscribirAlumnoACursos(dto);
			return ResponseEntity.ok(alumno); // 200
		}catch (IllegalStateException err) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage()); // 409
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}

	}
}
