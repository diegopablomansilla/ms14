package com.massoftware.c.persist.dao.util;

import java.util.List;

import com.massoftware.b.service.util.GenericFilter;
import com.massoftware.c.persist.dao.ds.info.Statement;

public abstract class AbstractDAO {

	// ---------------------------------------------------------------------------------------------------------------------------

	// String translate =
	// ",'/\"'';,_-.âãäåāăąàáÁÂÃÄÅĀĂĄÀèééêëēĕėęěĒĔĖĘĚÉÈËÊìíîïìĩīĭÌÍÎÏÌĨĪĬóôõöōŏőòÒÓÔÕÖŌŎŐùúûüũūŭůÙÚÛÜŨŪŬŮçÇñÑ',
	// '
	// aaaaaaaaaAAAAAAAAAeeeeeeeeeeEEEEEEEEEiiiiiiiiIIIIIIIIooooooooOOOOOOOOuuuuuuuuUUUUUUUUcCnN'";
	private final String TRANSLATE = ",'/\"'';,_-.âãäåàáÁÂÃÄÅÀèééêëÉÈËÊìíîïìÌÍÎÏÌóôõöòÒÓÔÕÖùúûüÙÚÛÜçÇñÑ', '        aaaaaaAAAAAAeeeeeEEEEiiiiiIIIIIoooooOOOOOuuuuUUUUcCnN'";
	private final String MSG_1 = "LIMIT ? OFFSET ?";
	private final String MSG_2 = "LIMIT ?";

	// ---------------------------------------------------------------------------------------------------------------------------

	// es igual al operador donde los valores coinciden exactamente.
	protected String buildLIKE(String attName) {
		return "TRANSLATE(LOWER(" + attName + ")" + TRANSLATE + ") LIKE TRANSLATE(? " + TRANSLATE + ")";
	}

	// es igual al operador donde los valores coinciden exactamente.
	protected String buildEQ(String attName) {
		return attName + " = ?";
	}

	// no es igual a donde los valores no coinciden.
	protected String buildNEQ(String attName) {
		return attName + " <> ?";
	}

	// mayor o igual que el valor especificado
	protected String buildGE(String attName) {
		return attName + " >= ?";
	}

	// menor o igual al valor especificado
	protected String buildLE(String attName) {
		return attName + " <= ?";
	}

	// mayor que el valor especificado
	protected String buildGT(String attName) {
		return attName + " > ?";
	}

	// menor que el valor especificado
	protected String buildLT(String attName) {
		return attName + " < ?";
	}

	protected void addArgGE(Statement statement, List<String> sqlWhereArgs, String attName, Object value) {
		if (value != null) {
			statement.addArg(value);
			sqlWhereArgs.add(buildGE(attName));
		}
	}

	protected void addArgLE(Statement statement, List<String> sqlWhereArgs, String attName, Object value) {
		if (value != null) {
			statement.addArg(value);
			sqlWhereArgs.add(buildLE(attName));
		}
	}

	protected void addArgEQ(Statement statement, List<String> sqlWhereArgs, String attName, Object value) {
		if (value != null) {
			statement.addArg(value);
			sqlWhereArgs.add(buildEQ(attName));
		}
	}

	protected void addArgLIKE(Statement statement, List<String> sqlWhereArgs, String attName, String value) {
		if (value != null) {

			String[] words = value.trim().toLowerCase().split(" ");

			for (String word : words) {
				word = word.trim();
				if (word.length() > 0) {
					statement.addArg("%" + word + "%");
					sqlWhereArgs.add(buildLIKE(attName));
				}
			}

		}
	}

	protected String buildWhereSQL(List<String> sqlWhereArgs) {
		if (sqlWhereArgs.size() == 0) {
			return "";
		}

		StringBuilder sqlWhere = new StringBuilder("WHERE\t");
		for (int i = 0; i < sqlWhereArgs.size(); i++) {
			sqlWhere.append(i == 0 ? sqlWhereArgs.get(i) : "\n\tAND " + sqlWhereArgs.get(i));
		}

		return sqlWhere.toString();
	}

	protected String buildOrderSQL(GenericFilter filter) {

		return "ORDER BY " + filter.getOrderBy() + (filter.getOrderByDesc() ? " DESC" : "");
	}

	protected String buildPageSQL(GenericFilter filter) {
		String sql = "";

		if (filter.getLimit() != null && filter.getOffset() > 0) {

			sql = MSG_1;

		} else if (filter.getLimit() != null) {
			sql = MSG_2;
		}

		return sql;
	}

	protected void addArgsPage(GenericFilter filter, Statement statement) {

		if (filter.getLimit() != null && filter.getOffset() > 0) {

			statement.addArg(filter.getLimit());
			statement.addArg(filter.getOffset());

		} else if (filter.getLimit() != null) {
			statement.addArg(filter.getLimit());
		}

	}

} // END CLASS -----------------------------------------------------------------
