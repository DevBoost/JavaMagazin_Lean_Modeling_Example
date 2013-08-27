package de.javamagazin.leanandroidforms.spec.codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.javamagazin.leanandroidforms.spec.FoodOrder;
import de.javamagazin.leanandroidforms.spec.FormSupport;
import de.javamagazin.leanandroidforms.spec.elements.EmailField;
import de.javamagazin.leanandroidforms.spec.elements.FormElement;
import de.javamagazin.leanandroidforms.spec.elements.Option;
import de.javamagazin.leanandroidforms.spec.elements.OptionSet;
import de.javamagazin.leanandroidforms.spec.elements.Question;

public class CodeGenerator {

	public static void main(String[] args) {
		new CodeGenerator().run();
	}

	private void run() {
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.createFormModel();
		FormSupport formSupport = foodOrder.getFormSupport();
		List<FormElement> formElements = formSupport.getFormElements();
		String code = createActivityMainXML(formElements);
		saveLayout(code);
		code = createStringsXML(formElements);
		saveStrings(code);
	}

	private String createStringsXML(List<FormElement> formElements) {
		StringBuilder code = new StringBuilder();
		code.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		code.append("<resources>\n");
		code.append("<string name=\"app_name\">LeanAndroidForms</string>\n");
		code.append("<string name=\"action_settings\">Settings</string>\n");
		code.append("<string name=\"text0\">Lean Android Form</string>\n");
		code.append("<string name=\"text_yesplease\">Yes, please!</string>\n");
		
		for (FormElement formElement : formElements) {
			code.append(createStringsXML(formElement));
		}
		code.append("</resources>");
		return code.toString();
	}

	private String createStringsXML(FormElement formElement) {
		StringBuilder code = new StringBuilder();
		int id = formElement.getId();
		String text = formElement.getText();
		code.append("<string name=\"text" + id + "\">" + text + "</string>\n");
		for (FormElement child : formElement.getChildren()) {
			code.append(createStringsXML(child));
		}
		return code.toString();
	}

	private void saveLayout(String code) {
		save("layout" + File.separator + "activity_main.xml", code);
	}

	private void saveStrings(String code) {
		save("values" + File.separator + "strings.xml", code);
	}

	private void save(String path, String code) {
		try {
			FileWriter writer = new FileWriter(new File(".." + File.separator + "de.javamagazin.leanandroidforms.app" + File.separator + "res" + File.separator
					+ path));
			writer.write(code);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String createActivityMainXML(List<FormElement> formElements) {
		StringBuilder code = new StringBuilder();
		code.append("<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\" ");
		code.append("xmlns:tools=\"http://schemas.android.com/tools\" ");
		code.append("android:layout_width=\"match_parent\" ");
		code.append("android:layout_height=\"match_parent\" ");
		code.append("android:paddingBottom=\"@dimen/activity_vertical_margin\" ");
		code.append("android:paddingLeft=\"@dimen/activity_horizontal_margin\" ");
		code.append("android:paddingRight=\"@dimen/activity_horizontal_margin\" ");
		code.append("android:paddingTop=\"@dimen/activity_vertical_margin\" ");
		code.append("tools:context=\".MainActivity\" >");
		code.append("\n");
		String lastElementID = null;
		String elementID;
		for (FormElement formElement : formElements) {
			if (formElement instanceof Question) {
				Question question = (Question) formElement;
				int id = question.getId();
				elementID = "textView" + id;
				code.append("<TextView ");
				code.append("android:id=\"@+id/" + elementID + "\" ");
				code.append("android:layout_width=\"wrap_content\" ");
				code.append("android:layout_height=\"wrap_content\" ");
				addAlignment(code, lastElementID);
				code.append("android:text=\"@string/text" + id + "\" />");
				code.append("\n");
				lastElementID = elementID;

				elementID = "checkBox" + id;
				code.append("<CheckBox ");
				code.append("android:id=\"@+id/" + elementID + "\" ");
				code.append("android:layout_width=\"wrap_content\" ");
				code.append("android:layout_height=\"wrap_content\" ");
				addAlignment(code, lastElementID);
				code.append("android:text=\"@string/text_yesplease\" />");
				code.append("\n");
				lastElementID = elementID;
			} else if (formElement instanceof OptionSet) {
				OptionSet optionSet = (OptionSet) formElement;
				int id = optionSet.getId();
				elementID = "textView" + optionSet.getId();
				code.append("<TextView ");
				code.append("android:id=\"@+id/" + elementID + "\" ");
				code.append("android:layout_width=\"wrap_content\" ");
				code.append("android:layout_height=\"wrap_content\" ");
				addAlignment(code, lastElementID);
				code.append("android:text=\"@string/text" + id + "\" />");
				code.append("\n");
				lastElementID = elementID;
				elementID = "radioGroup" + optionSet.getId();
				code.append("<RadioGroup ");
				code.append("android:id=\"@+id/" + elementID + "\" ");
				code.append("android:layout_width=\"wrap_content\" ");
				code.append("android:layout_height=\"wrap_content\" ");
				addAlignment(code, lastElementID);
				code.append(">\n");
				lastElementID = elementID;

				List<Option> options = optionSet.getOptions();
				for (Option option : options) {
					id = option.getId();
					elementID = "radioButton" + id;
					code.append("<RadioButton ");
					code.append("android:id=\"@+id/" + elementID + "\" ");
					code.append("android:layout_width=\"wrap_content\" ");
					code.append("android:layout_height=\"wrap_content\" ");
					//addAlignment(code, lastElementID);
					code.append("android:text=\"@string/text" + id + "\" />");
					code.append("\n");
					//lastElementID = elementID;
				}
				code.append("</RadioGroup>\n");
			} else if (formElement instanceof EmailField) {
				EmailField emailField = (EmailField) formElement;
				int id = emailField.getId();
				elementID = "textView" + id;
				code.append("<TextView ");
				code.append("android:id=\"@+id/" + elementID + "\" ");
				code.append("android:layout_width=\"wrap_content\" ");
				code.append("android:layout_height=\"wrap_content\" ");
				addAlignment(code, lastElementID);
				code.append("android:text=\"@string/text" + id + "\" />");
				code.append("\n");
				lastElementID = elementID;

				elementID = "editText" + id;
				code.append("<EditText ");
				code.append("android:id=\"@+id/" + elementID + "\" ");
				code.append("android:layout_width=\"wrap_content\" ");
				code.append("android:layout_height=\"wrap_content\" ");
				addAlignment(code, lastElementID);
				code.append("android:ems=\"10\" ");
				code.append("android:inputType=\"textEmailAddress\" > ");
				code.append("<requestFocus /> ");
				code.append("</EditText>\n");
				lastElementID = elementID;
			}
		}
		
		code.append("<Button android:id=\"@+id/sendbutton\" ");
		code.append("android:layout_width=\"wrap_content\" ");
		code.append("android:layout_height=\"wrap_content\" ");
		addAlignment(code, lastElementID);
		code.append("android:text=\"Send\" />\n");

		code.append("</RelativeLayout>");
		return code.toString();
	}

	private void addAlignment(StringBuilder code, String lastElementID) {
		if (lastElementID == null) {
			return;
		}
		code.append("android:layout_alignLeft=\"@+id/" + lastElementID + "\" ");
		code.append("android:layout_below=\"@+id/" + lastElementID + "\" ");
	}
}
