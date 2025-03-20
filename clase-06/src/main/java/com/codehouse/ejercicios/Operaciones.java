package com.codehouse.ejercicios;

import com.codehouse.interfaces.Operable;

public class Operaciones implements Operable {

	private double a;
	private double b;
	
	
	public Operaciones(double a, double b) {
		super();
		this.a = a;
		this.b = b;
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

	@Override
	public void enviarMensaje() {
		System.out.println("Ingrese dos numeros para Operar");
	}

	@Override
	public double operar(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enviarResultado() {
		System.out.println("El resultado de la Operacion es " + operar(this.a, this.b));

	}

}
