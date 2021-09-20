package com.exercise.analysis.main;

import java.util.Map;
import java.util.Set;

import static com.exercise.analysis.main.FileUtils.loadDataToMap;
import static com.exercise.analysis.main.FileUtils.printDependencyMap;
import static com.exercise.analysis.main.FileUtils.writeDependencyMapToFile;

public class App {
    public static void main(String[] args) {
        // Analyse dependencies for tokens from the data file
        Map<String, Set<String>> dataMap = loadDataToMap("data.txt");
        Map<String, Set<String>> resultMap = DependencyAnalysis.analyseDependencies(dataMap);
        System.out.println("Set of dependencies:");
        printDependencyMap(resultMap);
        writeDependencyMapToFile(resultMap, "result.txt");

        System.out.println();

        // Analyse inverse dependencies for tokens from the data file
        Map<String, Set<String>> dataMapInverse = loadDataToMap("data_inverse.txt");
        Map<String, Set<String>> resultMapInverse = DependencyAnalysis.analyseDependenciesInverse(dataMapInverse);
        System.out.println("Set of inverse dependencies:");
        printDependencyMap(resultMapInverse);
        writeDependencyMapToFile(resultMapInverse, "result_inverse.txt");
    }
}