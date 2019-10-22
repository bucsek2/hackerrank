package hu.bucsek2.java.data_structures.java_stack;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "{}()\n" +
                "({()})\n" +
                "{}(\n" +
                "[]";
        String expected = "true\n" +
                "true\n" +
                "false\n" +
                "true\n";
        test(in, expected);
    }

    @Test
    public void test1() {
        String in="({}[])\n" +
                "(({()})))\n" +
                "({(){}()})()({(){}()})(){()}\n" +
                "{}()))(()()({}}{}\n" +
                "}}}}\n" +
                "))))\n" +
                "{{{\n" +
                "(((\n" +
                "[]{}(){()}((())){{{}}}{()()}{{}{}}\n" +
                "[[]][][]\n" +
                "}{";
        String expected="true\n" +
                "false\n" +
                "true\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "true\n" +
                "true\n" +
                "false\n";
        test(in,expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}