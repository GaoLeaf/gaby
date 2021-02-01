package com.smile.jdbc.mybatis.type;

import com.smile.tool.json.JsonParser;
import com.smile.tool.json.JsonSerializer;
import com.smile.tool.lang.Strings;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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
            ps.setObject(i, JsonSerializer.stringify(parameter), JdbcType.VARCHAR.TYPE_CODE);
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return Strings.isEmpty(value) ? value : JsonParser.parse(value);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return Strings.isEmpty(value) ? value : JsonParser.parse(value);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return Strings.isEmpty(value) ? value : JsonParser.parse(value);
    }

}
