package hu.bucsek2.strings.java_anagrams;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest {

    @Test
    public void testAnagram() {
        Assert.assertTrue(Solution.isAnagram("anagram", "margana"));
        Assert.assertTrue(Solution.isAnagram("Hello", "hello"));
        Assert.assertFalse(Solution.isAnagram("anagramm", "marganaa"));
    }
}