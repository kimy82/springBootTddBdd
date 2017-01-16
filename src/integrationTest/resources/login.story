Feature: Login

Narrative:
As a user
I want to log in to the application
So that I go to my dashboard

Scenario: Sign In
Given a user with username userNameTest has sign up
When the user correctly signs in
Then the user goes to dashboard
