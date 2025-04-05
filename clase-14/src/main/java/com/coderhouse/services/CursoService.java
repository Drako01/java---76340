package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;
import com.coderhouse.repositories.CategoriaRepository;
import com.coderhouse.repositories.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoService implements CrudInterface<Curso, Long> {

	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso findById(Long id) {
		return cursoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Curso no encontrado.!"));
	}

	@Override
	@Transactional
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	@Transactional
	public Curso update(Long id, Curso cursoActualizado) {
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Curso no encontrado.!"));
		if(cursoActualizado.getNombre() != null && !cursoActualizado.getNombre().isEmpty()) {
			curso.setNombre(cursoActualizado.getNombre());
		}		
		return cursoRepository.save(curso);
	}

	@Override
	public void deleteById(Long id) {
		if(!cursoRepository.existsById(id)) {
			throw new IllegalArgumentException("Curso no encontrado.!");
		}
		cursoRepository.deleteById(id);		
	}

	@Transactional
	public Curso asignarCategoriaACurso(Long cursoId, Long categoriaId) {
		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new IllegalArgumentException("Categoria inexistente"));
		Curso curso = cursoRepository.findById(cursoId)
				.orElseThrow(() -> new IllegalArgumentException("Curso no encontrado.!"));
		
		//Validar que el Curso ya no tenga esta Categoria
		if(curso.getCategoria() != null && curso.getCategoria().getId().equals(categoriaId)) {
			throw new IllegalStateException("El curso ya tiene esta categoria asignada");
		}
		
		curso.setCategoria(categoria);
		
		return cursoRepository.save(curso);
	}
}
