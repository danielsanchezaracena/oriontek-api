# oriontek-api
API para el control de los clientes de Oriontek.

## Instalación

1. Clona el repositorio.
2. Corre el script de DB encontrado en el folder sql-scripts.
3. Ten en cuenta que la clave provisional para todos los usuarios es Test123.
4. Recuerda cambiar la url, user y el password de tu conexion de base de datos en application.properties.
5. Sube el proyecto.
6. Abre Postman.
7. Ya puedes probar la API utilizando Basic Authentication.

## Bcrypt

Para cambiar su clave debe generar un hash con BCrypt y sustituírlo en la tabla de users. Como generador pueden usar el siguiente:

- [BCrypt Hash Generator](https://bcrypt-generator.com/)

Los hash fueron generados con Bcrypt Factor 12.
