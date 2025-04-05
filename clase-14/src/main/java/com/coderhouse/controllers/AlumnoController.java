package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.AlumnoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("/api/alumnos")
@Tag(name = "Gestión de Alumnos", description = "Endpoints para gestionar Alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@Operation(summary = "Obtener la Lista de todos los Alumnos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de alumnos obtenida correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class)) }),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
	})
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		try {
			List<Alumno> alumnos = alumnoService.findAll();
			return ResponseEntity.ok(alumnos); // 200
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}

	}

	@Operation(summary = "Obtener un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno obtenido correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar obtener el Alumno", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
	})
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

	@Operation(summary = "Crear un Nuevo Alumno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Alumno creado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class)) }),
			@ApiResponse(responseCode = "400", description = "Error al intentar crear el Alumno", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })	
	@PostMapping("/create")
	public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
		try {
			Alumno alumnoCreado = alumnoService.save(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado); // 201

		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@Operation(summary = "Editar un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno editado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar editar el Alumno, no se encontro", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })	
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

	@Operation(summary = "Eliminar un Alumno por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Alumno eliminado Correctamente", content = {
					@Content() }),
			@ApiResponse(responseCode = "404", description = "Error al intentar eliminar el Alumno, El Alumno no existe", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
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

	
	@Operation(summary = "Inscribir a un Alumno a un Curso, usando DTO")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Alumno inscripto Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar inscribir el Alumno, o El Alumno no existe", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "409", description = "Error al intentar inscribir el Alumno, hay un Complicto con los datos", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
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
