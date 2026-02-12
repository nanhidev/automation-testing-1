
package com.project.utils;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ExtendWith(MockitoExtension.class)
public class WaitUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @Mock
    private WebElement anotherElement;

    @Mock
    private By locator;

    @Mock
    private WebElement frameElement;

    @Mock
    private Alert alert;

    @Test
    public void shouldReturnWebElementWhenVisible() {
        when(driver.findElement(locator)).thenReturn(element);
        when(driver).thenReturn(element);
        when(ExpectedConditions.visibilityOfElementLocated(locator)).thenReturn(element);

        WebElement result = WaitUtils.waitForVisibility(driver, locator);

        verify(driver).findElement(locator);
        assertSame(element, result);
    }

    @Test
    public void shouldReturnWebElementWhenClickable() {
        when(driver.findElement(locator)).thenReturn(element);
        when(ExpectedConditions.elementToBeClickable(element)).thenReturn(element);

        WebElement result = WaitUtils.waitForClickable(driver, element);

        verify(driver).findElement(locator);
        assertSame(element, result);
    }

    @Test
    public void shouldReturnListOfWebElementsWhenAllVisible() {
        List<WebElement> webElements = mock(List.class);
        when(driver.findElements(locator)).thenReturn(webElements);
        when(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).thenReturn(webElements);

        List<WebElement> result = WaitUtils.waitForAllVisible(driver, locator);

        verify(driver).findElements(locator);
        assertSame(webElements, result);
    }

    @Test
    public void shouldReturnTrueWhenInvisibility() {
        when(ExpectedConditions.invisibilityOfElementLocated(locator)).thenReturn(true);

        boolean result = WaitUtils.waitForInvisibility(driver, locator);

        verify(driver).findElement(locator);
        assertTrue(result);
    }

    @Test
    public void shouldReturnAlertWhenPresent() {
        when(ExpectedConditions.alertIsPresent()).thenReturn(alert);

        Alert result = WaitUtils.waitForAlert(driver);

        verify(driver).getWindowHandles();
        assertSame(alert, result);
    }

    @Test
    public void shouldReturnTrueWhenUrlContains() {
        when(ExpectedConditions.urlContains("test")).thenReturn(true);

        boolean result = WaitUtils.waitForUrlContains(driver, "test");

        verify(driver).getCurrentUrl();
        assertTrue(result);
    }

    @Test
    public void shouldReturnWebElementWhenFrameAndSwitch() {
        when(driver.findElement(locator)).thenReturn(frameElement);
        when(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)).thenReturn(frameElement);

        WebDriver result = WaitUtils.waitForFrameAndSwitch(driver, locator);

        verify(driver).findElement(locator);
        assertSame(frameElement, result);
    }
}
