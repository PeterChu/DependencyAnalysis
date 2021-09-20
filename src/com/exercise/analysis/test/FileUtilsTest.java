package com.exercise.analysis.test;

import com.exercise.analysis.main.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilsTest {

    @Test
    public void testLoadDataToMap() {
        Map<String, Set<String>> dataMap = FileUtils.loadDataToMap("./src/com/exercise/analysis/test/resources/data_test.txt");

        assertEquals(6, dataMap.size());
        assertEquals(Set.of("C", "E"), dataMap.get("B"));
    }
}
