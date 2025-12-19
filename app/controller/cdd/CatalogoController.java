package app.controller.cdd;

import app.dto.cdd.CatalogoRequest;
import app.dto.cdd.CatalogoResponse;
import app.service.cdd.CatalogoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    /**
     * Guardar Catálogo
     * POST /catalogo
     */
    @PostMapping
    public ResponseEntity<CatalogoResponse> guardar(@RequestBody CatalogoRequest request) {
        CatalogoResponse response = catalogoService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Actualizar Catálogo por ID
     * PUT /catalogo/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<CatalogoResponse> actualizar(
            @PathVariable String id,
            @RequestBody CatalogoRequest request) {
        CatalogoResponse response = catalogoService.actualizar(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * Listar todos los Catálogos
     * GET /catalogo
     */
    @GetMapping
    public ResponseEntity<List<CatalogoResponse>> listar() {
        List<CatalogoResponse> response = catalogoService.listar();
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener Catálogo por ID
     * GET /catalogo/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<CatalogoResponse> obtenerPorId(@PathVariable String id) {
        CatalogoResponse response = catalogoService.obtenerPorId(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Eliminar Catálogo por ID
     * DELETE /catalogo/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        catalogoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
