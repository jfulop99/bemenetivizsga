package hu.nive.ujratervezes.longestword;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {
    public String findLongestWord(String fileName) {
        String longestWord = "";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                String longestInTheLine = lineParser(line);
                if (longestInTheLine.length() > longestWord.length()) {
                    longestWord = longestInTheLine;
                }
            }
        } catch (IOException e) {
            return "";
        }
        return longestWord;
    }

    private String lineParser(String line) {
        String[] parts = line.split(" ");
        return Arrays.stream(parts).max(Comparator.comparing(String::length)).orElseThrow();
    }
}
