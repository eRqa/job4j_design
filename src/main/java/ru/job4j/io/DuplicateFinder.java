package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicateFinder implements FileVisitor<Path> {

    private List<Path> duplicateFiles = new ArrayList<>();
    private Set<FileProperty> filesSet = new HashSet<>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName());
        if (filesSet.contains(fileProperty)) {
            duplicateFiles.add(file);
        }
        filesSet.add(fileProperty);

//        files.stream()
//                .filter(currentPath -> currentPath.getFileName().equals(file.getFileName())
//                        && currentPath.toFile().length() == file.toFile().length())
//                .findFirst().ifPresent(founded -> duplicateFiles.add(file));
//        files.add(file);
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
