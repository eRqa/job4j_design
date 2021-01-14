package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DuplicateFinderUsage {

    public static void main(String[] args) throws IOException {
        DuplicateFinder finder = new DuplicateFinder();
        Files.walkFileTree(Paths.get(args[0]), finder);
        List<Path> files = finder.getDuplicateFiles();
        files.forEach(System.out::println);
    }

}
