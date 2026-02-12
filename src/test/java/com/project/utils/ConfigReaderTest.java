
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;

import java.util.Properties;

@ExtendWith(MockitoExtension.class)
public class ConfigReaderTest {

    @InjectMocks
    private ConfigReader configReader;

    @Mock
    private Properties properties;

    @BeforeAll
    public static void setUp() {
        System.setProperty("user.dir", "testDir");
    }

    @Test
    public void shouldReturnBrowserWhenGetBrowserCalled() {
        when(properties.getProperty("browser")).thenReturn("chrome");
        String result = configReader.getBrowser();
        assertEquals("chrome", result);
    }

    @Test
    public void shouldReturnBaseUrlWhenGetBaseUrlCalled() {
        when(properties.getProperty("url")).thenReturn("http://localhost");
        String result = configReader.getBaseUrl();
        assertEquals("http://localhost", result);
    }

    @Test
    public void shouldReturnImplicitWaitWhenGetImplicitWaitCalled() {
        when(properties.getProperty("implicit.wait")).thenReturn("10");
        int result = configReader.getImplicitWait();
        assertEquals(10, result);
    }

    @Test
    public void shouldReturnExplicitWaitWhenGetExplicitWaitCalled() {
        when(properties.getProperty("explicit.wait")).thenReturn("5");
        int result = configReader.getExplicitWait();
        assertEquals(5, result);
    }

    @Test
    public void shouldReturnIsHeadlessWhenIsHeadlessCalled() {
        when(properties.getProperty("browser.headless")).thenReturn("true");
        boolean result = configReader.isHeadless();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnEnvironmentWhenGetEnvironmentCalled() {
        when(properties.getProperty("environment")).thenReturn("test");
        String result = configReader.getEnvironment();
        assertEquals("test", result);
    }

    @Test
    public void shouldReturnFrameworkTypeWhenGetFrameworkTypeCalled() {
        when(properties.getProperty("framework.type")).thenReturn("cucumber-junit");
        String result = configReader.getFrameworkType();
        assertEquals("cucumber-junit", result);
    }

    @Test
    public void shouldReturnTestRunnerWhenGetTestRunnerCalled() {
        when(properties.getProperty("test.runner")).thenReturn("junit");
        String result = configReader.getTestRunner();
        assertEquals("junit", result);
    }

    @Test
    public void shouldReturnCucumberTagsWhenGetCucumberTagsCalled() {
        when(properties.getProperty("cucumber.tags")).thenReturn("@smoke");
        String result = configReader.getCucumberTags();
        assertEquals("@smoke", result);
    }

    @Test
    public void shouldReturnFeaturePathWhenGetFeaturePathCalled() {
        when(properties.getProperty("cucumber.features.path")).thenReturn("src/test/resources/features");
        String result = configReader.getFeaturePath();
        assertEquals("src/test/resources/features", result);
    }

    @Test
    public void shouldReturnGluePathWhenGetGluePathCalled() {
        when(properties.getProperty("cucumber.glue.path")).thenReturn("com.project.stepdefinitions");
        String result = configReader.getGluePath();
        assertEquals("com.project.stepdefinitions", result);
    }

    @Test
    public void shouldReturnReportPathWhenGetReportPathCalled() {
        when(properties.getProperty("report.path")).thenReturn("target/reports");
        String result = configReader.getReportPath();
        assertEquals("target/reports", result);
    }

    @Test
    public void shouldReturnIsScreenshotOnFailureWhenIsScreenshotOnFailureCalled() {
        when(properties.getProperty("screenshot.on.failure")).thenReturn("false");
        boolean result = configReader.isScreenshotOnFailure();
        assertEquals(false, result);
    }

    @Test
    public void shouldReturnIsPlaywrightEnabledWhenIsPlaywrightEnabledCalled() {
        when(properties.getProperty("playwright.enabled")).thenReturn("true");
        boolean result = configReader.isPlaywrightEnabled();
        assertEquals(true, result);
    }

    @Test
    public void shouldReturnIsVisualRegressionEnabledWhenIsVisualRegressionEnabledCalled() {
        when(properties.getProperty("visual.regression.enabled")).thenReturn("false");
        boolean result = configReader.isVisualRegressionEnabled();
        assertEquals(false, result);
    }

    @Test
    public void shouldReturnPlaywrightBrowserWhenGetPlaywrightBrowserCalled() {
        when(properties.getProperty("playwright.browser")).thenReturn("firefox");
        String result = configReader.getPlaywrightBrowser();
        assertEquals("firefox", result);
    }
}
