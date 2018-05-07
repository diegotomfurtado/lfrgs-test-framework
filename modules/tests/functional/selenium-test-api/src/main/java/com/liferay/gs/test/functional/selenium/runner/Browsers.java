package com.liferay.gs.test.functional.selenium.runner;

import com.liferay.gs.test.functional.selenium.constants.BrowserDrivers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrew Betts
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Browsers {

	public String[] value() default {BrowserDrivers.BROWSER_HTML_UNIT_TEST};

	public boolean restartService() default false;

}
