package com.automation-testing-1.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.automation-testing-1.pages.CreateJobOpeningPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class CreateJobOpening_positive extends DriverFactory {
CreateJobOpeningPage createJobOpeningPage = new CreateJobOpeningPage(driver);
@Given("the recruiter is on the Dashboard")
public void the_recruiter_is_on_the_dashboard() {
createJobOpeningPage.navigateToDashboard();
}
@When("the recruiter clicks on the {string} option in the side navigation")
public void the_recruiter_clicks_on_the_option_in_the_side_navigation(String job_opening_option) {
createJobOpeningPage.clickOnJobOpeningOption(job_opening_option);
}
@Then("the Job Opening screen should be displayed")
public void the_job_opening_screen_should_be_displayed() {
createJobOpeningPage.isJobOpeningScreenDisplayed();
}
@And("the {string} button should be visible")
public void the_button_should_be_visible(String add_job_opening_button) {
createJobOpeningPage.isButtonVisible(add_job_opening_button);
}
@When("the user clicks on the {string} button")
public void the_user_clicks_on_the_button(String action) {
createJobOpeningPage.clickOnAddJobOpeningButton(action);
}
@Then("the Create New Job Opening form should be opened")
public void the_create_new_job_opening_form_should_be_opened() {
createJobOpeningPage.isCreateNewJobOpeningFormOpened();
}
@And("the {string} and {string} buttons should be displayed")
public void the_and_buttons_should_be_displayed(String saveButton, String cancelButton) {
createJobOpeningPage.isButtonVisible(saveButton);
createJobOpeningPage.isButtonVisible(cancelButton);
}
@When("the recruiter selects a Job Role {string}")
public void the_recruiter_selects_a_job_role(String job_role) {
createJobOpeningPage.selectJobRole(job_role);
}
@When("the recruiter selects a Location {string}")
public void the_recruiter_selects_a_location(String location) {
createJobOpeningPage.selectLocation(location);
}
@When("the recruiter enters Minimum Experience {string}")
public void the_recruiter_enters_minimum_experience(String minimum_experience) {
createJobOpeningPage.enterMinimumExperience(minimum_experience);
}
@When("the recruiter enters Maximum Experience {string}")
public void the_recruiter_enters_maximum_experience(String maximum_experience) {
createJobOpeningPage.enterMaximumExperience(maximum_experience);
}
@When("the recruiter leaves Maximum Experience blank")
public void the_recruiter_leaves_maximum_experience_blank() {
createJobOpeningPage.leaveMaximumExperienceBlank();
}
@When("the recruiter enters Qualification {string}")
public void the_recruiter_enters_qualification(String qualification) {
createJobOpeningPage.enterQualification(qualification);
}
@When("the recruiter enters Short Job Description {string}")
public void the_recruiter_enters_short_job_description(String short_job_description) {
createJobOpeningPage.enterShortJobDescription(short_job_description);
}
@When("the recruiter enters Responsibilities {string}")
public void the_recruiter_enters_responsibilities(String responsibilities) {
createJobOpeningPage.enterResponsibilities(responsibilities);
}
@When("the recruiter enters Primary Skills {string}")
public void the_recruiter_enters_primary_skills(String primary_skills) {
createJobOpeningPage.enterPrimarySkills(primary_skills);
}
@When("the recruiter enters Secondary Skills {string}")
public void the_recruiter_enters_secondary_skills(String secondary_skills) {
createJobOpeningPage.enterSecondarySkills(secondary_skills);
}
@When("the recruiter enters Tags {string}")
public void the_recruiter_enters_tags(String tags) {
createJobOpeningPage.enterTags(tags);
}
@When("the recruiter selects a Vendor {string}")
public void the_recruiter_selects_a_vendor(String vendor) {
createJobOpeningPage.selectVendor(vendor);
}
@When("the recruiter selects Employment Type {string}")
public void the_recruiter_selects_employment_type(String employment_type) {
createJobOpeningPage.selectEmploymentType(employment_type);
}
@When("the recruiter selects Work Mode {string}")
public void the_recruiter_selects_work_mode(String work_mode) {
createJobOpeningPage.selectWorkMode(work_mode);
}
@When("the recruiter enters Total Openings {string}")
public void the_recruiter_enters_total_openings(String total_openings) {
createJobOpeningPage.enterTotalOpenings(total_openings);
}
@When("the recruiter selects Duration {string}")
public void the_recruiter_selects_duration(String duration) {
createJobOpeningPage.selectDuration(duration);
}
@When("the recruiter selects Status {string}")
public void the_recruiter_selects_status(String status) {
createJobOpeningPage.selectStatus(status);
}
@When("the recruiter enters Department {string}")
public void the_recruiter_enters_department(String department) {
createJobOpeningPage.enterDepartment(department);
}
@When("the recruiter enters Industry Type {string}")
public void the_recruiter_enters_industry_type(String industry_type) {
createJobOpeningPage.enterIndustryType(industry_type);
}
@When("the recruiter clicks on {string}")
public void the_recruiter_clicks_on(String action) {
createJobOpeningPage.clickOnSave(action);
}
@Then("the job opening should be saved successfully")
public void the_job_opening_should_be_saved_successfully() {
createJobOpeningPage.isJobOpeningSavedSuccessfully();
}
@Then("the job opening should be available in the Job Opening list")
public void the_job_opening_should_be_available_in_the_job_opening_list() {
createJobOpeningPage.isJobOpeningAvailableInList();
}

@When("the recruiter enters responsibilities")
public void the_recruiter_enters_responsibilities() {
createJobOpeningPage.enterResponsibilities();
}
@When("the recruiter enters department")
public void the_recruiter_enters_department() {
createJobOpeningPage.enterDepartment();
}
@When("the recruiter enters {string} as the minimum experience")
public void the_recruiter_enters_minimum_experience(String minExperience) {
createJobOpeningPage.enterMinimumExperience(minExperience);
}
@When("the recruiter selects {string} as the location")
public void the_recruiter_selects_location(String location) {
createJobOpeningPage.selectLocation(location);
}
@When("the recruiter enters {string} as the maximum experience")
public void the_recruiter_enters_maximum_experience(String maxExperience) {
createJobOpeningPage.enterMaximumExperience(maxExperience);
}
@When("the user clicks on the add job opening button")
public void the_user_clicks_on_add_job_opening_button() {
createJobOpeningPage.clickAddJobOpeningButton();
}
@When("the recruiter selects employment type")
public void the_recruiter_selects_employment_type() {
createJobOpeningPage.selectEmploymentType();
}
@When("the recruiter enters {string} as the short job description")
public void the_recruiter_enters_short_job_description(String shortDescription) {
createJobOpeningPage.enterShortJobDescription(shortDescription);
}
@When("the recruiter selects a job role")
public void the_recruiter_selects_a_job_role() {
createJobOpeningPage.selectJobRole();
}
@When("the recruiter enters primary skills")
public void the_recruiter_enters_primary_skills() {
createJobOpeningPage.enterPrimarySkills();
}
@When("the recruiter selects {string} as the job role")
public void the_recruiter_selects_job_role(String jobRole) {
createJobOpeningPage.selectJobRole(jobRole);
}
@Then("the save cancel buttons should be displayed")
public void the_save_cancel_buttons_should_be_displayed() {
createJobOpeningPage.areSaveCancelButtonsDisplayed();
}
@When("the recruiter selects status as {string}")
public void the_recruiter_selects_status_as(String status) {
createJobOpeningPage.selectStatus(status);
}
@When("the recruiter selects vendors")
public void the_recruiter_selects_vendors() {
createJobOpeningPage.selectVendors();
}
@When("the recruiter selects {string} as duration")
public void the_recruiter_selects_duration(String duration) {
createJobOpeningPage.selectDuration(duration);
}
@When("the recruiter enters industry type")
public void the_recruiter_enters_industry_type() {
createJobOpeningPage.enterIndustryType();
}
@When("the recruiter enters secondary skills")
public void the_recruiter_enters_secondary_skills() {
createJobOpeningPage.enterSecondarySkills();
}
@When("the recruiter enters qualification")
public void the_recruiter_enters_qualification() {
createJobOpeningPage.enterQualification();
}
@When("the recruiter enters tags")
public void the_recruiter_enters_tags() {
createJobOpeningPage.enterTags();
}
@When("the recruiter clicks on save")
public void the_recruiter_clicks_on_save() {
createJobOpeningPage.clickSave();
}
@When("the recruiter selects the location as {string}")
public void the_recruiter_selects_the_location_as(String location) {
createJobOpeningPage.selectLocation(location);
}
@When("the recruiter selects work mode")
public void the_recruiter_selects_work_mode() {
createJobOpeningPage.selectWorkMode();
}
@When("the recruiter enters total openings")
public void the_recruiter_enters_total_openings() {
createJobOpeningPage.enterTotalOpenings();
}
@When("the recruiter enters {string} as the qualification")
public void the_recruiter_enters_qualification_as(String qualification) {
createJobOpeningPage.enterQualification(qualification);
}
}