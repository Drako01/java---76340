# Proyecto de Gestión de Alumnos y Cursos 📚

Este proyecto es un ejemplo simple de cómo usar **Java**, **JPA (Jakarta Persistence API)** e **Hibernate** para gestionar entidades como `Alumno`, `Curso` y `Categoria` en una base de datos. Acá te explicamos los conceptos más importantes que se usan en el código.

---

## 🔧 ¿Qué es `@PersistenceContext`?

Cuando queremos acceder a la base de datos desde nuestra aplicación, necesitamos un objeto llamado **EntityManager**. Este objeto es el que se encarga de guardar, buscar, actualizar o borrar datos.

```java
@PersistenceContext
private EntityManager em;
```

Con `@PersistenceContext`, le pedimos a **Spring** que nos inyecte automáticamente el `EntityManager`. No lo tenemos que crear nosotros, Spring lo hace por detrás.

---

## 💾 ¿Qué es `@Transactional`?

Cada vez que hacemos una operación con la base de datos (guardar, buscar, modificar, borrar), lo hacemos dentro de una **transacción**.

```java
@Transactional
public void persistirAlumno(Alumno alumno) {
	em.persist(alumno);
}
```

### ¿Qué es una transacción?

Una transacción es un "bloque de trabajo" que **debe completarse todo o nada**. Por ejemplo:
- Si se corta la luz a mitad de una operación, no se guarda la mitad: **se cancela todo**.
- Si ocurre un error, se **deshace lo que se hizo antes del error**.

Con `@Transactional` nos aseguramos de que todo funcione de forma segura y consistente.

---

## 📄 ¿Qué es `TypedQuery`?

Cuando queremos hacer consultas personalizadas a la base de datos (por ejemplo, buscar un curso por ID), usamos `TypedQuery`.

```java
TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c WHERE c.id = :id", Curso.class);
return query.setParameter("id", cursoId).getSingleResult();
```

### ¿Qué significa todo esto?

- `"SELECT c FROM Curso c WHERE c.id = :id"` → Es una consulta en **JPQL** (parecido a SQL pero para objetos Java).
- `:id` → Es un **parámetro** que reemplazamos con un valor real.
- `.setParameter("id", cursoId)` → Le damos el valor al parámetro `:id`.
- `.getSingleResult()` → Esperamos un único resultado.

---

## 🧠 ¿Qué es Hibernate?

**Hibernate** es una herramienta (framework) que hace de "puente" entre Java y la base de datos. Traduce objetos Java a tablas de la base de datos, y viceversa.

Cuando usamos JPA (Jakarta Persistence API), **Hibernate se encarga de hacer el trabajo pesado** por debajo:
- Crear tablas
- Escribir sentencias SQL
- Administrar conexiones

Nosotros escribimos en Java, y Hibernate se encarga del resto.

---

## ✏️ Entidades principales

### `Alumno`

```java
@Entity
@Table(name = "Alumnos")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;

	@Column(unique = true, nullable = false)
	private int dni;

	@Column(unique = true, nullable = false)
	private String legajo;

	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
	private List<Curso> cursos = new ArrayList<>();
}
```

Un alumno tiene un **ID**, **nombre**, **apellido**, **DNI**, y un **legajo**. Además, puede estar anotado en varios cursos (relación muchos a muchos con `Curso`).

---

### `Curso`

```java
@Entity
@Table(name = "Cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "curso_alumno",
		joinColumns = @JoinColumn(name = "curso_id"),
		inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private List<Alumno> alumnos = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
}
```

Un curso tiene un **nombre**, una lista de alumnos, y pertenece a una **categoría**.

---

### 🧩 Método para anotar un alumno a cursos

Creamos un método que permite que un alumno se anote a uno o varios cursos:

```java
@Transactional
public void anotarAlumnoACursos(Long alumnoId, List<Long> cursoIds) throws Exception {
	Alumno alumno = em.find(Alumno.class, alumnoId);
	if (alumno == null) throw new Exception("Alumno no existe.");

	for (Long cursoId : cursoIds) {
		Curso curso = em.find(Curso.class, cursoId);
		if (curso == null) throw new Exception("Curso no existe.");

		// Relación en ambas direcciones (opcional pero recomendado)
		if (!curso.getAlumnos().contains(alumno)) curso.getAlumnos().add(alumno);
		if (!alumno.getCursos().contains(curso)) alumno.getCursos().add(curso);

		em.merge(curso);
	}
	em.merge(alumno);
}
```

Este método:
1. Busca al alumno y los cursos por sus IDs.
2. Asocia al alumno con cada curso.
3. Guarda los cambios en la base de datos.

---

## ✅ Requisitos previos

- Tener Java 17 o superior.
- Tener una base de datos configurada (por ejemplo MySQL o H2).
- Spring Boot y las dependencias de JPA/Hibernate correctamente configuradas.

---

## 📌 Conclusión

Este proyecto muestra cómo trabajar con entidades, relaciones, persistencia y consultas personalizadas de forma **profesional pero accesible**. Ideal para estudiantes que están dando sus primeros pasos con JPA y Hibernate.

---

---



## Profesor: Alejandro Daniel Di Stefano
[GitHub](https://github.com/Drako01) 