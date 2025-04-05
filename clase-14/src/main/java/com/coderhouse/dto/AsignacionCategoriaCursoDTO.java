package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO de Asignación de Categoria a Cursos")
public class AsignacionCategoriaCursoDTO {
	@Schema(description = "ID del Curso",  example = "1")
	private Long cursoId;
	@Schema(description = "ID de la Categoria",  example = "2")
	private Long categoriaId;
	
}
