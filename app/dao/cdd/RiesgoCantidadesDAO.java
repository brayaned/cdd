package app.dao.cdd;

import app.dto.cdd.RiesgoCantidadesDTO;
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
public class RiesgoCantidadesDAO {

    private final JdbcTemplate jdbcTemplate;

    public RiesgoCantidadesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper para RiesgoCantidadesDTO
    private static class RiesgoCantidadesRowMapper implements RowMapper<RiesgoCantidadesDTO> {
        @Override
        public RiesgoCantidadesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            RiesgoCantidadesDTO dto = new RiesgoCantidadesDTO();

            dto.setCatalogo(rs.getString("CATALOGO"));

            BigDecimal codigoCantidad = rs.getBigDecimal("CODIGO_CANTIDAD");
            dto.setCodigoCantidad(codigoCantidad);

            BigDecimal probabilidadRiesgo = rs.getBigDecimal("PROBABILIDAD_RIESGO");
            dto.setProbabilidadRiesgo(probabilidadRiesgo);

            BigDecimal valorInicial = rs.getBigDecimal("VALOR_INICIAL");
            dto.setValorInicial(valorInicial);

            BigDecimal valorFinal = rs.getBigDecimal("VALOR_FINAL");
            dto.setValorFinal(valorFinal);

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
    public int guardar(RiesgoCantidadesDTO dto) {
        String sql = "INSERT INTO CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "(CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
            dto.getCatalogo(),
            dto.getCodigoCantidad(),
            dto.getProbabilidadRiesgo(),
            dto.getValorInicial(),
            dto.getValorFinal(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaCreacion() != null ? Timestamp.valueOf(dto.getFechaCreacion()) : Timestamp.valueOf(LocalDateTime.now()),
            dto.getUsuarioCreacion()
        );
    }

    // Actualizar
    public int actualizar(RiesgoCantidadesDTO dto) {
        String sql = "UPDATE CDDLAFT_PERFIL_RIESGO_CANTIDADES SET " +
                     "PROBABILIDAD_RIESGO = ?, " +
                     "VALOR_INICIAL = ?, " +
                     "VALOR_FINAL = ?, " +
                     "FECHA_VIGENCIA = ?, " +
                     "FECHA_ULTIMA_MODIFICACION = ?, " +
                     "USUARIO_ULTIMA_MODIFICACION = ? " +
                     "WHERE CATALOGO = ? AND CODIGO_CANTIDAD = ?";

        return jdbcTemplate.update(sql,
            dto.getProbabilidadRiesgo(),
            dto.getValorInicial(),
            dto.getValorFinal(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaUltimaModificacion() != null ? Timestamp.valueOf(dto.getFechaUltimaModificacion()) : Timestamp.valueOf(LocalDateTime.now()),
            dto.getUsuarioUltimaModificacion(),
            dto.getCatalogo(),
            dto.getCodigoCantidad()
        );
    }

    // Buscar por catálogo y código de cantidad (clave compuesta)
    public Optional<RiesgoCantidadesDTO> findByCatalogoAndCodigo(String catalogo, BigDecimal codigoCantidad) {
        String sql = "SELECT CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE CATALOGO = ? AND CODIGO_CANTIDAD = ?";

        List<RiesgoCantidadesDTO> results = jdbcTemplate.query(sql, new RiesgoCantidadesRowMapper(), catalogo, codigoCantidad);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    // Listar todos
    public List<RiesgoCantidadesDTO> findAll() {
        String sql = "SELECT CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "ORDER BY CATALOGO, CODIGO_CANTIDAD";

        return jdbcTemplate.query(sql, new RiesgoCantidadesRowMapper());
    }

    // Buscar por catálogo
    public List<RiesgoCantidadesDTO> findByCatalogo(String catalogo) {
        String sql = "SELECT CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE CATALOGO = ? " +
                     "ORDER BY CODIGO_CANTIDAD";

        return jdbcTemplate.query(sql, new RiesgoCantidadesRowMapper(), catalogo);
    }

    // Buscar por rango de valores (valores entre valorInicial y valorFinal)
    public List<RiesgoCantidadesDTO> findByRangoValor(String catalogo, BigDecimal valor) {
        String sql = "SELECT CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE CATALOGO = ? AND ? BETWEEN VALOR_INICIAL AND VALOR_FINAL " +
                     "ORDER BY CODIGO_CANTIDAD";

        return jdbcTemplate.query(sql, new RiesgoCantidadesRowMapper(), catalogo, valor);
    }

    // Eliminar
    public int delete(String catalogo, BigDecimal codigoCantidad) {
        String sql = "DELETE FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE CATALOGO = ? AND CODIGO_CANTIDAD = ?";
        return jdbcTemplate.update(sql, catalogo, codigoCantidad);
    }

    // Verificar existencia
    public boolean exists(String catalogo, BigDecimal codigoCantidad) {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE CATALOGO = ? AND CODIGO_CANTIDAD = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, catalogo, codigoCantidad);
        return count != null && count > 0;
    }

    // Contar registros
    public int count() {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }

    // Contar registros por catálogo
    public int countByCatalogo(String catalogo) {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES WHERE CATALOGO = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, catalogo);
        return count != null ? count : 0;
    }

    // Buscar registros vigentes
    public List<RiesgoCantidadesDTO> findVigentes() {
        String sql = "SELECT CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE FECHA_VIGENCIA <= SYSDATE " +
                     "ORDER BY CATALOGO, CODIGO_CANTIDAD";

        return jdbcTemplate.query(sql, new RiesgoCantidadesRowMapper());
    }

    // Buscar registros vigentes por catálogo
    public List<RiesgoCantidadesDTO> findVigentesByCatalogo(String catalogo) {
        String sql = "SELECT CATALOGO, CODIGO_CANTIDAD, PROBABILIDAD_RIESGO, VALOR_INICIAL, " +
                     "VALOR_FINAL, FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_RIESGO_CANTIDADES " +
                     "WHERE CATALOGO = ? AND FECHA_VIGENCIA <= SYSDATE " +
                     "ORDER BY CODIGO_CANTIDAD";

        return jdbcTemplate.query(sql, new RiesgoCantidadesRowMapper(), catalogo);
    }
}
