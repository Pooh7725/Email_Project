Feature: login feature for outlook

@Login
Scenario: Login in outlook
Given user is already on login page user clicks on login link
And user enter username 
Then user clicks on next button
And user enters password
Then Click on login button 
And clicks on DoNotShowThisMessageAgain Checkbox
And Clicks on yes button
Then match title of the page
Then user has logged in and clicks on new message
And write email id in to textbox 
And write something into subject field
Then click on sendemail button
And click on sent items 
Then verify automated sent email and quit browser
