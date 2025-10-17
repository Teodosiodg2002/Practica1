# 🛒 Aplicación de Carrito de Compra con Spring Boot y Thymeleaf

![Captura de Pantalla de la Aplicación](https://imgur.com/a/oKiY8QP)

Este proyecto es una aplicación web completa desarrollada como parte de la práctica "Creación de una aplicación de carrito de la compra". La aplicación gestiona un catálogo de productos, permite a los usuarios añadirlos a un carrito de compra y cuenta con un panel de administración protegido para la gestión de productos.

---

## ✨ Características Principales

Basado en el guion de la práctica, el proyecto implementa las siguientes funcionalidades:

### **Gestión de Productos (CRUD)**
* **Panel de Administración:** Una vista segura (`/admin`) para gestionar el inventario.
* **Crear y Editar Productos:** Un formulario unificado para añadir nuevos productos y modificar los existentes
* **Listado de Productos:** Visualización de todos los productos en el panel de administración.
* **Eliminar Productos:** Funcionalidad para borrar productos de la base de datos.

### **Funcionalidad de Carrito de Compra**
* **Añadir al Carrito:** Los usuarios pueden añadir productos al carrito desde el catálogo.
* **Ver Carrito:** Una página dedicada (`/cart`) para mostrar los productos seleccionados.
* **Eliminar del Carrito:** Opción para quitar productos individualmente del carrito.
* **Gestión por Sesión:** Cada usuario tiene su propio carrito independiente gracias a la gestión de sesiones de Spring.

### **Seguridad y Autenticación**
* **Spring Security:** Implementación de un sistema de seguridad robusto.
* **Acceso por Roles:**
    * **Público:** Cualquiera puede ver el catálogo de productos y gestionar su propio carrito (`/products`, `/cart`). 
    * **Administrador:** Solo los usuarios con rol `ADMIN` pueden acceder al panel de gestión (`/admin`, CRUD de productos).
* **Página de Login:** Un formulario de inicio de sesión personalizado.

### **Exportación de Datos**
* **Backup SQL:** Una funcionalidad en el panel de administración que permite descargar un script SQL con todos los productos de la base de datos.

---

## 🛠️ Tecnologías Utilizadas

* **Backend:** Spring Boot, Spring MVC, Spring Data JPA, Spring Security
* **Frontend:** Thymeleaf, HTML5, Bootstrap 5 
* **Base de Datos:** H2 Database (en memoria) 
* **Build Tool:** Maven

---

## 🚀 Cómo Ejecutar el Proyecto

Para poner en marcha el proyecto en tu máquina local, sigue estos pasos:

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/Teodosiodg2002/spring-boot-shopping-cart](https://github.com/Teodosiodg2002/spring-boot-shopping-cart)
    ```
2.  **Navega a la carpeta del proyecto:**
    ```bash
    cd tu-repositorio
    ```
3.  **Ejecuta la aplicación con Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
4.  Abre tu navegador y ve a `http://localhost:8080`.

### **Credenciales de Acceso**

* **Administrador:**
    * **Usuario:** `admin`
    * **Contraseña:** `admin`

---
## 📸 Capturas de Pantalla

**Página de Administración**
![Panel de Administración](https://imgur.com/a/fqfZKHL)

**Página del Carrito de Compra**
![Carrito de Compra](https://imgur.com/jWC9abK)
