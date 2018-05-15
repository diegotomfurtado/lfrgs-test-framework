package com.liferay.gs.test.functional.cucumber.component;

import com.liferay.gs.test.functional.cucumber.WebDriverComponent;

import com.liferay.gs.test.functional.selenium.actions.LiferayUserActions;

/**
 * @author Andrew Betts
 */
public class LiferayUserActionsComponent extends WebDriverComponent {

	public LiferayUserActionsComponent() {
		_liferayUserActions = new LiferayUserActions();
	}

	public void signIn(String login, String password) {
		_liferayUserActions.signIn(login, password, webDriver);
	}

	public void signOut() {
		_liferayUserActions.signOut(webDriver);
	}

	private LiferayUserActions _liferayUserActions;

}
