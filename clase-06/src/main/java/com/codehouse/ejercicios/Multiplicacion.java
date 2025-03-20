package com.codehouse.ejercicios;

import com.codehouse.interfaces.Operable;

public class Multiplicacion extends Operaciones implements Operable {

	public Multiplicacion(double a, double b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double operar(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

}
