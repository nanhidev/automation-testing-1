
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ElementUtilsTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement webElement;

    @InjectMocks
    private ElementUtils elementUtils;

    @Test
    public void shouldReturnRandomTime() {
        LocalTime randomTime = ElementUtils.getRandomTime();
        assertNotNull(randomTime);
    }

    @Test
    public void shouldClickElementUsingJavaScript() {
        doNothing().when(webElement).click();
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        
        ElementUtils.jsClick(driver, webElement);

        verify(webElement, times(1)).click();
    }

    @Test
    public void shouldCheckIfElementIsClickable() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.isEnabled()).thenReturn(false);

        boolean isClickable = ElementUtils.isElementClickable(driver, By.className("test-class"));

        assertTrue(isClickable);
        verify(driver, times(1)).findElement(any(By.class));
    }

    @Test
    public void shouldClearAndSendKeys() {
        doNothing().when(webElement).clear();
        doNothing().when(webElement).sendKeys("test");
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        
        elementUtils.clearAndSendKeys(webElement, "test");

        verify(webElement, times(1)).clear();
        verify(webElement, times(1)).sendKeys("test");
    }

    @Test
    public void shouldVerifyDropdownOptions() {
        List<String> expectedOptions = Collections.singletonList("Option 1");
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.getText()).thenReturn("Option 1");
        
        elementUtils.verifyDropdownOptions(webElement, expectedOptions, "Dropdown options count mismatch");

        verify(webElement, times(1)).getText();
    }

    @Test
    public void shouldCheckIfElementIsDisplayed() {
        when(driver.findElement(any(By.class))).thenReturn(webElement);
        when(webElement.isDisplayed()).thenReturn(true);

        boolean isDisplayed = elementUtils.isElementDisplayed(webElement);

        assertTrue(isDisplayed);
        verify(webElement, times(1)).isDisplayed();
    }

    @Test
    public void shouldNavigateToLastPageIfPresent() {
        when(driver.findElements(any(By.class))).thenReturn(Collections.singletonList(webElement));
        when(webElement.isDisplayed()).thenReturn(true);
        when(webElement.click()).thenReturn(null);

        elementUtils.navigateToLastPageIfPresent();

        verify(webElement, times(1)).click();
    }

    @Test
    public void shouldVerifyCellIsReadOnly() {
        when(webElement.getAttribute("aria-readonly")).thenReturn("true");

        elementUtils.verifyCellIsReadOnly(webElement);

        verify(webElement, times(1)).getAttribute("aria-readonly");
    }

    @Test
    public void shouldVerifyCellIsEditable() {
        when(webElement.getAttribute("aria-readonly")).thenReturn(null);

        elementUtils.verifyCellIsEditable(webElement);

        verify(webElement, times(1)).getAttribute("aria-readonly");
    }

    @Test
    public void shouldCheckIfCheckboxIsChecked() {
        when(webElement.isSelected()).thenReturn(true);

        boolean isChecked = elementUtils.isCheckboxChecked(webElement);

        assertTrue(isChecked);
        verify(webElement, times(1)).isSelected();
    }

    @Test
    public void shouldCheckIfOptionIsSelected() {
        when(webElement.getText()).thenReturn("Option 1");
        when(driver.findElement(any(By.class))).thenReturn(webElement);

        boolean isSelected = elementUtils.isOptionSelected(webElement, "Option 1");

        assertTrue(isSelected);
        verify(webElement, times(1)).getText();
    }
}
