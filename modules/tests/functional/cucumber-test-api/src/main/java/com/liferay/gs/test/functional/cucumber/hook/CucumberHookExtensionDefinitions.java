package com.liferay.gs.test.functional.cucumber.hook;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrew Betts
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CucumberHookExtensionDefinitions {

	public CucumberHookExtensionDefinition[] value() default {};

}