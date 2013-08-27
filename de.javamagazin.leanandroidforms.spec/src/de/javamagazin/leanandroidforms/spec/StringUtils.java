package de.javamagazin.leanandroidforms.spec;

import java.util.Collection;
import java.util.Iterator;

public class StringUtils {

	/**
	 * Concatenates each element from the 'parts' collection and puts 'glue'
	 * in between.
	 * 
	 * @param parts
	 * @param glue
	 * @return
	 */
	public String explode(Collection<String> parts, String glue) {
		StringBuffer result = new StringBuffer();
		int size = parts.size();
		Iterator<String> iterator = parts.iterator();
		for (int i = 0; i < size; i++) {
			result.append(iterator.next());
			if (i < size - 1) {
				result.append(glue);
			}
		}
		return result.toString();
	}

}
