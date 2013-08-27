package de.javamagazin.leanmodeling.schema.formal;

import java.util.List;

import de.devboost.natspec.annotations.TextSyntax;
import de.javamagazin.leanmodeling.schema.AbstractSchemaSupport;
import de.javamagazin.leanmodeling.schema.ddl.Column;
import de.javamagazin.leanmodeling.schema.ddl.Table;

public class FomalSchemaSupport extends AbstractSchemaSupport {
	
	@TextSyntax("There is a table #1.")
	public Table createTable(String name) {
		Table newTable = new Table(name.toLowerCase());
		allTables.add(newTable);
		return newTable;
	}

	@TextSyntax("Every #1 has a #2 which is a #3 property.")
	public void addColumn(Table table, List<String> nameParts, String typeName) {
		String columnName = getColumnName(nameParts);
		String type = getType(typeName);
		Column newField = new Column(columnName, type);
		table.addColumn(newField);
	}

	@TextSyntax("Every #1 has an #2 which refers to table #3.")
	public void addReference(Table table, List<String> nameParts,
			Table otherTable) {

		String columnName = getColumnName(nameParts);
		Column newColumn = new Column(columnName, "INT");
		table.addColumn(newColumn);
	}

	private String getType(String propertyType) {
		String type;
		if ("textual".equals(propertyType)) {
			type = "VARCHAR(255)";
		} else if ("numeric".equals(propertyType)) {
			type = "INT";
		} else if ("date".equals(propertyType)) {
			type = "DATETIME";
		} else {
			throw new RuntimeException("Unknown type.");
		}
		return type;
	}
}
