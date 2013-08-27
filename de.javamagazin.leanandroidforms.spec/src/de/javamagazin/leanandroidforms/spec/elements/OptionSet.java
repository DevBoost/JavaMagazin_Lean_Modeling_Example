package de.javamagazin.leanandroidforms.spec.elements;

import java.util.ArrayList;
import java.util.List;

public class OptionSet extends FormElement {

	private String text;

	public OptionSet(int id, String text) {
		super(id);
		this.text = text;
	}

	private List<Option> options = new ArrayList<Option>();

	public void addOption(Option option) {
		options.add(option);
	}

	public List<Option> getOptions() {
		return options;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public List<FormElement> getChildren() {
		return new ArrayList<FormElement>(options);
	}
}
