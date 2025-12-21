// A partir de este DTO crea un request y response (el response solo para indicar que la operacion de guardado se realizo correctamente)
// Ten en cuenta realizar el mapper para el request con el dto y lo mismo para la respuesta
// Crea el controlador RiesgoController si no existe con las peticiones rest para guardar y consultar esta informacion que esta en el DTO
// Crea el servicio igualmente para las mismas operaciones, no es necesario realizar la logica completa del service necesitamos la estructura

public class RiesgoPersonaNaturalDTO {

    private BigDecimal industria;
    private BigDecimal ocupacion;
    private BigDecimal productos;
    private BigDecimal paisResidencia;
    private BigDecimal canalOnboarding;
    private BigDecimal ciudad;

}

// A partir de este DTO crea un request y response (el response solo para indicar que la operacion de guardado se realizo correctamente)
// Ten en cuenta realizar el mapper para el request con el dto y lo mismo para la respuesta
// Crea el controlador RiesgoController si no existe con las peticiones rest para guardar y consultar esta informacion que esta en el DTO
// Crea el servicio igualmente para las mismas operaciones, no es necesario realizar la logica completa del service necesitamos la estructura

public class RiesgoPersonaJuridicaDTO {

    private BigDecimal industria;
    private BigDecimal productos;
    private BigDecimal paisResidenciaUbos;
    private BigDecimal paisResidenciaFiscal;
    private BigDecimal paisIncorporacion;
    private BigDecimal estructuraPropiedadCompleja;
    private BigDecimal tipoPersonaJuridica;
    private BigDecimal canalOnboarding;
    private BigDecimal presenciaGrupo;
    private BigDecimal exposicionPaisesProhibidos;
}

Esto es lo que necesito reflejar en las apis:


Listo. Te dejo un CRUD completo (Spring Boot / JPA) para el catálogo PAÍS – PROBABILIDAD usando las entidades que armamos aquí:

CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD (PK compuesta: TIPO_PAIS + CODIGO_PAIS)

CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD_AUDITORIA (PK secuencial)

y para resolver el descripcion del país: CDDLAFT_PERFIL_RIESGO_PAIS


Incluye manejo de:

FECHA_CREACION, USUARIO_CREACION

FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION

Upsert (POST sirve como PUT)

Auditoría automática en create/update/delete



---

1) DTOs (request/response)

package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CatalogoPaisProbabilidadUpsertRequest {
    private String tipo;          // -> TIPO_PAIS
    private String id;            // -> CODIGO_PAIS
    private BigDecimal riesgo;    // -> PROBABILIDAD_RIESGO
    private LocalDate fechaVigencia;

    // getters/setters
}

package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CatalogoItemResponse {
    private String id;              // CODIGO_PAIS
    private String nombre;          // normalmente igual a id (o el que uses en front)
    private String descripcion;     // viene de CDDLAFT_PERFIL_RIESGO_PAIS.DESCRIPCION_PAIS
    private BigDecimal riesgo;      // PROBABILIDAD_RIESGO
    private LocalDate fechaVigencia;
    private String tipo;            // TIPO_PAIS

    // getters/setters
}


---

2) Repositories

package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.repository;

import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.entity.PerfilRiesgoPaisProbabilidadEntity;
import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.entity.PerfilRiesgoPaisProbabilidadId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilRiesgoPaisProbabilidadRepository
        extends JpaRepository<PerfilRiesgoPaisProbabilidadEntity, PerfilRiesgoPaisProbabilidadId> {

    List<PerfilRiesgoPaisProbabilidadEntity> findByTipoPais(String tipoPais);
}

package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.repository;

import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.entity.PerfilRiesgoPaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRiesgoPaisRepository extends JpaRepository<PerfilRiesgoPaisEntity, String> {
}

> Auditoría (ojo: aquí conviene que el @Id sea @GeneratedValue con sequence; si tu tabla ya tiene sequence, la configuras en la Entity).



package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.repository;

import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.entity.PerfilRiesgoPaisProbabilidadAuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRiesgoPaisProbabilidadAuditoriaRepository
        extends JpaRepository<PerfilRiesgoPaisProbabilidadAuditoriaEntity, Long> {
}


---

3) Service (CRUD + auditoría + campos de control)

package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.service;

import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.dto.CatalogoItemResponse;
import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.dto.CatalogoPaisProbabilidadUpsertRequest;
import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.entity.*;
import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.repository.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CatalogoPaisProbabilidadService {

    private final PerfilRiesgoPaisProbabilidadRepository probRepo;
    private final PerfilRiesgoPaisRepository paisRepo;
    private final PerfilRiesgoPaisProbabilidadAuditoriaRepository auditRepo;

    public CatalogoPaisProbabilidadService(
            PerfilRiesgoPaisProbabilidadRepository probRepo,
            PerfilRiesgoPaisRepository paisRepo,
            PerfilRiesgoPaisProbabilidadAuditoriaRepository auditRepo
    ) {
        this.probRepo = probRepo;
        this.paisRepo = paisRepo;
        this.auditRepo = auditRepo;
    }

    public List<CatalogoItemResponse> listar(String tipoPais) {
        var rows = (tipoPais == null || tipoPais.isBlank())
                ? probRepo.findAll()
                : probRepo.findByTipoPais(tipoPais);

        return rows.stream().map(this::toResponse).toList();
    }

    @Transactional
    public CatalogoItemResponse upsert(CatalogoPaisProbabilidadUpsertRequest req) {
        if (req.getTipo() == null || req.getTipo().isBlank())
            throw new IllegalArgumentException("tipo (TIPO_PAIS) es requerido");
        if (req.getId() == null || req.getId().isBlank())
            throw new IllegalArgumentException("id (CODIGO_PAIS) es requerido");
        if (req.getRiesgo() == null)
            throw new IllegalArgumentException("riesgo (PROBABILIDAD_RIESGO) es requerido");
        if (req.getFechaVigencia() == null)
            throw new IllegalArgumentException("fechaVigencia (FECHA_VIGENCIA) es requerido");

        var now = LocalDateTime.now();
        var user = currentUser();

        var id = new PerfilRiesgoPaisProbabilidadId();
        id.tipoPais = req.getTipo();
        id.codigoPais = req.getId();

        var existingOpt = probRepo.findById(id);

        PerfilRiesgoPaisProbabilidadEntity entity;
        if (existingOpt.isPresent()) {
            entity = existingOpt.get();
            entity.setProbabilidadRiesgo(req.getRiesgo());
            entity.setFechaVigencia(req.getFechaVigencia());
            entity.setFechaUltimaModificacion(now);
            entity.setUsuarioUltimaModificacion(user);

            // auditoría snapshot (update)
            auditRepo.save(snapshotAudit(entity));

        } else {
            entity = new PerfilRiesgoPaisProbabilidadEntity();
            entity.setTipoPais(req.getTipo());
            entity.setCodigoPais(req.getId());
            entity.setProbabilidadRiesgo(req.getRiesgo());
            entity.setFechaVigencia(req.getFechaVigencia());

            entity.setFechaCreacion(now);
            entity.setUsuarioCreacion(user);

            // en creación, normalmente no hay ultima_modificacion
            entity.setFechaUltimaModificacion(null);
            entity.setUsuarioUltimaModificacion(null);

            probRepo.save(entity);

            // auditoría snapshot (create)
            auditRepo.save(snapshotAudit(entity));
        }

        // si era update y no estaba guardado explícitamente, JPA lo flush en commit
        return toResponse(entity);
    }

    @Transactional
    public void eliminar(String tipoPais, String codigoPais) {
        var id = new PerfilRiesgoPaisProbabilidadId();
        id.tipoPais = tipoPais;
        id.codigoPais = codigoPais;

        var entity = probRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe registro para tipo=" + tipoPais + " id=" + codigoPais));

        // para auditoría de borrado: guardo snapshot con ultima modificación = ahora
        var now = LocalDateTime.now();
        var user = currentUser();
        entity.setFechaUltimaModificacion(now);
        entity.setUsuarioUltimaModificacion(user);
        auditRepo.save(snapshotAudit(entity));

        probRepo.delete(entity);
    }

    private CatalogoItemResponse toResponse(PerfilRiesgoPaisProbabilidadEntity e) {
        var resp = new CatalogoItemResponse();
        resp.setTipo(e.getTipoPais());
        resp.setId(e.getCodigoPais());
        resp.setNombre(e.getCodigoPais());

        var paisDesc = paisRepo.findById(e.getCodigoPais())
                .map(PerfilRiesgoPaisEntity::getDescripcionPais)
                .orElse(null);

        resp.setDescripcion(paisDesc);
        resp.setRiesgo(e.getProbabilidadRiesgo());
        resp.setFechaVigencia(e.getFechaVigencia());
        return resp;
    }

    private PerfilRiesgoPaisProbabilidadAuditoriaEntity snapshotAudit(PerfilRiesgoPaisProbabilidadEntity e) {
        var a = new PerfilRiesgoPaisProbabilidadAuditoriaEntity();

        // si tu auditoría tiene @GeneratedValue, NO seteas id aquí
        a.setTipoPais(e.getTipoPais());
        a.setCodigoPais(e.getCodigoPais());
        a.setProbabilidadRiesgo(e.getProbabilidadRiesgo());
        a.setFechaVigencia(e.getFechaVigencia());

        a.setFechaCreacion(e.getFechaCreacion());
        a.setUsuarioCreacion(e.getUsuarioCreacion());
        a.setFechaUltimaModificacion(e.getFechaUltimaModificacion());
        a.setUsuarioUltimaModificacion(e.getUsuarioUltimaModificacion());

        return a;
    }

    private String currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getName() == null) return "SYSTEM";
        return auth.getName();
    }
}


---

4) Controller REST

package com.santander.bnc.bsn023.bncbsn023siarbackendj.app.controller;

import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.dto.CatalogoItemResponse;
import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.dto.CatalogoPaisProbabilidadUpsertRequest;
import com.santander.bnc.bsn023.bncbsn023siarbackendj.app.service.CatalogoPaisProbabilidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogos/pais-probabilidad")
public class CatalogoPaisProbabilidadController {

    private final CatalogoPaisProbabilidadService service;

    public CatalogoPaisProbabilidadController(CatalogoPaisProbabilidadService service) {
        this.service = service;
    }

    // GET /catalogos/pais-probabilidad?tipo=UBO  (opcional)
    @GetMapping
    public ResponseEntity<List<CatalogoItemResponse>> listar(@RequestParam(name = "tipo", required = false) String tipo) {
        return ResponseEntity.ok(service.listar(tipo));
    }

    // POST (sirve como PUT / upsert)
    @PostMapping
    public ResponseEntity<CatalogoItemResponse> upsert(@RequestBody CatalogoPaisProbabilidadUpsertRequest req) {
        return ResponseEntity.ok(service.upsert(req));
    }

    // DELETE /catalogos/pais-probabilidad/{tipo}/{id}
    @DeleteMapping("/{tipo}/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("tipo") String tipo, @PathVariable("id") String id) {
        service.eliminar(tipo, id);
        return ResponseEntity.noContent().build();
    }
}


---

5) Nota importante sobre la auditoría (ID secuencial)

Tu tabla auditoría tiene ID_CONSECUTIVO_... tipo NUMBER(38,0). Lo ideal es en la entity auditoría:

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAIS_PROB_AUD")
@SequenceGenerator(
    name = "SEQ_PAIS_PROB_AUD",
    sequenceName = "CDDLAFT.SEQ_PAIS_PROB_AUD", // AJUSTA AL NOMBRE REAL
    allocationSize = 1
)
@Column(name = "ID_CONSECUTIVO_PAIS_PROBABILIDAD_AUDITORIA", nullable = false)
private Long id;

Si en tu esquema el nombre del sequence es otro, me lo pasas y lo dejo exacto.


---

¿Siguiente paso?

Con esto ya tienes el controller completo para “País Probabilidad” (incluye auditoría y campos de control).
Si me confirmas cuál catálogo quieres que sea el siguiente (Industria, Ocupación, Producto, Canal Onboarding, Ciudad/Depto, etc.), lo replico igual con el mismo patrón, respetando los campos de creación/modificación y la auditoría correspondiente.


--aquí--

# cdd

Lista url SIAR (CDD): 

 { path: "catalogos", component: ConfiguracionCatalogosComponent }, 
  { path: "riesgo", component: ConfiguracionRiesgoComponent },
  { path: "variables-riesgo", component: ConfiguracionvariablesComponent },
  { path: "riesgo-total", component: ConfiguraciontotalComponent },
  { path: "resultado-riesgo", component: ConfiguracionPersonasComponent },

http://localhost:4200/#/

1.
URL: /catalogos  
// Tabla CDDLAFT_INDICE_CATALOGOS
GET
catalogos: {'Industria': { 
// Tabla CDDLAFT_PERFIL_RIESGO_INDUSTRIA
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Ocupación': {
//Tabla CDDLAFT_PERFIL_RIESGO_OCUPACION
	data: {
		0:{
//Observación: el id debe ser string para poder manejar la estructura, la cual debe ser del siguiente modo:
Código  Descripción
EMP 	EMPLEADO
REN 	RENTISTA
PEN 	PENSIONADO
IND 	IDEPENDIENTE
DES 	DESEMPLEADO
EST 	ESTUDIANTE
Definido por el usuario, si se requiere uno nuevo debe ser agregado manualmente pero principalmente se maneja esta estructura.

    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Productos': {
//Tabla CDDLAFT_PERFIL_RIESGO_PRODUCTO
	data: {
//Tipos de datos recibidos para el campo producto id:
Código  Descripción
PRO 	Prospera
FIN 	Financing
BIZ 	Bizagi Banco
CDT 	CDT
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Pais': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS
	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Canal de Onboarding': {
// Tabla CDDLAFT_PERFIL_RIESGO_CANAL_ONBOARDING
	data: {
		0:{
    			id: 'string', 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'ciudad': {
// Tabla CDDLAFT_PERFIL_RIESGO_DEPARTAMENTO_CIUDAD, CDDLAFT_PERFIL_RIESGO_CIUDADES, CDDLAFT_PERFIL_RIESGO_DEPARTAMENTOS
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'Pais de residencia de los UBOs': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS

	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'Pais de residencia fiscal': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS

	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
},'Pais de incorporacion': {
// Tabla CDDLAFT_PERFIL_RIESGO_PAIS_PROBABILIDAD, CDDLAFT_PERFIL_RIESGO_PAIS, CDDLAFT_PERFIL_RIESGO_TIPO_PAIS

	data: {
		0:{
//Lo mismo el banco maneja los campos id de paises por string
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Estructura de propiedad compleja': {
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Tipo de persona jurídica': {
// Tabla CDDLAFT_PERFIL_RIESGO_TIPO_PERSONA_JURIDICA
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Presencia del Grupo': {
// Tabla CDDLAFT_PERFIL_RIESGO_GRUPOS
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}, 'Exposición a países prohibídos y Altamente restringidos': {

	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}}
POST:
catalogos: {'Industria': {
	data: {
		0:{
    			id: string, 
			nombre: 'string', 
			descripcion: 'string', 
			riesgo: 'decimal', 
			fechaVigencia:  Date, 
			tipo: "string" },
  		},
		...
}}
Por cada uno se requiere un guardado y eliminado, el mismo post puede servir como put, los campos de id se manejan como string por el requerimiento del banco y se planteó dejar todos como string.
2.
📋 RESUMEN COMPLETO DE LA IMPLEMENTACIÓN

  ✅ API de Riesgo - Completamente Implementada

  Se han creado 2 módulos de API REST para gestionar perfiles de riesgo:
  1. Riesgo Persona Natural
  2. Riesgo Persona Jurídica

  ---
  📂 UBICACIÓN DE ARCHIVOS

  1. Entidades JPA (app/Entity/cdd/)

  - RiesgoPersonaNaturalEntity.java - Mapea tabla CDDLAFT_PERFIL_RIESGO_PERSONA_NATURAL
  - RiesgoPersonaJuridicaEntity.java - Mapea tabla CDDLAFT_PERFIL_RIESGO_PERSONA_JURIDICA

  Campos de Persona Natural:
  - industria, ocupacion, productos, paisResidencia, canalOnboarding, ciudad
  - Campos de auditoría: fechaCreacion, usuarioCreacion, fechaUltimaModificacion, usuarioUltimaModificacion

  Campos de Persona Jurídica:
  - industria, productos, paisResidenciaUbos, paisResidenciaFiscal, paisIncorporacion, estructuraPropiedadCompleja, tipoPersonaJuridica, canalOnboarding, presenciaGrupo, exposicionPaisesProhibidos
  - Campos de auditoría (iguales que Persona Natural)

  ---
  2. DTOs (app/dto/cdd/)

  Para Persona Natural:
  - RiesgoPersonaNaturalDTO.java - DTO completo con todos los campos
  - RiesgoPersonaNaturalRequest.java - Para POST/PUT (sin ID, sin auditoría)
  - RiesgoPersonaNaturalResponse.java - Para respuestas (con ID, auditoría y mensaje)

  Para Persona Jurídica:
  - RiesgoPersonaJuridicaDTO.java - DTO completo con todos los campos
  - RiesgoPersonaJuridicaRequest.java - Para POST/PUT (sin ID, sin auditoría)
  - RiesgoPersonaJuridicaResponse.java - Para respuestas (con ID, auditoría y mensaje)

  ---
  3. Mappers (app/mapper/cdd/)

  - RiesgoPersonaNaturalMapper.java
  - RiesgoPersonaJuridicaMapper.java

  Métodos implementados en cada mapper:
  1. toEntity(Request) - Convierte Request → Entity (para crear)
  2. toResponse(Entity) - Convierte Entity → Response (para responder)
  3. updateEntityFromRequest(Request, Entity) - Actualiza Entity desde Request
  4. toEntityFromDTO(DTO) - Convierte DTO → Entity
  5. toDTO(Entity) - Convierte Entity → DTO

  ---
  4. Repositories (app/repository/cdd/)

  - RiesgoPersonaNaturalRepository.java - Extiende JpaRepository<RiesgoPersonaNaturalEntity, Long>
  - RiesgoPersonaJuridicaRepository.java - Extiende JpaRepository<RiesgoPersonaJuridicaEntity, Long>

  ---
  5. Servicio (app/service/cdd/)

  - RiesgoService.java - Service unificado para ambos módulos

  Métodos para Persona Natural:
  - guardarPersonaNatural(request) - Crea nuevo registro
  - actualizarPersonaNatural(id, request) - Actualiza registro existente
  - listarPersonaNatural() - Lista todos los registros
  - obtenerPersonaNaturalPorId(id) - Obtiene un registro por ID

  Métodos para Persona Jurídica:
  - guardarPersonaJuridica(request) - Crea nuevo registro
  - actualizarPersonaJuridica(id, request) - Actualiza registro existente
  - listarPersonaJuridica() - Lista todos los registros
  - obtenerPersonaJuridicaPorId(id) - Obtiene un registro por ID

  Características del servicio:
  - Gestión automática de auditoría (usuario y fecha)
  - Transacciones con @Transactional
  - Obtiene usuario actual desde Spring Security Context
  - Fallback a "SYSTEM" si no hay usuario autenticado

  ---
  6. Controlador (app/controller/cdd/)

  - RiesgoController.java - Controller unificado en /riesgo

  ---
  🌐 ENDPOINTS IMPLEMENTADOS (8 endpoints)

  Persona Natural (4 endpoints)

  1. POST /riesgo/persona-natural
    - Crear nuevo perfil de riesgo
    - Body: RiesgoPersonaNaturalRequest
    - Response: RiesgoPersonaNaturalResponse (HTTP 201)
  2. PUT /riesgo/persona-natural/{id}
    - Actualizar perfil existente
    - Path: id (Long)
    - Body: RiesgoPersonaNaturalRequest
    - Response: RiesgoPersonaNaturalResponse (HTTP 200)
  3. GET /riesgo/persona-natural
    - Listar todos los perfiles
    - Response: List<RiesgoPersonaNaturalResponse> (HTTP 200)
  4. GET /riesgo/persona-natural/{id}
    - Obtener perfil por ID
    - Path: id (Long)
    - Response: RiesgoPersonaNaturalResponse (HTTP 200)

  Persona Jurídica (4 endpoints)

  5. POST /riesgo/persona-juridica
    - Crear nuevo perfil de riesgo
    - Body: RiesgoPersonaJuridicaRequest
    - Response: RiesgoPersonaJuridicaResponse (HTTP 201)
  6. PUT /riesgo/persona-juridica/{id}
    - Actualizar perfil existente
    - Path: id (Long)
    - Body: RiesgoPersonaJuridicaRequest
    - Response: RiesgoPersonaJuridicaResponse (HTTP 200)
  7. GET /riesgo/persona-juridica
    - Listar todos los perfiles
    - Response: List<RiesgoPersonaJuridicaResponse> (HTTP 200)
  8. GET /riesgo/persona-juridica/{id}
    - Obtener perfil por ID
    - Path: id (Long)
    - Response: RiesgoPersonaJuridicaResponse (HTTP 200)

  ---
  📝 EJEMPLOS DE USO

  Crear Persona Natural:

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

  Respuesta:
  {
    "id": 1,
    "industria": 0.25,
    "ocupacion": 0.15,
    "productos": 0.20,
    "paisResidencia": 0.10,
    "canalOnboarding": 0.15,
    "ciudad": 0.15,
    "mensaje": "Riesgo de Persona Natural guardado exitosamente",
    "fechaCreacion": "2025-12-21T10:30:00",
    "usuarioCreacion": "admin",
    "fechaUltimaModificacion": null,
    "usuarioUltimaModificacion": null
  }

  Crear Persona Jurídica:

  POST /riesgo/persona-juridica
  Content-Type: application/json

  {
    "industria": 0.15,
    "productos": 0.10,
    "paisResidenciaUbos": 0.12,
    "paisResidenciaFiscal": 0.08,
    "paisIncorporacion": 0.10,
    "estructuraPropiedadCompleja": 0.15,
    "tipoPersonaJuridica": 0.10,
    "canalOnboarding": 0.10,
    "presenciaGrupo": 0.05,
    "exposicionPaisesProhibidos": 0.05
  }

  Respuesta:
  {
    "id": 1,
    "industria": 0.15,
    "productos": 0.10,
    "paisResidenciaUbos": 0.12,
    "paisResidenciaFiscal": 0.08,
    "paisIncorporacion": 0.10,
    "estructuraPropiedadCompleja": 0.15,
    "tipoPersonaJuridica": 0.10,
    "canalOnboarding": 0.10,
    "presenciaGrupo": 0.05,
    "exposicionPaisesProhibidos": 0.05,
    "mensaje": "Riesgo de Persona Jurídica guardado exitosamente",
    "fechaCreacion": "2025-12-21T10:30:00",
    "usuarioCreacion": "admin",
    "fechaUltimaModificacion": null,
    "usuarioUltimaModificacion": null
  }

  ---
  🔧 ARQUITECTURA Y FLUJO

  Cliente HTTP
      ↓
  RiesgoController (@RestController /riesgo)
      ↓
  RiesgoService (@Service)
      ↓
  RiesgoPersonaNaturalMapper / RiesgoPersonaJuridicaMapper
      ↓
  RiesgoPersonaNaturalRepository / RiesgoPersonaJuridicaRepository
      ↓
  Base de Datos Oracle (Schema: CDDLAFT)

  Flujo de una petición POST:
  1. Controller recibe Request
  2. Service llama a Mapper.toEntity(request)
  3. Service establece campos de auditoría (fechaCreacion, usuarioCreacion)
  4. Repository guarda en BD
  5. Service llama a Mapper.toResponse(entity)
  6. Service agrega mensaje de confirmación
  7. Controller devuelve Response al cliente

  Flujo de una petición PUT:
  1. Controller recibe id y Request
  2. Service busca Entity por ID en Repository
  3. Service llama a Mapper.updateEntityFromRequest(request, entity)
  4. Service actualiza campos de auditoría (fechaUltimaModificacion, usuarioUltimaModificacion)
  5. Repository guarda cambios
  6. Service llama a Mapper.toResponse(entity)
  7. Controller devuelve Response actualizado

  ---
  ✅ CARACTERÍSTICAS IMPLEMENTADAS

  1. Auditoría automática - Tracking de quién y cuándo crea/modifica
  2. Transacciones - Operaciones atómicas con @Transactional
  3. Validación - Lanza IllegalArgumentException si no encuentra registro
  4. Seguridad - Integración con Spring Security para obtener usuario actual
  5. Separación de responsabilidades - Patrón MVC + Repository
  6. Mapeo limpio - DTOs separados para Request/Response
  7. Compatibilidad Java 17 - Usando Jakarta EE (no javax)

  ---
  📦 RESUMEN DE ARCHIVOS CREADOS

  | Tipo         | Cantidad    | Ubicación           |
  |--------------|-------------|---------------------|
  | Entities     | 2           | app/Entity/cdd/     |
  | DTOs         | 6           | app/dto/cdd/        |
  | Mappers      | 2           | app/mapper/cdd/     |
  | Repositories | 2           | app/repository/cdd/ |
  | Services     | 1           | app/service/cdd/    |
  | Controllers  | 1           | app/controller/cdd/ |
  | TOTAL        | 14 archivos |                     |

  ---
  🚀 LISTO PARA COPIAR AL PROYECTO PRINCIPAL

  Todos los archivos están ubicados en:
  C:\Users\USER\Desktop\SIAR-Back\app\

  Puedes copiar toda la estructura de carpetas app/ a tu proyecto principal de Spring Boot. Los imports están usando:
  - jakarta.persistence.* (Java 17 compatible)
  - org.springframework.*
  - java.math.BigDecimal
  - java.time.LocalDateTime

  Nota: Como mencionaste que es solo una parte del proyecto, asegúrate de que tu proyecto principal tenga las dependencias necesarias en el pom.xml o build.gradle:  
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Security
  - Driver JDBC de Oracle

3.
URL: /variables-riesgo
get-post
// Tabla CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE, CDDLAFT_PERFIL_TIPO_VARIABLE, CDDLAFT_PERFIL_GRUPO_VARIABLE
onboarding-ongoing: {
      porcentaje1: string,
      porcentaje2: string,
      fechaVigencia: date
}
4.
URL: /riesgo-total
get-post-delete
// Tabla CDDLAFT_PERFIL_RIESGO_CATALOGOS, CDDLAFT_INDICE_CATALOGOS, 
riesgo-total: {
  id: number;
  nombre: string;
  descripcion: string;
  riesgo: string;
  fechaVigencia: Date;
  limInf: string;
  limSup: string
  tipo: string
}
5.
URL: /resultado-riesgo
get
// Tabla CDDLAFT_PERFIL_RIESGO_NIVEL_RIESGO
resultado-riesgo:{
	id: number
	documento: 'number',
	tipoDocumento: 'string', 
	nombre: 'string', 
	tipoPersona: 'string', 
	producto: 'string', 
	fecha: 'date', 
	resultadoRiesgo: 'string', 
	nivelRiesgo: 'number'
}
get 
Informacion adicional:
por id de resultado-riesgo
id:{
   0:{
	Catálogo: string,
	Valor: string,
	Riesgo: number
    }...
}
 
