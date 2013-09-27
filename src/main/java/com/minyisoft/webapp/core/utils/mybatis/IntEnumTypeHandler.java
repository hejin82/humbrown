package com.minyisoft.webapp.core.utils.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.minyisoft.webapp.core.model.enumField.CoreEnumHelper;
import com.minyisoft.webapp.core.model.enumField.ICoreEnum;

public class IntEnumTypeHandler<E extends ICoreEnum<Integer>> extends
		BaseTypeHandler<E> {
	private Class<E> type;

	public IntEnumTypeHandler(Class<E> type) {
		if (type == null)
			throw new IllegalArgumentException("Type argument cannot be null");
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return getEnum(rs.getInt(columnName));
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return getEnum(rs.getInt(columnIndex));
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return getEnum(cs.getInt(columnIndex));
	}

	private E getEnum(int value) {
		return CoreEnumHelper.getEnum(type, value);
	}
}