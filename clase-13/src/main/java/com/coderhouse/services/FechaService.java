package com.coderhouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.dto.TimeResponseDTO;

@Service
public class FechaService {

	@Autowired
	private RestTemplate rt;
	
	
	public TimeResponseDTO obtenerFechaYHoraActuales() {
		try {
			
			final String URL = "https://timeapi.io/api/Time/current/zone?timeZone=America/Argentina/Buenos_Aires";
			
			return rt.getForObject(URL, TimeResponseDTO.class);
			
		}catch(Exception e) {
			System.err.println("Error, No se pudo conectar a la API" + e.getMessage());
			return null;
		}
	}
	
	
}
