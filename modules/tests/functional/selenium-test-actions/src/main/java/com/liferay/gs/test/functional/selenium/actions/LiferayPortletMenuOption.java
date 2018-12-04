package com.liferay.gs.test.functional.selenium.actions;

/**
 * @author Andrew Betts
 */
public enum LiferayPortletMenuOption {
	LOOK_AND_FEEL(
		"portlet-css", "portlet-css-icon", "Look and Feel Configuration"),
	EXPORT_IMPORT(
		"portlet-export-import", "portlet-export-import-icon",
		"Export / Import"),
	CONFIGURATION(
		"portlet-configuration", "portlet-configuration-icon", "Configuration"),
	PERMISSIONS("", "", "Permissions"),
	CONFIGURATION_TEMPLATES("", "", "Configuration Templates"),
	REMOVE("portlet-close", "portlet-close-icon", "Remove");

	private LiferayPortletMenuOption(
		String cssClass, String iconCssClass, String title) {

		CSS_CLASS = cssClass;
		ICON_CSS_CLASS = iconCssClass;
		TITLE = title;
	}

	public static final String MENU_OPTION_SPAN_CLASS = "taglib-text-icon";

	public final String CSS_CLASS;
	public final String ICON_CSS_CLASS;
	public final String TITLE;

}