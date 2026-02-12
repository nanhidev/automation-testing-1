
package com.project.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoExtension;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExecutionSummaryListenerTest {

    @InjectMocks
    private ExecutionSummaryListener listener;

    @Mock
    private ITestResult testResult;

    @Mock
    private ITestContext testContext;

    @Test
    public void shouldIncrementPassedCountWhenTestSuccess() {
        listener.onTestSuccess(testResult);
        verify(testResult).getTestContext();
    }

    @Test
    public void shouldIncrementFailedCountWhenTestFailure() {
        listener.onTestFailure(testResult);
        verify(testResult).getTestContext();
    }

    @Test
    public void shouldIncrementSkippedCountWhenTestSkipped() {
        listener.onTestSkipped(testResult);
        verify(testResult).getTestContext();
    }

    @Test
    public void shouldPrintExecutionSummaryOnFinish() {
        listener.onFinish(testContext);
        verify(testContext).getAllTestMethods();
    }
}
