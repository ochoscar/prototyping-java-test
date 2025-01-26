package com.ochoscar.tdd2;

import org.junit.Assert;
import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;

public class OSopsTest {

    @Test
    public void testNonDeterministic() {
        // Given
        String expected = "First line";
        OSops ops = new OSops();
        PrintStreamFake out = new PrintStreamFake(System.out);

        // When
        ops.nonDeterministicSeparation(out);
        String actual = out.getEmittedLines();

        // Then
        Assert.assertEquals(expected, actual);
    }

}

class PrintStreamFake extends PrintStream {

    private String emittedLines = "";

    public PrintStreamFake(OutputStream out) {
        super(out);
    }

    public void println(String x) {
        emittedLines += x;
    }

    public String getEmittedLines() {
        return emittedLines;
    }

}