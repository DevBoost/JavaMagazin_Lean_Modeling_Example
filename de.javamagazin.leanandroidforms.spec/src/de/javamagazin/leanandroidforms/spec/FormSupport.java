package de.javamagazin.leanandroidforms.spec;

import java.util.ArrayList;
import java.util.List;

import de.devboost.natspec.annotations.TextSyntax;
import de.javamagazin.leanandroidforms.spec.elements.EmailField;
import de.javamagazin.leanandroidforms.spec.elements.FormElement;
import de.javamagazin.leanandroidforms.spec.elements.Option;
import de.javamagazin.leanandroidforms.spec.elements.OptionSet;
import de.javamagazin.leanandroidforms.spec.elements.Question;

public class FormSupport {
	
	private List<FormElement> elements = new ArrayList<FormElement>();
	private int nextID = 1;

	@TextSyntax("Let user select between the following options:")
	public OptionSet addOptionSet() {
		String text = "Please select one of the following:";
		OptionSet optionSet = new OptionSet(nextID++, text);
		elements.add(optionSet);
		return optionSet;
	}

	@TextSyntax("- #1")
	public void addOption(List<String> parts, OptionSet optionSet) {
		String text = new StringUtils().explode(parts, " ");
		Option option = new Option(nextID++, text);
		optionSet.addOption(option);
	}

	@TextSyntax("Ask user: #1")
	public void askWouldYouLikeFrenchFriesWithThat(List<String> parts) {
		Question question = new Question(nextID++, new StringUtils().explode(parts, " "));
		elements.add(question);
	}

	public List<FormElement> getFormElements() {
		return elements;
	}

	@TextSyntax("Ask user for his email address.")
	public void askUserForHisEmailAddress() {
		elements.add(new EmailField(nextID++));
	}
}
