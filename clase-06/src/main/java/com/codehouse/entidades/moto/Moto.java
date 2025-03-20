package com.codehouse.entidades.moto;

import com.codehouse.abstractas.Vehiculo;

public class Moto extends Vehiculo {

	private double velocidadMaxima;
		
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) throws Exception {
		if(velocidadMaxima < 0) {
			throw new Exception("La velocidad no puede ser Negativa");
		}
		this.velocidadMaxima = velocidadMaxima;
	}

	@Override
	protected void encender() {
		System.out.println("Mi Moto enciende");
		
	}

	@Override
	protected void apagar() {
		System.out.println("Mi Moto se apaga");
		
	}

	@Override
	protected void mover() {
		System.out.println("Mi Moto se mueve");
		
	}

	@Override
	public String toString() {
		return "Moto [marca=" + marca + ", modelo=" + modelo + ", color=" + color 
				+ ", ruedas=" + ruedas + "]";
	}
	
	@Override
	public void mostrarCantidadDeRuedas() {
		System.out.println("Mi Moto " + getMarca() + " tiene " 
							+ getRuedas() + " Ruedas, y es de color " + getColor() 
							+ " y corre a " + getVelocidadMaxima() + " Km/hr.");		
	}
	
	
}
