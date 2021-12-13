package com.employee.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtils {

	public boolean isBlankString(String string) {
		return string == null || string.isBlank();
	}
}
