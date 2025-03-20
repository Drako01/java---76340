package com.codehouse;

import com.codehouse.ejercicios.Multiplicacion;
import com.codehouse.ejercicios.Resta;
import com.codehouse.ejercicios.Suma;
import com.codehouse.entidades.auto.Auto;
import com.codehouse.entidades.gato.Gato;
import com.codehouse.entidades.moto.Moto;
import com.codehouse.entidades.perro.Perro;
import com.codehouse.sobrecarga.Impresora;

public class Main {

	public static void main(String[] args) throws Exception {
		
//		Perro miPerro = new Perro();
//		
//		System.out.println(miPerro);
//		miPerro.setNombre("Firulay");
//		miPerro.comer();
//		miPerro.dormir();
//		miPerro.respirar();
//		miPerro.jugar();
//		
//		Gato miGato = new Gato();
//		System.out.println(miGato);
//		
//
//		Auto ferrari = new Auto();
//		
//		ferrari.setMarca("Ferrai");
//		ferrari.setColor("Rojo");
//		ferrari.setModelo("Testarosa");
//		ferrari.setRuedas(4);
//		
//		System.out.println(ferrari);
//		
//		ferrari.mostrarCantidadDeRuedas();
//		
//		
//		Moto miMoto = new Moto();
//		
//		miMoto.setMarca("Harley");
//		miMoto.setColor("Negro");
//		miMoto.setModelo("Iron 883");
//		miMoto.setRuedas(2);
//		miMoto.setVelocidadMaxima(280);
//		
//		System.out.println(miMoto);
//		miMoto.mostrarCantidadDeRuedas();
//		
//		Auto ferrari = new Auto(320);
//		ferrari.setMarca("Ferrari");
//		
//		Impresora impresora = new Impresora();
//		
//		impresora.imprimir(18);
//		
//		impresora.imprimir(108, 5);
//		
//		impresora.imprimir("Palabra");
//		
//		impresora.imprimir("Hola ", " Mundo");
//		
//		int[] enteros = {1, 2, 8, 15, 5656, 45, 54, 18, 99};
//		
//		impresora.imprimir(enteros);
		
		Suma suma = new Suma(10, 20);
		Resta resta = new Resta();
		Multiplicacion multiplicacion = new Multiplicacion(5,6);
		
		suma.enviarMensaje();
		suma.enviarResultado();
		
		resta.enviarMensaje();
		System.out.println("El resultado de la Resta es " + resta.operar(10, 20));
		
		multiplicacion.enviarMensaje();
		multiplicacion.enviarResultado();
	}

}
