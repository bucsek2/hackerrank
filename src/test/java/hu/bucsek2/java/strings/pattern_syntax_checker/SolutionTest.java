package hu.bucsek2.java.strings.pattern_syntax_checker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals("Valid", Solution.checkPattern("([A-Z])(.+)"));
        Assert.assertEquals("Invalid", Solution.checkPattern("[AZ[a-z](a-z)"));
        Assert.assertEquals("Invalid", Solution.checkPattern("batcatpat(nat"));
    }
}