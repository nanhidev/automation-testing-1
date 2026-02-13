
Feature: Sheet1 @feature_login_screen

  Background: 
    Given the user is on the Welcome page

  @verify_login_navigation
  Scenario Outline: Verify that clicking the 'Get Started' button navigates to the Login page
    When the user clicks on the 'Get Started' button
    Then the Login page loads successfully
    And the URL reflects the Login page

  Examples:
    | action                     |
    | Click on the 'Get Started' |

  @valid_login
  Scenario Outline: Login Screen for Recruiters
    Given the user enters a valid email address in the Email ID field
    And the user enters a valid password in the Password field
    And the Login button is enabled
    When the user clicks the Login button
    And waits for the dashboard to load
    Then the dashboard is displayed

    Examples:
      | email                             | password      |
      | fouqia.zeba+recruiter@walkingtree.tech | Password@123 |

@verify_show_hide_password
Scenario Outline: Login Screen for Recruiters
  Given the user enters "<password>" in the Password field
  When the user locates the 'Show/Hide Password' option
  And the user clicks on the 'Show Password' option
  Then the user should see the password revealed
  When the user clicks on the 'Hide Password' option
  Then the user should see the password masked again

Examples:
  | password      |
  | Password@123  |

  @valid-password-input
  Scenario Outline: Login Screen for Recruiters
    Given the user clicks on the Password field
    When the user enters a valid password "<password>"
    Then the input should be accepted
    When the user clicks the 'Show Password' option
    Then the password should be visible
    When the user clicks the 'Hide Password' option
    Then the password should be masked again

    Examples:
      | password      |
      | Password@123  |

@verify_ui_elements
Scenario Outline: Login Screen for Recruiters
  When the user opens the Login page
  Then the Email ID field is displayed
  And the Password field is displayed
  And the Login button is displayed
  And the 'Show/Hide Password' option is displayed
  And the layout is user-friendly and intuitive

Examples:
  | email_id | password |
  |          |          |

@whitespace_login
Scenario Outline: Login Screen for Recruiters
  When I enter whitespace in the Email ID field
  And I enter whitespace in the Password field
  Then the Login button should be enabled
  And the error message below the Email field will be displayed 'Email is required!'
  And the error message below the Password field will be displayed 'Password must be 8 character length'

Examples:
  | field_email | field_password |
  | " "         | " "            |
