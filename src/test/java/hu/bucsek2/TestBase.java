package hu.bucsek2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

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

    @Test
    public final void test_base2() {
        String test = "test2";

        setIn(test);

        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            System.out.print(line);

            Assert.assertEquals(test, getOut());
        }
    }

    @Test
    @Ignore
    public void test_resource_read() {
        String read = readResource("test0");
        String expected = "test";
        Assert.assertEquals(expected, read);
    }

    @Test
    @Ignore
    public void test_resource_read2() {
        String read = readResource("test1");
        String expected = "test\ntest\n\ntest";
        Assert.assertEquals(expected, read);
    }

    protected String readResource(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(this.getClass().getPackageName() + "." + path);

        StringJoiner joiner = new StringJoiner("\n");
        try (Scanner scanner = new Scanner(stream)) {
            while (scanner.hasNext()) {
                joiner.add(scanner.nextLine());
            }
        }

        return joiner.toString();
    }

    protected Runnable mainRunnable() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    protected void test(String in, String expected) {
        test(in, expected, mainRunnable());
    }

    protected void test(String in, String expected, Runnable runMethod) {
        setIn(in);

        runMethod.run();

        String actual = getOut();

        Assert.assertEquals(expected, actual);
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
