package com.exercise.analysis.test;

import com.exercise.analysis.main.DependencyAnalysis;
import com.exercise.analysis.main.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DependencyAnalysisTest {

    @Test
    public void testAnalyseDependencies() {
        Map<String, Set<String>> dataMap = FileUtils.loadDataToMap("./src/com/exercise/analysis/test/resources/data_test.txt");
        Map<String, Set<String>> resultMap = DependencyAnalysis.analyseDependencies(dataMap);

        assertEquals(Set.of("B", "C", "E", "F", "G", "H"), resultMap.get("A"));
    }

    @Test
    public void testAnalyseDependenciesInverse() {
        Map<String, Set<String>> dataMapInverse = FileUtils.loadDataToMap("./src/com/exercise/analysis/test/resources/data_inverse_test.txt");
        Map<String, Set<String>> resultMapInverse = DependencyAnalysis.analyseDependenciesInverse(dataMapInverse);

        assertEquals(Set.of("B"), resultMapInverse.get("A"));
    }
}
