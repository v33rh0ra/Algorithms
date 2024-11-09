package com.v33rh0ra.algorithms.codingconstructs.newio;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summarizingInt;

public class Nio {

    private static Stream<String> getFileContents(Path filePath) throws IOException {
        return Files.lines(filePath)
                .map(String::trim)
                .filter(s -> !s.isEmpty());
    }
    public static void main(String[] args) throws IOException {
        System.out.println("file names...");
        String cwd = Paths.get(".").toRealPath().toString();
        System.out.println("cwd = " + cwd);
        String targetPath = cwd+"/src/main/java/com/v33rh0ra/algorithms/codingconstructs/newio";
        Path filePath = Paths.get(targetPath + "/Nio.java").toRealPath();

        Files.list(Paths.get(targetPath))
                .map(Path::getFileName)
                .map(Path::toString)
                .filter(name -> name.endsWith("java"))
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\nPrint file contents..");

        getFileContents(filePath).forEach(System.out::println);



        Double averageLineLength = getFileContents(filePath)
                .collect(averagingInt(String::length));
        System.out.println("\nAverage line length : "+averageLineLength);

        IntSummaryStatistics stats = getFileContents(filePath)
                .collect(summarizingInt(String::length));
        System.out.println("avg:"+stats.getAverage());
        System.out.println("count:"+stats.getCount());
        System.out.println("max:"+stats.getMax());
        System.out.println("min:"+stats.getMin());
    }
}
