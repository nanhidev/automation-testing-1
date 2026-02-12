
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AssertTest {

    @Mock
    private WebDriver driver;

    @Mock
    private WebElement element;

    @InjectMocks
    private Assert assertUtil;

    @Test
    public void shouldPassWhenAssertTrueIsTrue() {
        assertUtil.assertTrue(true, "Condition should be true");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertTrueIsFalse() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertTrue(false, "Condition should be true");
        });
        assertEquals("Condition should be true", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertFalseIsFalse() {
        assertUtil.assertFalse(false, "Condition should be false");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertFalseIsTrue() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertFalse(true, "Condition should be false");
        });
        assertEquals("Condition should be false", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertEqualsIsEqual() {
        assertUtil.assertEquals("expected", "expected", "Values should be equal");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertEqualsIsNotEqual() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertEquals("actual", "expected", "Values should be equal");
        });
        assertEquals("Values should be equal [Expected: expected, Actual: actual]", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertNotNullIsNotNull() {
        assertUtil.assertNotNull(new Object(), "Object should not be null");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertNotNullIsNull() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertNotNull(null, "Object should not be null");
        });
        assertEquals("Object should not be null", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertNullIsNull() {
        assertUtil.assertNull(null, "Object should be null");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertNullIsNotNull() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertNull(new Object(), "Object should be null");
        });
        assertEquals("Object should be null", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertContains() {
        assertUtil.assertContains("Hello, world!", "world", "String should contain substring");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertNotContains() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertNotContains("Hello, world!", "world", "String should not contain substring");
        });
        assertEquals("String should not contain: world [Contains: world]", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementVisibleWithWebElement() {
        when(element.isDisplayed()).thenReturn(true);
        assertUtil.assertElementVisible(driver, element, "Element should be visible");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementVisibleWithWebElementIsNotVisible() {
        when(element.isDisplayed()).thenReturn(false);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementVisible(driver, element, "Element should be visible");
        });
        assertEquals("Element should be visible", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementVisibleWithLocator() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        assertUtil.assertElementVisible(driver, locator, "Element should be visible");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementVisibleWithLocatorIsNotVisible() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(false);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementVisible(driver, locator, "Element should be visible");
        });
        assertEquals("Element should be visible", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementNotVisibleWithWebElement() {
        when(element.isDisplayed()).thenReturn(false);
        assertUtil.assertElementNotVisible(driver, element, "Element should not be visible");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementNotVisibleWithWebElementIsVisible() {
        when(element.isDisplayed()).thenReturn(true);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementNotVisible(driver, element, "Element should not be visible");
        });
        assertEquals("Element should not be visible", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementNotVisibleWithLocator() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(false);
        assertUtil.assertElementNotVisible(driver, locator, "Element should not be visible");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementNotVisibleWithLocatorIsVisible() {
        By locator = By.id("test");
        when(driver.findElement(locator)).thenReturn(element);
        when(element.isDisplayed()).thenReturn(true);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementNotVisible(driver, locator, "Element should not be visible");
        });
        assertEquals("Element should not be visible", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementEnabled() {
        when(element.isEnabled()).thenReturn(true);
        assertUtil.assertElementEnabled(driver, element, "Element should be enabled");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementEnabledIsDisabled() {
        when(element.isEnabled()).thenReturn(false);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementEnabled(driver, element, "Element should be enabled");
        });
        assertEquals("Element should be enabled", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementDisabled() {
        when(element.isEnabled()).thenReturn(false);
        assertUtil.assertElementDisabled(driver, element, "Element should be disabled");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementDisabledIsEnabled() {
        when(element.isEnabled()).thenReturn(true);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementDisabled(driver, element, "Element should be disabled");
        });
        assertEquals("Element should be disabled", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertElementClickable() {
        when(element.isEnabled()).thenReturn(true);
        assertUtil.assertElementClickable(driver, element, "Element should be clickable");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertElementClickableIsNotClickable() {
        when(element.isEnabled()).thenReturn(false);
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertElementClickable(driver, element, "Element should be clickable");
        });
        assertEquals("Element should be clickable", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertPageTitle() {
        when(driver.getTitle()).thenReturn("Expected Title");
        assertUtil.assertPageTitle(driver, "Expected Title");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertPageTitleIsNotEqual() {
        when(driver.getTitle()).thenReturn("Actual Title");
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertPageTitle(driver, "Expected Title");
        });
        assertEquals("Page title verification", exception.getMessage());
    }

    @Test
    public void shouldPassWhenAssertListSize() {
        assertUtil.assertListSize(Collections.singletonList("item"), 1, "List should have size 1");
    }

    @Test
    public void shouldThrowAssertionErrorWhenAssertListSizeIsNotEqual() {
        Exception exception = assertThrows(AssertionError.class, () -> {
            assertUtil.assertListSize(Collections.singletonList("item"), 2, "List should have size 2");
        });
        assertEquals("List should have size 2 size verification", exception.getMessage());
    }
}
