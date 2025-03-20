import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraysClase03 {

	public static void main(String[] args) {
		/*
		int[] numerosEnteros = new int[5]; // Defino la cantidad total de Elementos
		
		numerosEnteros[0] = 5;
		//numerosEnteros[0] = 15; // Reasignando
		numerosEnteros[1] = 9;
		numerosEnteros[2] = -5;
		numerosEnteros[3] = 8;
		numerosEnteros[4] = 0;
		*/
		//numerosEnteros[5] = 100; //6
		/*
		System.out.println("Posicion en Memoria del Array: " + numerosEnteros);
		
		System.out.println("El elemento en la Posicion 0 es: " + numerosEnteros[0]);
		System.out.println("El elemento en la Posicion 1 es: " + numerosEnteros[1]);
		System.out.println("El elemento en la Posicion 2 es: " + numerosEnteros[2]);
		System.out.println("El elemento en la Posicion 3 es: " + numerosEnteros[3]);
		System.out.println("El elemento en la Posicion 4 es: " + numerosEnteros[4]);
		*/
		/*
		String[] palabras = {
				"Hola",
				"Mundo",
				"Coder",
				"Java",
				"Alejandro",
				"Otra palabra"
		};
		
		System.out.println("El Array de palabras tiene " 
				+ palabras.length  + " elementos.!");
		
		System.out.println(Arrays.toString(palabras));
		*/
		// Listas
		
		List<String> palabras = new ArrayList<>();
		
		List<String> palabras2 = new ArrayList<>();
		
		palabras.add("Hola"); //0
		palabras.add("Mundo"); //1
		palabras.add("Coder"); //2
		palabras.add("Java"); //3
		palabras.add("Alejandro");
		palabras.remove("Alejandro");
		
		palabras2.add("Alejandro"); //4
		palabras2.add("Marco"); //5
		palabras2.add("Javier"); //6
		
//		System.out.println(palabras);
//		System.out.println("La Lista de palabras tiene " + palabras.size() + " elementos.!");
//		
//		System.out.println(palabras2);
		
		
		palabras.addAll(palabras2);
		
		//System.out.println(palabras);
		
		//System.out.println(palabras.containsAll(palabras2));
		//palabras.removeAll(palabras2);
		//System.out.println(palabras);
		
		//System.out.println(palabras.containsAll(palabras2));
		
//		palabras.clear();
//		System.out.println(palabras);
		
//		if(palabras.isEmpty()) {
//			System.out.println("La lista palabras esta vacia.!");
//		} else {
//			
//			System.out.println("La cantidad de elementos de palabras es: " + palabras.size());
//			for (String palabra : palabras) {	
//				int indice = palabras.indexOf(palabra);
//				System.out.println("La palabra con Indice " + indice + " es: "  + palabra);
//			}
			
//			for (int i = 0; i < palabras.size(); i++) {
//				System.out.println("La palabra con Indice " + i + " es: " + palabras.get(i));
//			}
			
//			Iterator<String> iterator = palabras.iterator();
//			
//			while(iterator.hasNext()) {
//				String palabra = iterator.next();
//				System.out.println("Palabra : "  + palabra);
//				iterator.remove();
//			}
			
			//System.out.println("La cantidad de elementos de palabras es: " + palabras.size());
//		}
		
//		int indice = palabras.indexOf("Coder");
//		System.out.println("El indice de la palabra Coder es: " + indice);
		
		
		// while y do wile
		//int indice = 0;
		
//		while(!palabras.isEmpty() && indice < palabras.size()) {
//			System.out.println("Palabra : "  + palabras.get(indice));
//			indice++;
//		}
		
//		if(!palabras.isEmpty()) {
//			do {
//				System.out.println("Palabra : "  + palabras.get(indice));
//				indice++;
//			} while(indice < palabras.size());
//		} else {
//			System.err.println("La Lista esta Vacia.");
//		}
		
		
		// Otra forma de declarar foreach
		
		
//		palabras.forEach( palabra -> {
//			System.out.println("Palabra : "  + palabra);
//		});
		
		
		
		//Repaso
		
		palabras.add("String nuevo");
		palabras.remove("String nuevo");
		
		palabras.set(4, "Nuevo String");
		
		
		System.out.println(palabras);
		
	}

}
