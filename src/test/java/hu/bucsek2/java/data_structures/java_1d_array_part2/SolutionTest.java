package hu.bucsek2.java.data_structures.java_1d_array_part2;

import hu.bucsek2.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;
import java.util.Set;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "4\n" +
                "5 3\n" +
                "0 0 0 0 0\n" +
                "6 5\n" +
                "0 0 0 1 1 1\n" +
                "6 3\n" +
                "0 0 1 1 1 0\n" +
                "3 1\n" +
                "0 1 0";
        String expected = "YES\n" +
                "YES\n" +
                "NO\n" +
                "NO\n";
        test(in, expected);
    }

    @Test
    public void test1() {
        String in = "3\n" +
                "6 2\n" +
                "0 1 0 1 0 1\n" +
                "10 6\n" +
                "0 0 1 1 0 0 1 1 0 0\n" +
                "10 3\n" +
                "0 0 1 1 0 0 1 1 0 0";
        String expected = "YES\n" +
                "NO\n" +
                "YES\n";
        test(in, expected);
    }

    @Test
    public void test3() {
        String in = readResource("test3.in");
        String expected = readResource("test3.expected") + "\n";
        test(in, expected);
    }

    @Test
    public void test3_30() {
        String in = "1\n" +
                "61 57\n" +
                "0 0 1 1 0 0 0 0 0 0 0 0 0 1 0 1 1 1 1 0 1 1 1 0 1 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 0 1 0 1 0 1 1 0 0 0 1 1 1";
        String expeced = "YES\n";

        test(in, expeced);
    }

    @Test
    public void grapTest() {
        int[] game = {0, 0, 1, 1, 0, 0, 1, 1, 0, 0};
        int leap = 3;

        Map<Integer, Set<Integer>> graph = Solution.createGraph(leap, game);
        Assert.assertTrue(Solution.canReachVertex(graph, 0, 10));
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}
