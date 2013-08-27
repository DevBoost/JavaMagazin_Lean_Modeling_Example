package de.javamagazin.leanmodeling.schema;

import java.util.ArrayList;
import java.util.List;

import de.javamagazin.leanmodeling.schema.ddl.Table;

public abstract class AbstractSchemaSupport {

	protected List<Table> allTables = new ArrayList<Table>();

	public List<Table> getAllTables() {
		return allTables;
	}

	protected String getClassName(String name) {
		return name.toLowerCase();
	}

	protected String getColumnName(List<String> nameParts) {
		String columnName = "";
		int parts = nameParts.size();
		for (int i = 0; i < parts; i++) {
			String nextPart = nameParts.get(i);
			if (i > 0) {
				columnName += "_" + nextPart.toLowerCase();
			} else {
				columnName += nextPart;
			}
		}
		if (columnName.endsWith(".")) {
			columnName = columnName.substring(0, columnName.length() - 1);
		}
		return columnName;
	}

	protected Table getClass(String tableName) {
		for (Table table : allTables) {
			if (table.getName().equals(tableName)) {
				return table;
			}
		}
		throw new RuntimeException("Can't find table '" + tableName  + "'.");
	}
}
