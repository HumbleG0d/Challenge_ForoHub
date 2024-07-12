# Challenge_ForoHub
Desafío numero 3 de la ruta backend ONE - Oracle Next Education. Este desafío consiste en crear una API Rest para un foro.

## Descripción

Un foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. Aquí en Alura Latam, los estudiantes utilizan el foro para resolver sus dudas sobre los cursos y proyectos en los que participan. Este lugar mágico está lleno de mucho aprendizaje y colaboración entre estudiantes, profesores y moderadores.

Ya sabemos para qué sirve el foro y conocemos su aspecto, ¿pero sabemos cómo funciona detrás de escena? Es decir, ¿dónde se almacenan las informaciones? ¿Cómo se tratan los datos para relacionar un tópico con una respuesta, o cómo se relacionan los usuarios con las respuestas de un tópico?

Este es nuestro desafío, llamado ForoHub: en él, vamos a replicar este proceso a nivel de back end y, para eso, crearemos una API REST usando Spring.

## Objetivo

Nuestra API se centrará específicamente en los tópicos, y debe permitir a los usuarios:

- Crear un nuevo tópico.
- Mostrar todos los tópicos creados.
- Mostrar un tópico específico.
- Actualizar un tópico.
- Eliminar un tópico.

Es lo que normalmente conocemos como CRUD (CREATE, READ, UPDATE, DELETE) y es muy similar a lo que desarrollamos en LiterAlura, pero ahora de forma completa, agregando las operaciones de UPDATE y DELETE, y usando un framework que facilitará mucho nuestro trabajo.

## Funcionalidades

En resumen, nuestro objetivo con este challenge es implementar una API REST con las siguientes funcionalidades:

- API con rutas implementadas siguiendo las mejores prácticas del modelo REST.
- Validaciones realizadas según las reglas de negocio.
- Implementación de una base de datos relacional para la persistencia de la información.
- Servicio de autenticación/autorización para restringir el acceso a la información.

## Tecnologías Utilizadas

### Backend

- **Java Spring Boot:** Utilizado para desarrollar la API REST.
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Spring Boot DevTools
  - H2 Database (para pruebas)

- **JWT (JSON Web Tokens):** Utilizado para la autenticación y autorización de usuarios.


## Ejecución de la aplicación
**1. Loguear usuario.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgLogUser.png)

**2. Mostrar usuario logueado.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgObtenerUsuario.png)

**3. Agregar topico.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgAgregarTopicos.png)

**4. Mostrar todos los topicos.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgMostrarTopicos.png)

**5. Mostrar topico por id.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgMostrarTopcioId.png)

**6. Actualizar topico.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgAcutualizarTopico.png)

**7. Eliminar topico.**

![](https://github.com/HumbleG0d/Challenge_ForoHub/blob/main/API/src/main/java/alura/com/api/asstes/ImgEliminarTopico.png)
