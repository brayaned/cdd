package app.dao.cdd;

import app.dto.cdd.CatalogoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CatalogoDAO {

    private final JdbcTemplate jdbcTemplate;

    public CatalogoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper para CatalogoDTO
    private static class CatalogoRowMapper implements RowMapper<CatalogoDTO> {
        @Override
        public CatalogoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CatalogoDTO dto = new CatalogoDTO();
            dto.setId(rs.getString("CATALOGO"));
            dto.setNombre(rs.getString("ID_CODIGO_INDUSTRIA"));
            dto.setDescripcion(rs.getString("DESCRIPCION_INDUSTRIA"));

            BigDecimal riesgo = rs.getBigDecimal("PROBABILIDAD_RIESGO");
            dto.setRiesgo(riesgo);

            java.sql.Date fechaVigencia = rs.getDate("FECHA_VIGENCIA");
            if (fechaVigencia != null) {
                dto.setFechaVigencia(fechaVigencia.toLocalDate());
            }

            // Campos de auditoría
            Timestamp fechaCreacion = rs.getTimestamp("FECHA_CREACION");
            if (fechaCreacion != null) {
                dto.setFechaCreacion(fechaCreacion.toLocalDateTime());
            }

            dto.setUsuarioCreacion(rs.getString("USUARIO_CREACION"));

            Timestamp fechaModificacion = rs.getTimestamp("FECHA_ULTIMA_MODIFICACION");
            if (fechaModificacion != null) {
                dto.setFechaUltimaModificacion(fechaModificacion.toLocalDateTime());
            }

            dto.setUsuarioUltimaModificacion(rs.getString("USUARIO_ULTIMA_MODIFICACION"));

            return dto;
        }
    }

    // Guardar
    public int guardar(CatalogoDTO dto) {
        String sql = "INSERT INTO CDDLAFT_PERFIL_RIESGO_INDUSTRIA " +
                     "(CATALOGO, ID_CODIGO_INDUSTRIA, DESCRIPCION_INDUSTRIA, " +
                     "PROBABILIDAD_RIESGO, FECHA_VIGENCIA, FECHA_CREACION, " +
                     "USUARIO_CREACION) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
            dto.getId(),
            dto.getNombre(),
            dto.getDescripcion(),
            dto.getRiesgo(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaCreacion() != null ? Timestamp.valueOf(dto.getFechaCreacion()) : null,
            dto.getUsuarioCreacion()
        );
    }

    // Actualizar
    public int actualizar(CatalogoDTO dto) {
        String sql = "UPDATE CDDLAFT_PERFIL_RIESGO_INDUSTRIA SET " +
                     "ID_CODIGO_INDUSTRIA = ?, " +
                     "DESCRIPCION_INDUSTRIA = ?, " +
                     "PROBABILIDAD_RIESGO = ?, " +
                     "FECHA_VIGENCIA = ?, " +
                     "FECHA_ULTIMA_MODIFICACION = ?, " +
                     "USUARIO_ULTIMA_MODIFICACION = ? " +
                     "WHERE CATALOGO = ?";

        return jdbcTemplate.update(sql,
            dto.getNombre(),
            dto.getDescripcion(),
            dto.getRiesgo(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaUltimaModificacion() != null ? Timestamp.valueOf(dto.getFechaUltimaModificacion()) : null,
            dto.getUsuarioUltimaModificacion(),
            dto.getId()
        );
    }

    // Buscar por ID
    public Optional<CatalogoDTO> findById(String id) {
        String sql = "SELECT CATALOGO, ID_CODIGO_INDUSTRIA, DESCRIPCION_INDUSTRIA, " +
                     "PROBABILIDAD_RIESGO, FECHA_VIGENCIA, FECHA_CREACION, " +
                     "USUARIO_CREACION, FECHA_ULTIMA_MODIFICACION, " +
                     "USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_INDUSTRIA " +
                     "WHERE CATALOGO = ?";

        List<CatalogoDTO> results = jdbcTemplate.query(sql, new CatalogoRowMapper(), id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    // Listar todos
    public List<CatalogoDTO> findAll() {
        String sql = "SELECT CATALOGO, ID_CODIGO_INDUSTRIA, DESCRIPCION_INDUSTRIA, " +
                     "PROBABILIDAD_RIESGO, FECHA_VIGENCIA, FECHA_CREACION, " +
                     "USUARIO_CREACION, FECHA_ULTIMA_MODIFICACION, " +
                     "USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_INDUSTRIA " +
                     "ORDER BY CATALOGO";

        return jdbcTemplate.query(sql, new CatalogoRowMapper());
    }

    // Eliminar
    public int delete(String id) {
        String sql = "DELETE FROM CDDLAFT_PERFIL_RIESGO_INDUSTRIA WHERE CATALOGO = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Verificar existencia
    public boolean exists(String id) {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_INDUSTRIA WHERE CATALOGO = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    // Buscar por tipo (si el campo 'tipo' se mapea a alguna columna específica)
    public List<CatalogoDTO> findByTipo(String tipo) {
        String sql = "SELECT CATALOGO, ID_CODIGO_INDUSTRIA, DESCRIPCION_INDUSTRIA, " +
                     "PROBABILIDAD_RIESGO, FECHA_VIGENCIA, FECHA_CREACION, " +
                     "USUARIO_CREACION, FECHA_ULTIMA_MODIFICACION, " +
                     "USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_INDUSTRIA " +
                     "WHERE CATALOGO LIKE ? " +
                     "ORDER BY CATALOGO";

        return jdbcTemplate.query(sql, new CatalogoRowMapper(), tipo + "%");
    }

    // Contar registros
    public int count() {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_INDUSTRIA";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }
}
