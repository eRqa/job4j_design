package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 3;
        short sh = 4;
        char ch = 'Y';
        int i = 1;
        long l = 22;
        float f = 32;
        double d = 1231;
        boolean bool = true;
        LOG.debug("Primitive types : byte {}; short {}; char {}; int {}; "
                + "long {}; float {}; double {}; boolean {};", b, sh, ch, i, l, f, d, bool);
    }
}