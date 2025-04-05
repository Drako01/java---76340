package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dto.InscripcioAlumnoDTO;
import com.coderhouse.interfaces.CrudInterface;
import com.coderhouse.models.Alumno;
import com.coderhouse.models.Curso;
import com.coderhouse.repositories.AlumnoRepository;
import com.coderhouse.repositories.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoService implements CrudInterface<Alumno, Long> {

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno findById(Long id) {
		return alumnoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
	}

	@Override
	@Transactional
	public Alumno save(Alumno nuevoAlumno) {
		return alumnoRepository.save(nuevoAlumno);
	}

	@Override
	@Transactional
	public Alumno update(Long id, Alumno alumnoActualizado) {
		Alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
		
		if (alumnoActualizado.getNombre() != null && !alumnoActualizado.getNombre().isEmpty()) {
			alumno.setNombre(alumnoActualizado.getNombre());
		}
		
		if (alumnoActualizado.getApellido() != null && !alumnoActualizado.getApellido().isEmpty()) {
			alumno.setApellido(alumnoActualizado.getApellido());
		}

		if (alumnoActualizado.getDni() != 0) {
			alumno.setDni(alumnoActualizado.getDni());
		}

		if (alumnoActualizado.getEdad() != 0) {
			alumno.setEdad(alumnoActualizado.getEdad());
		}
		
		if (alumnoActualizado.getLegajo() != null && !alumnoActualizado.getLegajo().isEmpty()) {
			alumno.setLegajo(alumnoActualizado.getLegajo());
		}

		return alumnoRepository.save(alumno);
	}

	@Override
	public void deleteById(Long id) {
		if(!alumnoRepository.existsById(id)) {
			throw new IllegalArgumentException("Alumno no encontrado");
		}
		alumnoRepository.deleteById(id);
	}

	@Transactional
	public Alumno inscribirAlumnoACursos(InscripcioAlumnoDTO dto) {
		
		Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
		
		for (Long cursoId : dto.getCursoIds()) {
			
			Curso curso = cursoRepository.findById(cursoId)
					.orElseThrow(() -> new IllegalArgumentException("Curso no encontrado.!"));
			
			// Verificar si el Alumno esta Inscripto a ese Curso
			if(alumno.getCursos().contains(curso)) {
				throw new IllegalStateException("El alumno ya esta inscripto en el curso con ID: " + cursoId);
			}
			
			alumno.getCursos().add(curso);
			curso.getAlumnos().add(alumno);
			
			cursoRepository.save(curso);
			
		}
			
		return alumnoRepository.save(alumno);
	}
}
