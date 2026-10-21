# Herramientas

Aplicación Spring Boot con Kotlin, PostgreSQL, JPA y Flyway.

## Requisitos

- Java 21 o posterior
- PostgreSQL
- Maven (o el wrapper incluido)

## Ejecutar localmente

1. Crea una base de datos PostgreSQL llamada `Herramientas`.
2. Define estas variables de entorno antes de iniciar la aplicación:

   - `DB_URL` (opcional; por defecto `jdbc:postgresql://localhost:5432/Herramientas`)
   - `DB_USERNAME` (opcional; por defecto `postgres`)
   - `DB_PASSWORD` (obligatoria; contraseña del usuario de PostgreSQL)

3. Inicia la aplicación:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

En IntelliJ, configura las mismas variables en **Run → Edit Configurations → Environment variables**. Flyway ejecuta automáticamente las migraciones al iniciar. El servidor escucha en el puerto `8081`.
