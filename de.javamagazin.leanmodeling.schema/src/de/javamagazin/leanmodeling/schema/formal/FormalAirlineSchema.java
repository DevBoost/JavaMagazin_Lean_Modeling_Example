package de.javamagazin.leanmodeling.schema.formal;

import java.io.IOException;

import de.javamagazin.leanmodeling.schema.AbstractNatSpecTemplate;
import de.javamagazin.leanmodeling.schema.AbstractSchemaSupport;

public class FormalAirlineSchema extends AbstractNatSpecTemplate {
	
	protected FomalSchemaSupport fomalSchemaSupport = new FomalSchemaSupport();
	
	public static void main(String[] args) throws IOException {
		new FormalAirlineSchema().run();
	}

	public void createDataModel() {
		// generated code will be inserted here
		// The code in this method is generated from: /de.javamagazin.leanmodeling.schema/src/de/javamagazin/leanmodeling/schema/formal/FormalAirlineSchema.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// There is a table Airplane
		de.javamagazin.leanmodeling.schema.ddl.Table table_Airplane = fomalSchemaSupport.createTable("Airplane");
		// Every Airplane has a type which is a textual property.
		fomalSchemaSupport.addColumn(table_Airplane, java.util.Arrays.asList(new java.lang.String[] {"type"}), "textual");
		// Every Airplane has a seat count which is a numeric property.
		fomalSchemaSupport.addColumn(table_Airplane, java.util.Arrays.asList(new java.lang.String[] {"seat", "count"}), "numeric");
		// There is a table Passenger
		de.javamagazin.leanmodeling.schema.ddl.Table table_Passenger = fomalSchemaSupport.createTable("Passenger");
		// Every Passenger has a name which is a textual property.
		fomalSchemaSupport.addColumn(table_Passenger, java.util.Arrays.asList(new java.lang.String[] {"name"}), "textual");
		// Every Passenger has a date of birth which is a date property.
		fomalSchemaSupport.addColumn(table_Passenger, java.util.Arrays.asList(new java.lang.String[] {"date", "of", "birth"}), "date");
		// There is a table Flight
		de.javamagazin.leanmodeling.schema.ddl.Table table_Flight = fomalSchemaSupport.createTable("Flight");
		// Every Flight has an airplane type which refers to table Airplane
		fomalSchemaSupport.addReference(table_Flight, java.util.Arrays.asList(new java.lang.String[] {"airplane", "type"}), table_Airplane);
		
	}

	@Override
	protected AbstractSchemaSupport getDataModelSupport() {
		return fomalSchemaSupport;
	}
}