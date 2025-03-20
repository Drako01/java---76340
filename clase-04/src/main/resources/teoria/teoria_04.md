**Programación Orientada a Objetos (OOP) en Java**

---

## 1. Introducción a la Programación Orientada a Objetos (OOP)
La Programación Orientada a Objetos (OOP) es un paradigma de programación basado en la creación y manipulación de **objetos**. Java es un lenguaje de programación orientado a objetos, lo que significa que todo en Java se basa en la definición y el uso de clases y objetos.

Los cuatro pilares principales de la OOP son:
- **Encapsulamiento:** Protección de los datos dentro de una clase.
- **Herencia:** Capacidad de una clase de heredar características de otra.
- **Polimorfismo:** Capacidad de un objeto de tomar múltiples formas.
- **Abstracción:** Ocultación de detalles innecesarios y exposición de solo lo esencial.

---

## 2. Clases y Métodos en Java

### **¿Qué es una clase?**
Una **clase** es una plantilla o modelo que define atributos y comportamientos de un objeto. En Java, una clase se declara usando la palabra clave `class`.

#### **Ejemplo de una clase en Java:**
```java
// Definición de una clase llamada Coche
class Coche {
    // Atributos
    String marca;
    int velocidad;
    
    // Método para mostrar información del coche
    void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Velocidad: " + velocidad + " km/h");
    }
}
```

### **¿Qué es un método?**
Un **método** es una función dentro de una clase que define el comportamiento de los objetos.

#### **Ejemplo de un método en Java:**
```java
class Coche {
    String marca;
    int velocidad;
    
    void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("El coche ha acelerado. Nueva velocidad: " + velocidad + " km/h");
    }
}
```

**Uso de la clase y el método:**
```java
public class Main {
    public static void main(String[] args) {
        Coche miCoche = new Coche();
        miCoche.marca = "Toyota";
        miCoche.velocidad = 50;
        miCoche.acelerar(20);
    }
}
```

---

## 3. Métodos `equals()` y `hashCode()` en Java

### **¿Qué es `equals()`?**
El método `equals()` en Java se usa para comparar si dos objetos son iguales en contenido. 

Por defecto, el método `equals()` heredado de `Object` compara las referencias de los objetos, lo que significa que solo devuelve `true` si ambos objetos apuntan a la misma dirección de memoria. Para comparar el contenido de los objetos, es necesario sobrescribir este método.

#### **Ejemplo de `equals()` en Java:**
```java
class Persona {
    String nombre;
    int edad;
    
    // Constructor
    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // Sobrescribir equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return edad == persona.edad && nombre.equals(persona.nombre);
    }
}
```

**Uso de `equals()`:**
```java
Persona p1 = new Persona("Juan", 25);
Persona p2 = new Persona("Juan", 25);
System.out.println(p1.equals(p2)); // true
```

### **¿Qué es `hashCode()`?**
El método `hashCode()` devuelve un número entero que representa de manera única un objeto. Es utilizado en estructuras de datos como `HashMap`, `HashSet` y `HashTable` para organizar y acceder a los objetos de manera eficiente.

Si sobrescribimos `equals()`, también debemos sobrescribir `hashCode()` para garantizar que dos objetos iguales tengan el mismo código hash.

#### **Ejemplo de `hashCode()` en Java:**
```java
import java.util.Objects;

class Persona {
    String nombre;
    int edad;
    
    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return edad == persona.edad && nombre.equals(persona.nombre);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }
}
```

**Uso de `hashCode()`:**
```java
Persona p1 = new Persona("Juan", 25);
Persona p2 = new Persona("Juan", 25);
System.out.println(p1.hashCode());
System.out.println(p2.hashCode());
```

### **¿Por qué son importantes `equals()` y `hashCode()`?**
- **`equals()`** permite comparar correctamente los objetos basados en sus valores y no en su referencia en memoria.
- **`hashCode()`** permite almacenar objetos en estructuras eficientes como `HashSet` y `HashMap`.

### **Ejemplo práctico en un `HashSet`**
```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Persona> personas = new HashSet<>();
        
        Persona p1 = new Persona("Ana", 30);
        Persona p2 = new Persona("Ana", 30);
        
        personas.add(p1);
        personas.add(p2);
        
        System.out.println("Total de personas en el HashSet: " + personas.size()); // 1
    }
}
```

**Conclusión:** Si no sobrescribimos `hashCode()`, el `HashSet` podría tratar `p1` y `p2` como diferentes aunque sean iguales con `equals()`.

---

## 4. Constructores en Java
Un **constructor** es un método especial que se ejecuta cuando se crea un objeto. Se usa para inicializar los atributos.

### **Ejemplo de Constructor en Java:**
```java
class Coche {
    String marca;
    int velocidad;
    
    // Constructor
    Coche(String marca, int velocidad) {
        this.marca = marca;
        this.velocidad = velocidad;
    }
}
```

**Uso del constructor:**
```java
Coche miCoche = new Coche("Ford", 100);
System.out.println("Marca: " + miCoche.marca);
System.out.println("Velocidad: " + miCoche.velocidad + " km/h");
```

---

## **Conclusión**
Estos conceptos son fundamentales en la Programación Orientada a Objetos en Java. Con una buena comprensión de **clases, métodos, equals/hashCode y constructores**, los principiantes pueden empezar a desarrollar aplicaciones más complejas y estructuradas.


---



## Profesor: Alejandro Daniel Di Stefano
[GitHub](https://github.com/Drako01) 