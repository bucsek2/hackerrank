package hu.bucsek2.strings.java_string_tokens;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest {

    @Test
    public void test() {
        Object[] tokens = Solution.break2Tokens("He is a very very good boy, isn't he?");
        Object[] expected = {10, "He", "is", "a", "very", "very", "good", "boy", "isn", "t", "he"};

        Assert.assertArrayEquals(expected, tokens);
    }

    @Test
    public void test3() {
        String test = "           YES      leading spaces        are valid,    problemsetters are         evillllll";

        Object[] tokens = Solution.break2Tokens(test);
        Object[] expected = {8, "YES", "leading", "spaces", "are", "valid", "problemsetters", "are", "evillllll"};

        Assert.assertArrayEquals(expected, tokens);
    }
}