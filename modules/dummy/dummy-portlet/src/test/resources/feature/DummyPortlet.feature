Feature: Test Adding, Editing and Removing a Dummy in the Portal

	Scenario: Add a new Dummy
		When I click on the 'add' button
		And I type 'foo' into field 'one'
		And I also click on the 'save' button
		And I click on the back 'view' button
		Then I 'should' see a dummy displayed in the portlet with 'one' equal to 'foo'

	Scenario: Edit an Existing Dummy
		Given I see a dummy displayed in the portlet with 'one' equal to 'foo'
		When I click on the 'edit' button
		And I type 'bar' into field 'one'
		And I also click on the 'save' button
		And I click on the back 'view' button
		Then I 'should' see a dummy displayed in the portlet with 'one' equal to 'bar'

	Scenario: Remove a Dummy
		Given I see a dummy displayed in the portlet with 'one' equal to 'foo'
		When I click on the 'delete' button
		Then I ' not' see a dummy displayed in the portlet with 'one' equal to 'foo'
