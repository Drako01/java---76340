package com.coderhouse.entities;

import java.util.Objects;

import com.coderhouse.exceptions.EdadMascotaException;

public class Mascota {

	private static final int EDAD_MAXIMA = 15;
	
	
	private String nombre;
	private String color;
	private String raza;
	private String tamanio;
	private int edad;
	
		
	public Mascota() {
		super();		
	}
	
	public Mascota(String nombre, String raza) {
		super();
		this.nombre = nombre;
		this.raza = raza;
	}


	public Mascota(String nombre, String color, String raza, String tamanio, int edad) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.raza = raza;
		this.tamanio = tamanio;
		this.edad = edad;
	}



	String mensajeError = "Una Mascota No puede tener mas de " + EDAD_MAXIMA + " de Edad.";
	
	public void caminar() {
		System.out.println(getNombre() + " esta caminando");
	}

	public void comer() {
		System.out.println(getNombre() + " esta comiendo");
	}
	
	public void dormir() {
		System.out.println(getNombre() + " esta durmiendo");
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getTamanio() {
		return tamanio;
	}


	public void setTamanio(String tammanio) {
		this.tamanio = tammanio;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) throws EdadMascotaException {
		if(edad > EDAD_MAXIMA) {
			throw new EdadMascotaException(mensajeError);
		} 
		this.edad = edad;
	}

	
	// Sobreescritura de Metodos => Polimorfismo
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", color=" + color + ", raza=" + raza
				+ ", tamanio=" + tamanio + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, edad, mensajeError, nombre, raza, tamanio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(color, other.color) && edad == other.edad
				&& Objects.equals(mensajeError, other.mensajeError) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(raza, other.raza) && Objects.equals(tamanio, other.tamanio);
	}
	
	
	
	
}
