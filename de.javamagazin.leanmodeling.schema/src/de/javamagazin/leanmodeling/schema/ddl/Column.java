package de.javamagazin.leanmodeling.schema.ddl;

public class Column {

	private String name;
	private String type;

	public Column(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
}
