package hu.bucsek2.data_structures.java_dequeue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.function.Function;

@RunWith(JUnit4.class)
public class testTest {
    private static final String BASE_PATH = "data_structures/java_dequeue/";

    private static class TestCase {
        int n, m;
        int[] array;
    }

    @Test
    public void name() {
        test.UniqueList<Integer> asd = new test.UniqueList<>(Integer.class);

        asd.add(5);
        asd.add(2);
        asd.add(6);
        asd.add(3);

        for (int num : asd.toArray()) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    @Test
    public void test0() {
        runTest("test0", 3);
    }

    @Test
    public void test1() {
        runTest("test1", 45);
    }

    @Test
    public void test9() {
        runTest("test9", 94531);
    }

    private void runTest(String path, int expected) {
        runTest(path, expected, testCase -> test.calcMaxUnique(testCase.m, testCase.array), "base");
        runTest(path, expected, testCase -> test.calcMaxUnique2(testCase.m, testCase.array), "try2");
    }

    private void runTest(String path, Integer expected, Function<TestCase, Integer> testFunction, String functionName) {
        Instant start = Instant.now();
        TestCase testCase = readTestCase(path);
        Assert.assertEquals(expected, testFunction.apply(testCase));
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println(path + " - " + functionName + " - " + duration);
    }

    private TestCase readTestCase(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(BASE_PATH + path);
        Scanner scanner = new Scanner(stream);

        TestCase testCase = new TestCase();

        testCase.n = scanner.nextInt();
        testCase.m = scanner.nextInt();

        testCase.array = new int[testCase.n];

        int i = 0;
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            testCase.array[i++] = number;
        }
        scanner.close();

        return testCase;
    }
}