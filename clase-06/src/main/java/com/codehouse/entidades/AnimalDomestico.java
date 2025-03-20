package com.codehouse.entidades;

import com.codehouse.interfaces.AccionesInterface;
import com.codehouse.interfaces.AnimalInterface;

public class AnimalDomestico implements AnimalInterface, AccionesInterface {

	private String nombre;
	
	private String raza;
	
	private int edad;
	
	private String tamanio;
	
	private String genero;
	
	public AnimalDomestico() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public AnimalDomestico(String nombre) {
		super();
		this.nombre = nombre;
	}


	public AnimalDomestico(String nombre, String raza, int edad, String tamanio) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.tamanio = tamanio;
	}


	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emitirSonido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dormir() {
		// TODO Auto-generated method stub
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getTamanio() {
		return tamanio;
	}


	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "AnimalDomestico [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", tamanio=" + tamanio
				+ ", genero=" + genero + "]";
	}


	@Override
	public void respirar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	
}
