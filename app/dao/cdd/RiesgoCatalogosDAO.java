package app.dao.cdd;

import app.dto.cdd.CatalogosDTO;
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
public class RiesgoCatalogosDAO {

    private final JdbcTemplate jdbcTemplate;

    public RiesgoCatalogosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper para CatalogosDTO
    private static class CatalogosRowMapper implements RowMapper<CatalogosDTO> {
        @Override
        public CatalogosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CatalogosDTO dto = new CatalogosDTO();
            dto.setNombreCatalogo(rs.getString("NOMBRE_CATALOGO"));
            dto.setTipoCatalogo(rs.getString("TIPO_CATALOGO"));

            BigDecimal probabilidadRiesgo = rs.getBigDecimal("PROBABILIDAD_RIESGO");
            dto.setProbabilidadRiesgo(probabilidadRiesgo);

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
    public int guardar(CatalogosDTO dto) {
        String sql = "INSERT INTO CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "(NOMBRE_CATALOGO, TIPO_CATALOGO, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
            dto.getNombreCatalogo(),
            dto.getTipoCatalogo(),
            dto.getProbabilidadRiesgo(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaCreacion() != null ? Timestamp.valueOf(dto.getFechaCreacion()) : Timestamp.valueOf(LocalDateTime.now()),
            dto.getUsuarioCreacion()
        );
    }

    // Actualizar
    public int actualizar(CatalogosDTO dto) {
        String sql = "UPDATE CDDLAFT_PERFIL_RIESGO_CATALOGOS SET " +
                     "PROBABILIDAD_RIESGO = ?, " +
                     "FECHA_VIGENCIA = ?, " +
                     "FECHA_ULTIMA_MODIFICACION = ?, " +
                     "USUARIO_ULTIMA_MODIFICACION = ? " +
                     "WHERE NOMBRE_CATALOGO = ? AND TIPO_CATALOGO = ?";

        return jdbcTemplate.update(sql,
            dto.getProbabilidadRiesgo(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaUltimaModificacion() != null ? Timestamp.valueOf(dto.getFechaUltimaModificacion()) : Timestamp.valueOf(LocalDateTime.now()),
            dto.getUsuarioUltimaModificacion(),
            dto.getNombreCatalogo(),
            dto.getTipoCatalogo()
        );
    }

    // Buscar por nombre y tipo de catálogo (clave compuesta)
    public Optional<CatalogosDTO> findByNombreAndTipo(String nombreCatalogo, String tipoCatalogo) {
        String sql = "SELECT NOMBRE_CATALOGO, TIPO_CATALOGO, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "WHERE NOMBRE_CATALOGO = ? AND TIPO_CATALOGO = ?";

        List<CatalogosDTO> results = jdbcTemplate.query(sql, new CatalogosRowMapper(), nombreCatalogo, tipoCatalogo);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    // Listar todos
    public List<CatalogosDTO> findAll() {
        String sql = "SELECT NOMBRE_CATALOGO, TIPO_CATALOGO, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "ORDER BY NOMBRE_CATALOGO, TIPO_CATALOGO";

        return jdbcTemplate.query(sql, new CatalogosRowMapper());
    }

    // Buscar por tipo de catálogo
    public List<CatalogosDTO> findByTipoCatalogo(String tipoCatalogo) {
        String sql = "SELECT NOMBRE_CATALOGO, TIPO_CATALOGO, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "WHERE TIPO_CATALOGO = ? " +
                     "ORDER BY NOMBRE_CATALOGO";

        return jdbcTemplate.query(sql, new CatalogosRowMapper(), tipoCatalogo);
    }

    // Eliminar
    public int delete(String nombreCatalogo, String tipoCatalogo) {
        String sql = "DELETE FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "WHERE NOMBRE_CATALOGO = ? AND TIPO_CATALOGO = ?";
        return jdbcTemplate.update(sql, nombreCatalogo, tipoCatalogo);
    }

    // Verificar existencia
    public boolean exists(String nombreCatalogo, String tipoCatalogo) {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "WHERE NOMBRE_CATALOGO = ? AND TIPO_CATALOGO = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, nombreCatalogo, tipoCatalogo);
        return count != null && count > 0;
    }

    // Contar registros
    public int count() {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }

    // Buscar catálogos vigentes
    public List<CatalogosDTO> findVigentes() {
        String sql = "SELECT NOMBRE_CATALOGO, TIPO_CATALOGO, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CATALOGOS " +
                     "WHERE FECHA_VIGENCIA <= SYSDATE " +
                     "ORDER BY NOMBRE_CATALOGO, TIPO_CATALOGO";

        return jdbcTemplate.query(sql, new CatalogosRowMapper());
    }
}
