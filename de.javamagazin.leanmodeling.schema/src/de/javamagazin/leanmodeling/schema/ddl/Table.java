package de.javamagazin.leanmodeling.schema.ddl;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private String name;
	private List<Column> columns = new ArrayList<Column>();

	public Table(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addColumn(Column column) {
		this.columns.add(column);
	}

	public List<Column> getColumns() {
		return columns;
	}
}
