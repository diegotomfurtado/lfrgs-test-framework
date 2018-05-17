# Liferay Cucumber Test API

## Overview

This module provides base classes to extend while using Cucumber to create
functional tests. It is intended to wrap and extend the capabilities provided by
 [selenium-test-api](/modules/tests/functional/selenium-test-api/README.md) (e.g. setting the web driver and loading test properties).

## Cucumber

Cucumber is a JUnit extension. It uses feature files and Gherkin syntax to
generate the tests and run them in the order specified.

### Cucumber Feature File Declarations

Some of the allowed feature file declarations are:
- **Feature**: describes the feature being tested
- **Background**: steps to use before every scenario
- **Scenario**: specific set of user actions defined in steps
- **Scenario Outline**: just like a scenario, but defined for a pre-determined
set of inputs
- **Examples**: Provides pre-determined inputs to the Scenario Outline
- steps: provides a string to match against a regex defined in a java step
class with one of the cucumber step annotations.
    - **Given**
    - **When**
    - **And**
    - **But**
    - **Then**
- **@\[tag name\]**: these are user defined tags that define meta information
about the feature or scenario. They can be used to define test groups to execute
, or as signals to perform some sort of special setup.

### Cucumber Step Annotations

The Cucumber step annotations cannot have the same regex pattern since the
Cucumber StepDefinition uses the pattern as the key in a map. When processing a
step those regex patterns are used to determine which step should be executed.
The annotation itself is not stored in the map. This can lead to a potentially
confusing situation:

With the following two java steps:
```
    Given("I go to google home")
    Then("I should see 'Google' as the page title")
```
the following Scenario

```
    Given: I go to google home
    Then: I should see 'Google' as the page title
```
could be changed to

```
    When: I go to google home
    When: I should see 'Google' as the page title
```
without impacting the test. The feature file parser relies on the regex pattern
defined on the java annotation to find its match; it does not remember the
annotation itself.

In light of this separation between the feature parser and the runtime regex
match, two things are required:
1) A regex pattern cannot be reused. Every annotation must use only one pattern.
Thus it is not possible to define both **Given("I go to the store")** and
**When("I go to the store")**. However, this distinction is unnecessary since a
feature file defining **When: I go to the store** would match the step declared
with **Given("I go the store")** because the "regex" pattern would match.
2) A feature step declaration must not match more than one regex pattern. Using
the example from (1), defining an additional java step with
**Then(I '(.\*)' to the store)** would result in multiple matches and an
**AmbiguousStepDefinitionsException**.

## Test API

The entry point to this module is when a test class (FeatureRunner) uses the
JUnit @RunWith() annotation specifying the **LiferayCucumberRunner** class.

The **LiferayCucumberRunner** sets a custom ObjectFactory as a SystemProperty,
which is read by the JavaBackend Cucumber class. **BaseStepObjectFactory** is
responsible for updating the WebDriver in all sub classes of BaseStep. Updating
the webDriver for a BaseStep propagates to all registered **WebDriverComponent**
classes.

### JUnit Runners

The **LiferayCucumberRunner** uses a **BrowserRunnerBuilder** to create a
**BrowserRunner** for each **BrowserType** specified in the **Browser**
annotation of the test class. A **CucumberRunnerBuilder** is passed to the
constructor of the **BrowserRunnerBuilder** to construct the underlying tests.

The **CucumberRunnerBuilder** sets the class name of **BaseStepObjectFactory**
in the "cucumber.api.java.ObjectFactory" SystemProperty, as well as processing
all specified **CucumberHookExtension**'s annotated on the test class. It is a
ParentRunner of Runner's so the class level JUnit annotations will be honored:
@AfterClass, @BeforeClass, and @ClassRule. However, Cucumber does not recognize
any other JUnit annotations so a @Before annotated method will never execute.

The Cucumber runner and its Scenario and Feature builders are used underneath
these custom runners, so all the normal Cucumber syntax and extension points are
still available.

### Before and After Scenarios

Cucumber defines "glue" paths to look in its classLoader for Step definitions.
Two special Cucumber annotations, @Before and @After, do not show up in the
Feature file but are still executed. These look and perform similar to the JUnit
annotations, but they may also take an argument describing a tag pattern
controlling when to execute.

Because these are global hooks as long as they appear in the classpath of the
step definition, it may be difficult to organize the java packages to achieve
proper test execution. This is why the **CucumberHookExtension** has ben added.

Annotating a test class with **@CucumberHookExtensionDefinition**, or using the
parent container annotation **@CucumberHookExtensionDefinitions**, will load
**CucumberHookExtension** classes into the corresponding registry. These hook
Extensions are fetched from the registry during the Before and After testing
phases, which is where Cucumber hooks are normally executed. The hook extensions
are executed first, followed by any Cucumber hooks found in the classPath

### Steps and Components

Step classes define java methods to execute based on a regex pattern. These
steps typically leverage the selenium web driver in order to perform a defined
user action.

Component classes are intended to help organize and reuse code that can be
reused across steps. **BaseStep** provides a component registry api that manages
**WebDriverComponent** classes.

Extending **BaseStep** allows the **BaseStepObjectFactory** to update the
selenium web driver. Each component used in the step class should be registered
through the *registerComponents* method. Those components can be fetched by
their class via *getComponent*