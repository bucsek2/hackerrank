package hu.bucsek2.data_structures.java_dequeue;

import hu.bucsek2.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

@RunWith(JUnit4.class)
public class testTest extends TestBase {
    @Override
    protected Runnable mainRunnable() {
        return () -> test.main(null);
    }

    @Test
    public void test0() {
        String in = readResource("test0.in");
        String expected = "3\n";
        test(in, expected);
    }

    @Test
    public void test1() {
        String in = readResource("test1.in");
        String expected = "45\n";
        test(in, expected);
    }

    @Test
    public void test7() {
        String in = "10 3\n" +
                "1 1 1 1 1 1 1 1 1 1";
        String expected = "1\n";
        test(in, expected);
    }

    @Test
    public void test9() {
        String in = readResource("test9.in");
        String expected = "94531\n";
        test(in, expected);
    }

    @Test
    public void test10() {
        String in = readResource("test10.in");
        String expected = "94055\n";
        test(in, expected);
    }

    @Override
    protected void test(String in, String expected) {
        Instant start = Instant.now();
        super.test(in, expected);
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        Assert.assertTrue(MessageFormat.format("Too slow! - {0}", duration.toString()), duration.getSeconds() <= 2);
    }
}