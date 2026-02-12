
package com.backend.pages;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ExtendWith(MockitoExtension.class)
public class CreateJobOpeningPageTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement dashboardLink;

    @Mock
    private WebElement jobOpeningOption;

    @Mock
    private WebElement jobOpeningScreen;

    @Mock
    private WebElement addJobOpeningButton;

    @Mock
    private WebElement createNewJobOpeningForm;

    @Mock
    private WebElement saveButton;

    @Mock
    private WebElement cancelButton;

    @Mock
    private WebElement jobRoleDropdown;

    @Mock
    private WebElement locationDropdown;

    @Mock
    private WebElement minimumExperienceField;

    @Mock
    private WebElement maximumExperienceField;

    @Mock
    private WebElement qualificationField;

    @Mock
    private WebElement shortJobDescriptionField;

    @Mock
    private WebElement responsibilitiesField;

    @Mock
    private WebElement primarySkillsField;

    @Mock
    private WebElement secondarySkillsField;

    @Mock
    private WebElement tagsField;

    @Mock
    private WebElement vendorDropdown;

    @Mock
    private WebElement employmentTypeDropdown;

    @Mock
    private WebElement workModeDropdown;

    @Mock
    private WebElement totalOpeningsField;

    @Mock
    private WebElement durationDropdown;

    @Mock
    private WebElement statusDropdown;

    @Mock
    private WebElement departmentField;

    @Mock
    private WebElement industryTypeField;

    @InjectMocks
    private CreateJobOpeningPage createJobOpeningPage;

    @Test
    public void shouldNavigateToDashboard() {
        createJobOpeningPage.navigateToDashboard();
        verify(driver).findElement(dashboardLink);
    }

    @Test
    public void shouldClickOnJobOpeningOption() {
        createJobOpeningPage.clickOnJobOpeningOption();
        verify(driver).findElement(jobOpeningOption);
    }

    @Test
    public void shouldReturnTrueWhenJobOpeningScreenIsDisplayed() {
        when(driver.findElement(jobOpeningScreen)).thenReturn(jobOpeningScreen);
        when(jobOpeningScreen.isDisplayed()).thenReturn(true);
        boolean result = createJobOpeningPage.isJobOpeningScreenDisplayed();
        verify(driver).findElement(jobOpeningScreen);
        assertTrue(result);
    }

    @Test
    public void shouldClickOnAddJobOpeningButton() {
        createJobOpeningPage.clickOnAddJobOpeningButton();
        verify(driver).findElement(addJobOpeningButton);
    }

    @Test
    public void shouldReturnTrueWhenCreateNewJobOpeningFormIsOpened() {
        when(driver.findElement(createNewJobOpeningForm)).thenReturn(createNewJobOpeningForm);
        when(createNewJobOpeningForm.isDisplayed()).thenReturn(true);
        boolean result = createJobOpeningPage.isCreateNewJobOpeningFormOpened();
        verify(driver).findElement(createNewJobOpeningForm);
        assertTrue(result);
    }

    @Test
    public void shouldSelectJobRole() {
        String jobRole = "Developer";
        createJobOpeningPage.selectJobRole(jobRole);
        verify(driver).findElement(jobRoleDropdown);
    }

    @Test
    public void shouldSelectLocation() {
        String location = "New York";
        createJobOpeningPage.selectLocation(location);
        verify(driver).findElement(locationDropdown);
    }

    @Test
    public void shouldEnterMinimumExperience() {
        String minimumExperience = "2";
        createJobOpeningPage.enterMinimumExperience(minimumExperience);
        verify(driver).findElement(minimumExperienceField);
    }

    @Test
    public void shouldEnterMaximumExperience() {
        String maximumExperience = "5";
        createJobOpeningPage.enterMaximumExperience(maximumExperience);
        verify(driver).findElement(maximumExperienceField);
    }

    @Test
    public void shouldLeaveMaximumExperienceBlank() {
        createJobOpeningPage.leaveMaximumExperienceBlank();
        verify(driver).findElement(maximumExperienceField);
    }

    @Test
    public void shouldEnterQualification() {
        String qualification = "Bachelor's";
        createJobOpeningPage.enterQualification(qualification);
        verify(driver).findElement(qualificationField);
    }

    @Test
    public void shouldEnterShortJobDescription() {
        String shortJobDescription = "Software Developer";
        createJobOpeningPage.enterShortJobDescription(shortJobDescription);
        verify(driver).findElement(shortJobDescriptionField);
    }

    @Test
    public void shouldEnterResponsibilities() {
        String responsibilities = "Develop and maintain";
        createJobOpeningPage.enterResponsibilities(responsibilities);
        verify(driver).findElement(responsibilitiesField);
    }

    @Test
    public void shouldEnterPrimarySkills() {
        String primarySkills = "Java, Spring";
        createJobOpeningPage.enterPrimarySkills(primarySkills);
        verify(driver).findElement(primarySkillsField);
    }

    @Test
    public void shouldEnterSecondarySkills() {
        String secondarySkills = "SQL, Docker";
        createJobOpeningPage.enterSecondarySkills(secondarySkills);
        verify(driver).findElement(secondarySkillsField);
    }

    @Test
    public void shouldEnterTags() {
        String tags = "Java, Backend";
        createJobOpeningPage.enterTags(tags);
        verify(driver).findElement(tagsField);
    }

    @Test
    public void shouldSelectVendor() {
        String vendor = "Vendor A";
        createJobOpeningPage.selectVendor(vendor);
        verify(driver).findElement(vendorDropdown);
    }

    @Test
    public void shouldSelectEmploymentType() {
        String employmentType = "Full-time";
        createJobOpeningPage.selectEmploymentType(employmentType);
        verify(driver).findElement(employmentTypeDropdown);
    }

    @Test
    public void shouldSelectWorkMode() {
        String workMode = "Remote";
        createJobOpeningPage.selectWorkMode(workMode);
        verify(driver).findElement(workModeDropdown);
    }

    @Test
    public void shouldEnterTotalOpenings() {
        String totalOpenings = "5";
        createJobOpeningPage.enterTotalOpenings(totalOpenings);
        verify(driver).findElement(totalOpeningsField);
    }

    @Test
    public void shouldSelectDuration() {
        String duration = "6 months";
        createJobOpeningPage.selectDuration(duration);
        verify(driver).findElement(durationDropdown);
    }

    @Test
    public void shouldSelectStatus() {
        String status = "Open";
        createJobOpeningPage.selectStatus(status);
        verify(driver).findElement(statusDropdown);
    }

    @Test
    public void shouldEnterDepartment() {
        String department = "IT";
        createJobOpeningPage.enterDepartment(department);
        verify(driver).findElement(departmentField);
    }

    @Test
    public void shouldEnterIndustryType() {
        String industryType = "Software";
        createJobOpeningPage.enterIndustryType(industryType);
        verify(driver).findElement(industryTypeField);
    }

    @Test
    public void shouldClickOnSave() {
        createJobOpeningPage.clickOnSave();
        verify(driver).findElement(saveButton);
    }

    @Test
    public void shouldReturnTrueWhenJobOpeningSavedSuccessfully() {
        boolean result = createJobOpeningPage.isJobOpeningSavedSuccessfully();
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenJobOpeningAvailableInList() {
        boolean result = createJobOpeningPage.isJobOpeningAvailableInList();
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenSaveCancelButtonsDisplayed() {
        when(driver.findElement(saveButton)).thenReturn(saveButton);
        when(driver.findElement(cancelButton)).thenReturn(cancelButton);
        when(saveButton.isDisplayed()).thenReturn(true);
        when(cancelButton.isDisplayed()).thenReturn(true);
        boolean result = createJobOpeningPage.areSaveCancelButtonsDisplayed();
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenButtonVisible() {
        String buttonId = "addJobOpeningButton";
        when(driver.findElement(any())).thenReturn(addJobOpeningButton);
        when(addJobOpeningButton.isDisplayed()).thenReturn(true);
        boolean result = createJobOpeningPage.isButtonVisible(buttonId);
        assertTrue(result);
    }
}
