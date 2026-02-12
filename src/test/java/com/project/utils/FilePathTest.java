
package com.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FilePathTest {

    @Test
    public void shouldReturnConfigPropertyFilePath() {
        // Act
        String result = FilePath.getConfigPropertyFilePath();

        // Assert
        assertEquals("/src/test/resources/com/project/config/config.properties", result);
    }
}
