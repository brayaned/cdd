package app.controller.cdd;

import app.dto.cdd.RiesgoPersonaJuridicaRequest;
import app.dto.cdd.RiesgoPersonaJuridicaResponse;
import app.dto.cdd.RiesgoPersonaNaturalRequest;
import app.dto.cdd.RiesgoPersonaNaturalResponse;
import app.service.cdd.RiesgoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/riesgo")
public class RiesgoController {

    private final RiesgoService riesgoService;

    public RiesgoController(RiesgoService riesgoService) {
        this.riesgoService = riesgoService;
    }

    // ========== ENDPOINTS PARA PERSONA NATURAL ==========

    /**
     * Guardar configuración de riesgo para Persona Natural
     * POST /riesgo/persona-natural
     */
    @PostMapping("/persona-natural")
    public ResponseEntity<RiesgoPersonaNaturalResponse> guardarPersonaNatural(
            @RequestBody RiesgoPersonaNaturalRequest request) {
        RiesgoPersonaNaturalResponse response = riesgoService.guardarPersonaNatural(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Actualizar configuración de riesgo para Persona Natural por ID
     * PUT /riesgo/persona-natural/{id}
     */
    @PutMapping("/persona-natural/{id}")
    public ResponseEntity<RiesgoPersonaNaturalResponse> actualizarPersonaNatural(
            @PathVariable Long id,
            @RequestBody RiesgoPersonaNaturalRequest request) {
        RiesgoPersonaNaturalResponse response = riesgoService.actualizarPersonaNatural(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar todas las configuraciones de riesgo para Persona Natural
     * GET /riesgo/persona-natural
     */
    @GetMapping("/persona-natural")
    public ResponseEntity<List<RiesgoPersonaNaturalResponse>> listarPersonaNatural() {
        List<RiesgoPersonaNaturalResponse> response = riesgoService.listarPersonaNatural();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener configuración de riesgo para Persona Natural por ID
     * GET /riesgo/persona-natural/{id}
     */
    @GetMapping("/persona-natural/{id}")
    public ResponseEntity<RiesgoPersonaNaturalResponse> obtenerPersonaNaturalPorId(@PathVariable Long id) {
        RiesgoPersonaNaturalResponse response = riesgoService.obtenerPersonaNaturalPorId(id);
        return ResponseEntity.ok(response);
    }

    // ========== ENDPOINTS PARA PERSONA JURIDICA ==========

    /**
     * Guardar configuración de riesgo para Persona Jurídica
     * POST /riesgo/persona-juridica
     */
    @PostMapping("/persona-juridica")
    public ResponseEntity<RiesgoPersonaJuridicaResponse> guardarPersonaJuridica(
            @RequestBody RiesgoPersonaJuridicaRequest request) {
        RiesgoPersonaJuridicaResponse response = riesgoService.guardarPersonaJuridica(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Actualizar configuración de riesgo para Persona Jurídica por ID
     * PUT /riesgo/persona-juridica/{id}
     */
    @PutMapping("/persona-juridica/{id}")
    public ResponseEntity<RiesgoPersonaJuridicaResponse> actualizarPersonaJuridica(
            @PathVariable Long id,
            @RequestBody RiesgoPersonaJuridicaRequest request) {
        RiesgoPersonaJuridicaResponse response = riesgoService.actualizarPersonaJuridica(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar todas las configuraciones de riesgo para Persona Jurídica
     * GET /riesgo/persona-juridica
     */
    @GetMapping("/persona-juridica")
    public ResponseEntity<List<RiesgoPersonaJuridicaResponse>> listarPersonaJuridica() {
        List<RiesgoPersonaJuridicaResponse> response = riesgoService.listarPersonaJuridica();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener configuración de riesgo para Persona Jurídica por ID
     * GET /riesgo/persona-juridica/{id}
     */
    @GetMapping("/persona-juridica/{id}")
    public ResponseEntity<RiesgoPersonaJuridicaResponse> obtenerPersonaJuridicaPorId(@PathVariable Long id) {
        RiesgoPersonaJuridicaResponse response = riesgoService.obtenerPersonaJuridicaPorId(id);
        return ResponseEntity.ok(response);
    }
}
