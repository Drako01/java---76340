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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cursos")
@Tag(name = "Gestion de Cursos", description = "Endpoints para gestionar Cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@Operation(summary = "Obtener Lista de Cursos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Cursos obtenida Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener a los Cursos", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping(path = {"/", ""})
	public ResponseEntity<List<Curso>> getAllCursos() {
		try {
			List<Curso> cursos = cursoService.findAll();
			return ResponseEntity.ok(cursos); // 200
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@Operation(summary = "Obtener un Curso por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curso obtenido Correctamente", content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Curso", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
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

	@Operation(summary = "Creacion de un Curso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Curso creado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar obtener el Curso", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping
	public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
		try {
			Curso cursoNuevo = cursoService.save(curso);
			return ResponseEntity.status(HttpStatus.CREATED).body(cursoNuevo);
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@Operation(summary = "Edicion o Modificacion de un Curso por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curso editado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Curso", 
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
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

	@Operation(summary = "Eliminacion de un Curso por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Curso eliminado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Curso", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
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

	@Operation(summary = "Asignación de Categoria a un Curso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Categoria asignada correctamente", content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar obtener el Curso o Categoria", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
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
