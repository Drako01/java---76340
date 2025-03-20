package com.codehouse.entidades.gato;

import com.codehouse.entidades.AnimalDomestico;
import com.codehouse.interfaces.CRUDInterface;

public class Gato extends AnimalDomestico implements CRUDInterface{

	@Override
	public String toString() {
		return "Gato [nombre=" + getNombre() + ", raza=" + getRaza() + ", "
				+ "edad=" + getEdad() + ", tamanio=" + getTamanio()
				+ ", genero=" + getGenero() + "]";
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readById() {
		// TODO Auto-generated method stub
		
	}
}
