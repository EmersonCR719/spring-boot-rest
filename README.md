#Spring Boot REST API

Este proyecto es una API RESTful construida con Spring Boot. La API permite gestionar fabricantes y productos.

##Estructura del Proyecto
SpringBootRest/
├── .mvn/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── aplicacion/
│   │               └── rest/
│   │                   ├── controller/
│   │                   │   ├── MakerController.java
│   │                   │   ├── ProductController.java
│   │                   ├── dto/
│   │                   │   ├── MakerDTO.java
│   │                   │   ├── ProductDTO.java
│   │                   ├── entities/
│   │                   │   ├── Maker.java
│   │                   │   ├── Product.java
│   │                   ├── persistence/
│   │                   │   ├── impl/
│   │                   │   │   ├── MakerDAOImpl.java
│   │                   │   │   ├── ProductDAOImpl.java
│   │                   │   ├── IMakerDAO.java
│   │                   │   ├── IProductDAO.java
│   │                   ├── repository/
│   │                   │   ├── MakerRepository.java
│   │                   │   ├── ProductRepository.java
│   │                   ├── service/
│   │                   │   ├── impl/
│   │                   │   │   ├── MakerServiceImpl.java
│   │                   │   │   ├── ProductServiceImpl.java
│   │                   │   ├── IMakerService.java
│   │                   │   ├── IProductService.java
│   │                   ├── SpringBootRestApplication.java
├── pom.xml
└── ...

##Descripción de Directorios y Archivos

-controller/: Contiene los controladores REST.
-dto/: Contiene los objetos de transferencia de datos (DTO).
-entities/: Contiene las entidades JPA.
-persistence/: Contiene las interfaces DAO y sus implementaciones.
-repository/: Contiene los repositorios de JPA.
-service/: Contiene las interfaces y las implementaciones de los servicios.
-SpringBootRestApplication.java: Clase principal para ejecutar la aplicación Spring Boot.

##Instalación y Configuración

###Prerequisitos
-JDK 11 o superior.
-Maven 3.6.3 o superior.
-MySQL (o cualquier otra base de datos relacional que prefieras).

##Configuración de la Base de Datos
Crea una base de datos en MySQL llamada 'rest_api_db' y actualiza las credenciales en application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/rest_api_db
spring.datasource.username=root
spring.datasource.password=emer123

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

##Instalación
-Clona el repositorio:
git clone https://github.com/tu_usuario/springbootrest.git
-Navega al directorio del proyecto:
cd springbootrest
-Compila y empaqueta el proyecto con Maven:
mvn clean install

##Ejecución del Proyecto
Para ejecutar la aplicación, usa el siguiente comando:
mvn spring-boot:run

##Uso
La API expone los siguientes endpoints:
###Fabricantes
-GET /fabricantes: Obtiene todos los fabricantes.
-POST /fabricantes: Crea un nuevo fabricante.
-GET /fabricantes/{id}: Obtiene un fabricante por su ID.
-PUT /fabricantes/{id}: Actualiza un fabricante por su ID.
-DELETE /fabricantes/{id}: Elimina un fabricante por su ID.

###Productos
-GET /productos: Obtiene todos los productos.
-POST /productos: Crea un nuevo producto.
-GET /productos/{id}: Obtiene un producto por su ID.
-PUT /productos/{id}: Actualiza un producto por su ID.
-DELETE /productos/{id}: Elimina un producto por su ID.

##Contribución
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

-Haz un fork del proyecto.
-Crea una rama nueva (git checkout -b feature/nueva-caracteristica).
-Realiza tus cambios.
-Haz un commit de tus cambios (git commit -am 'Agrega nueva característica').
-Empuja la rama (git push origin feature/nueva-caracteristica).
-Abre un Pull Request.
