package de.javamagazin.leanmodeling.schema.formal;

import java.io.IOException;

import de.javamagazin.leanmodeling.schema.AbstractNatSpecTemplate;
import de.javamagazin.leanmodeling.schema.AbstractSchemaSupport;

public class _NatSpecTemplate extends AbstractNatSpecTemplate {
	
	protected FomalSchemaSupport fomalSchemaSupport = new FomalSchemaSupport();
	
	public static void main(String[] args) throws IOException {
		new _NatSpecTemplate().run();
	}

	public void createDataModel() {
		// generated code will be inserted here
		/* @MethodBody */
	}

	@Override
	protected AbstractSchemaSupport getDataModelSupport() {
		return fomalSchemaSupport;
	}
}