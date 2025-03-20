package com.coderhouse.entities.gato;

import com.coderhouse.entities.Mascota;

public class Gato extends Mascota {

	// Decorador.
	@Override
	public void caminar() {
		System.out.println("Mi gato " + getNombre() + " esta caminando");
	}

	@Override
	public void comer() {
		System.out.println("Mi gato " + getNombre() + " esta comiendo comida para Gatos");
	}

	@Override
	public void dormir() {
		System.out.println("Mi gato " + getNombre() + " esta durmiendo");
	}
	
	@Override
	public String toString() {
		return "Gato [Nombre" + getNombre() + ", Color" + getColor() + ", Raza" + getRaza()
				+ ", Tamanio" + getTamanio() + ", Edad" + getEdad() + "]";
	}
}
