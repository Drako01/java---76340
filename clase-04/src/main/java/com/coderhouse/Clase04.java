package com.coderhouse;

import com.coderhouse.objetos.Perro;

public class Clase04 {

	public static void main(String[] args) throws Exception {

		//Perro primerPerro = new Perro();
		/*
		primerPerro.nombre = "Firulay";
		primerPerro.raza = "Caniche";
		primerPerro.color = "Beige";
		primerPerro.tamanio = "Mediano";
		primerPerro.edad = 4;
		primerPerro.peso = 4.5;
		
		
		
		System.out.println(primerPerro.nombre);
		System.out.println(primerPerro.raza);
		System.out.println(primerPerro.color);
		System.out.println(primerPerro.tamanio);
		System.out.println(primerPerro.edad);
		System.out.println(primerPerro.peso);
		*/
		
//		
//		primerPerro.ladrar();
//		primerPerro.caminar();
//		primerPerro.comer();
		
		Perro primerPerro = new Perro();
		primerPerro.setNombre("Firulay");
		primerPerro.setRaza("Caniche");
		primerPerro.setColor("Beige");
		primerPerro.setTamanio("Mediano");
		primerPerro.setEdad(2);
		primerPerro.setPeso(4.5);
		/*
		System.out.println("Mi Perro " + primerPerro.getNombre() + " es un " + primerPerro.getRaza() 
		+ " de color " + primerPerro.getColor() + ", es de Tamaño " + primerPerro.getTamanio()
		+ ", tiene " + primerPerro.getEdad() + " de Edad, y pesa " + primerPerro.getPeso() + " Kg.");
		*/
		Perro segundoPerro = new Perro();
		
		segundoPerro.setNombre("Daisy");
		segundoPerro.setRaza("Yorky");
		segundoPerro.setColor("Marron");
		segundoPerro.setTamanio("Chico");
		segundoPerro.setEdad(4);
		segundoPerro.setPeso(2.5);
		
		primerPerro.mostrarAtributos();
		segundoPerro.mostrarAtributos();
		
		
		System.out.println(primerPerro);
		System.out.println(segundoPerro);
		
		double radio = 7.5;
		
		System.out.println("El area de un Circulo de Radio " + radio + 
				"cm es de " + calcularElAreaDeUnCirculo(radio) + "cm.");
		
		String[] nombres = new String[] {
				"Gabriel",
				"Alejandro",
				"Sara",
				"Javier",
				"Tomas",
				"Marcelo"
		};
		
		imprimaLaListaDeNombre(nombres);
		
		
		
		Perro.ladrar();
		
		primerPerro.saltar();
		primerPerro.caminar();
		primerPerro.comer();
		segundoPerro.saltar();
		segundoPerro.caminar();
		segundoPerro.comer();
		
		System.out.println(nombre);
		
	}
	
	
	static final double PI;
	static final double PI_DOS;
		
	static {
		PI = 3.14152653889793;
		PI_DOS = 6.28;
	}
	
	
	static String nombre = "Alejandro 2";
	
	public static double calcularElAreaDeUnCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

	
	private static void imprimaLaListaDeNombre(String[] nombreDePersonas) {
		for(String nombre : nombreDePersonas) {
			System.out.println("Nombre: " + nombre);
		}
		
	}
	
	
	
}
