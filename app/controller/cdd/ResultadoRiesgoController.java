package app.controller.cdd;

import app.dto.cdd.DetalleResultadoRiesgoDTO;
import app.dto.cdd.ResultadoRiesgoDTO;
import app.service.cdd.ResultadoRiesgoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultado-riesgo")
public class ResultadoRiesgoController {

    private final ResultadoRiesgoService resultadoRiesgoService;

    public ResultadoRiesgoController(ResultadoRiesgoService resultadoRiesgoService) {
        this.resultadoRiesgoService = resultadoRiesgoService;
    }

    /**
     * Listar todos los Resultados de Riesgo
     * GET /resultado-riesgo
     */
    @GetMapping
    public ResponseEntity<List<ResultadoRiesgoDTO>> listarResultadosRiesgo() {
        List<ResultadoRiesgoDTO> response = resultadoRiesgoService.listarResultadosRiesgo();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener Resultado de Riesgo por ID
     * GET /resultado-riesgo/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoRiesgoDTO> obtenerResultadoRiesgoPorId(@PathVariable Long id) {
        ResultadoRiesgoDTO response = resultadoRiesgoService.obtenerResultadoRiesgoPorId(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar todos los Detalles de Resultado de Riesgo
     * GET /resultado-riesgo/detalle
     */
    @GetMapping("/detalle")
    public ResponseEntity<List<DetalleResultadoRiesgoDTO>> listarDetallesResultadoRiesgo() {
        List<DetalleResultadoRiesgoDTO> response = resultadoRiesgoService.listarDetallesResultadoRiesgo();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener Detalle de Resultado de Riesgo por ID
     * GET /resultado-riesgo/detalle/{id}
     */
    @GetMapping("/detalle/{id}")
    public ResponseEntity<DetalleResultadoRiesgoDTO> obtenerDetalleResultadoRiesgoPorId(@PathVariable Long id) {
        DetalleResultadoRiesgoDTO response = resultadoRiesgoService.obtenerDetalleResultadoRiesgoPorId(id);
        return ResponseEntity.ok(response);
    }
}
