package com.coderhouse;

import com.coderhouse.entities.Mascota;
import com.coderhouse.entities.gato.Gato;
import com.coderhouse.entities.perro.Perro;
import com.coderhouse.exceptions.EdadMascotaException;

public class Main {

	public static void main(String[] args) throws EdadMascotaException {

		Perro unPerro = new Perro();

		unPerro.setNombre("Firulay");
		unPerro.setEdad(4);
		unPerro.setColor("Blanco");
		unPerro.setRaza("Caniche");
		unPerro.setTamanio("Mediano");

//		unPerro.caminar();
//		unPerro.comer();
//		unPerro.dormir();
//		
//		System.out.println(unPerro);

		Gato unGato = new Gato();

		unGato.setNombre("Michi");
		unGato.setEdad(6);
		unGato.setColor("Negro");
		unGato.setRaza("Siames");
		unGato.setTamanio("Grande");

//		unGato.caminar();
//		unGato.comer();
//		unGato.dormir();

		// System.out.println(unGato);

		Mascota unaMascota = new Mascota();

		unaMascota.setNombre("Firulay 2");
		unaMascota.setEdad(4);
		unaMascota.setColor("Blanco");
		unaMascota.setRaza("Caniche");
		unaMascota.setTamanio("Mediano");

		// System.out.println(unaMascota);

//		Perro otroPerro = new Perro();
//		
//		otroPerro.setNombre("Firulay");
//		otroPerro.setEdad(4);
//		otroPerro.setColor("Blanco");
//		otroPerro.setRaza("Caniche");
//		otroPerro.setTamanio("Mediano");

//		Perro otroPerro = unPerro;

		/// Son iguales unPerro y otroPerro????

//		if(unPerro.equals(otroPerro)) {
//			System.out.println("El Hashcode es" + unPerro.hashCode());
//			System.out.println("El Hashcode es" + otroPerro.hashCode());
//			System.out.println("Ambos perros son iguales");
//		} else {
//			System.out.println("El Hashcode es" + unPerro.hashCode());
//			System.out.println("El Hashcode es" + otroPerro.hashCode());
//			System.out.println("Los perros son distintos");
//		}

//		Perro otroPerro = new Perro();
//
//		otroPerro.setNombre("Firulay");
//		otroPerro.setColor("Blanco");
//		otroPerro.setRaza("Caniche");
//		otroPerro.setTamanio("Mediano");
//		try {
//			otroPerro.setEdad(40);
//		} catch (Exception err) {
//			System.err.println("Error, " + err.getMessage());
//		} finally {
//			System.out.println("Finalizo la validacion de la Edad");
//		}

		Perro otroPerro = new Perro("Firulay", "Blanco", "Caniche", "Mediano", 4);

		System.out.println(otroPerro);

		Perro perrito = new Perro("Perrito", "Caniche");
		perrito.setColor("Blanco");
		perrito.setTamanio("Mediano");
		try {
			perrito.setEdad(4);
		} catch (Exception err) {
			System.err.println("Error, " + err.getMessage());
		} 

		System.out.println(perrito);
	}

}
