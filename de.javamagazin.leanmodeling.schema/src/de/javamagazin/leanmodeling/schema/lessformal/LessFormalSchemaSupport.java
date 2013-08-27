package de.javamagazin.leanmodeling.schema.lessformal;

import java.util.List;

import de.devboost.natspec.annotations.TextSyntax;
import de.javamagazin.leanmodeling.schema.AbstractSchemaSupport;
import de.javamagazin.leanmodeling.schema.ddl.Column;
import de.javamagazin.leanmodeling.schema.ddl.Table;

public class LessFormalSchemaSupport extends AbstractSchemaSupport {

	@TextSyntax("A #1 is a #2")
	public Table createTable(String name, List<String> description) {
		Table newTable = new Table(getClassName(name));
		allTables.add(newTable);
		return newTable;
	}

	@TextSyntax("Every #1 has a #2")
	public void createColumn(String tableName, List<String> nameParts) {
		String propertyName = getColumnName(nameParts);
		String type = getType(getColumnName(nameParts));
		getClass(getClassName(tableName)).addColumn(new Column(propertyName, type));
	}

	@TextSyntax("It also has a #1")
	public void createColumn(List<String> nameParts, Table table) {
		String propertyName = getColumnName(nameParts);
		String type = getType(getColumnName(nameParts));
		table.addColumn(new Column(propertyName, type));
	}

	private String getType(String propertyName) {
		if (propertyName.equals("name") || propertyName.equals("type")) {
			return "VARCHAR(255)";
		}
		if (propertyName.equals("seatCount")) {
			return "INT";
		}
		if (propertyName.equals("airplaneType")) {
			return "INT";
		}
		if (propertyName.equals("dateOfBirth")) {
			return "DATETIME";
		}
		
		throw new RuntimeException("No type defined for property '" + propertyName + "'");
	}
}
