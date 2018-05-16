# Dummy Liferay MVC Portlet

## Overview

The dummy portlet extends Liferay's MVCPortlet class and relies on Liferay's
OSGI MVCCommand services for its implementation.

The Portlet class itself is a stub, which defines the various javax and liferay
portlet properties. The functionality is broken up into MVC command classes;
each portlet command extends its respective portlet phase (e.g. a render command
 extends MVCRenderCommand).

The portlet contians the following elements:
- list page with search container and an 'add' button
- edit page with form for adding/updating a 'Dummy' model
- command classes to perform the render and actions of the list and edit pages

## Tests

### Functional

The functional tests mimic a User's experience with the portlet using cucumber.

The **DummyPortlet.feature** file outlines the steps an end user would take in
interacting with the portlet in three different scenarios: adding a 'Dummy',
editing a 'Dummy', and deleting a 'Dummy'.

A **DummyFeatureHookExtension** is used to perform test set up and tear down
since the basic cucumber runner is limited in its capacity for such operations.
This hook signs in the default user and adds the Dummy portlet to the page
before each scenario. After each scenario the user is signed out, each 'Dummy'
is deleted and the portlet is removed from the page.

The steps are organized by component and are a way to connect the
Gherkin/Cucumber annotations to the backend WebDriverComponents. There are three
different components classes:

- **ButtonComponent**
- **DummyFormComponent**
- **DummyTableComponent**

these classes use their injected webDriver and the cucumber and selenium test
modules to perform the specific test actions. Composition is favored since it
allows the classes to extend WebDriverComponent, and still reuse code.

### Unit

leveraging the proxy-test-api, the **EditDummyRenderCommandTest** is a simple
unit test for the EditDummyMVCRenderCommand.

The **DependencyProxyManager** is used to create proxy objects that mock the
layer underneath the test class. Specifically in this case it is mocking the
DummyLocalService and the Request and Response objects.

A call collecting proxy for the request is used in order to assert that a dummy
object was added as an attribute