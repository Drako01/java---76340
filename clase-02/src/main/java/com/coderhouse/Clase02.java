package com.coderhouse;

import java.util.Scanner;

public class Clase02 {

	public static void main(String[] args) {
		/*
		 * int numeroA = 2; int numeroB = 2;
		 * 
		 * if(numeroA > numeroB) { // Retornar un true o un false
		 * System.out.println("El númeroA " + numeroA + " es Mayor que numeroB " +
		 * numeroB); } else if(numeroA < numeroB){ System.out.println("El numeroB " +
		 * numeroB + " es Mayor que numeroA " + numeroA); } else {
		 * System.out.println("El numeroB " + numeroB + " es Igual que numeroA " +
		 * numeroA); }
		 */

		// Calculadora
		/*
		 * float numeroA = 10; float numeroB = 0;
		 * 
		 * float resultado = numeroA / numeroB;
		 * 
		 * if(numeroB != 0) { System.out.println("El Resultado de la Operacion es = " +
		 * resultado); } else {
		 * System.err.println("Error, No es posible Dividir por Cero"); }
		 */

		//Scanner scanner = new Scanner(System.in);

		// System.out.println("Ingrese un Numero: (Que sea en Formato Numerico y
		// Entero)");
		//int numeroIngresado = scanner.nextInt();
		/*
		 * if(numeroIngresado > 0) {
		 * System.out.println("Usted ingreso un numero Positivo"); } else
		 * if(numeroIngresado < 0) {
		 * System.out.println("Usted ingreso un numero Negativo"); } else
		 * if(numeroIngresado == 0){ System.out.println("Usted ingreso el Cero"); } else
		 * { System.err.println("Usted ingreso un dato no valido"); }
		 */
		/*
		System.out.println("Ingrese un Numero de la semana");
		int numeroIngresado = scanner.nextInt();
		
		if (numeroIngresado == 1) {
			System.out.println("Hoy es Lunes");
		} else if (numeroIngresado == 2) {
			System.out.println("Hoy es Martes");
		} else if (numeroIngresado == 3) {
			System.out.println("Hoy es Miercoles");
		} else if (numeroIngresado == 4) {
			System.out.println("Hoy es Jueves");
		} else if (numeroIngresado == 5) {
			System.out.println("Hoy es Viernes");
		} else if (numeroIngresado == 6) {
			System.out.println("Hoy es Sabado");
		} else if (numeroIngresado == 7) {
			System.out.println("Hoy es Domingo");
		} else {
			System.err.println("Error, El dia ingresado es Incorrecto.!");
		}

		scanner.close();
		
		*/
		/*
		System.out.println("Ingrese su Edad");
		int ingreseSuEdad = scanner.nextInt();
		
		if(ingreseSuEdad >= 18 && ingreseSuEdad <= 120) {
			System.out.println("Usted puede Ingresar, es mayor de Edad");
		} else if(ingreseSuEdad > 0 && ingreseSuEdad < 18) {
			System.err.println("Usted es menor de Edad y no puede pasar");
		} else {
			System.err.println("Error, La Edad ingresada es Incorrecta.!!");
		}
		
		
		
		scanner.close();
		*/
		/*
		System.out.println("Ingrese un dia de la semana");
		int ingreseUnDiaDeLaSemana = scanner.nextInt();
		String nombreDelDiaDeLaSemana = null;
		*/
		/*
		switch(ingreseUnDiaDeLaSemana) {
			case 1:
				System.out.println("Hoy es Lunes");
				break;
			case 2:
				System.out.println("Hoy es Martes");
				break;
			case 3:
				System.out.println("Hoy es Miercoles");
				break;
			case 4:
				System.out.println("Hoy es Jueves");
				break;
			case 5:
				System.out.println("Hoy es Viernes");
				break;
			case 6:
				System.out.println("Hoy es Sabado");
				break;
			case 7:
				System.out.println("Hoy es Domingo");
				break;
			default:
				System.err.println("Error, El dia ingresado es Incorrecto.!");
		}*/
		/*
		switch(ingreseUnDiaDeLaSemana) {
		case 1:
			nombreDelDiaDeLaSemana =  "Lunes";
			break;
		case 2:
			nombreDelDiaDeLaSemana =  "Martes";
			break;
		case 3:
			nombreDelDiaDeLaSemana =  "Miercoles";
			break;
		case 4:
			nombreDelDiaDeLaSemana =  "Jueves";
			break;
		case 5:
			nombreDelDiaDeLaSemana =  "Viernes";
			break;
		case 6:
			nombreDelDiaDeLaSemana =  "Sabado";
			break;
		case 7:
			nombreDelDiaDeLaSemana =  "Domingo";
			break;
		default:
			nombreDelDiaDeLaSemana =  "Error, El dia ingresado es Incorrecto.!";
		}
		
		System.out.println("Usted ha ingresado el dia "  +  nombreDelDiaDeLaSemana);
		System.out.println("La ejecucion de su Aplicacion a concluido");
		
		scanner.close();
		*/
		/*
		System.out.println("Ingrese el dia de la Semana (con Palabras)");
		
		String diaIngresado = scanner.nextLine().trim().toLowerCase();
		
		switch(diaIngresado) {
			case "lunes", "martes", "miercoles", "miércoles", "jueves", "viernes":
				System.out.println("Es un dia Laborable");
				break;
			case "sábado", "sabado", "domingo":
				System.out.println("Hoy es dia de Descanso");
				break;
			default:
				System.err.println("Error, El dia ingresado es Incorrecto.!");			
		
		}
		
		scanner.close();
		*/
		
		// Operador Ternario
		
		
		/*
		int numeroA = 12;
		int numeroB = 12;
		
		boolean condicion = numeroA > numeroB;
		
		String mensaje = condicion 
				? "El númeroA " + numeroA + " es Mayorque numeroB " + numeroB
				: "El númeroB " + numeroB + " es Mayor o Igual que numeroA " + numeroA;
		
		
		System.out.println(mensaje);
		
		*/
		
		// Datos Random
		/*
		float random = 0;
		
		random = (float) Math.random();
		
		System.out.println(random);
		*/
		
		int min = 5;
		int max = 10;
		
		int random = (int) (Math.random() * (max - min + 1) + min);
		
		
		System.out.println(random);
		
		final double PI = Math.PI;
		System.out.println(PI);
	}

}
