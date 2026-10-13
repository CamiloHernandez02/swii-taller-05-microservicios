# Taller Lección 5: descomposición de rica-api en dos servicios

Ingeniería de Software II (UPTC). Monorepo con dos proyectos Maven independientes (Java 25, Spring Boot 4.1.1).

| Servicio | Puerto | Base de datos |
| :--- | :--- | :--- |
| `investigadores-service` | 8080 | PostgreSQL 5432 (`investigadores-db`) |
| `publicaciones-service` | 8081 | MongoDB 27017 (`publicaciones-mongo`) |

## Ejecutar

```bash
cd investigadores-service && docker compose up -d && ./mvnw spring-boot:run
cd publicaciones-service && docker compose up -d && ./mvnw spring-boot:run
```

`publicaciones-service` usa `VerificadorInvestigadorPendiente` (acepta cualquier correo); la comunicación real se implementa en el Taller de la Lección 6.

Ver [NOTAS.md](NOTAS.md) para el corte entre servicios.
