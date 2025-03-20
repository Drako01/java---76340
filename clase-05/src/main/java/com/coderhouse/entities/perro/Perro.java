package com.coderhouse.entities.perro;

import com.coderhouse.entities.Mascota;

public class Perro extends Mascota {

	public Perro() {
		// TODO Auto-generated constructor stub
	}
	
	public Perro(String nombre, String raza) {
		super(nombre, raza);		
	}
	
	public Perro(String nombre, String color, String raza, String tamanio, int edad) {
		super(nombre, color, raza, tamanio, edad);
	}
	

	@Override
	public void caminar() {
		System.out.println("Mi perro " + getNombre() + " esta caminando");
	}

	@Override
	public void comer() {
		System.out.println("Mi perro " + getNombre() + " esta comiendo comida para Perros");
	}

	@Override
	public void dormir() {
		System.out.println("Mi perro " + getNombre() + " esta durmiendo");
	}

	@Override
	public String toString() {
		return "Perro [Nombre = " + getNombre() + ", Color = " + getColor() + ", Raza = " 
				+ getRaza() + ", Tamanio = "
				+ getTamanio() + ", Edad = " + getEdad() + "]";
	}

	
	
	
	

}
