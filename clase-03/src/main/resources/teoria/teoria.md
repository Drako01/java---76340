## Listas y Arraylists son lo mismo en Java? 

No, **listas (List)** y **ArrayLists** no son lo mismo en Java, pero están estrechamente relacionadas. Aquí tienes una explicación clara y concisa:

### **1. `List` es una interfaz**
- `List` es una **interfaz** en Java, parte del paquete `java.util`.
- Define un comportamiento general para las listas, como almacenar elementos en un orden específico, permitir duplicados y tener métodos como `add`, `remove`, `get`, etc.
- No se puede instanciar directamente porque es solo una definición de comportamiento.

### **2. `ArrayList` es una implementación concreta de `List`**
- `ArrayList` es una **clase concreta** que implementa la interfaz `List`.
- Utiliza un arreglo dinámico internamente para almacenar los elementos. Esto significa que el tamaño del arreglo puede crecer automáticamente cuando se agregan más elementos.
- Como implementa `List`, debe proporcionar implementaciones para todos los métodos definidos en la interfaz.

### **Ejemplo de código:**

```java
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Usando la interfaz List (polimorfismo)
        List<String> listaDeNombres = new ArrayList<>();

        // Agregando elementos
        listaDeNombres.add("Juan");
        listaDeNombres.add("María");
        listaDeNombres.add("Pedro");

        // Mostrando elementos
        System.out.println("Elementos de la lista:");
        for (String nombre : listaDeNombres) {
            System.out.println(nombre);
        }
    }
}
```

### **Diferencias clave:**
| Característica                 | List                          | ArrayList                      |
|--------------------------------|-------------------------------|--------------------------------|
| **Tipo**                       | Interfaz                     | Clase concreta                |
| **Instanciación**              | No se puede instanciar        | Se puede instanciar directamente |
| **Métodos**                    | Declarados, no implementados | Implementados                 |
| **Ejemplo de implementación** | `ArrayList`, `LinkedList`, etc. | Específica para `ArrayList`    |

### **En resumen:**
- Usa `List` como tipo para aprovechar el polimorfismo y permitir que tu código sea más flexible (por ejemplo, podrías cambiar a `LinkedList` más tarde sin cambiar mucho código).
- Usa `ArrayList` cuando necesites una lista basada en arreglos dinámicos.



---

## 📌 **Fundamentos de Java**  

```md
# Fundamentos de Java 🖥️☕  

Este documento cubre los conceptos fundamentales de **estructuras de datos y ciclos en Java**, con ejemplos prácticos y explicaciones claras.  

## 📖 Contenido  
1. [Introducción a Java](#introducción-a-java)  
2. [Estructuras de Datos](#estructuras-de-datos)  
   - Arrays vs List  
   - Iterable vs Iterator  
3. [Ciclos en Java](#ciclos-en-java)  
   - For vs Foreach vs While vs Do-While  
4. [Uso de `String[] args` en `main`](#uso-de-string-args-en-main)  
5. [Ejercicios Prácticos](#ejercicios-prácticos)  

---

## 🟢 **Introducción a Java**  

Java es un lenguaje de programación **orientado a objetos**, ampliamente usado para desarrollo web, móvil (Android) y empresarial.  

📌 **Ejemplo básico de Java: "Hola Mundo"**  

```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("¡Hola, mundo!");
    }
}
```

✅ **Puntos clave:**  
- La ejecución de Java comienza en `main()`.  
- `System.out.println()` imprime en consola.  

---

## 🔵 **Estructuras de Datos**  

En Java, podemos almacenar datos en **Arrays**, **Listas**, y recorrerlos con **Iterable** o **Iterator**.  

### 📌 **Arrays vs List**  

| Característica | Arrays | List (ArrayList) |
|--------------|--------------------|--------------------|
| **Tamaño** | Fijo | Dinámico |
| **Acceso** | Índice (`arr[0]`) | Métodos (`list.get(0)`) |
| **Performance** | Rápido | Lig. más lento por flexibilidad |
| **Modificación** | No crece ni reduce | Puede agregar/eliminar elementos |

📌 **Ejemplo con Arrays:**  
```java
public class EjemploArray {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}
```

📌 **Ejemplo con List:**  
```java
import java.util.ArrayList;
import java.util.List;

public class EjemploLista {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Carlos");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
```

✅ **Diferencia clave:**  
- `Array` es más eficiente en memoria, pero no crece dinámicamente.  
- `List` (ArrayList) permite agregar y eliminar elementos fácilmente.  

---

### 📌 **Iterable vs Iterator**  

| Característica | Iterable | Iterator |
|--------------|--------------------|--------------------|
| **Uso** | Se usa con `foreach` | Permite más control sobre la iteración |
| **Métodos** | No tiene (`foreach` lo usa implícitamente) | `hasNext()`, `next()`, `remove()` |
| **Eliminar elementos?** | ❌ No | ✅ Sí, con `remove()` |

📌 **Ejemplo con Iterable (`foreach`)**  
```java
import java.util.List;
import java.util.Arrays;

public class EjemploForeach {
    public static void main(String[] args) {
        List<String> colores = Arrays.asList("Rojo", "Verde", "Azul");

        for (String color : colores) {
            System.out.println(color);
        }
    }
}
```

📌 **Ejemplo con Iterator:**  
```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjemploIterator {
    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");

        Iterator<String> iterador = frutas.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}
```

✅ **Diferencia clave:**  
- `foreach` es más simple, pero **no permite modificar elementos** mientras iteramos.  
- `Iterator` permite eliminar elementos con `remove()`.  

---

## 🔵 **Ciclos en Java**  

| Ciclo | Cuándo usarlo | Ejemplo |
|------------|------------------|------------|
| `for` | Cuando sabemos cuántas veces iterar. | `for (int i = 0; i < 5; i++)` |
| `foreach` | Para recorrer listas o arrays. | `for (String s : lista)` |
| `while` | Cuando no sabemos cuántas veces iterar. | `while (condición)` |
| `do-while` | Para asegurarnos de ejecutar al menos una vez. | `do { ... } while (condición);` |

📌 **Ejemplo con `for`**  
```java
public class EjemploFor {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Número: " + i);
        }
    }
}
```

📌 **Ejemplo con `while`**  
```java
public class EjemploWhile {
    public static void main(String[] args) {
        int contador = 0;

        while (contador < 5) {
            System.out.println("Contador: " + contador);
            contador++;
        }
    }
}
```

📌 **Ejemplo con `do-while`**  
```java
import java.util.Scanner;

public class EjemploDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        
        do {
            System.out.print("Ingresa un número mayor a 10: ");
            numero = scanner.nextInt();
        } while (numero <= 10);
        
        System.out.println("¡Correcto! Ingresaste: " + numero);
    }
}
```

---

## 🔴 **Uso de `String[] args` en `main`**  

El parámetro `String[] args` permite recibir **argumentos desde la línea de comandos**.  

📌 **Ejemplo:**  
```java
public class ArgumentosMain {
    public static void main(String[] args) {
        System.out.println("Número de argumentos: " + args.length);
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argumento " + i + ": " + args[i]);
        }
    }
}
```
🔹 **Ejecutarlo desde la terminal:**  
```bash
java ArgumentosMain Hola 123 Mundo
```
🔹 **Salida:**  
```
Número de argumentos: 3
Argumento 0: Hola
Argumento 1: 123
Argumento 2: Mundo
```

✅ **Puntos clave:**  
- Los argumentos llegan siempre como `String`.  
- Se pueden convertir con `Integer.parseInt(args[0])`, `Double.parseDouble()`, etc.  

---

## 🟡 **Ejercicios Prácticos**  
1. Pedir al usuario 5 números y almacenarlos en una `List`.  
2. Mostrar los números en orden inverso usando un `Iterator`.  

---



## Profesor: Alejandro Daniel Di Stefano
[GitHub](https://github.com/Drako01) 