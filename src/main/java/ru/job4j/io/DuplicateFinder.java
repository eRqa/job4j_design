package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicateFinder implements FileVisitor<Path> {

    private List<Path> files = new ArrayList<>();
    private List<Path> duplicateFiles = new ArrayList<>();


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        files.stream()
                .filter(currentPath -> currentPath.getFileName().equals(file.getFileName())
                        && currentPath.toFile().length() == file.toFile().length())
                .findFirst().ifPresent(founded -> duplicateFiles.add(file));
        files.add(file);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public List<Path> getDuplicateFiles() {
        return duplicateFiles;
    }
}
