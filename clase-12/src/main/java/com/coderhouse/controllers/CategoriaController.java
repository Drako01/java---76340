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
import com.coderhouse.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		try {
			List<Categoria> categorias = categoriaService.findAll();
			return ResponseEntity.ok(categorias);
		} catch (Exception err) {
			return ResponseEntity.internalServerError().build();
		}
	}

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

	@PostMapping("/create")
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
		try {
			Categoria categoriaNueva = categoriaService.save(categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaNueva); // 201

		} catch (Exception err) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

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
