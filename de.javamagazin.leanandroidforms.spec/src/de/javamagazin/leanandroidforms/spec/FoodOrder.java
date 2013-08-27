package de.javamagazin.leanandroidforms.spec;

public class FoodOrder {

	protected FormSupport formSupport = new FormSupport();

	public void createFormModel() {
		// generated code will be inserted here
		// The code in this method is generated from: /de.javamagazin.leanandroidforms.spec/src/de/javamagazin/leanandroidforms/spec/FoodOrder.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Let user select between the following options:
		de.javamagazin.leanandroidforms.spec.elements.OptionSet optionSet_ = formSupport.addOptionSet();
		// - Hamburger
		formSupport.addOption(java.util.Arrays.asList(new java.lang.String[] {"Hamburger"}), optionSet_);
		// - Cheeseburger
		formSupport.addOption(java.util.Arrays.asList(new java.lang.String[] {"Cheeseburger"}), optionSet_);
		// - Garden Salad
		formSupport.addOption(java.util.Arrays.asList(new java.lang.String[] {"Garden", "Salad"}), optionSet_);
		// Ask user: Would you like french fries with that?
		formSupport.askWouldYouLikeFrenchFriesWithThat(java.util.Arrays.asList(new java.lang.String[] {"Would", "you", "like", "french", "fries", "with", "that?"}));
		// Ask user: Do you collect bonus points?
		formSupport.askWouldYouLikeFrenchFriesWithThat(java.util.Arrays.asList(new java.lang.String[] {"Do", "you", "collect", "bonus", "points?"}));
		// Ask user for his email address.
		formSupport.askUserForHisEmailAddress();
		
	}

	public FormSupport getFormSupport() {
		return formSupport;
	}
}