package de.javamagazin.leanandroidforms.spec.elements;

import java.util.Collections;
import java.util.List;

public class Question extends FormElement {

	private String text;

	public Question(int id, String text) {
		super(id);
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public List<FormElement> getChildren() {
		return Collections.emptyList();
	}
}
