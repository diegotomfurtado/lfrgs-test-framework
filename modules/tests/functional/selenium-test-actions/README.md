# Liferay Selenium Test Actions

## Overview

The Selenium Web Driver api can be overwhelming. This module seeks to provide
convenient utilities to accomplish specific user actions within a Liferay
Portal.

There are two groups of classes provided: Rules and Actions

## Rules

- **NavigationTestRule**: navigates to a url before a test is run and navigates
back to the previous url after the test finishes.
- **SignedInTestRule**: signs in through the struts path c/portal/login with a
provided login and password before a test starts, and signs out the user after
the test finishes.

## Actions

- **LiferayPortletActions**: provides portlet specific api like getting the
portlet WebElement and opening the configuration menu.
- **LiferayUserActions**: provides user specific api like signing a user in and
out
- **ProductNavigationMenuActions**: provides product menu api like searching for
a portlet and adding a portlet to the page
- **WebDriverActions**: provides basic convenience methods wrapping some of the
selenium web driver methods