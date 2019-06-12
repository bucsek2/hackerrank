package hu.bucsek2.strings.java_regex;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest {

    @Test
    public void test() {
        Assert.assertTrue("000.12.12.034".matches(new MyRegex().pattern));
        Assert.assertTrue("121.234.12.12".matches(new MyRegex().pattern));
        Assert.assertTrue("23.45.12.56".matches(new MyRegex().pattern));
        Assert.assertFalse("00.12.123.123123.123".matches(new MyRegex().pattern));
        Assert.assertFalse("122.23".matches(new MyRegex().pattern));
        Assert.assertFalse("Hello.IP".matches(new MyRegex().pattern));
    }
}