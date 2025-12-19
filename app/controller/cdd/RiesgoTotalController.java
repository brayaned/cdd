package app.controller.cdd;

import app.dto.cdd.RiesgoTotalRequest;
import app.dto.cdd.RiesgoTotalResponse;
import app.service.cdd.RiesgoTotalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/riesgo-total")
public class RiesgoTotalController {

    private final RiesgoTotalService riesgoTotalService;

    public RiesgoTotalController(RiesgoTotalService riesgoTotalService) {
        this.riesgoTotalService = riesgoTotalService;
    }

    /**
     * Guardar Riesgo Total
     * POST /riesgo-total
     */
    @PostMapping
    public ResponseEntity<RiesgoTotalResponse> guardar(@RequestBody RiesgoTotalRequest request) {
        RiesgoTotalResponse response = riesgoTotalService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Actualizar Riesgo Total por ID
     * PUT /riesgo-total/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<RiesgoTotalResponse> actualizar(
            @PathVariable Long id,
            @RequestBody RiesgoTotalRequest request) {
        RiesgoTotalResponse response = riesgoTotalService.actualizar(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar todos los Riesgos Totales
     * GET /riesgo-total
     */
    @GetMapping
    public ResponseEntity<List<RiesgoTotalResponse>> listar() {
        List<RiesgoTotalResponse> response = riesgoTotalService.listar();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener Riesgo Total por ID
     * GET /riesgo-total/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<RiesgoTotalResponse> obtenerPorId(@PathVariable Long id) {
        RiesgoTotalResponse response = riesgoTotalService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Eliminar Riesgo Total por ID
     * DELETE /riesgo-total/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        riesgoTotalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
