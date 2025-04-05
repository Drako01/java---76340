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

import com.coderhouse.dto.AsignacionCategoriaCursoDTO;
import com.coderhouse.models.Curso;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping(path = {"/", ""})
	public ResponseEntity<List<Curso>> getAllCursos() {
		try {
			List<Curso> cursos = cursoService.findAll();
			return ResponseEntity.ok(cursos); // 200
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@GetMapping(path = "/{cursoId}")
	public ResponseEntity<?> getCursoById(@PathVariable Long cursoId) {
		if(cursoId == null) {
			return ResponseEntity.badRequest().body("El ID del Curso no puede ser Null");
		}
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

	@PutMapping(path = "/{cursoId}")
	public ResponseEntity<?> updateCursoById(@PathVariable Long cursoId, @RequestBody Curso cursoActualizado) {
		if(cursoId == null) {
			return ResponseEntity.badRequest().body("El ID del Curso no puede ser Null");
		}
		try {
			Curso updatedCurso = cursoService.update(cursoId, cursoActualizado);
			return ResponseEntity.ok(updatedCurso); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@DeleteMapping(path = "/{cursoId}")
	public ResponseEntity<?> deleteCursoById(@PathVariable Long cursoId) {
		if(cursoId == null) {
			return ResponseEntity.badRequest().body("El ID del Curso no puede ser Null");
		}
		try {
			cursoService.deleteById(cursoId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@PostMapping(path = "/asignar-categoria")
	public ResponseEntity<?> asignarCategoriaACurso(@RequestBody AsignacionCategoriaCursoDTO dto) {
		if(dto.getCursoId() == null || dto.getCategoriaId() == null) {
			return ResponseEntity.badRequest().body("El Parametro ID  no puede ser Null");
		}
		try {

			Curso cursoActualizado = cursoService.asignarCategoriaACurso(
					dto.getCursoId(), 
					dto.getCategoriaId()
					);
			return ResponseEntity.ok(cursoActualizado);
		}catch (IllegalStateException err) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage()); // 409
		} catch (IllegalArgumentException err) {
			ErrorResponse error = new ErrorResponse("Recurso no encontrado", "Detalle");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

}
