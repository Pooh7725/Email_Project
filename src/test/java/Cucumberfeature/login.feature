Feature: login feature for outlook

Scenario: Login in outlook

Given user is already on login page user clicks on login link
And user enter username 
Then user clicks on next button
And user enters password
Then Click on login button 
And clicks on DoNotShowThisMessageAgain Checkbox
And Clicks on yes button
Then match title of the page
