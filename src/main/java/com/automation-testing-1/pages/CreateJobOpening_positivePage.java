package com.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.ElementUtils;
import org.junit.Assert;

public class CreateJobOpeningPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    public CreateJobOpeningPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dashboardLink")
    private WebElement dashboardLink;
    @FindBy(id = "jobOpeningOption")
    private WebElement jobOpeningOption;
    @FindBy(id = "jobOpeningScreen")
    private WebElement jobOpeningScreen;
    @FindBy(id = "addJobOpeningButton")
    private WebElement addJobOpeningButton;
    @FindBy(id = "createNewJobOpeningForm")
    private WebElement createNewJobOpeningForm;
    @FindBy(id = "saveButton")
    private WebElement saveButton;
    @FindBy(id = "cancelButton")
    private WebElement cancelButton;
    @FindBy(id = "jobRoleDropdown")
    private WebElement jobRoleDropdown;
    @FindBy(id = "locationDropdown")
    private WebElement locationDropdown;
    @FindBy(id = "minimumExperienceField")
    private WebElement minimumExperienceField;
    @FindBy(id = "maximumExperienceField")
    private WebElement maximumExperienceField;
    @FindBy(id = "qualificationField")
    private WebElement qualificationField;
    @FindBy(id = "shortJobDescriptionField")
    private WebElement shortJobDescriptionField;
    @FindBy(id = "responsibilitiesField")
    private WebElement responsibilitiesField;
    @FindBy(id = "primarySkillsField")
    private WebElement primarySkillsField;
    @FindBy(id = "secondarySkillsField")
    private WebElement secondarySkillsField;
    @FindBy(id = "tagsField")
    private WebElement tagsField;
    @FindBy(id = "vendorDropdown")
    private WebElement vendorDropdown;
    @FindBy(id = "employmentTypeDropdown")
    private WebElement employmentTypeDropdown;
    @FindBy(id = "workModeDropdown")
    private WebElement workModeDropdown;
    @FindBy(id = "totalOpeningsField")
    private WebElement totalOpeningsField;
    @FindBy(id = "durationDropdown")
    private WebElement durationDropdown;
    @FindBy(id = "statusDropdown")
    private WebElement statusDropdown;
    @FindBy(id = "departmentField")
    private WebElement departmentField;
    @FindBy(id = "industryTypeField")
    private WebElement industryTypeField;

    public void navigateToDashboard() {
        try {
            elementUtils.clickElement(dashboardLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnJobOpeningOption() {
        try {
            elementUtils.clickElement(jobOpeningOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isJobOpeningScreenDisplayed() {
        try {
            return elementUtils.isElementDisplayed(jobOpeningScreen);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickOnAddJobOpeningButton() {
        try {
            elementUtils.clickElement(addJobOpeningButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCreateNewJobOpeningFormOpened() {
        try {
            return elementUtils.isElementDisplayed(createNewJobOpeningForm);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void selectJobRole(String jobRole) {
        try {
            elementUtils.selectOptionInDropdown(jobRoleDropdown, jobRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectLocation(String location) {
        try {
            elementUtils.selectOptionInDropdown(locationDropdown, location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterMinimumExperience(String minimumExperience) {
        try {
            elementUtils.clearAndSendKeys(minimumExperienceField, minimumExperience);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterMaximumExperience(String maximumExperience) {
        try {
            elementUtils.clearAndSendKeys(maximumExperienceField, maximumExperience);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leaveMaximumExperienceBlank() {
        try {
            elementUtils.clearElement(maximumExperienceField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterQualification(String qualification) {
        try {
            elementUtils.clearAndSendKeys(qualificationField, qualification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterShortJobDescription(String shortJobDescription) {
        try {
            elementUtils.clearAndSendKeys(shortJobDescriptionField, shortJobDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterResponsibilities(String responsibilities) {
        try {
            elementUtils.clearAndSendKeys(responsibilitiesField, responsibilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPrimarySkills(String primarySkills) {
        try {
            elementUtils.clearAndSendKeys(primarySkillsField, primarySkills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterSecondarySkills(String secondarySkills) {
        try {
            elementUtils.clearAndSendKeys(secondarySkillsField, secondarySkills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterTags(String tags) {
        try {
            elementUtils.clearAndSendKeys(tagsField, tags);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectVendor(String vendor) {
        try {
            elementUtils.selectOptionInDropdown(vendorDropdown, vendor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectEmploymentType(String employmentType) {
        try {
            elementUtils.selectOptionInDropdown(employmentTypeDropdown, employmentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectWorkMode(String workMode) {
        try {
            elementUtils.selectOptionInDropdown(workModeDropdown, workMode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterTotalOpenings(String totalOpenings) {
        try {
            elementUtils.clearAndSendKeys(totalOpeningsField, totalOpenings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDuration(String duration) {
        try {
            elementUtils.selectOptionInDropdown(durationDropdown, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectStatus(String status) {
        try {
            elementUtils.selectOptionInDropdown(statusDropdown, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterDepartment(String department) {
        try {
            elementUtils.clearAndSendKeys(departmentField, department);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterIndustryType(String industryType) {
        try {
            elementUtils.clearAndSendKeys(industryTypeField, industryType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnSave() {
        try {
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isJobOpeningSavedSuccessfully() {
        // Implement a check to verify if the job opening is saved successfully
        return true; // Placeholder for actual implementation
    }

    public boolean isJobOpeningAvailableInList() {
        // Implement a check to verify if the job opening is available in the list
        return true; // Placeholder for actual implementation
    }

    public boolean areSaveCancelButtonsDisplayed() {
        try {
            return elementUtils.isElementDisplayed(saveButton) &&
                   elementUtils.isElementDisplayed(cancelButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isButtonVisible(String buttonId) {
        try {
            WebElement buttonElement = driver.findElement(By.id(buttonId));
            return elementUtils.isElementDisplayed(buttonElement);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}