package com.liferay.gs.test.functional.cucumber.hook;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrew Betts
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CucumberHookExtensionDefinitions.class)
@Target({ElementType.TYPE})
public @interface CucumberHookExtensionDefinition {

	public Class<? extends BaseCucumberHookExtension> value();

	public int order() default 0;

	public String[] tagExpressions() default {};

}