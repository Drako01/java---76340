package com.coderhouse.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Alumno;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persistirAlumno(Alumno alumno) {
		em.persist(alumno);
	}

	@Transactional
	public void persistirCurso(Curso curso) {
		em.persist(curso);
	}

	@Transactional
	public void persistirCategoria(Categoria categoria) {
		em.persist(categoria);
	}

	@Transactional
	public Curso getCursoById(Long cursoId) throws Exception {
		try {
			TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c WHERE c.id = :id", Curso.class);
			return query.setParameter("id", cursoId).getSingleResult();
		} catch (Exception e) {
			throw new Exception("El curso no Existe.!");
		}
	}

	@Transactional
	public Categoria getCategoriaById(Long categoriaId) throws Exception {
		try {
			TypedQuery<Categoria> query = em.createQuery("SELECT ca FROM Categoria ca WHERE ca.id = :id",
					Categoria.class);
			return query.setParameter("id", categoriaId).getSingleResult();
		} catch (Exception e) {
			throw new Exception("El curso no Existe.!");
		}
	}

	@Transactional
	public Alumno getAlumnoById(Long alumnoId) throws Exception {
		try {
			TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.id = :id", Alumno.class);
			return query.setParameter("id", alumnoId).getSingleResult();
		} catch (Exception e) {
			throw new Exception("El Alumno no Existe.!");
		}
	}

	@Transactional
	public void asignarCategoriaACurso(Long cursoId, Long categoriaId) throws Exception {

		Curso curso = getCursoById(cursoId);
		if (curso == null) {
			throw new Exception("El Curso con ID: " + cursoId + " no Existe.!");
		}

		Categoria categoria = getCategoriaById(categoriaId);
		if (categoria == null) {
			throw new Exception("La Categoria con ID " + categoriaId + " no Existe.!");
		}

		curso.setCategoria(categoria);

		// Persistir datos
		em.merge(curso);

	}

	@Transactional
	public void inscribirAUnAlumnoEnUnCursoOEnVariosCursos(
				Long alumnoId, List<Long> cursoIds) throws Exception {

		Alumno alumno = getAlumnoById(alumnoId);
		if (alumno == null) {
			throw new Exception("El Alumno con ID: " + alumnoId + " no Existe.!!");
		}

		for (Long cursoId : cursoIds) {
			Curso curso = getCursoById(cursoId);
			if (curso == null) {
				throw new Exception("El Curso con ID: " + cursoId + " no Existe.!!");
			}

			// Asociar al alumno con el curso
			if (!curso.getAlumnos().contains(alumno)) {
				curso.getAlumnos().add(alumno);
			}

			// Opcional: Asociar curso al alumno - Para mantener bidireccionalidad
			// sincronizada
			if (!alumno.getCursos().contains(curso)) {
				alumno.getCursos().add(curso);
			}

			em.merge(curso);
			
		}

		em.merge(alumno);
		em.flush();

	}

}
