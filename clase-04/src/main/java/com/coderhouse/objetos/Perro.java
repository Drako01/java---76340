package com.coderhouse.objetos;

public class Perro {

	// Constante o Variable de Clase
	private static final int EDAD_MAXIMA = 16;
	
	String mensajeError = "El Perro no vive mas de " + EDAD_MAXIMA + " años de Edad";
	
	// Atributos del Objeto o Variables de Instancia
	
	private String nombre;	
	private String raza;
	private String color;
	private String tamanio;
	private int edad;
	private double peso;
	
	// Metodos
	public void saltar() {
		System.out.println("El perro " + nombre +" esta saltando");
	}
	
	public void caminar() {
		System.out.println("El perro " + nombre + "  esta caminando");
	}
	
	public void comer() {
		System.out.println("El perro " + nombre + " esta comiendo");
	}


	// Encapsulamiento
	// Getters y Setters
	
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception{
		if(edad <= 0 || edad > EDAD_MAXIMA) {
			throw new Exception(mensajeError);
		}else {			
			this.edad = edad;
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	public void mostrarAtributos() {
		System.out.println("Mi Perro " + nombre + " es un " + this.getRaza() 
		+ " de color " + this.getColor() + ", es de Tamaño " + this.getTamanio()
		+ ", tiene " + this.getEdad() + " de Edad, y pesa " + this.getPeso() + " Kg.");		
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", color=" + color + ", tamanio=" + tamanio + ", edad="
				+ edad + ", peso=" + this.getPeso() + "]";
	}
	
	//Metodo Estatico
	
	public static void ladrar() {
		System.out.println("Guau Guau");
	}
}
