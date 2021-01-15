package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ArgZipTest {

    @Test
    public void whenValid() {
        String[] args = new String[] {"-d=C:\\testDirectory", "-o=C:\\testDirectoryOut", "-e=txt"};
        ArgZip argZip = new ArgZip(args);
        assertThat(argZip.valid(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalid() {
        String[] args = new String[] {"-x=C:\\testDirectory", "-o=C:\\testDirectoryOut", "-e=txt"};
        ArgZip argZip = new ArgZip(args);
    }

    @Test
    public void directory() {
        String[] args = new String[] {"-d=C:\\testDirectory", "-o=C:\\testDirectoryOut", "-e=txt"};
        ArgZip argZip = new ArgZip(args);
        assertThat(argZip.directory(), is("C:\\testDirectory"));
    }

    @Test
    public void exclude() {
        String[] args = new String[] {"-d=C:\\testDirectory", "-o=C:\\testDirectoryOut", "-e=txt"};
        ArgZip argZip = new ArgZip(args);
        assertThat(argZip.exclude(), is("txt"));
    }

    @Test
    public void output() {
        String[] args = new String[] {"-d=C:\\testDirectory", "-o=C:\\testDirectoryOut", "-e=txt"};
        ArgZip argZip = new ArgZip(args);
        assertThat(argZip.output(), is("C:\\testDirectoryOut"));
    }
}