package com.codehouse.entidades.auto;

import com.codehouse.abstractas.Vehiculo;

public class Auto extends Vehiculo {

	
	public Auto(int velocidad) {
		System.out.println("Mi Auto " + marca + " corre a " + velocidad + " Km/hr.");
	}
	
	@Override
	protected void encender() {
		System.out.println("Mi Auto enciende");

	}

	@Override
	protected void apagar() {
		System.out.println("Mi Auto se apaga");

	}

	@Override
	protected void mover() {
		System.out.println("Mi Auto se mueve");

	}
	
	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", ruedas=" + ruedas + "]";
	}

	@Override
	public void mostrarCantidadDeRuedas() {
		System.out.println("Mi Auto " + getMarca() + " tiene " 
							+ getRuedas() + " Ruedas, y es de color " + getColor());		
	}

}
