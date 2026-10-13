### El corte: qué va en cada servicio

| Paquete / clase actual | Destino |
| :--- | :--- |
| `investigadores.*` (dominio, aplicación, infraestructura) | `investigadores-service` |
| `publicaciones.*` | `publicaciones-service` |
| `compartido.GlobalExceptionHandler`, `RecursoNoEncontradoException` | Se duplica en ambos: cada servicio necesita su propio manejo de errores; ya no hay un único `@ControllerAdvice` compartido |
| `plataforma.StatusController`, `CorsConfig` | Se duplica en ambos, adaptado (cada servicio expone su propio `/api/status`) |
| `plataforma.ArranqueInformativo`, `SaludoInstitucionalService` | Se descarta: era una demostración del Tutorial 2 (IoC/DI) sin valor de negocio real |

### Sobre la duplicación de `compartido` y `plataforma`

Es la primera consecuencia real de Database per Service y despliegue independiente. Un `@ControllerAdvice` compartido implicaría una librería o módulo común versionado por separado (shared kernel), fuera del alcance de este taller.

### Decisiones de adaptación

- `LimitePublicacionesAnualesService` deja de recibir un `Investigador`: usa `Publicacion.getInvestigadorCorreo()`, así `publicaciones-service` no conoce el dominio de investigadores.
- `publicaciones-service` agrega un handler 409 para `LimiteAnualExcedidoException`.
- `VerificadorInvestigadorPendiente` acepta cualquier correo; es la brecha que cierra el Taller de la Lección 6.
- El paquete `aplication` (errata) se renombra a `aplicacion`.
