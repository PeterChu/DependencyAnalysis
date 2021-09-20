package com.exercise.analysis.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class FileUtils {
    // Load list of dependencies for each token from the file to a map
    public static Map<String, Set<String>> loadDataToMap(String fileName) {
        Map<String, Set<String>> dataMap = new HashMap<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                StringTokenizer st = new StringTokenizer(line);
                if (st.hasMoreTokens()) {
                    String key = st.nextToken();
                    Set<String> set = new HashSet<>();
                    while (st.hasMoreTokens()) {
                        set.add(st.nextToken());
                    }

                    dataMap.put(key, set);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataMap;
    }

    // Print out the dependency map to the standard output
    public static void printDependencyMap(Map<String, Set<String>> map) {
        map.forEach((key, value) -> {
            System.out.println(mapEntryToString(key, value));
        });
    }

    // Write the dependency map to a file
    public static void writeDependencyMapToFile(Map<String, Set<String>> map, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            map.forEach((key, value) -> {
                pw.println(mapEntryToString(key, value));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String mapEntryToString(String key, Set<String> set) {
        StringBuilder result = new StringBuilder(key);
        result.append(" ");
        for (String s : set) {
            result.append(s).append(" ");
        }
        return result.toString();
    }
}
