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

import com.coderhouse.models.Categoria;
import com.coderhouse.responses.ErrorResponse;
import com.coderhouse.services.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Gestion de Categorias", description = "Endpoints para gestionar a las Categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Operation(summary = "Obtener Lista de Categorias")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Categorias obtenida Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Categoria.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener a las Categorias", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) 
			})
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		try {
			List<Categoria> categorias = categoriaService.findAll();
			return ResponseEntity.ok(categorias);
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Operation(summary = "Obtener una Categoria por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Categoria obtenida Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Categoria.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener la Categoria", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) 
			})
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long categoriaId) {
		try {
			Categoria categoria = categoriaService.findById(categoriaId);
			return ResponseEntity.ok(categoria); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@Operation(summary = "Crear una Categoria nueva")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Categoria creada Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Categoria.class)) }),
			@ApiResponse(responseCode = "400", description = "Error al intentar crear la Categoria", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) 
			})
	@PostMapping("/create")
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		try {
			Categoria categoriaNueva = categoriaService.save(categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaNueva); // 201

		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@Operation(summary = "Editar una Categoria por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Categoria editada Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Categoria.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar editar la Categoria, o la Categoria no Existe", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) 
			})
	@PutMapping("/{categoriaId}")
	public ResponseEntity<Categoria> updateCategoriaById(@PathVariable Long categoriaId,
			@RequestBody Categoria categoriaActualizada) {
		try {
			Categoria updatedCategoria = categoriaService.update(categoriaId, categoriaActualizada);
			return ResponseEntity.ok(updatedCategoria); // 200
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@Operation(summary = "Eliminar una Categoria por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Categoria eliminada Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Categoria.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar editar la Categoria, o la Categoria no Existe", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) 
			})
	@DeleteMapping("/{categoriaId}")
	public ResponseEntity<Void> deleteCategoriaById(@PathVariable Long categoriaId) {
		try {
			categoriaService.deleteById(categoriaId);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

}
