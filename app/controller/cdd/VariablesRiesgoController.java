package app.controller.cdd;

import app.dto.cdd.VariablesRiesgoRequest;
import app.dto.cdd.VariablesRiesgoResponse;
import app.service.cdd.VariablesRiesgoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variables-riesgo")
public class VariablesRiesgoController {

    private final VariablesRiesgoService variablesRiesgoService;

    public VariablesRiesgoController(VariablesRiesgoService variablesRiesgoService) {
        this.variablesRiesgoService = variablesRiesgoService;
    }

    /**
     * Guardar Variables de Riesgo
     * POST /variables-riesgo
     */
    @PostMapping
    public ResponseEntity<VariablesRiesgoResponse> guardar(@RequestBody VariablesRiesgoRequest request) {
        VariablesRiesgoResponse response = variablesRiesgoService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Listar todas las Variables de Riesgo
     * GET /variables-riesgo
     */
    @GetMapping
    public ResponseEntity<List<VariablesRiesgoResponse>> listar() {
        List<VariablesRiesgoResponse> response = variablesRiesgoService.listar();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener Variables de Riesgo por ID
     * GET /variables-riesgo/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<VariablesRiesgoResponse> obtenerPorId(@PathVariable Long id) {
        VariablesRiesgoResponse response = variablesRiesgoService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }
}
