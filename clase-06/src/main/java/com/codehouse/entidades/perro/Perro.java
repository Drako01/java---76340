package com.codehouse.entidades.perro;

import com.codehouse.entidades.AnimalDomestico;
import com.codehouse.interfaces.PerroInterface;

public class Perro extends AnimalDomestico implements PerroInterface{


	@Override
	public void comer() {
		System.out.println("Mi perro " + getNombre() + " esta comiendo.!");		
	}

	@Override
	public void moverse() {
		System.out.println("Mi perro " + getNombre() + " se esta moviendo.!");
		
	}

	@Override
	public void emitirSonido() {
		System.out.println("Mi perro " + getNombre() + " esta ladrando.!");
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void dormir() {
		System.out.println("Mi perro " + getNombre() + " esta durmiendo.!");
		
	}

	@Override
	public void olfatear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Perro [nombre=" + getNombre() + ", raza=" + getRaza() + ", "
				+ "edad=" + getEdad() + ", tamanio=" + getTamanio()
				+ ", genero=" + getGenero() + "]";
	}
}
