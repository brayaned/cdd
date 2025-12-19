package app.service.cdd;

import app.Entity.cdd.DetalleResultadoRiesgoEntity;
import app.Entity.cdd.ResultadoRiesgoEntity;
import app.dto.cdd.DetalleResultadoRiesgoDTO;
import app.dto.cdd.ResultadoRiesgoDTO;
import app.mapper.cdd.DetalleResultadoRiesgoMapper;
import app.mapper.cdd.ResultadoRiesgoMapper;
import app.repository.cdd.DetalleResultadoRiesgoRepository;
import app.repository.cdd.ResultadoRiesgoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultadoRiesgoService {

    private final ResultadoRiesgoRepository resultadoRiesgoRepository;
    private final DetalleResultadoRiesgoRepository detalleResultadoRiesgoRepository;
    private final ResultadoRiesgoMapper resultadoRiesgoMapper;
    private final DetalleResultadoRiesgoMapper detalleResultadoRiesgoMapper;

    public ResultadoRiesgoService(
            ResultadoRiesgoRepository resultadoRiesgoRepository,
            DetalleResultadoRiesgoRepository detalleResultadoRiesgoRepository,
            ResultadoRiesgoMapper resultadoRiesgoMapper,
            DetalleResultadoRiesgoMapper detalleResultadoRiesgoMapper
    ) {
        this.resultadoRiesgoRepository = resultadoRiesgoRepository;
        this.detalleResultadoRiesgoRepository = detalleResultadoRiesgoRepository;
        this.resultadoRiesgoMapper = resultadoRiesgoMapper;
        this.detalleResultadoRiesgoMapper = detalleResultadoRiesgoMapper;
    }

    // Listar todos los resultados de riesgo
    public List<ResultadoRiesgoDTO> listarResultadosRiesgo() {
        List<ResultadoRiesgoEntity> entities = resultadoRiesgoRepository.findAll();
        return entities.stream()
                .map(resultadoRiesgoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener resultado de riesgo por ID
    public ResultadoRiesgoDTO obtenerResultadoRiesgoPorId(Long id) {
        ResultadoRiesgoEntity entity = resultadoRiesgoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe resultado de riesgo con id: " + id));

        return resultadoRiesgoMapper.toDTO(entity);
    }

    // Listar todos los detalles de resultado de riesgo
    public List<DetalleResultadoRiesgoDTO> listarDetallesResultadoRiesgo() {
        List<DetalleResultadoRiesgoEntity> entities = detalleResultadoRiesgoRepository.findAll();
        return entities.stream()
                .map(detalleResultadoRiesgoMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener detalle de resultado de riesgo por ID
    public DetalleResultadoRiesgoDTO obtenerDetalleResultadoRiesgoPorId(Long id) {
        DetalleResultadoRiesgoEntity entity = detalleResultadoRiesgoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe detalle de resultado de riesgo con id: " + id));

        return detalleResultadoRiesgoMapper.toDTO(entity);
    }
}
