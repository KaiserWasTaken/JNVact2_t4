# Proyecto Spring Boot: catalogo de libros

Aplicacion web desarrollada con Spring Boot para practicar controladores REST,
vistas Thymeleaf, DTOs, formularios y parametros de URL. El ejemplo principal
utiliza un catalogo de libros.

## Requisitos

- Java 25 o superior.
- Maven. El proyecto incluye Maven Wrapper.

## Tecnologias

- Spring Boot
- Spring MVC
- Thymeleaf mediante `spring-boot-starter-thymeleaf`
- DTOs para transportar datos
- Endpoints REST con JSON

## Ejecutar el proyecto

Desde esta carpeta (`demo`):

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicacion utiliza el puerto `9526`.

Tambien se puede compilar y ejecutar el archivo JAR:

```powershell
.\mvnw.cmd package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## DTO utilizado

La clase `LibroDTO` representa los datos de un libro:

- `id`
- `titulo`
- `autor`
- `categoria`
- `precio`

El DTO se utiliza en el controlador MVC y en el endpoint REST POST.

## Controlador MVC y vistas Thymeleaf

El controlador MVC se encuentra en:

```text
src/main/java/com/web/demo/controllers/LibrosController.java
```

### GET /libros

URL completa:

```text
http://localhost:9526/libros
```

Muestra el listado de libros en la vista `libros/lista.html`. El controlador
envia la lista mediante `Model` y la vista recorre los elementos con:

```html
<tr th:each="libro : ${libros}">
```

### GET /libros?categoria=Tecnologia

URL completa:

```text
http://localhost:9526/libros?categoria=Tecnologia
```

Este endpoint usa `@RequestParam` para recibir el parametro opcional
`categoria`. Si se envia, filtra la lista. Si se omite, muestra todos los
libros.

### GET /libros/nuevo

URL completa:

```text
http://localhost:9526/libros/nuevo
```

Muestra el formulario en `libros/formulario.html`. El controlador agrega un
objeto `LibroDTO` vacio al `Model`. La vista usa `th:object` y `th:field`.

### POST /libros

URL completa:

```text
http://localhost:9526/libros
```

Recibe los datos del formulario mediante:

```java
@ModelAttribute("libro") LibroDTO libro
```

El libro recibe un identificador, se agrega a la lista en memoria y se
redirige al listado. Este endpoint recibe datos de formulario, no JSON.

### GET /libros/{id}

Ejemplo de URL completa:

```text
http://localhost:9526/libros/2
```

Usa `@PathVariable int id` para buscar un libro por su identificador y mostrar
su detalle en `libros/detalle.html`. Si el libro no existe, responde con
estado HTTP `404 Not Found`.

## Propiedad personalizada con @Value

En `application.properties` se define:

```properties
catalogo.nombre=Catalogo de libros de jonathan
```

El controlador la lee con:

```java
@Value("${catalogo.nombre}")
private String nombreCatalogo;
```

El valor aparece en el titulo y encabezado del listado.

## Endpoint REST POST con DTO

El controlador REST se encuentra en:

```text
src/main/java/com/web/demo/controllers/LibrosRestController.java
```

### POST /api/libros

URL completa:

```text
http://localhost:9526/api/libros
```

Recibe un objeto JSON mediante `@RequestBody LibroDTO` y devuelve el objeto
como JSON. Si el `id` no se envia o es menor o igual que cero, el servidor
asigna uno automaticamente.

Header:

```text
Content-Type: application/json
```

Body para Postman o Bruno:

```json
{
  "titulo": "El principito",
  "autor": "Antoine de Saint-Exupery",
  "categoria": "Novela",
  "precio": 199.90
}
```

Respuesta esperada:

```json
{
  "id": 100,
  "titulo": "El principito",
  "autor": "Antoine de Saint-Exupery",
  "categoria": "Novela",
  "precio": 199.9
}
```

## Endpoints REST existentes

### GET /api/proyecto

```text
http://localhost:9526/api/proyecto
```

Devuelve la informacion general del proyecto y su autor.

### GET /api/materias

```text
http://localhost:9526/api/materias
```

Devuelve una lista JSON de materias con nombre, semestre y estado.

### GET /api/estado

```text
http://localhost:9526/api/estado
```

Devuelve el estado actual del servidor.

### GET /api/detalles_info2

```text
http://localhost:9526/api/detalles_info2
```

Devuelve un objeto `ClaseDTO` en formato JSON.

### GET /api/parametros/detalle?informacion=Saludos

```text
http://localhost:9526/api/parametros/detalle?informacion=Saludos
```

Usa `@RequestParam` para recibir `informacion`. Si no se envia, utiliza un
mensaje predeterminado.

### GET /api/variable/pagina1/Hola

```text
http://localhost:9526/api/variable/pagina1/Hola
```

Usa `@PathVariable` para recibir `mensaje` y devolverlo dentro de un DTO.

### GET /api/variable/valores

```text
http://localhost:9526/api/variable/valores
```

Devuelve los valores configurados con `@Value`.

### POST /api/variable/solicitud

```text
http://localhost:9526/api/variable/solicitud
```

Recibe un objeto `Empleados` en JSON mediante `@RequestBody` y lo devuelve
como respuesta JSON.

## Secciones para capturas de pantalla

Las siguientes secciones quedan preparadas para agregar capturas manualmente.

### 1. Vista del listado con th:each

URL:

```text
http://localhost:9526/libros
```

<!-- Agregar aqui la captura del listado de libros. -->

### 2. Formulario con @ModelAttribute

URL:

```text
http://localhost:9526/libros/nuevo
```

<!-- Agregar aqui la captura del formulario. -->

### 3. Resultado del filtro con @RequestParam

URL:

```text
http://localhost:9526/libros?categoria=Tecnologia
```

<!-- Agregar aqui la captura del resultado filtrado. -->

### 4. Resultado del detalle con @PathVariable

URL:

```text
http://localhost:9526/libros/2
```

<!-- Agregar aqui la captura del detalle. -->

### 5. Peticion POST en Postman o Bruno

URL:

```text
http://localhost:9526/api/libros
```

Metodo: `POST`

<!-- Agregar aqui la captura de la peticion y respuesta JSON. -->

## Pruebas

Para ejecutar las pruebas automatizadas:

```powershell
.\mvnw.cmd test
```

## Estructura principal

```text
src/
|-- main/
|   |-- java/com/web/demo/
|   |   |-- DemoApplication.java
|   |   |-- controllers/
|   |   |-- models/
|   |       |-- dto/
|   |-- resources/
|       |-- application.properties
|       |-- templates/
|-- test/
```
