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

import com.coderhouse.models.Curso;
import com.coderhouse.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> getAllCursos() {
		try {
			List<Curso> cursos = cursoService.findAll();
			return ResponseEntity.ok(cursos); // 200
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> getCursoById(@PathVariable Long cursoId) {
		try {
			Curso curso = cursoService.findById(cursoId);
			return ResponseEntity.ok(curso); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@PostMapping
	public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
		try {
			Curso cursoNuevo = cursoService.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoNuevo);
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@PutMapping("/{cursoId}")
	public ResponseEntity<Curso> updateCursoById(@PathVariable Long cursoId, @RequestBody Curso cursoActualizado) {
		try {
			Curso updatedCurso = cursoService.update(cursoId, cursoActualizado);
			return ResponseEntity.ok(updatedCurso); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@DeleteMapping("/{cursoId}")
	public ResponseEntity<Void> deleteCursoById(@PathVariable Long cursoId) {
		try {
			cursoService.deleteById(cursoId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}
}
