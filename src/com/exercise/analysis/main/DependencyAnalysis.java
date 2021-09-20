package com.exercise.analysis.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DependencyAnalysis {
    // Analyse and add all dependencies for each token
    public static Map<String, Set<String>> analyseDependencies(Map<String, Set<String>> dataMap) {
        Map<String, Set<String>> resultMap = new HashMap<>();

        dataMap.forEach((key, set) -> {
            Set<String> currentSet = new HashSet<>(set);

            addDependencies(set, currentSet, dataMap);
            resultMap.put(key, currentSet);
        });

        return resultMap;
    }

    // Add dependencies from the original dependency list for each token recursively
    private static void addDependencies(Set<String> startSet, Set<String> endSet, Map<String, Set<String>> dataMap) {
        for (String s: startSet) {
            if (dataMap.containsKey(s)) {
               endSet.addAll(dataMap.get(s));
               addDependencies(dataMap.get(s), endSet, dataMap);
            } else {
                return;
            }
        }
    }

    // Analyse and add all inverse dependencies for each token
    public static Map<String, Set<String>> analyseDependenciesInverse(Map<String, Set<String>> dataMap) {
        Map<String, Set<String>> resultMap = new HashMap<>();

        dataMap.forEach((key, set) -> {
            Set<String> currentSet = new HashSet<>(set);

            addDependenciesInverse(set, currentSet, dataMap);
            resultMap.put(key, currentSet);
        });

        return resultMap;
    }

    // Add inverse dependencies from the original dependency list for each token recursively
    private static void addDependenciesInverse(Set<String> startSet, Set<String> endSet, Map<String, Set<String>> dataMap) {
        for (String s: startSet) {
            if (dataMap.containsKey(s)) {
                endSet.removeAll(dataMap.get(s));
                addDependenciesInverse(dataMap.get(s), endSet, dataMap);
            } else {
                return;
            }
        }
    }
}