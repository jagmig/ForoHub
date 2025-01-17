

# Foro Hub 👩‍💻! #


![341230127-952e8461-2eac-4c28-8fd0-bb676e672528](https://github.com/user-attachments/assets/3cb12fc6-5658-4188-a4d3-3f97bfec6ff6)


Foro Hub es una aplicación de foro diseñada para discusión entre usuarios. Esta aplicación permite a los usuarios crear tópicos, responder a los mismos y participar en discusiones.

Características ⚙️

    Registro y autenticación de usuarios.
    Creación, edición y eliminación de tópicos.
    Respuesta a tópicos existentes.
    Listado de usuarios y tópicos.
    Autenticación mediante JWT.

Tecnologías utilizadas ⚒️

    Java
    Spring Boot
    Spring Security
    JWT (JSON Web Tokens)
    JPA (Java Persistence API)
    MySql Workbench para Base de Datos
    Postman (para pruebas de API)
    Swagger (para documentación de API)

Estructura del proyecto 🖥️

    Entities: Clases de entidad que representan las tablas de la base de datos.
    Dto: Clases de Data Transfer Object utilizadas para transferir datos entre el cliente y el servidor.
    Repository: Interfaces que extienden JpaRepository para realizar operaciones CRUD en las entidades.
    Service: Clases de servicio que contienen la lógica de negocio.
    Controller: Clases de controlador que manejan las solicitudes HTTP.
    Security: Clases relacionadas con la configuración de seguridad y la autenticación.

Instalación 🚧

Clona este repositorio:

git clone https://github.com/jagmig/ForoHub.git

Navega al directorio del proyecto:

cd ForoHub

    Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse).
    Configuración
    Base de datos: MySQL Workbench 📈


Swagger está configurado para generar documentación de la API automáticamente. Puedes acceder a la interfaz de Swagger en la siguiente URL cuando el servidor esté en funcionamiento:

http://localhost:8080/swagger-ui/index.html

swagger.png

Ejecución Para ejecutar la aplicación, utiliza el siguiente comando en la raíz del proyecto:

mvn spring-boot:run

La aplicación estará disponible en http://localhost:8080.

Endpoints principales:

    /login: Endpoint para autenticación de usuarios. Envía una solicitud POST con un JSON que contiene username y password.
    /usuarios: Endpoint para listar usuarios. Requiere autenticación mediante un token JWT.
    /topicos: Endpoint para manejar la creación, actualización y eliminación de tópicos.

Ejemplos de solicitudes 📑

   ###Autenticación 🔐###

Solicitud:

POST http://localhost:8080/login

Body:

{
    "username": "nombre_usuario",
    "password": "contraseña"
}
 "content": [
        {
            "id": 1,
            "titulo": "Hola Java",
            "mensaje": "Bienvenidos a Java",
            "fechaCreacion": "2025-01-17T12:37:40",
            "status": "ABIERTO",
            "autor": {
                "id": 1,
                "nombre": "Jorge Gomez",
                "correoElectronico": "jagmig@hotmail.com",
                "perfil": {
                    "id": 1,
                    "nombre": "ADMINISTRADOR"
                }
            },
            "curso": {
                "id": 1,
                "nombre": "Java",
                "categoria": "BACKEND"
            }
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}

Respuesta:

{
    "token": "jwt_token_generado"
}

 ##Crear un tópico 📝##

Solicitud:

GET http://localhost:8080/topico/topicos

Headers:

Authorization: Bearer jwt_token_generado
Content-Type: application/json



Feedback ⌨️

Los comentarios, criticas, ideas, observaciones son bienvenidas. Por favor siéntete libre de hacer un fork del proyecto y enviar un pull request.

Licencia 🚀

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.
About

Challenge Foro Hub con Spring Boot

    Java 100.0% 

Footer
© 2025 GitHub, I
