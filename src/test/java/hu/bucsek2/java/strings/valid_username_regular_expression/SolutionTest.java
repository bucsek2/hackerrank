package hu.bucsek2.java.strings.valid_username_regular_expression;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "8\n" +
                "Julia\n" +
                "Samantha\n" +
                "Samantha_21\n" +
                "1Samantha\n" +
                "Samantha?10_2A\n" +
                "JuliaZ007\n" +
                "Julia@007\n" +
                "_Julia007";
        String expected = "Invalid\n" +
                "Valid\n" +
                "Valid\n" +
                "Invalid\n" +
                "Invalid\n" +
                "Valid\n" +
                "Invalid\n" +
                "Invalid\n";

        test(in, expected, () -> Solution.main(null));
    }
}