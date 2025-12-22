package app.dao.cdd;

import app.dto.cdd.TipoGrupoVariableDTO;
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
public class TipoGrupoVariableDAO {

    private final JdbcTemplate jdbcTemplate;

    public TipoGrupoVariableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper para TipoGrupoVariableDTO
    private static class TipoGrupoVariableRowMapper implements RowMapper<TipoGrupoVariableDTO> {
        @Override
        public TipoGrupoVariableDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            TipoGrupoVariableDTO dto = new TipoGrupoVariableDTO();

            BigDecimal tipoVariable = rs.getBigDecimal("TIPO_VARIABLE");
            dto.setTipoVariable(tipoVariable);

            BigDecimal grupoVariable = rs.getBigDecimal("GRUPO_VARIABLE");
            dto.setGrupoVariable(grupoVariable);

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
    public int guardar(TipoGrupoVariableDTO dto) {
        String sql = "INSERT INTO CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "(TIPO_VARIABLE, GRUPO_VARIABLE, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
            dto.getTipoVariable(),
            dto.getGrupoVariable(),
            dto.getProbabilidadRiesgo(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaCreacion() != null ? Timestamp.valueOf(dto.getFechaCreacion()) : Timestamp.valueOf(LocalDateTime.now()),
            dto.getUsuarioCreacion()
        );
    }

    // Actualizar
    public int actualizar(TipoGrupoVariableDTO dto) {
        String sql = "UPDATE CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE SET " +
                     "PROBABILIDAD_RIESGO = ?, " +
                     "FECHA_VIGENCIA = ?, " +
                     "FECHA_ULTIMA_MODIFICACION = ?, " +
                     "USUARIO_ULTIMA_MODIFICACION = ? " +
                     "WHERE TIPO_VARIABLE = ? AND GRUPO_VARIABLE = ?";

        return jdbcTemplate.update(sql,
            dto.getProbabilidadRiesgo(),
            dto.getFechaVigencia() != null ? java.sql.Date.valueOf(dto.getFechaVigencia()) : null,
            dto.getFechaUltimaModificacion() != null ? Timestamp.valueOf(dto.getFechaUltimaModificacion()) : Timestamp.valueOf(LocalDateTime.now()),
            dto.getUsuarioUltimaModificacion(),
            dto.getTipoVariable(),
            dto.getGrupoVariable()
        );
    }

    // Buscar por tipo y grupo de variable (clave compuesta)
    public Optional<TipoGrupoVariableDTO> findByTipoAndGrupo(BigDecimal tipoVariable, BigDecimal grupoVariable) {
        String sql = "SELECT TIPO_VARIABLE, GRUPO_VARIABLE, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "WHERE TIPO_VARIABLE = ? AND GRUPO_VARIABLE = ?";

        List<TipoGrupoVariableDTO> results = jdbcTemplate.query(sql, new TipoGrupoVariableRowMapper(), tipoVariable, grupoVariable);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    // Listar todos
    public List<TipoGrupoVariableDTO> findAll() {
        String sql = "SELECT TIPO_VARIABLE, GRUPO_VARIABLE, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "ORDER BY TIPO_VARIABLE, GRUPO_VARIABLE";

        return jdbcTemplate.query(sql, new TipoGrupoVariableRowMapper());
    }

    // Buscar por tipo de variable
    public List<TipoGrupoVariableDTO> findByTipoVariable(BigDecimal tipoVariable) {
        String sql = "SELECT TIPO_VARIABLE, GRUPO_VARIABLE, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "WHERE TIPO_VARIABLE = ? " +
                     "ORDER BY GRUPO_VARIABLE";

        return jdbcTemplate.query(sql, new TipoGrupoVariableRowMapper(), tipoVariable);
    }

    // Buscar por grupo de variable
    public List<TipoGrupoVariableDTO> findByGrupoVariable(BigDecimal grupoVariable) {
        String sql = "SELECT TIPO_VARIABLE, GRUPO_VARIABLE, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "WHERE GRUPO_VARIABLE = ? " +
                     "ORDER BY TIPO_VARIABLE";

        return jdbcTemplate.query(sql, new TipoGrupoVariableRowMapper(), grupoVariable);
    }

    // Eliminar
    public int delete(BigDecimal tipoVariable, BigDecimal grupoVariable) {
        String sql = "DELETE FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "WHERE TIPO_VARIABLE = ? AND GRUPO_VARIABLE = ?";
        return jdbcTemplate.update(sql, tipoVariable, grupoVariable);
    }

    // Verificar existencia
    public boolean exists(BigDecimal tipoVariable, BigDecimal grupoVariable) {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "WHERE TIPO_VARIABLE = ? AND GRUPO_VARIABLE = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, tipoVariable, grupoVariable);
        return count != null && count > 0;
    }

    // Contar registros
    public int count() {
        String sql = "SELECT COUNT(*) FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count != null ? count : 0;
    }

    // Buscar registros vigentes
    public List<TipoGrupoVariableDTO> findVigentes() {
        String sql = "SELECT TIPO_VARIABLE, GRUPO_VARIABLE, PROBABILIDAD_RIESGO, " +
                     "FECHA_VIGENCIA, FECHA_CREACION, USUARIO_CREACION, " +
                     "FECHA_ULTIMA_MODIFICACION, USUARIO_ULTIMA_MODIFICACION " +
                     "FROM CDDLAFT_PERFIL_TIPO_GRUPO_VARIABLE " +
                     "WHERE FECHA_VIGENCIA <= SYSDATE " +
                     "ORDER BY TIPO_VARIABLE, GRUPO_VARIABLE";

        return jdbcTemplate.query(sql, new TipoGrupoVariableRowMapper());
    }
}
