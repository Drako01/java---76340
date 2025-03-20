package com.codehouse.ejercicios;

import com.codehouse.interfaces.Operable;

public class Suma implements Operable {
	
	private double a;
	private double b;

	
	
	public Suma(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public void enviarMensaje() {
		System.out.println("Ingrese dos numeros para Sumar");
	}

	@Override
	public double operar(double a, double b) {
		return a + b;
	}

	@Override
	public void enviarResultado() {
		System.out.println("El resultado de la Suma es " + operar(this.a, this.b));
		
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	

}
