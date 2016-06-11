package com.fbeppler.ir.commons.util;

import org.apache.commons.lang3.StringUtils;

public final class TextUtils {

	private TextUtils() {

	}

	public static String removeAccents(final String text) {
		return StringUtils.stripAccents(text);
	}

}
