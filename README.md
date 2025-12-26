https://teams.microsoft.com/l/meetup-join/19%3ameeting_MzAzN2M0MTAtMDkxNS00MzAyLWIzNzktNDVkMGE0NzY0NzYx%40thread.v2/0?context=%7b%22Tid%22%3a%2235595a02-4d6d-44ac-99e1-f9ab4cd872db%22%2c%22Oid%22%3a%2257dbd4af-7422-4d95-a998-95526de057c9%22%7d



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
        ---
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
        \app\

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
        ---
3.
        ---
        📋 RESUMEN COMPLETO - API DE VARIABLES DE RIESGO
        ✅ Implementación Completa y Lista para Usar
        ---
        📂 UBICACIÓN DE ARCHIVOS

        Todos los archivos están en:
        app\

        1. Entidad JPA (app/Entity/cdd/)

        Archivo: VariablesRiesgoEntity.java
        - Tabla: CDDLAFT_PERFIL_VARIABLES_RIESGO
        - Schema: CDDLAFT
        - ID: Long (auto-generado con @GeneratedValue)

        Campos de Negocio:
        - porcentaje1: String (length 50)
        - porcentaje2: String (length 50)
        - fechaVigencia: LocalDate (not null)

        Campos de Auditoría:
        - fechaCreacion: LocalDateTime (not null)
        - usuarioCreacion: String (not null, length 100)
        - fechaUltimaModificacion: LocalDateTime
        - usuarioUltimaModificacion: String (length 100)

        ---
        1. DTOs (app/dto/cdd/)

        VariablesRiesgoDTO.java - DTO completo
        - Incluye: id, porcentaje1, porcentaje2, fechaVigencia
        - Incluye campos de auditoría completos

        VariablesRiesgoRequest.java - Para POST
        - Campos: porcentaje1, porcentaje2, fechaVigencia
        - Sin ID, sin campos de auditoría

        VariablesRiesgoResponse.java - Para respuestas
        - Incluye: id, porcentaje1, porcentaje2, fechaVigencia
        - Incluye: mensaje (String)
        - Incluye campos de auditoría completos

        ---
        1. Mapper (app/mapper/cdd/)

        Archivo: VariablesRiesgoMapper.java

        Métodos implementados:
        2. toEntity(Request) - Convierte Request → Entity (para crear)
        3. toResponse(Entity) - Convierte Entity → Response (para responder)
        4. updateEntityFromRequest(Request, Entity) - Actualiza Entity desde Request
        5. toEntityFromDTO(DTO) - Convierte DTO → Entity
        6. toDTO(Entity) - Convierte Entity → DTO

        ---
        7. Repository (app/repository/cdd/)

        Archivo: VariablesRiesgoRepository.java
        - Interfaz que extiende JpaRepository<VariablesRiesgoEntity, Long>
        - Proporciona métodos CRUD automáticos

        ---
        1. Servicio (app/service/cdd/)

        Archivo: VariablesRiesgoService.java

        Métodos implementados:
        2. guardar(request) - Crea nuevo registro con auditoría automática
        3. listar() - Lista todos los registros
        4. obtenerPorId(id) - Obtiene un registro por ID

        Características:
        - Gestión automática de auditoría (usuario y fecha de creación)
        - Transacciones con @Transactional
        - Obtiene usuario desde Spring Security Context
        - Fallback a "SYSTEM" si no hay usuario autenticado
        - Validación con IllegalArgumentException

        ---
        1. Controlador (app/controller/cdd/)

        Archivo: VariablesRiesgoController.java
        - Base URL: /variables-riesgo
        - Anotado con @RestController

        ---
        🌐 ENDPOINTS IMPLEMENTADOS (3 endpoints)

        1. POST /variables-riesgo

        Descripción: Guardar nuevas Variables de Riesgo

        Request Body: VariablesRiesgoRequest
        {
            "porcentaje1": "20",
            "porcentaje2": "80",
            "fechaVigencia": "2025-01-01"
        }

        Response: VariablesRiesgoResponse (HTTP 201 CREATED)
        {
            "id": 1,
            "porcentaje1": "20",
            "porcentaje2": "80",
            "fechaVigencia": "2025-01-01",
            "mensaje": "Variables de Riesgo guardadas exitosamente",
            "fechaCreacion": "2025-12-21T11:30:00",
            "usuarioCreacion": "admin",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
        }

        ---
        2. GET /variables-riesgo

        Descripción: Listar todas las Variables de Riesgo

        Response: List<VariablesRiesgoResponse> (HTTP 200 OK)
        [
            {
            "id": 1,
            "porcentaje1": "20",
            "porcentaje2": "80",
            "fechaVigencia": "2025-01-01",
            "fechaCreacion": "2025-12-21T11:30:00",
            "usuarioCreacion": "admin",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            },
            {
            "id": 2,
            "porcentaje1": "30",
            "porcentaje2": "70",
            "fechaVigencia": "2025-02-01",
            "fechaCreacion": "2025-12-21T12:00:00",
            "usuarioCreacion": "admin",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            }
        ]

        ---
        3. GET /variables-riesgo/{id}

        Descripción: Obtener Variables de Riesgo por ID

        Path Parameter: id (Long)

        Response: VariablesRiesgoResponse (HTTP 200 OK)
        {
            "id": 1,
            "porcentaje1": "20",
            "porcentaje2": "80",
            "fechaVigencia": "2025-01-01",
            "fechaCreacion": "2025-12-21T11:30:00",
            "usuarioCreacion": "admin",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
        }

        Error Response: (HTTP 500 si no existe)
        {
            "error": "IllegalArgumentException: No existe registro con id: 999"
        }

        ---
        🔧 ARQUITECTURA Y FLUJO

        Cliente HTTP
            ↓
        VariablesRiesgoController (@RestController /variables-riesgo)
            ↓
        VariablesRiesgoService (@Service)
            ├── Gestión de auditoría automática
            └── Transacciones (@Transactional)
            ↓
        VariablesRiesgoMapper (@Component)
            ├── Request → Entity
            └── Entity → Response
            ↓
        VariablesRiesgoRepository (@Repository)
            └── JpaRepository<VariablesRiesgoEntity, Long>
            ↓
        Base de Datos Oracle
            └── CDDLAFT.CDDLAFT_PERFIL_VARIABLES_RIESGO

        Flujo de Petición POST /variables-riesgo:

        4. Controller recibe VariablesRiesgoRequest
        5. Service llama a Mapper.toEntity(request)
        6. Service establece auditoría:
            - fechaCreacion = LocalDateTime.now()
            - usuarioCreacion = currentUser() (desde Spring Security)
        7. Repository guarda Entity en BD con save(entity)
        8. Service llama a Mapper.toResponse(savedEntity)
        9. Service agrega mensaje: "Variables de Riesgo guardadas exitosamente"
        10. Controller devuelve Response con HTTP 201 CREATED

        Flujo de Petición GET /variables-riesgo:

        11. Controller llama a service.listar()
        12. Service llama a repository.findAll()
        13. Repository ejecuta query SQL: SELECT * FROM CDDLAFT_PERFIL_VARIABLES_RIESGO
        14. Service convierte cada Entity a Response usando Stream y Mapper
        15. Controller devuelve List<Response> con HTTP 200 OK

        Flujo de Petición GET /variables-riesgo/{id}:

        16. Controller recibe id como Path Variable
        17. Service llama a repository.findById(id)
        18. Repository ejecuta query SQL: SELECT * FROM ... WHERE ID = ?
        19. Si existe: Mapper convierte Entity → Response
        20. Si no existe: Lanza IllegalArgumentException
        21. Controller devuelve Response con HTTP 200 OK

        ---
        ✅ CARACTERÍSTICAS IMPLEMENTADAS

        22. Auditoría Automática
            - Tracking de usuario y fecha de creación
            - Usuario obtenido desde Spring Security Context
        23. Transacciones
            - Método guardar() usa @Transactional
            - Rollback automático en caso de error
        24. Validación
            - Lanza IllegalArgumentException si no encuentra registro por ID
            - Manejo de entidades nulas en Mapper
        25. Seguridad
            - Integración con Spring Security
            - Obtiene usuario autenticado actual
            - Fallback a "SYSTEM" si no hay autenticación
        26. Separación de Responsabilidades
            - Patrón MVC + Repository
            - DTOs separados para Request/Response
            - Mappers independientes
        27. Compatibilidad Java 17
            - Uso de jakarta.persistence.* (no javax.persistence)
            - Uso de tipos modernos: LocalDate, LocalDateTime

        ---
        📦 RESUMEN DE ARCHIVOS CREADOS

        | Tipo         | Archivo                        | Ubicación           |
        |--------------|--------------------------------|---------------------|
        | Entity       | VariablesRiesgoEntity.java     | app/Entity/cdd/     |
        | DTO Simple   | VariablesRiesgoDTO.java        | app/dto/cdd/        |
        | DTO Request  | VariablesRiesgoRequest.java    | app/dto/cdd/        |
        | DTO Response | VariablesRiesgoResponse.java   | app/dto/cdd/        |
        | Mapper       | VariablesRiesgoMapper.java     | app/mapper/cdd/     |
        | Repository   | VariablesRiesgoRepository.java | app/repository/cdd/ |
        | Service      | VariablesRiesgoService.java    | app/service/cdd/    |
        | Controller   | VariablesRiesgoController.java | app/controller/cdd/ |
        | TOTAL        | 8 archivos                     |                     |

        ---
        🚀 LISTO PARA COPIAR AL PROYECTO PRINCIPAL

        Imports utilizados (Java 17 compatible):

        // JPA
        import jakarta.persistence.*;

        // Spring
        import org.springframework.stereotype.Service;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Component;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.http.ResponseEntity;
        import org.springframework.http.HttpStatus;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.data.jpa.repository.JpaRepository;

        // Java
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.List;
        import java.util.stream.Collectors;

        Dependencias necesarias en el proyecto principal:

        <!-- pom.xml -->
        <dependencies>
            <!-- Spring Boot Starter Web -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>

            <!-- Spring Boot Starter Data JPA -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
            </dependency>

            <!-- Spring Boot Starter Security -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-security</artifactId>
            </dependency>

            <!-- Oracle JDBC Driver -->
            <dependency>
                <groupId>com.oracle.database.jdbc</groupId>
                <artifactId>ojdbc8</artifactId>
                <scope>runtime</scope>
            </dependency>
        </dependencies>

        ---
        📝 NOTAS IMPORTANTES

        28. Tabla de Base de Datos: Asegúrate de que exista la tabla CDDLAFT.CDDLAFT_PERFIL_VARIABLES_RIESGO con las columnas correspondientes.
        29. Configuración Spring Boot: Verifica que application.properties tenga la configuración de Oracle:
        spring.datasource.url=jdbc:oracle:thin:@localhost:1521:ORCL
        spring.datasource.username=${DB_USERNAME}
        spring.datasource.password=${DB_PASSWORD}
        spring.jpa.hibernate.ddl-auto=validate
        30. Diferencia con el README: El README menciona las tablas:
            - CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE
            - CDDLAFT_PERFIL_TIPO_VARIABLE
            - CDDLAFT_PERFIL_GRUPO_VARIABLE

        Pero la implementación usa: CDDLAFT_PERFIL_VARIABLES_RIESGO

        Si necesitas mapear las otras tablas, serían entidades adicionales separadas.
        31. Solo POST, no PUT: El servicio solo implementa creación (POST), no actualización (PUT). Si necesitas actualización, puedo agregar ese endpoint.

        ---
4.
         ---
            📋 RESUMEN COMPLETO - API DE RIESGO TOTAL

            ✅ Implementación Completa y Lista para Usar

            ---
            📂 UBICACIÓN DE ARCHIVOS

            Todos los archivos están en:
            C:\Users\USER\Desktop\SIAR-Back\app\

            1. Entidad JPA (app/Entity/cdd/)

            Archivo: RiesgoTotalEntity.java
            - Tabla: CDDLAFT_PERFIL_RIESGO_TOTAL
            - Schema: CDDLAFT
            - ID: Long (auto-generado con @GeneratedValue)

            Campos de Negocio:
            - nombre: String (not null, length 255) - Nombre del nivel de riesgo
            - descripcion: String (length 500) - Descripción del riesgo
            - riesgo: String (length 50) - Categoría de riesgo
            - fechaVigencia: LocalDate (not null) - Fecha de vigencia
            - limInf: BigInteger - Límite inferior
            - limSup: BigInteger - Límite superior
            - tipo: String (length 50) - Tipo de riesgo

            Campos de Auditoría:
            - fechaCreacion: LocalDateTime (not null)
            - usuarioCreacion: String (not null, length 100)
            - fechaUltimaModificacion: LocalDateTime
            - usuarioUltimaModificacion: String (length 100)

            ---
            1. DTOs (app/dto/cdd/)

            RiesgoTotalDTO.java - DTO completo
            - Incluye: id, nombre, descripcion, riesgo, fechaVigencia, limInf, limSup, tipo
            - Incluye campos de auditoría completos

            RiesgoTotalRequest.java - Para POST/PUT
            - Campos: nombre, descripcion, riesgo, fechaVigencia, limInf, limSup, tipo
            - Sin ID, sin campos de auditoría

            RiesgoTotalResponse.java - Para respuestas
            - Incluye: id, nombre, descripcion, riesgo, fechaVigencia, limInf, limSup, tipo
            - Incluye: mensaje (String)
            - Incluye campos de auditoría completos

            ---
            1. Mapper (app/mapper/cdd/)

            Archivo: RiesgoTotalMapper.java

            Métodos implementados:
            2. toEntity(Request) - Convierte Request → Entity (para crear)
            3. toResponse(Entity) - Convierte Entity → Response (para responder)
            4. updateEntityFromRequest(Request, Entity) - Actualiza Entity desde Request
            5. toEntityFromDTO(DTO) - Convierte DTO → Entity
            6. toDTO(Entity) - Convierte Entity → DTO

            ---
            7. Repository (app/repository/cdd/)

            Archivo: RiesgoTotalRepository.java
            - Interfaz que extiende JpaRepository<RiesgoTotalEntity, Long>
            - Proporciona métodos CRUD automáticos

            ---
            1. Servicio (app/service/cdd/)

            Archivo: RiesgoTotalService.java

            Métodos implementados:
            2. guardar(request) - Crea nuevo registro con auditoría automática
            3. actualizar(id, request) - Actualiza registro existente con auditoría
            4. listar() - Lista todos los registros
            5. obtenerPorId(id) - Obtiene un registro por ID
            6. eliminar(id) - Elimina un registro por ID

            Características:
            - Gestión automática de auditoría (usuario y fechas)
            - Transacciones con @Transactional
            - Obtiene usuario desde Spring Security Context
            - Fallback a "SYSTEM" si no hay usuario autenticado
            - Validación con IllegalArgumentException

            ---
            1. Controlador (app/controller/cdd/)

            Archivo: RiesgoTotalController.java
            - Base URL: /riesgo-total
            - Anotado con @RestController

            ---
            🌐 ENDPOINTS IMPLEMENTADOS (5 endpoints)

            1. POST /riesgo-total

            Descripción: Crear nuevo Riesgo Total

            Request Body: RiesgoTotalRequest
            {
                "nombre": "Riesgo Alto",
                "descripcion": "Nivel de riesgo alto para clientes con exposición elevada",
                "riesgo": "ALTO",
                "fechaVigencia": "2025-01-01",
                "limInf": 75,
                "limSup": 100,
                "tipo": "PERSONA_NATURAL"
            }

            Response: RiesgoTotalResponse (HTTP 201 CREATED)
            {
                "id": 1,
                "nombre": "Riesgo Alto",
                "descripcion": "Nivel de riesgo alto para clientes con exposición elevada",
                "riesgo": "ALTO",
                "fechaVigencia": "2025-01-01",
                "limInf": 75,
                "limSup": 100,
                "tipo": "PERSONA_NATURAL",
                "mensaje": "Riesgo Total guardado exitosamente",
                "fechaCreacion": "2025-12-21T12:00:00",
                "usuarioCreacion": "admin",
                "fechaUltimaModificacion": null,
                "usuarioUltimaModificacion": null
            }

            ---
            2. PUT /riesgo-total/{id}

            Descripción: Actualizar Riesgo Total existente

            Path Parameter: id (Long)

            Request Body: RiesgoTotalRequest
            {
                "nombre": "Riesgo Medio-Alto",
                "descripcion": "Nivel de riesgo medio-alto actualizado",
                "riesgo": "MEDIO_ALTO",
                "fechaVigencia": "2025-02-01",
                "limInf": 50,
                "limSup": 74,
                "tipo": "PERSONA_NATURAL"
            }

            Response: RiesgoTotalResponse (HTTP 200 OK)
            {
                "id": 1,
                "nombre": "Riesgo Medio-Alto",
                "descripcion": "Nivel de riesgo medio-alto actualizado",
                "riesgo": "MEDIO_ALTO",
                "fechaVigencia": "2025-02-01",
                "limInf": 50,
                "limSup": 74,
                "tipo": "PERSONA_NATURAL",
                "mensaje": "Riesgo Total actualizado exitosamente",
                "fechaCreacion": "2025-12-21T12:00:00",
                "usuarioCreacion": "admin",
                "fechaUltimaModificacion": "2025-12-21T13:30:00",
                "usuarioUltimaModificacion": "admin"
            }

            ---
            3. GET /riesgo-total

            Descripción: Listar todos los Riesgos Totales

            Response: List<RiesgoTotalResponse> (HTTP 200 OK)
            [
                {
                "id": 1,
                "nombre": "Riesgo Alto",
                "descripcion": "Nivel de riesgo alto",
                "riesgo": "ALTO",
                "fechaVigencia": "2025-01-01",
                "limInf": 75,
                "limSup": 100,
                "tipo": "PERSONA_NATURAL",
                "fechaCreacion": "2025-12-21T12:00:00",
                "usuarioCreacion": "admin",
                "fechaUltimaModificacion": null,
                "usuarioUltimaModificacion": null
                },
                {
                "id": 2,
                "nombre": "Riesgo Bajo",
                "descripcion": "Nivel de riesgo bajo",
                "riesgo": "BAJO",
                "fechaVigencia": "2025-01-01",
                "limInf": 0,
                "limSup": 25,
                "tipo": "PERSONA_NATURAL",
                "fechaCreacion": "2025-12-21T12:15:00",
                "usuarioCreacion": "admin",
                "fechaUltimaModificacion": null,
                "usuarioUltimaModificacion": null
                }
            ]

            ---
            4. GET /riesgo-total/{id}

            Descripción: Obtener Riesgo Total por ID

            Path Parameter: id (Long)

            Response: RiesgoTotalResponse (HTTP 200 OK)
            {
                "id": 1,
                "nombre": "Riesgo Alto",
                "descripcion": "Nivel de riesgo alto",
                "riesgo": "ALTO",
                "fechaVigencia": "2025-01-01",
                "limInf": 75,
                "limSup": 100,
                "tipo": "PERSONA_NATURAL",
                "fechaCreacion": "2025-12-21T12:00:00",
                "usuarioCreacion": "admin",
                "fechaUltimaModificacion": null,
                "usuarioUltimaModificacion": null
            }

            Error Response: (HTTP 500 si no existe)
            {
                "error": "IllegalArgumentException: No existe registro con id: 999"
            }

            ---
            5. DELETE /riesgo-total/{id}

            Descripción: Eliminar Riesgo Total por ID

            Path Parameter: id (Long)

            Response: HTTP 204 NO CONTENT (sin body)

            Error Response: (HTTP 500 si no existe)
            {
                "error": "IllegalArgumentException: No existe registro con id: 999"
            }

            ---
            🔧 ARQUITECTURA Y FLUJO

            Cliente HTTP
                ↓
            RiesgoTotalController (@RestController /riesgo-total)
                ↓
            RiesgoTotalService (@Service)
                ├── Gestión de auditoría automática
                └── Transacciones (@Transactional)
                ↓
            RiesgoTotalMapper (@Component)
                ├── Request → Entity
                ├── Entity → Response
                └── updateEntityFromRequest
                ↓
            RiesgoTotalRepository (@Repository)
                └── JpaRepository<RiesgoTotalEntity, Long>
                ↓
            Base de Datos Oracle
                └── CDDLAFT.CDDLAFT_PERFIL_RIESGO_TOTAL

            Flujo POST /riesgo-total:

            6. Controller recibe RiesgoTotalRequest
            7. Service llama a Mapper.toEntity(request)
            8. Service establece auditoría:
                - fechaCreacion = LocalDateTime.now()
                - usuarioCreacion = currentUser() (desde Spring Security)
            9. Repository guarda Entity con save(entity)
            10. Service llama a Mapper.toResponse(savedEntity)
            11. Service agrega mensaje: "Riesgo Total guardado exitosamente"
            12. Controller devuelve Response con HTTP 201 CREATED

            Flujo PUT /riesgo-total/{id}:

            13. Controller recibe id y RiesgoTotalRequest
            14. Service busca Entity con repository.findById(id)
            15. Si no existe: Lanza IllegalArgumentException
            16. Service llama a Mapper.updateEntityFromRequest(request, entity)
            17. Service actualiza auditoría:
                - fechaUltimaModificacion = LocalDateTime.now()
                - usuarioUltimaModificacion = currentUser()
            18. Repository guarda cambios con save(entity)
            19. Service llama a Mapper.toResponse(updatedEntity)
            20. Service agrega mensaje: "Riesgo Total actualizado exitosamente"
            21. Controller devuelve Response con HTTP 200 OK

            Flujo GET /riesgo-total:

            22. Controller llama a service.listar()
            23. Service llama a repository.findAll()
            24. Repository ejecuta: SELECT * FROM CDDLAFT_PERFIL_RIESGO_TOTAL
            25. Service convierte cada Entity a Response usando Stream y Mapper
            26. Controller devuelve List<Response> con HTTP 200 OK

            Flujo DELETE /riesgo-total/{id}:

            27. Controller recibe id
            28. Service busca Entity con repository.findById(id)
            29. Si no existe: Lanza IllegalArgumentException
            30. Repository elimina con delete(entity)
            31. Controller devuelve HTTP 204 NO CONTENT

            ---
            ✅ CARACTERÍSTICAS IMPLEMENTADAS

            32. Auditoría Automática
                - Tracking de usuario y fechas de creación/modificación
                - Usuario obtenido desde Spring Security Context
            33. Transacciones
                - Métodos guardar(), actualizar(), eliminar() usan @Transactional
                - Rollback automático en caso de error
            34. Validación
                - Lanza IllegalArgumentException si no encuentra registro por ID
                - Manejo de entidades nulas en Mapper
            35. Seguridad
                - Integración con Spring Security
                - Obtiene usuario autenticado actual
                - Fallback a "SYSTEM" si no hay autenticación
            36. Separación de Responsabilidades
                - Patrón MVC + Repository
                - DTOs separados para Request/Response
                - Mappers independientes
            37. Compatibilidad Java 17
                - Uso de jakarta.persistence.*
                - Tipos modernos: LocalDate, LocalDateTime, BigInteger
            38. CRUD Completo
                - Create (POST), Read (GET), Update (PUT), Delete (DELETE)

            ---
            📦 RESUMEN DE ARCHIVOS CREADOS

            | Tipo         | Archivo                    | Ubicación           |
            |--------------|----------------------------|---------------------|
            | Entity       | RiesgoTotalEntity.java     | app/Entity/cdd/     |
            | DTO Simple   | RiesgoTotalDTO.java        | app/dto/cdd/        |
            | DTO Request  | RiesgoTotalRequest.java    | app/dto/cdd/        |
            | DTO Response | RiesgoTotalResponse.java   | app/dto/cdd/        |
            | Mapper       | RiesgoTotalMapper.java     | app/mapper/cdd/     |
            | Repository   | RiesgoTotalRepository.java | app/repository/cdd/ |
            | Service      | RiesgoTotalService.java    | app/service/cdd/    |
            | Controller   | RiesgoTotalController.java | app/controller/cdd/ |
            | TOTAL        | 8 archivos                 |                     |

            ---
            🚀 LISTO PARA COPIAR AL PROYECTO PRINCIPAL

            Imports utilizados (Java 17 compatible):

            // JPA
            import jakarta.persistence.*;

            // Spring
            import org.springframework.stereotype.Service;
            import org.springframework.stereotype.Repository;
            import org.springframework.stereotype.Component;
            import org.springframework.web.bind.annotation.*;
            import org.springframework.http.ResponseEntity;
            import org.springframework.http.HttpStatus;
            import org.springframework.transaction.annotation.Transactional;
            import org.springframework.security.core.Authentication;
            import org.springframework.security.core.context.SecurityContextHolder;
            import org.springframework.data.jpa.repository.JpaRepository;

            // Java
            import java.math.BigInteger;
            import java.time.LocalDate;
            import java.time.LocalDateTime;
            import java.util.List;
            import java.util.stream.Collectors;

            Dependencias necesarias:

            <!-- pom.xml -->
            <dependencies>
                <!-- Spring Boot Starter Web -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>

                <!-- Spring Boot Starter Data JPA -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-jpa</artifactId>
                </dependency>

                <!-- Spring Boot Starter Security -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-security</artifactId>
                </dependency>

                <!-- Oracle JDBC Driver -->
                <dependency>
                    <groupId>com.oracle.database.jdbc</groupId>
                    <artifactId>ojdbc8</artifactId>
                    <scope>runtime</scope>
                </dependency>
            </dependencies>

            ---
            📝 NOTAS IMPORTANTES

            39. Tabla de Base de Datos: Asegúrate de que exista la tabla CDDLAFT.CDDLAFT_PERFIL_RIESGO_TOTAL con las columnas correspondientes.
            40. Diferencia con README: El README menciona las tablas:
                - CDDLAFT_PERFIL_RIESGO_CATALOGOS
                - CDDLAFT_INDICE_CATALOGOS

            Pero la implementación usa: CDDLAFT_PERFIL_RIESGO_TOTAL
            41. Tipos de Datos:
                - limInf y limSup son BigInteger (no String como en README)
                - Permite almacenar números muy grandes sin límite
            42. Operación DELETE:
                - Elimina físicamente el registro de la base de datos
                - No hay eliminación lógica (soft delete)
                - Devuelve HTTP 204 NO CONTENT sin body
            43. Configuración Spring Boot:
            spring.datasource.url=jdbc:oracle:thin:@localhost:1521:ORCL
            spring.datasource.username=${DB_USERNAME}
            spring.datasource.password=${DB_PASSWORD}
            spring.jpa.hibernate.ddl-auto=validate

            ---
5.
        ---
        📋 RESUMEN COMPLETO - APIS DE RESULTADO DE RIESGO

        ✅ 2 APIs Implementadas y Listas para Usar

        1. API Resultado de Riesgo - Consulta de resultados de evaluación
        2. API Detalle Resultado de Riesgo - Información adicional de resultados

        ---
        📂 UBICACIÓN DE ARCHIVOS

        Todos los archivos están en:
        C:\Users\USER\Desktop\SIAR-Back\app\

        ---
        🔷 API 1: RESULTADO DE RIESGO

        1. Entidad JPA (app/Entity/cdd/)

        Archivo: ResultadoRiesgoEntity.java
        - Tabla: CDDLAFT_PERFIL_RESULTADO_RIESGO
        - Schema: CDDLAFT
        - ID: Long (auto-generado)

        Campos de Negocio:
        - documento: Double - Número de documento
        - tipoDocumento: String (length 50) - Tipo de documento (CC, NIT, etc.)
        - nombre: String (length 255) - Nombre de la persona/empresa
        - tipoPersona: String (length 50) - Natural o Jurídica
        - producto: String (length 100) - Producto contratado
        - fecha: LocalDate - Fecha de evaluación
        - resultadoRiesgo: String (length 100) - Resultado de la evaluación
        - nivelRiesgo: BigDecimal (precision 10, scale 2) - Nivel numérico de riesgo

        Campos de Auditoría:
        - fechaCreacion: LocalDateTime (not null)
        - usuarioCreacion: String (not null, length 100)
        - fechaUltimaModificacion: LocalDateTime
        - usuarioUltimaModificacion: String (length 100)

        ---
        2. DTO (app/dto/cdd/)

        Archivo: ResultadoRiesgoDTO.java
        - Incluye: id, documento, tipoDocumento, nombre, tipoPersona, producto, fecha, resultadoRiesgo, nivelRiesgo
        - Incluye campos de auditoría completos

        ---
        3. Mapper (app/mapper/cdd/)

        Archivo: ResultadoRiesgoMapper.java

        Métodos implementados:
        1. toDTO(Entity) - Convierte Entity → DTO
        2. toEntity(DTO) - Convierte DTO → Entity

        ---
        4. Repository (app/repository/cdd/)

        Archivo: ResultadoRiesgoRepository.java
        - Interfaz que extiende JpaRepository<ResultadoRiesgoEntity, Long>
        - Proporciona métodos CRUD automáticos

        ---
        🔶 API 2: DETALLE RESULTADO DE RIESGO

        1. Entidad JPA (app/Entity/cdd/)

        Archivo: DetalleResultadoRiesgoEntity.java
        - Tabla: CDDLAFT_PERFIL_DETALLE_RESULTADO_RIESGO
        - Schema: CDDLAFT
        - ID: Long (auto-generado)

        Campos de Negocio:
        - catalogo: String (length 100) - Nombre del catálogo
        - valor: String (length 255) - Valor del detalle
        - riesgo: BigDecimal (precision 10, scale 2) - Riesgo asociado

        Campos de Auditoría:
        - fechaCreacion: LocalDateTime (not null)
        - usuarioCreacion: String (not null, length 100)
        - fechaUltimaModificacion: LocalDateTime
        - usuarioUltimaModificacion: String (length 100)

        ---
        2. DTO (app/dto/cdd/)

        Archivo: DetalleResultadoRiesgoDTO.java
        - Incluye: id, catalogo, valor, riesgo
        - Incluye campos de auditoría completos

        ---
        3. Mapper (app/mapper/cdd/)

        Archivo: DetalleResultadoRiesgoMapper.java

        Métodos implementados:
        1. toDTO(Entity) - Convierte Entity → DTO
        2. toEntity(DTO) - Convierte DTO → Entity

        ---
        4. Repository (app/repository/cdd/)

        Archivo: DetalleResultadoRiesgoRepository.java
        - Interfaz que extiende JpaRepository<DetalleResultadoRiesgoEntity, Long>
        - Proporciona métodos CRUD automáticos

        ---
        🔗 SERVICIO Y CONTROLADOR COMPARTIDO

        Servicio (app/service/cdd/)

        Archivo: ResultadoRiesgoService.java

        Métodos para Resultado de Riesgo:
        1. listarResultadosRiesgo() - Lista todos los resultados
        2. obtenerResultadoRiesgoPorId(id) - Obtiene un resultado por ID

        Métodos para Detalle Resultado de Riesgo:
        3. listarDetallesResultadoRiesgo() - Lista todos los detalles
        4. obtenerDetalleResultadoRiesgoPorId(id) - Obtiene un detalle por ID

        Características:
        - Sin transacciones (solo operaciones de lectura)
        - Validación con IllegalArgumentException
        - Conversión Entity → DTO usando Stream API

        ---
        Controlador (app/controller/cdd/)

        Archivo: ResultadoRiesgoController.java
        - Base URL: /resultado-riesgo
        - Anotado con @RestController
        - Gestiona ambas APIs en un solo controller

        ---
        🌐 ENDPOINTS IMPLEMENTADOS (4 endpoints)

        Endpoints de Resultado de Riesgo

        1. GET /resultado-riesgo

        Descripción: Listar todos los Resultados de Riesgo

        Response: List<ResultadoRiesgoDTO> (HTTP 200 OK)
        [
            {
            "id": 1,
            "documento": 123456789,
            "tipoDocumento": "CC",
            "nombre": "Juan Pérez",
            "tipoPersona": "NATURAL",
            "producto": "Cuenta de Ahorros",
            "fecha": "2025-01-15",
            "resultadoRiesgo": "APROBADO",
            "nivelRiesgo": 25.50,
            "fechaCreacion": "2025-01-15T10:00:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            },
            {
            "id": 2,
            "documento": 987654321,
            "tipoDocumento": "NIT",
            "nombre": "Empresa ABC S.A.S",
            "tipoPersona": "JURIDICA",
            "producto": "Crédito Empresarial",
            "fecha": "2025-01-16",
            "resultadoRiesgo": "RECHAZADO",
            "nivelRiesgo": 85.75,
            "fechaCreacion": "2025-01-16T11:30:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            }
        ]

        ---
        2. GET /resultado-riesgo/{id}

        Descripción: Obtener Resultado de Riesgo por ID

        Path Parameter: id (Long)

        Response: ResultadoRiesgoDTO (HTTP 200 OK)
        {
            "id": 1,
            "documento": 123456789,
            "tipoDocumento": "CC",
            "nombre": "Juan Pérez",
            "tipoPersona": "NATURAL",
            "producto": "Cuenta de Ahorros",
            "fecha": "2025-01-15",
            "resultadoRiesgo": "APROBADO",
            "nivelRiesgo": 25.50,
            "fechaCreacion": "2025-01-15T10:00:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
        }

        Error Response: (HTTP 500 si no existe)
        {
            "error": "IllegalArgumentException: No existe resultado de riesgo con id: 999"
        }

        ---
        Endpoints de Detalle Resultado de Riesgo

        3. GET /resultado-riesgo/detalle

        Descripción: Listar todos los Detalles de Resultado de Riesgo (información adicional)

        Response: List<DetalleResultadoRiesgoDTO> (HTTP 200 OK)
        [
            {
            "id": 1,
            "catalogo": "Industria",
            "valor": "Tecnología",
            "riesgo": 15.25,
            "fechaCreacion": "2025-01-15T10:00:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            },
            {
            "id": 2,
            "catalogo": "País de Residencia",
            "valor": "Colombia",
            "riesgo": 10.50,
            "fechaCreacion": "2025-01-15T10:00:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            },
            {
            "id": 3,
            "catalogo": "Ocupación",
            "valor": "Ingeniero",
            "riesgo": 8.75,
            "fechaCreacion": "2025-01-15T10:00:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
            }
        ]

        ---
        4. GET /resultado-riesgo/detalle/{id}

        Descripción: Obtener Detalle de Resultado de Riesgo por ID

        Path Parameter: id (Long)

        Response: DetalleResultadoRiesgoDTO (HTTP 200 OK)
        {
            "id": 1,
            "catalogo": "Industria",
            "valor": "Tecnología",
            "riesgo": 15.25,
            "fechaCreacion": "2025-01-15T10:00:00",
            "usuarioCreacion": "system",
            "fechaUltimaModificacion": null,
            "usuarioUltimaModificacion": null
        }

        Error Response: (HTTP 500 si no existe)
        {
            "error": "IllegalArgumentException: No existe detalle de resultado de riesgo con id: 999"
        }

        ---
        🔧 ARQUITECTURA Y FLUJO

        Cliente HTTP
            ↓
        ResultadoRiesgoController (@RestController /resultado-riesgo)
            ├── /resultado-riesgo (GET lista, GET por ID)
            └── /resultado-riesgo/detalle (GET lista, GET por ID)
            ↓
        ResultadoRiesgoService (@Service)
            ├── ResultadoRiesgoRepository
            ├── DetalleResultadoRiesgoRepository
            ├── ResultadoRiesgoMapper
            └── DetalleResultadoRiesgoMapper
            ↓
        Base de Datos Oracle
            ├── CDDLAFT.CDDLAFT_PERFIL_RESULTADO_RIESGO
            └── CDDLAFT.CDDLAFT_PERFIL_DETALLE_RESULTADO_RIESGO

        Flujo GET /resultado-riesgo:

        1. Controller llama a service.listarResultadosRiesgo()
        2. Service llama a resultadoRiesgoRepository.findAll()
        3. Repository ejecuta: SELECT * FROM CDDLAFT_PERFIL_RESULTADO_RIESGO
        4. Service convierte cada Entity a DTO usando resultadoRiesgoMapper.toDTO()
        5. Controller devuelve List<ResultadoRiesgoDTO> con HTTP 200 OK

        Flujo GET /resultado-riesgo/{id}:

        1. Controller recibe id como Path Variable
        2. Service llama a resultadoRiesgoRepository.findById(id)
        3. Repository ejecuta: SELECT * FROM ... WHERE ID = ?
        4. Si no existe: Lanza IllegalArgumentException
        5. Service convierte Entity a DTO usando Mapper
        6. Controller devuelve ResultadoRiesgoDTO con HTTP 200 OK

        Flujo GET /resultado-riesgo/detalle:

        1. Controller llama a service.listarDetallesResultadoRiesgo()
        2. Service llama a detalleResultadoRiesgoRepository.findAll()
        3. Repository ejecuta: SELECT * FROM CDDLAFT_PERFIL_DETALLE_RESULTADO_RIESGO
        4. Service convierte cada Entity a DTO usando detalleResultadoRiesgoMapper.toDTO()
        5. Controller devuelve List<DetalleResultadoRiesgoDTO> con HTTP 200 OK

        Flujo GET /resultado-riesgo/detalle/{id}:

        1. Controller recibe id como Path Variable
        2. Service llama a detalleResultadoRiesgoRepository.findById(id)
        3. Si no existe: Lanza IllegalArgumentException
        4. Service convierte Entity a DTO usando Mapper
        5. Controller devuelve DetalleResultadoRiesgoDTO con HTTP 200 OK

        ---
        ✅ CARACTERÍSTICAS IMPLEMENTADAS

        1. Solo Lectura (GET)
            - Ambas APIs son de solo lectura
            - No hay operaciones POST, PUT o DELETE
            - No se modifican datos
        2. Validación
            - Lanza IllegalArgumentException si no encuentra registro por ID
            - Manejo de entidades nulas en Mappers
        3. Separación de Responsabilidades
            - Patrón MVC + Repository
            - DTOs para respuestas
            - Mappers independientes para cada entidad
        4. Compatibilidad Java 17
            - Uso de jakarta.persistence.*
            - Tipos modernos: LocalDate, LocalDateTime, BigDecimal, Double
        5. Controller Unificado
            - Un solo controller gestiona ambas APIs
            - URLs organizadas con /detalle para diferenciar
        6. Auditoría Incluida
            - Campos de auditoría en DTOs
            - Tracking de creación y modificación

        ---
        📦 RESUMEN DE ARCHIVOS CREADOS

        Para Resultado de Riesgo:

        | Tipo       | Archivo                        | Ubicación           |
        |------------|--------------------------------|---------------------|
        | Entity     | ResultadoRiesgoEntity.java     | app/Entity/cdd/     |
        | DTO        | ResultadoRiesgoDTO.java        | app/dto/cdd/        |
        | Mapper     | ResultadoRiesgoMapper.java     | app/mapper/cdd/     |
        | Repository | ResultadoRiesgoRepository.java | app/repository/cdd/ |

        Para Detalle Resultado de Riesgo:

        | Tipo       | Archivo                               | Ubicación           |
        |------------|---------------------------------------|---------------------|
        | Entity     | DetalleResultadoRiesgoEntity.java     | app/Entity/cdd/     |
        | DTO        | DetalleResultadoRiesgoDTO.java        | app/dto/cdd/        |
        | Mapper     | DetalleResultadoRiesgoMapper.java     | app/mapper/cdd/     |
        | Repository | DetalleResultadoRiesgoRepository.java | app/repository/cdd/ |

        Compartidos:

        | Tipo       | Archivo                        | Ubicación           |
        |------------|--------------------------------|---------------------|
        | Service    | ResultadoRiesgoService.java    | app/service/cdd/    |
        | Controller | ResultadoRiesgoController.java | app/controller/cdd/ |

        TOTAL: 10 archivos

        ---
        🚀 LISTO PARA COPIAR AL PROYECTO PRINCIPAL

        Imports utilizados (Java 17 compatible):

        // JPA
        import jakarta.persistence.*;

        // Spring
        import org.springframework.stereotype.Service;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Component;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.http.ResponseEntity;
        import org.springframework.data.jpa.repository.JpaRepository;

        // Java
        import java.math.BigDecimal;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.List;
        import java.util.stream.Collectors;

        Dependencias necesarias:

        <!-- pom.xml -->
        <dependencies>
            <!-- Spring Boot Starter Web -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>

            <!-- Spring Boot Starter Data JPA -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
            </dependency>

            <!-- Oracle JDBC Driver -->
            <dependency>
                <groupId>com.oracle.database.jdbc</groupId>
                <artifactId>ojdbc8</artifactId>
                <scope>runtime</scope>
            </dependency>
        </dependencies>

        ---
        📝 NOTAS IMPORTANTES

        1. Tablas de Base de Datos:
            - CDDLAFT.CDDLAFT_PERFIL_RESULTADO_RIESGO
            - CDDLAFT.CDDLAFT_PERFIL_DETALLE_RESULTADO_RIESGO
        2. Diferencia con README:
            - README menciona tabla: CDDLAFT_PERFIL_RIESGO_NIVEL_RIESGO
            - Implementación usa: CDDLAFT_PERFIL_RESULTADO_RIESGO
        3. Tipo de Dato documento:
            - Es Double (no number como en README)
            - Permite almacenar números grandes con decimales
        4. Información Adicional:
            - El README menciona "Información adicional por id"
            - Esto se implementa con DetalleResultadoRiesgoEntity
            - Endpoint: /resultado-riesgo/detalle/{id}
        5. Solo Consultas:
            - Ambas APIs son de solo lectura (GET)
            - No hay creación, actualización o eliminación
        6. Configuración Spring Boot:
        spring.datasource.url=jdbc:oracle:thin:@localhost:1521:ORCL
        spring.datasource.username=${DB_USERNAME}
        spring.datasource.password=${DB_PASSWORD}
        spring.jpa.hibernate.ddl-auto=validate

        ---
        💡 RELACIÓN ENTRE LAS DOS APIS

        La API de Detalle Resultado de Riesgo proporciona información adicional desglosada:

        Resultado de Riesgo (Resumen)
        ├── documento: 123456789
        ├── nombre: "Juan Pérez"
        ├── resultadoRiesgo: "APROBADO"
        └── nivelRiesgo: 25.50 (suma de detalles)

        Detalles de Resultado de Riesgo (Información adicional)
        ├── Detalle 1: Industria → Tecnología → Riesgo: 15.25
        ├── Detalle 2: País → Colombia → Riesgo: 10.50
        └── Detalle 3: Ocupación → Ingeniero → Riesgo: 8.75
                                                ─────────
                                                Total: 34.50

        ---
 


**Como implementar los repository en ves de DAO:**
**CÓMO SE USAN EN LOS SERVICIOS**

  En VariablesRiesgoService:

  @Service
  public class VariablesRiesgoService {

      private final VariablesRiesgoRepository variablesRiesgoRepository; // ← DAO inyectado

      public VariablesRiesgoService(VariablesRiesgoRepository variablesRiesgoRepository) {
          this.variablesRiesgoRepository = variablesRiesgoRepository; // Inyección por constructor
      }

      @Transactional
      public VariablesRiesgoResponse guardar(VariablesRiesgoRequest request) {
          // Usar el Repository (DAO)
          VariablesRiesgoEntity savedEntity = variablesRiesgoRepository.save(entity); // ← Llamada al DAO
          return response;
      }

      public List<VariablesRiesgoResponse> listar() {
          List<VariablesRiesgoEntity> entities = variablesRiesgoRepository.findAll(); // ← Llamada al DAO
          return entities.stream()...
      }

      public VariablesRiesgoResponse obtenerPorId(Long id) {
          VariablesRiesgoEntity entity = variablesRiesgoRepository.findById(id) // ← Llamada al DAO
              .orElseThrow(() -> new IllegalArgumentException("No existe..."));
          return mapper.toResponse(entity);
      }
  }

  En RiesgoService:

  @Service
  public class RiesgoService {

      private final RiesgoPersonaNaturalRepository personaNaturalRepository; // ← DAO 1
      private final RiesgoPersonaJuridicaRepository personaJuridicaRepository; // ← DAO 2

      public RiesgoService(
              RiesgoPersonaNaturalRepository personaNaturalRepository,
              RiesgoPersonaJuridicaRepository personaJuridicaRepository
      ) {
          this.personaNaturalRepository = personaNaturalRepository;
          this.personaJuridicaRepository = personaJuridicaRepository;
      }

      // Uso de DAO para Persona Natural
      @Transactional
      public RiesgoPersonaNaturalResponse guardarPersonaNatural(RiesgoPersonaNaturalRequest request) {
          RiesgoPersonaNaturalEntity savedEntity = personaNaturalRepository.save(entity); // ← DAO
          return response;
      }

      // Uso de DAO para Persona Jurídica
      @Transactional
      public RiesgoPersonaJuridicaResponse guardarPersonaJuridica(RiesgoPersonaJuridicaRequest request) {
          RiesgoPersonaJuridicaEntity savedEntity = personaJuridicaRepository.save(entity); // ← DAO
          return response;
      }
  }

  ---
  📋 RESUMEN

  | API Module              | DAO/Repository                  | Ubicación           | Estado    |
  |-------------------------|---------------------------------|---------------------|-----------|
  | Variables de Riesgo     | VariablesRiesgoRepository       | app/repository/cdd/ | ✅ Creado |
  | Riesgo Persona Natural  | RiesgoPersonaNaturalRepository  | app/repository/cdd/ | ✅ Creado |
  | Riesgo Persona Jurídica | RiesgoPersonaJuridicaRepository | app/repository/cdd/ | ✅ Creado |

  Todos los DAO (Repositories) están creados y funcionando correctamente.

  ---
  🎯 ¿NECESITAS QUERIES PERSONALIZADAS?

  Si necesitas queries más complejas, puedes agregarlas directamente en los Repositories:

  @Repository
  public interface VariablesRiesgoRepository extends JpaRepository<VariablesRiesgoEntity, Long> {

      // Query derivada por nombre de método
      List<VariablesRiesgoEntity> findByFechaVigencia(LocalDate fecha);

      // Query con @Query personalizada
      @Query("SELECT v FROM VariablesRiesgoEntity v WHERE v.porcentaje1 = :porcentaje")
      List<VariablesRiesgoEntity> buscarPorPorcentaje1(@Param("porcentaje") String porcentaje);

      // Query nativa SQL
      @Query(value = "SELECT * FROM CDDLAFT_PERFIL_VARIABLES_RIESGO WHERE PORCENTAJE2 > :valor", nativeQuery = true)
      List<VariablesRiesgoEntity> buscarPorPorcentaje2Mayor(@Param("valor") String valor);
  }
