package com.codehouse.ejercicios;

import com.codehouse.interfaces.Operable;

public class Resta implements Operable {

	@Override
	public void enviarMensaje() {
		System.out.println("Ingrese dos numeros para Restar");
	}

	@Override
	public double operar(double a, double b) {
		return a - b;
	}

	@Override
	public void enviarResultado() {
		// TODO Auto-generated method stub
		
	}

}
