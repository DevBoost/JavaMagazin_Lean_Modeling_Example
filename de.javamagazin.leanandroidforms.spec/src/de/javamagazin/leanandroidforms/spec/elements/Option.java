package de.javamagazin.leanandroidforms.spec.elements;

import java.util.Collections;
import java.util.List;

public class Option extends FormElement {

	private String name;

	public Option(int id, String name) {
		super(id);
		this.name = name;
	}

	@Override
	public String getText() {
		return name;
	}

	@Override
	public List<FormElement> getChildren() {
		return Collections.emptyList();
	}
}
