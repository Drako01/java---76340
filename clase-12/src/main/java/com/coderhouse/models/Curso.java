package com.coderhouse.models;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.JoinColumn;


@Data
@Entity
@Table(name = "Cursos")
public class Curso {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental.
	private Long id;

	@Column(name = "Nombre", nullable = false, unique = true)
	private String nombre;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "curso_alumno", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	@JsonIgnore
	private List<Alumno> alumnos = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;

}
