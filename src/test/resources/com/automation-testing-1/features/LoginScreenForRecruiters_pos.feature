
Feature: LoginScreenForRecruiters_pos @feature_user_login

Background: 
  Given the user is on the Welcome Page

@navigate_to_login
Scenario Outline: Login Screen for Recruiters
  When the user locates the 'Get Started' button
  And the user clicks on the 'Get Started' button
  Then the user should be redirected to the Login page
  And the URL should reflect the Login page

Examples:
  | action                |
  | Get Started button    |

@valid-login
Scenario Outline: Login Screen for Recruiters
  Given I enter a valid email address in the Email ID field
  And I enter a valid password in the Password field
  And I ensure the Login button is enabled
  When I click the Login button
  Then the user should be redirected to the dashboard
  And the dashboard should display relevant recruiter information

Examples:
  | email                   | password            |
  | recruiter@example.com   | SecurePassword123   |

@password_visibility_toggle
Scenario Outline: Login Screen for Recruiters
  Given the user enters <password> in the Password field
  When the user locates the 'Show/Hide Password' option
  And the user clicks the 'Show' option
  Then the user observes that the password is revealed
  When the user clicks the 'Hide' option
  Then the user observes that the password is masked

  Examples:
    | password      |
    | P@ssw0rd123   |

@check_login_button_enabled
Scenario Outline: Login button should be enabled when fields are filled
  Given the user leaves both Email ID and Password fields empty
  Then the Login button should be disabled
  When the user enters "<email>" in the Email ID field
  Then the Login button should be disabled
  When the user enters "<password>" in the Password field
  Then the Login button should be disabled
  When the user enters "<email>" in the Email ID field
  And the user enters "<password>" in the Password field
  Then the Login button should be enabled

  Examples:
    | email             | password      |
    | krishna@gmail.com | Password123   |

@invalid_login_test
Scenario Outline: Login Screen for Recruiters
  When I enter "<email>" in the Email ID field
  And I enter "<password>" in the Password field
  And I click the Login button
  Then the error message 'Incorrect email or password.' is displayed
  And the Email ID field retains the value "<email>"
  And the Password field retains the value "<password>"
  When I correct the Email ID to a valid one
  And I correct the Password to a valid one
  Then the Login button is enabled

Examples:
  | email  | password |
  | abc@   | 12345    |

@valid-login
Scenario Outline: Login Screen for Recruiters
  Given the user enters a valid email address in the Email ID field
  And the user enters a valid password in the Password field
  Then the Login button should be enabled
  Given the user clears the Email ID field
  Then the Login button should be disabled
  Given the user re-enters the valid email address
  Then the Login button should be enabled

Examples:
  | email                | password           |
  | krishna@gmail.com    | ValidPassword123   |

@logout-scenario
Scenario Outline: Verify User Logout from Dashboard
  When I locate the 'Logout' button on the dashboard
  And I click the 'Logout' button
  And I wait for the logout process to complete
  Then the user is logged out successfully
  And the Welcome page is displayed
  And the URL reflects the Welcome page
  And accessing the dashboard URL directly redirects to the Welcome page

Examples:
  |   |
  |   |

@navigate_back_to_welcome
Scenario Outline: Login Screen for Recruiters
  When the user clicks the 'Back to Welcome' link/button
  Then the user should be redirected to the Welcome page
  And the URL should reflect the Welcome page
  And the 'Get Started' button should be visible and clickable

Examples:
  | action                       |
  | Back to Welcome link/button  |
