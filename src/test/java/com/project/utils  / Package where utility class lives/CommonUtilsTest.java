
package com.project.utils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.Scenario;

import java.io.File;

@ExtendWith(MockitoExtension.class)
class CommonUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement webElement;

    @InjectMocks
    private CommonUtils commonUtils;

    @Test
    void shouldGenerateEmailWithTimestamp() {
        String email = CommonUtils.getEmailWithTimeStamp();
        assertTrue(email.startsWith("newemail") && email.endsWith("@gmail.com"));
    }

    @Test
    void shouldTakeScreenshot() {
        Scenario scenario = mock(Scenario.class);
        String scenarioName = "testScenario";

        when(driver).thenReturn((TakesScreenshot) driver);
        when(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)).thenReturn(new byte[]{});

        byte[] screenshot = CommonUtils.takeScreenShot(scenario, driver, scenarioName);
        assertNotNull(screenshot);
    }

    @Test
    void shouldScrollToBottom() {
        JavascriptExecutor js = mock(JavascriptExecutor.class);
        when(driver).thenReturn(js);
        when(js.executeScript("return document.body.scrollHeight")).thenReturn(100L).thenReturn(100L);

        CommonUtils.scrollToBottom(driver);
        verify(js, atLeastOnce()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Test
    void shouldScrollToTop() {
        JavascriptExecutor js = mock(JavascriptExecutor.class);
        when(driver).thenReturn(js);
        when(js.executeScript("return window.pageYOffset")).thenReturn(10L).thenReturn(0L);

        CommonUtils.scrollToTop(driver);
        verify(js, atLeastOnce()).executeScript("window.scrollBy(0, -1000);");
    }

    @Test
    void shouldVerifyDropdownSelectedOptionIndex() {
        Select dropdown = mock(Select.class);
        when(webElement).thenReturn(dropdown);
        WebElement selectedOption = mock(WebElement.class);
        when(dropdown.getFirstSelectedOption()).thenReturn(selectedOption);
        when(dropdown.getOptions()).thenReturn(Arrays.asList(selectedOption));

        CommonUtils.DropdownSelectedOptionVerification(webElement, 0, "Dropdown option mismatch");
        verify(dropdown, times(1)).getFirstSelectedOption();
        verify(dropdown, times(1)).getOptions();
    }

    @Test
    void shouldCaptureScreenshot() throws IOException {
        when(driver).thenReturn((TakesScreenshot) driver);
        File src = mock(File.class);
        when(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)).thenReturn(src);
        String path = System.getProperty("user.dir") + "/screenshots/test.png";
        when(src.getPath()).thenReturn(path);

        String result = CommonUtils.captureScreenshot(driver, "test");
        assertEquals(path, result);
    }

    @Test
    void shouldSwitchToNewWindow() {
        when(driver.getWindowHandle()).thenReturn("currentWindow");
        when(driver.getWindowHandles()).thenReturn(new HashSet<>(Arrays.asList("currentWindow", "newWindow")));

        CommonUtils.switchToNewWindow(driver);
        verify(driver, times(1)).switchTo().window("newWindow");
    }

    @Test
    void shouldSwitchToParentWindow() {
        when(driver.getWindowHandles()).thenReturn(new HashSet<>(Arrays.asList("parentWindow", "childWindow")));

        CommonUtils.switchToParentWindow(driver);
        verify(driver, times(1)).switchTo().window("parentWindow");
    }

    @Test
    void shouldUploadFile() {
        String filePath = "path/to/file";
        CommonUtils.uploadFile(webElement, filePath);
        verify(webElement, times(1)).sendKeys(filePath);
    }

    @Test
    void shouldCheckIfAlertIsPresent() {
        when(driver.switchTo().alert()).thenReturn(mock(Alert.class));
        assertTrue(CommonUtils.isAlertPresent(driver));
    }

    @Test
    void shouldAcceptAlert() {
        Alert alert = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(alert);
        CommonUtils.acceptAlert(driver);
        verify(alert, times(1)).accept();
    }

    @Test
    void shouldDismissAlert() {
        Alert alert = mock(Alert.class);
        when(driver.switchTo().alert()).thenReturn(alert);
        CommonUtils.dismissAlert(driver);
        verify(alert, times(1)).dismiss();
    }

    @Test
    void shouldWaitForElementVisible() {
        CommonUtils.waitForElementVisible(driver, webElement);
        verify(driver, times(1)).wait(new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME)));
    }

    @Test
    void shouldWaitForElementClickable() {
        CommonUtils.waitForElementClickable(driver, webElement);
        verify(driver, times(1)).wait(new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME)));
    }

    @Test
    void shouldWaitForPageLoad() {
        CommonUtils.waitForPageLoad(driver);
        verify(driver, times(1)).wait(new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME)));
    }

    @Test
    void shouldRefreshPage() {
        CommonUtils.refreshPage(driver);
        verify(driver, times(1)).navigate().refresh();
    }

    @Test
    void shouldMaximizeWindow() {
        CommonUtils.maximizeWindow(driver);
        verify(driver, times(1)).manage().window().maximize();
    }

    @Test
    void shouldSleep() throws InterruptedException {
        CommonUtils.sleep(1);
        verifyNoMoreInteractions(driver);
    }
}
