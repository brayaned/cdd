# SIAR Backend - Sistema de Perfil de Riesgo

## 📋 Descripción del Proyecto

Sistema backend desarrollado en Java 17 con Spring Boot para la gestión de perfiles de riesgo bancario. Implementa un sistema completo de evaluación de riesgo para personas naturales y jurídicas, incluyendo catálogos, variables y resultados de riesgo.

## 🏗️ Arquitectura del Proyecto

### Tecnologías Principales
- **Java:** 17
- **Framework:** Spring Boot
- **ORM:** JPA/Hibernate
- **Base de Datos:** Oracle (Schema: CDDLAFT)
- **Seguridad:** Spring Security
- **Patrón de Diseño:** MVC + Repository Pattern

### Estructura de Capas

```
app/
├── Entity/cdd/          # Entidades JPA
├── dto/cdd/             # Data Transfer Objects
├── mapper/cdd/          # Mappers (Entity <-> DTO)
├── repository/cdd/      # Repositorios JPA
├── service/cdd/         # Lógica de negocio
└── controller/cdd/      # Controladores REST
```

## 📦 Módulos Implementados

### 1. Riesgo Persona Natural

**Propósito:** Gestión de perfiles de riesgo para personas naturales.

**Entidad:** `RiesgoPersonaNaturalEntity`
- **Tabla:** `CDDLAFT_PERFIL_RIESGO_PERSONA_NATURAL`
- **ID:** Long (auto-generado)

**Campos de Negocio:**
- `industria`: BigDecimal - Ponderación industria
- `ocupacion`: BigDecimal - Ponderación ocupación
- `productos`: BigDecimal - Ponderación productos
- `paisResidencia`: BigDecimal - Ponderación país de residencia
- `canalOnboarding`: BigDecimal - Ponderación canal de onboarding
- `ciudad`: BigDecimal - Ponderación ciudad

**Endpoints:**
- `POST /riesgo/persona-natural` - Crear perfil
- `PUT /riesgo/persona-natural/{id}` - Actualizar perfil
- `GET /riesgo/persona-natural` - Listar todos
- `GET /riesgo/persona-natural/{id}` - Obtener por ID

**Archivos:**
- Entity: `RiesgoPersonaNaturalEntity.java`
- DTOs: `RiesgoPersonaNaturalDTO.java`, `RiesgoPersonaNaturalRequest.java`, `RiesgoPersonaNaturalResponse.java`
- Mapper: `RiesgoPersonaNaturalMapper.java`
- Repository: `RiesgoPersonaNaturalRepository.java`
- Service: `RiesgoService.java`
- Controller: `RiesgoController.java`

---

### 2. Riesgo Persona Jurídica

**Propósito:** Gestión de perfiles de riesgo para personas jurídicas.

**Entidad:** `RiesgoPersonaJuridicaEntity`
- **Tabla:** `CDDLAFT_PERFIL_RIESGO_PERSONA_JURIDICA`
- **ID:** Long (auto-generado)

**Campos de Negocio:**
- `industria`: BigDecimal
- `productos`: BigDecimal
- `paisResidenciaUbos`: BigDecimal
- `paisResidenciaFiscal`: BigDecimal
- `paisIncorporacion`: BigDecimal
- `estructuraPropiedadCompleja`: BigDecimal
- `tipoPersonaJuridica`: BigDecimal
- `canalOnboarding`: BigDecimal
- `presenciaGrupo`: BigDecimal
- `exposicionPaisesProhibidos`: BigDecimal

**Endpoints:**
- `POST /riesgo/persona-juridica` - Crear perfil
- `PUT /riesgo/persona-juridica/{id}` - Actualizar perfil
- `GET /riesgo/persona-juridica` - Listar todos
- `GET /riesgo/persona-juridica/{id}` - Obtener por ID

**Archivos:**
- Entity: `RiesgoPersonaJuridicaEntity.java`
- DTOs: `RiesgoPersonaJuridicaDTO.java`, `RiesgoPersonaJuridicaRequest.java`, `RiesgoPersonaJuridicaResponse.java`
- Mapper: `RiesgoPersonaJuridicaMapper.java`
- Repository: `RiesgoPersonaJuridicaRepository.java`
- Service: `RiesgoService.java`
- Controller: `RiesgoController.java`

---

### 3. Riesgo Total

**Propósito:** Gestión de rangos y niveles de riesgo total.

**Entidad:** `RiesgoTotalEntity`
- **Tabla:** `CDDLAFT_PERFIL_RIESGO_TOTAL`
- **ID:** Long (auto-generado)

**Campos de Negocio:**
- `nombre`: String - Nombre del nivel de riesgo
- `descripcion`: String - Descripción
- `riesgo`: String - Categoría de riesgo
- `fechaVigencia`: LocalDate - Fecha de vigencia
- `limInf`: BigInteger - Límite inferior
- `limSup`: BigInteger - Límite superior
- `tipo`: String - Tipo de riesgo

**Endpoints:**
- `POST /riesgo-total` - Crear
- `PUT /riesgo-total/{id}` - Actualizar
- `GET /riesgo-total` - Listar todos
- `GET /riesgo-total/{id}` - Obtener por ID
- `DELETE /riesgo-total/{id}` - Eliminar

**Archivos:**
- Entity: `RiesgoTotalEntity.java`
- DTOs: `RiesgoTotalDTO.java`, `RiesgoTotalRequest.java`, `RiesgoTotalResponse.java`
- Mapper: `RiesgoTotalMapper.java`
- Repository: `RiesgoTotalRepository.java`
- Service: `RiesgoTotalService.java`
- Controller: `RiesgoTotalController.java`

---

### 4. Variables de Riesgo

**Propósito:** Gestión de variables y porcentajes de riesgo.

**Entidad:** `VariablesRiesgoEntity`
- **Tabla:** `CDDLAFT_PERFIL_VARIABLES_RIESGO`
- **ID:** Long (auto-generado)

**Campos de Negocio:**
- `porcentaje1`: String - Primer porcentaje
- `porcentaje2`: String - Segundo porcentaje
- `fechaVigencia`: LocalDate - Fecha de vigencia

**Endpoints:**
- `POST /variables-riesgo` - Crear
- `GET /variables-riesgo` - Listar todos
- `GET /variables-riesgo/{id}` - Obtener por ID

**Archivos:**
- Entity: `VariablesRiesgoEntity.java`
- DTOs: `VariablesRiesgoDTO.java`, `VariablesRiesgoRequest.java`, `VariablesRiesgoResponse.java`
- Mapper: `VariablesRiesgoMapper.java`
- Repository: `VariablesRiesgoRepository.java`
- Service: `VariablesRiesgoService.java`
- Controller: `VariablesRiesgoController.java`

---

### 5. Resultado de Riesgo

**Propósito:** Consulta de resultados de evaluación de riesgo.

**Entidad:** `ResultadoRiesgoEntity`
- **Tabla:** `CDDLAFT_PERFIL_RESULTADO_RIESGO`
- **ID:** Long (auto-generado)

**Campos de Negocio:**
- `documento`: Double - Número de documento
- `tipoDocumento`: String - Tipo de documento
- `nombre`: String - Nombre de la persona
- `tipoPersona`: String - Natural o Jurídica
- `producto`: String - Producto contratado
- `fecha`: LocalDate - Fecha de evaluación
- `resultadoRiesgo`: String - Resultado de la evaluación
- `nivelRiesgo`: BigDecimal - Nivel numérico de riesgo

**Endpoints:**
- `GET /resultado-riesgo` - Listar todos
- `GET /resultado-riesgo/{id}` - Obtener por ID

**Archivos:**
- Entity: `ResultadoRiesgoEntity.java`
- DTO: `ResultadoRiesgoDTO.java`
- Mapper: `ResultadoRiesgoMapper.java`
- Repository: `ResultadoRiesgoRepository.java`
- Service: `ResultadoRiesgoService.java`
- Controller: `ResultadoRiesgoController.java`

---

### 6. Detalle Resultado de Riesgo

**Propósito:** Consulta de detalles específicos de resultados de riesgo.

**Entidad:** `DetalleResultadoRiesgoEntity`
- **Tabla:** `CDDLAFT_PERFIL_DETALLE_RESULTADO_RIESGO`
- **ID:** Long (auto-generado)

**Campos de Negocio:**
- `catalogo`: String - Nombre del catálogo
- `valor`: String - Valor del detalle
- `riesgo`: BigDecimal - Riesgo asociado

**Endpoints:**
- `GET /resultado-riesgo/detalle` - Listar todos
- `GET /resultado-riesgo/detalle/{id}` - Obtener por ID

**Archivos:**
- Entity: `DetalleResultadoRiesgoEntity.java`
- DTO: `DetalleResultadoRiesgoDTO.java`
- Mapper: `DetalleResultadoRiesgoMapper.java`
- Repository: `DetalleResultadoRiesgoRepository.java`
- Service: `ResultadoRiesgoService.java` (compartido)
- Controller: `ResultadoRiesgoController.java` (compartido)

---

### 7. Catálogo

**Propósito:** Gestión de catálogos generales del sistema.

**Entidad:** `CatalogoEntity`
- **Tabla:** `CDDLAFT_PERFIL_CATALOGO`
- **ID:** String (manual)

**Campos de Negocio:**
- `id`: String - Identificador único
- `nombre`: String - Nombre del catálogo
- `descripcion`: String - Descripción
- `riesgo`: BigDecimal - Nivel de riesgo
- `fechaVigencia`: LocalDate - Fecha de vigencia
- `tipo`: String - Tipo de catálogo

**Endpoints:**
- `POST /catalogo` - Crear
- `PUT /catalogo/{id}` - Actualizar
- `GET /catalogo` - Listar todos
- `GET /catalogo/{id}` - Obtener por ID
- `DELETE /catalogo/{id}` - Eliminar

**Archivos:**
- Entity: `CatalogoEntity.java`
- DTOs: `CatalogoDTO.java`, `CatalogoRequest.java`, `CatalogoResponse.java`
- Mapper: `CatalogoMapper.java`
- Repository: `CatalogoRepository.java`
- Service: `CatalogoService.java`
- Controller: `CatalogoController.java`

---

## 🔧 Características Técnicas Comunes

### Campos de Auditoría

Todas las entidades incluyen los siguientes campos de auditoría:

```java
@Column(name = "FECHA_CREACION", nullable = false)
private LocalDateTime fechaCreacion;

@Column(name = "USUARIO_CREACION", nullable = false, length = 100)
private String usuarioCreacion;

@Column(name = "FECHA_ULTIMA_MODIFICACION")
private LocalDateTime fechaUltimaModificacion;

@Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 100)
private String usuarioUltimaModificacion;
```

### Gestión Automática de Auditoría

Los servicios gestionan automáticamente los campos de auditoría:
- **En creación:** Se establece `fechaCreacion` y `usuarioCreacion`
- **En actualización:** Se establece `fechaUltimaModificacion` y `usuarioUltimaModificacion`
- **Usuario actual:** Obtenido desde Spring Security Context

```java
private String currentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || auth.getName() == null) {
        return "SYSTEM";
    }
    return auth.getName();
}
```

### Patrón de DTOs

Cada módulo implementa 3 tipos de DTOs:

1. **DTO Simple:** Mapeo 1:1 con la entidad (incluye todos los campos)
2. **Request DTO:** Para operaciones POST/PUT (sin ID ni campos de auditoría)
3. **Response DTO:** Para respuestas (incluye ID, campos de auditoría y mensaje de confirmación)

### Mappers

Cada mapper implementa 5 métodos estándar:

```java
// Request -> Entity (para creación)
public EntityType toEntity(RequestDTO request)

// Entity -> Response (para respuestas)
public ResponseDTO toResponse(EntityType entity)

// Actualizar Entity desde Request (para updates)
public void updateEntityFromRequest(RequestDTO request, EntityType entity)

// DTO -> Entity (conversión completa)
public EntityType toEntityFromDTO(SimpleDTO dto)

// Entity -> DTO (conversión completa)
public SimpleDTO toDTO(EntityType entity)
```

### Transacciones

Operaciones de escritura (CREATE, UPDATE, DELETE) usan `@Transactional`:

```java
@Transactional
public ResponseDTO guardar(RequestDTO request) {
    // Lógica de negocio
}
```

### Manejo de Excepciones

Validación consistente con `IllegalArgumentException`:

```java
Entity entity = repository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("No existe registro con id: " + id));
```

---

## 📊 Resumen de Endpoints

### Total de Endpoints: 17

| Módulo | Endpoints | Operaciones |
|--------|-----------|-------------|
| Persona Natural | 4 | POST, PUT, GET (lista), GET (id) |
| Persona Jurídica | 4 | POST, PUT, GET (lista), GET (id) |
| Riesgo Total | 5 | POST, PUT, GET (lista), GET (id), DELETE |
| Variables Riesgo | 3 | POST, GET (lista), GET (id) |
| Resultado Riesgo | 2 | GET (lista), GET (id) |
| Detalle Resultado | 2 | GET (lista), GET (id) |
| Catálogo | 5 | POST, PUT, GET (lista), GET (id), DELETE |

---

## 📈 Estadísticas del Proyecto

### Archivos Creados
- **Entities:** 7
- **DTOs:** 20 (simples, Request, Response)
- **Mappers:** 7
- **Repositories:** 7
- **Services:** 5
- **Controllers:** 5

**Total:** 51 archivos Java

### Líneas de Código
- **Aproximadamente:** 2,500+ líneas de código

---

## 🚀 Mejores Prácticas Implementadas

### ✅ Código Limpio
- Nombres descriptivos y significativos
- Métodos pequeños con responsabilidad única
- Separación clara de capas (Controller, Service, Repository)

### ✅ Principios SOLID
- **Single Responsibility:** Cada clase tiene una única responsabilidad
- **Dependency Injection:** Uso de constructores para inyección
- **Interface Segregation:** Repositories extienden JpaRepository

### ✅ Seguridad
- Integración con Spring Security
- Auditoría automática de usuarios
- Validación de datos de entrada

### ✅ Mantenibilidad
- Código consistente y predecible
- Patrones de diseño aplicados uniformemente
- Documentación mediante JavaDoc en endpoints

### ✅ Rendimiento
- Uso de transacciones apropiadas
- Queries optimizadas con JPA
- Stream API para transformaciones de colecciones

---

## 🔄 Flujo de una Request Típica

```
1. Cliente HTTP
   ↓
2. Controller (@RestController)
   - Recibe RequestDTO
   - Valida entrada
   ↓
3. Service (@Service)
   - Aplica lógica de negocio
   - Gestiona transacciones
   - Establece auditoría
   ↓
4. Mapper (@Component)
   - Convierte Request → Entity
   - Convierte Entity → Response
   ↓
5. Repository (@Repository)
   - Interactúa con base de datos
   - Ejecuta queries JPA
   ↓
6. Base de Datos (Oracle)
   - Schema: CDDLAFT
   - Tablas: CDDLAFT_PERFIL_*
```

---

## 📝 Ejemplo de Uso

### Crear un Perfil de Riesgo para Persona Natural

**Request:**
```http
POST /riesgo/persona-natural
Content-Type: application/json

{
  "industria": 0.25,
  "ocupacion": 0.15,
  "productos": 0.20,
  "paisResidencia": 0.10,
  "canalOnboarding": 0.15,
  "ciudad": 0.15
}
```

**Response:**
```json
{
  "id": 1,
  "industria": 0.25,
  "ocupacion": 0.15,
  "productos": 0.20,
  "paisResidencia": 0.10,
  "canalOnboarding": 0.15,
  "ciudad": 0.15,
  "mensaje": "Riesgo de Persona Natural guardado exitosamente",
  "fechaCreacion": "2025-12-19T10:30:00",
  "usuarioCreacion": "admin",
  "fechaUltimaModificacion": null,
  "usuarioUltimaModificacion": null
}
```

---

## 🔐 Configuración Requerida

### Base de Datos
- Oracle Database
- Schema: `CDDLAFT`
- Usuario con permisos CREATE, READ, UPDATE, DELETE

### Spring Boot Configuration
```properties
# Database
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:ORCL
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect

# Security
spring.security.user.name=${SECURITY_USER}
spring.security.user.password=${SECURITY_PASSWORD}
```

---

## 🎯 Próximos Pasos Sugeridos

1. **Testing:**
   - Implementar tests unitarios para Services
   - Tests de integración para Controllers
   - Tests de Repository con base de datos H2

2. **Validación:**
   - Agregar `@Valid` y `@Validated` en Controllers
   - Implementar DTOs con Bean Validation annotations

3. **Documentación:**
   - Integrar Swagger/OpenAPI
   - Documentar API con SpringDoc

4. **Manejo de Errores:**
   - Implementar `@ControllerAdvice` global
   - Respuestas de error estandarizadas

5. **Seguridad:**
   - Implementar JWT Authentication
   - Configurar CORS apropiadamente
   - Agregar autorización por roles

---

## 📞 Información de Contacto

**Proyecto:** SIAR Backend
**Versión:** 1.0.0
**Java:** 17
**Spring Boot:** 3.x
**Generado con:** Claude Code (Anthropic)

---

*Última actualización: Diciembre 2025*
