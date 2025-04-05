package com.coderhouse.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscripcioAlumnoDTO {

	private Long alumnoId;
	
	private List<Long> cursoIds;
}
