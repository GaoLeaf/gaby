package com.smile.jdbc.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gaowenjin
 * @date 2021/1/29
 * @description:
 */
public class JsonTypeHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (Objects.isNull(parameter)) {
            // 入参为空，以字符串形式存入
            ps.setNull(i, JdbcType.VARCHAR.TYPE_CODE);
        } else {
            // 入参不为空，将入参转成字符串
            if (parameter instanceof Set) {
                Set set = (Set) parameter;
                ps.setObject(i, set.stream().collect(Collectors.joining(",", "[", "]")), JdbcType.VARCHAR.TYPE_CODE);
            } else {
                ps.setNull(i, JdbcType.VARCHAR.TYPE_CODE);
            }
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

}
