package com.fbeppler.ir.commons.util;

import org.apache.commons.lang3.StringUtils;

import com.fbeppler.ir.commons.tools.BrazilianStemmer;
import com.google.common.base.Strings;

public final class TextUtils {

	private static final BrazilianStemmer BRAZILIAN_STEMMER = new BrazilianStemmer();

	private TextUtils() {

	}

	public static String removeAccents(final String text) {
		return StringUtils.stripAccents(text);
	}

	public static String stemmer(final String term) {
		final String stem = BRAZILIAN_STEMMER.stem(term);
		if (Strings.isNullOrEmpty(stem)) {
			return term;
		}

		return stem;
	}

}
