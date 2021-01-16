package ru.job4j.io;

import java.nio.file.Path;
import java.util.Objects;

public class FileProperty {
    private long size;
    private Path name;

    public FileProperty(long size, Path name) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public Path getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return size == that.size
                && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
