package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Schema(description = "Modelo de Alumno")
@Table(name = "Alumnos")
public class Alumno {

	@Schema(description = "ID del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental.
	private Long id;

	@Schema(description = "Nombre del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alejandro")
	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Schema(description = "Apellido del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "Di Stefano")
	@Column(name = "Apellido", nullable = false)
	private String apellido;

	@Schema(description = "DNI del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "22333444")
	@Column(name = "DNI", nullable = false, unique = true)
	private int dni;

	@Schema(description = "Legajo del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "L22333444")
	@Column(name = "Legajo", nullable = false, unique = true)
	private String legajo;

	
	@Schema(description = "Edad del Alumno", example = "49")
	@Column(name = "Edad")
	private int edad;

	@Schema(description = "Lista de Cursos en los que el Alumno esta Inscripto")
	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
	private List<Curso> cursos = new ArrayList<>();

	@Schema(description = "Fecha de Alta del Alumno", example = "2025/05/06")
	private LocalDateTime createdAt;	

}
