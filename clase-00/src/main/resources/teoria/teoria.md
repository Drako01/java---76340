# **Paso a paso claro y detallado** para conectar un repositorio de **GitHub** a tu **workspace de Eclipse** y subir tu trabajo al repositorio.

---

## **🔹 Paso 1: Instalar y Configurar Git en Eclipse**
Antes de empezar, asegúrate de que Eclipse tiene **EGit**, el plugin de Git, instalado.

1. **Abrir Eclipse**.
2. Ir a **Help** > **Eclipse Marketplace**.
3. En la barra de búsqueda, escribir **EGit**.
4. Si está instalado, ya puedes usar Git en Eclipse.  
   👉 Si no, presiona **Install**, sigue los pasos y reinicia Eclipse.

---

## **🔹 Paso 2: Configurar Git en Eclipse**
Si nunca usaste Git en Eclipse, debes configurarlo:

1. Ir a **Window** > **Preferences**.
2. Expandir **Team** > **Git**.
3. En la sección **Configuration**, agregar:
   - **User.name** → Tu nombre de usuario de GitHub.
   - **User.email** → El correo asociado a tu cuenta de GitHub.
4. Presiona **Apply and Close**.

---

## **🔹 Paso 3: Clonar el Repositorio de GitHub en Eclipse**
Si ya tienes un **repositorio creado en GitHub**, sigue estos pasos para clonarlo en tu workspace de Eclipse:

1. **Copiar la URL del repositorio en GitHub**:
   - Ir a **GitHub** y abrir el repositorio.
   - Presionar **Code** > **SSH o HTTPS**.
   - Copiar la URL (por ejemplo: `https://github.com/tu-usuario/tu-repositorio.git`).

2. **Abrir la vista de Git en Eclipse**:
   - Ir a **Window** > **Show View** > **Other...**.
   - Buscar **Git Repositories** y seleccionarlo.

3. **Clonar el repositorio**:
   - En la vista **Git Repositories**, hacer clic en **Clone a Git repository**.
   - Pegar la URL copiada en el campo **URI**.
   - Presionar **Next** y esperar a que se descarguen los datos.
   - Elegir la rama principal (**main** o **master**).
   - Presionar **Next** y luego **Finish**.

4. **Importar el proyecto a Eclipse**:
   - Ir a **File** > **Import**.
   - Seleccionar **Git** > **Projects from Git** y presionar **Next**.
   - Elegir **Existing local repository** y presionar **Next**.
   - Seleccionar el repositorio clonado y presionar **Next**.
   - Seleccionar **Import existing Eclipse projects** y presionar **Next**.
   - Finalizar con **Finish**.

---

## **🔹 Paso 4: Subir tu Código a GitHub**
Si has trabajado en un proyecto y deseas subirlo a GitHub:

1. **Ir a la vista de Git Repositories** en Eclipse.
2. Hacer clic derecho en el repositorio y seleccionar **Add to Index** (para agregar archivos al seguimiento de Git).
3. Hacer clic derecho en el proyecto y seleccionar **Team** > **Commit**.
4. Escribir un mensaje de commit en el campo superior.
5. Seleccionar los archivos a incluir en el commit.
6. Presionar **Commit and Push** para enviarlo a GitHub.
7. En la ventana emergente, ingresar las credenciales de GitHub si es necesario y presionar **OK**.

---

## **🔹 Paso 5: Confirmar que el Código está en GitHub**
1. Ir a tu repositorio en GitHub.
2. Verificar que los archivos subidos aparecen en la lista.


---

---



# **🔹 Paso a Paso para Generar un Token de GitHub y Vincularlo a Eclipse**  

Para poder conectar **Eclipse** con **GitHub**, necesitas un **Personal Access Token (PAT)** en lugar de una contraseña. Aquí tienes los pasos detallados para generarlo y configurarlo en Eclipse.  

---

## **🔸 Paso 1: Generar el Token en GitHub**  
1️⃣ **Iniciar sesión en GitHub**  
   - Ir a [https://github.com](https://github.com) e iniciar sesión con tu cuenta.  

2️⃣ **Acceder a la configuración del token**  
   - Hacer clic en tu foto de perfil (arriba a la derecha).  
   - Seleccionar **Settings** (Configuración).  
   - En la barra lateral izquierda, hacer clic en **Developer settings**.  
   - Ir a **Personal access tokens** > **Tokens (classic)**.  
   - Presionar el botón **Generate new token (classic)**.  

3️⃣ **Configurar el Token**  
   - **Nota**: Ingresa un nombre para el token (Ejemplo: "Token para Eclipse").  
   - **Expiration**: Puedes elegir la duración del token (se recomienda **"No expiration"** si no quieres regenerarlo cada cierto tiempo).  
   - **Scopes (Permisos)**: Marca las siguientes opciones:  
     ✅ `repo` → Acceso a repositorios privados y públicos.  
     ✅ `workflow` → Para trabajar con GitHub Actions.  
     ✅ `write:packages` y `read:packages` → Si usas GitHub Packages.  
     ✅ `admin:repo_hook` → Para manejar hooks de repositorios.  
   - Presionar **Generate token**.  

4️⃣ **Copiar el Token**  
   - **Importante**: Copia el token **de inmediato** y guárdalo en un lugar seguro.  
   - **GitHub NO lo volverá a mostrar** después de salir de la página.  

---

## **🔸 Paso 2: Configurar el Token en Eclipse**  
Ahora que tienes tu token, configúralo en Eclipse para conectarte a GitHub.  

1️⃣ **Abrir Eclipse**.  
2️⃣ Ir a **Window** > **Preferences**.  
3️⃣ Expandir la opción **Team** > **Git** > **Configuration**.  
4️⃣ En la pestaña **User Settings**, asegurarte de que tu `user.name` y `user.email` sean los mismos que usaste en GitHub.  
5️⃣ En la pestaña **System Settings**, haz clic en **Add Entry** y agrega:  
   - **Key**: `credential.helper`  
   - **Value**: `store`  
6️⃣ **Guardar y cerrar la ventana**.  

---

## **🔸 Paso 3: Usar el Token en Eclipse**  
Cuando intentes hacer **push**, **pull** o clonar un repositorio:  

1️⃣ Eclipse te pedirá credenciales de GitHub.  
2️⃣ **Usuario**: Ingresa tu nombre de usuario de GitHub.  
3️⃣ **Contraseña**: **Pega el token** generado en GitHub.  
4️⃣ Marca la opción **Store in Secure Store** para no tener que ingresarlo cada vez.  
5️⃣ Presiona **OK** y listo. 🚀  

---
