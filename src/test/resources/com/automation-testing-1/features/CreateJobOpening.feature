
@feature_create_job_opening
Feature: CreateJobOpening

  Background: 
    Given the user is on the Dashboard

  @navigate-job-opening
  Scenario Outline: Create Job Opening
    When the user clicks on the "Job Opening" option in the side navigation
    Then the Job Opening screen should be displayed
    And the "Add Job Opening" button should be visible

    Examples:
      |   |
      |   |

  @open-create-job-form
  Scenario Outline: Create Job Opening
    When the user clicks on the Add Job Opening button
    Then the Create New Job Opening form should be opened
    And the Save and Cancel buttons should be displayed

  Examples:
    | action                     |
    | Add Job Opening            |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects a Job Role "<job_role>"
    And the recruiter selects a Location "<location>"
    And the recruiter enters Minimum Experience "<min_experience>"
    And the recruiter enters Maximum Experience "<max_experience>"
    And the recruiter enters Qualification "<qualification>"
    And the recruiter enters Short Job Description "<short_description>"
    And the recruiter enters Responsibilities "<responsibilities>"
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

    Examples:
      | job_role         | location    | min_experience | max_experience | qualification       | short_description                   | responsibilities                                         |
      | Software Engineer | New York    | 2              | 5              | Bachelor's Degree     | This is a short job description.  | 1. Develop software solutions. 2. Collaborate with team members. |

  @create-job-opening
  Scenario Outline: Create Job Opening
    When I select a Job Role "<job_role>"
    And I select a Location "<location>"
    And I enter Minimum Experience "<min_experience>"
    And I leave Maximum Experience blank
    And I enter Qualification "<qualification>"
    And I leave Responsibilities blank
    And I click on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

    Examples:
      | job_role          | location   | min_experience | qualification       |
      | Software Engineer  | New York   | 3              | Bachelor's Degree    |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When I select the Job Role "<job_role>"
    And I select the Location "<location>"
    And I enter the Minimum Experience "<min_experience>"
    And I enter the Maximum Experience "<max_experience>"
    And I enter the Qualification "<qualification>"
    And I enter the Tags "<tags>"
    And I click on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list with the correct tags

    Examples:
      | job_role         | location    | min_experience | max_experience | qualification      | tags                      |
      | Software Engineer | New York    | 2              | 5              | Bachelor's Degree    | Java, Python, SQL        |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When I select a Job Role "<job_role>"
    And I select a Location "<location>"
    And I enter Minimum Experience "<min_experience>"
    And I enter Maximum Experience "<max_experience>"
    And I enter Qualification "<qualification>"
    And I select a Vendor "<vendor>"
    And I click on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list with the correct vendor

    Examples:
      | job_role          | location   | min_experience | max_experience | qualification      | vendor    |
      | Software Engineer  | New York   | 2              | 5              | Bachelor's Degree   | Vendor A  |

@valid-job-opening
Scenario Outline: Create Job Opening with Valid Work Mode
  When I select a Job Role "<job_role>"
  And I select a Location "<location>"
  And I enter Minimum Experience "<min_experience>"
  And I enter Maximum Experience "<max_experience>"
  And I enter Qualification "<qualification>"
  And I select a valid Work Mode "<work_mode>"
  And I click on "Save"
  Then the job opening should be saved successfully
  And the job opening should be available in the Job Opening list with the correct work mode

  Examples:
    | job_role         | location    | min_experience | max_experience | qualification      | work_mode |
    | Software Engineer | New York    | 2              | 5              | Bachelor's Degree   | Remote    |

  @valid-job-creation
  Scenario Outline: Create Job Opening
    When the recruiter selects a Job Role
    And the recruiter selects a Location
    And the recruiter enters Minimum Experience
    And the recruiter enters Maximum Experience
    And the recruiter enters Qualification
    And the recruiter enters a valid Department
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list with the correct department

    Examples:
      | Job Role        | Location   | Minimum Experience | Maximum Experience | Qualification      | Department   |
      | Software Engineer| New York  | 2                  | 5                  | Bachelor's Degree   | Engineering   |

  @valid-job-opening
  Scenario Outline: Create Job Opening with Valid Industry Type
    When the recruiter selects a Job Role "<job_role>"
    And the recruiter selects a Location "<location>"
    And the recruiter enters Minimum Experience "<min_experience>"
    And the recruiter enters Maximum Experience "<max_experience>"
    And the recruiter enters Qualification "<qualification>"
    And the recruiter enters a valid Industry Type "<industry_type>"
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list with the correct industry type

    Examples:
      | job_role         | location    | min_experience | max_experience | qualification       | industry_type           |
      | Software Engineer | New York    | 2              | 5              | Bachelor's Degree    | Information Technology   |

  @valid-job-opening
  Scenario Outline: Create Job Opening with Valid Skills
    When I select a Job Role
    And I select a Location
    And I enter Minimum Experience
    And I enter Maximum Experience
    And I enter Qualification
    And I enter valid Primary Skills
    And I enter valid Secondary Skills
    And I click on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list with the correct skills

    Examples: 
      | Job Role | Location | Min Experience | Max Experience | Qualification | Primary Skills | Secondary Skills |
      | Role1    | Location1| 2 years        | 5 years        | Qualification1 | Skill1         | Skill2           |
