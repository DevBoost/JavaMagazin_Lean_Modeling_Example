package de.javamagazin.leanmodeling.schema.lessformal;

import java.io.IOException;

import de.javamagazin.leanmodeling.schema.AbstractNatSpecTemplate;
import de.javamagazin.leanmodeling.schema.AbstractSchemaSupport;

public class _NatSpecTemplate extends AbstractNatSpecTemplate {
	
	protected LessFormalSchemaSupport lessFormalSchemaSupport = new LessFormalSchemaSupport();

	public static void main(String[] args) throws IOException {
		new _NatSpecTemplate().run();
	}

	public void createDataModel() {
		// generated code will be inserted here
		/* @MethodBody */
	}

	@Override
	protected AbstractSchemaSupport getDataModelSupport() {
		return lessFormalSchemaSupport;
	}
}