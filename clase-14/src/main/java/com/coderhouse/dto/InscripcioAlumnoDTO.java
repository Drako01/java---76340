package com.coderhouse.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de Inscripcion de un Alumno a uno o varios Cursos")
public class InscripcioAlumnoDTO {

	@Schema(description = "ID del Alumno",  example = "1")
	private Long alumnoId;
	
	@Schema(description = "IDs de los Cursos",  example = "[1, 2, 3, 4]")
	private List<Long> cursoIds;
}
