package hu.bucsek2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.util.Scanner;

@RunWith(JUnit4.class)
public class TestBase {

    private InputStream stdin;
    private PrintStream stdout;
    private OutputStream out;

    @Before
    public void setUp() {
        stdin = System.in;
        stdout = System.out;

        out = new ByteArrayOutputStream();
        PrintStream writer = new PrintStream(out, false);

        System.setOut(writer);
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Test
    public final void test_base() {
        String test = "test";

        setIn(test);

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            System.out.print(line);

            Assert.assertEquals(test, getOut());
        }
    }

    protected void setIn(String in) {
        System.setIn(new ByteArrayInputStream(in.getBytes()));
    }

    protected String getOut() {
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
