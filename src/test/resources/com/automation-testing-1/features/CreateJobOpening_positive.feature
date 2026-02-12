
@feature_create_job_opening
Feature: CreateJobOpening_positive

Background: 
  Given the recruiter is on the Dashboard

@navigate-job-opening
Scenario Outline: Create Job Opening
  When the recruiter clicks on the "<job_opening_option>" option in the side navigation
  Then the Job Opening screen should be displayed
  And the "<add_job_opening_button>" button should be visible

  Examples:
    | job_opening_option     | add_job_opening_button |
    | Job Opening            | Add Job Opening        |

@valid-job-opening
Scenario Outline: Create Job Opening
  When the user clicks on the "Add Job Opening" button
  Then the Create New Job Opening form should be opened
  And the "Save" and "Cancel" buttons should be displayed

Examples:
  | action                       |
  | Add Job Opening             |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects a Job Role <job_role>
    And the recruiter selects a Location <location>
    And the recruiter enters Minimum Experience <minimum_experience>
    And the recruiter enters Maximum Experience <maximum_experience>
    And the recruiter enters Qualification <qualification>
    And the recruiter enters Short Job Description <short_job_description>
    And the recruiter enters Responsibilities <responsibilities>
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

  Examples:
    | job_role          | location   | minimum_experience | maximum_experience | qualification        | short_job_description | responsibilities      |
    | Software Engineer  | New York   | 2                  | 5                  | Bachelor's Degree     | a * 100               | a * 100               |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects "<job_role>" as the Job Role
    And the recruiter selects "<location>" as the Location
    And the recruiter enters "<minimum_experience>" as the Minimum Experience
    And the recruiter leaves Maximum Experience blank
    And the recruiter enters "<qualification>" as the Qualification
    And the recruiter enters "<short_job_description>" as the Short Job Description
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

    Examples:
      | job_role          | location   | minimum_experience | qualification       | short_job_description                                                                 |
      | Software Engineer  | New York   | 2                  | Bachelor's Degree    | This is a short job description that outlines the responsibilities and requirements of the position. |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects a Job Role "<job_role>"
    And the recruiter selects a Location "<location>"
    And the recruiter enters Minimum Experience "<min_experience>"
    And the recruiter enters Maximum Experience "<max_experience>"
    And the recruiter selects Employment Type "<employment_type>"
    And the recruiter selects Work Mode "<work_mode>"
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

  Examples:
    | job_role         | location   | min_experience | max_experience | employment_type | work_mode |
    | Software Engineer | New York   | 2              | 5              | Full-time       | Remote    |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects a Job Role "<job_role>"
    And the recruiter selects a Location "<location>"
    And the recruiter enters Minimum Experience "<min_experience>"
    And the recruiter enters Maximum Experience "<max_experience>"
    And the recruiter enters Tags "<tags>"
    And the recruiter selects a Vendor "<vendor>"
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

  Examples:
    | job_role         | location   | min_experience | max_experience | tags          | vendor     |
    | Software Engineer | New York   | 2              | 5              | Urgent, Tech  | Vendor A   |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects a Job Role
    And the recruiter selects a Location
    And the recruiter enters Minimum Experience
    And the recruiter enters Maximum Experience
    And the recruiter enters Qualification
    And the recruiter enters Short Job Description
    And the recruiter enters Responsibilities
    And the recruiter enters Primary Skills
    And the recruiter enters Secondary Skills
    And the recruiter enters Total Openings
    And the recruiter selects Employment Type
    And the recruiter selects Duration
    And the recruiter selects Work Mode
    And the recruiter selects Status
    And the recruiter enters Department
    And the recruiter enters Industry Type
    And the recruiter enters Tags
    And the recruiter selects Vendors
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

  Examples:
    | Job Role         | Location   | Minimum Experience | Maximum Experience | Qualification       | Short Job Description         | Responsibilities            | Primary Skills | Secondary Skills | Total Openings | Employment Type | Duration   | Work Mode | Status | Department   | Industry Type         | Tags            | Vendors   |
    | Software Engineer | New York   | 2                  | 5                  | Bachelor's Degree    | Short job description a * 100 | Responsibilities a * 100 | Java, Python   | JavaScript      | 3              | Full-time       | 6 months  | Remote    | Active | Engineering   | Information Technology | Tag1, Tag2     | Vendor1   |

  @valid-job-opening
  Scenario Outline: Create Job Opening
    When the recruiter selects the Job Role as <job_role>
    And the recruiter selects the Location as <location>
    And the recruiter enters Minimum Experience as <min_experience>
    And the recruiter enters Maximum Experience as <max_experience>
    And the recruiter selects Status as <status>
    And the recruiter clicks on "Save"
    Then the job opening should be saved successfully
    And the job opening should be available in the Job Opening list

  Examples:
    | job_role         | location   | min_experience | max_experience | status |
    | Software Engineer | New York   | 2              | 5              | Open   |

@valid-job-opening
Scenario Outline: Create Job Opening
  When the recruiter selects a Job Role "<job_role>"
  And the recruiter selects a Location "<location>"
  And the recruiter enters Minimum Experience "<minimum_experience>"
  And the recruiter enters Maximum Experience "<maximum_experience>"
  And the recruiter enters Responsibilities "<responsibilities>"
  And the recruiter enters Primary Skills "<primary_skills>"
  And the recruiter enters Secondary Skills "<secondary_skills>"
  And the recruiter clicks on "Save"
  Then the job opening should be saved successfully
  And the job opening should be available in the Job Opening list

Examples:
  | job_role          | location   | minimum_experience | maximum_experience | responsibilities                                             | primary_skills         | secondary_skills          |
  | Software Engineer  | New York   | 2                  | 5                  | Develop software applications, Collaborate with cross-functional teams | Java, Python, SQL      | JavaScript, HTML, CSS     |

@valid-job-opening
Scenario Outline: Create Job Opening with Valid Duration
  When the recruiter selects "<job_role>" as the Job Role
  And the recruiter selects "<location>" as the Location
  And the recruiter enters "<min_experience>" as Minimum Experience
  And the recruiter enters "<max_experience>" as Maximum Experience
  And the recruiter selects "<duration>" as Duration
  And the recruiter clicks on "Save"
  Then the job opening should be saved successfully
  And the job opening should be available in the Job Opening list

Examples:
  | job_role         | location   | min_experience | max_experience | duration    |
  | Software Engineer | New York   | 2              | 5              | 6 months    |
