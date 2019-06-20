package hu.bucsek2.strings.java_regex_2_duplicate_words;

import hu.bucsek2.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DuplicateWordsTest extends TestBase {

    @Test
    public void test0() {
        String data = "5\n" +
                "Goodbye bye bye world world world\n" +
                "Sam went went to to to his business\n" +
                "Reya is is the the best player in eye eye game\n" +
                "in inthe\n" +
                "Hello hello Ab aB";

        setIn(data);
        DuplicateWords.main(null);

        String expected = "Goodbye bye world\n" +
                "Sam went to his business\n" +
                "Reya is the best player in eye game\n" +
                "in inthe\n" +
                "Hello Ab\n";

        String out = getOut();

        Assert.assertEquals(expected, out);
    }

    @Test
    public void test1() {
        String data= "5\n" +
                "tap taptap For fOr for forfor\n" +
                "taptap of kirethe the hte hTe hte\n" +
                "tim tamtim tam tam ta tam tam\n" +
                "a a a a a a a a a a a a a a a a\n" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        setIn(data);
        DuplicateWords.main(null);

        String expected = "tap taptap For forfor\n" +
                "taptap of kirethe the hte\n" +
                "tim tamtim tam ta tam\n" +
                "a\n" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n";

        String out = getOut();

        Assert.assertEquals(expected,out);
    }
}