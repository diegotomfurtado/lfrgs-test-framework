# Liferay Cucumber Test Components

## Overview

This module provides helpful components that may be useful when writing liferay
specific cucumber tests.

## Components

Currently, the components are wrappers around action classes found in
[selenium-test-actions](/modules/tests/functional/selenium-test-actions/README.md), exposing their api in **WebDriverComponent** classes.

- **LiferayPortletActionsComponent** wraps LiferayPortletActions
- **LiferayUserActionsComponent** wraps LiferayUserActions
- **ProductNavigationMenuActionsComponent** wraps ProductNavigationMenuActions
- **WebDriverActionsComponent** wraps WebDriverActions

To use these components in a Step class (extending BaseStep), register them
through the *registerComponents* method, and then fetch them with the
*getComponent* method.