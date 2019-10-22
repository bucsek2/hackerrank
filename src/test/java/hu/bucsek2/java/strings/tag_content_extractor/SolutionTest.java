package hu.bucsek2.java.strings.tag_content_extractor;

import hu.bucsek2.TestBase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    private static final Runnable testRun = () -> Solution.main(null);

    @Override
    protected Runnable mainRunnable() {
        return testRun;
    }

    @Test
    public void test0() {
        String in = "4\n" +
                "<h1>Nayeem loves counseling</h1>\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\n" +
                "<Amee>safat codes like a ninja</amee>\n" +
                "<SA premium>Imtiaz has a secret crush</SA premium>";
        String expected = "Nayeem loves counseling\n" +
                "Sanjay has no watch\n" +
                "So wait for a while\n" +
                "None\n" +
                "Imtiaz has a secret crush\n";
        test(in, expected, testRun);
    }

    @Test
    public void test1() {
        String in = "10\n" +
                "<h1>some</h1>\n" +
                "<h1>had<h1>public</h1></h1>\n" +
                "<h1>had<h1>public</h1515></h1>\n" +
                "<h1><h1></h1></h1>\n" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
                "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>\n" +
                "<>hello</>\n" +
                "<>hello</><h>dim</h>\n" +
                "<>hello</><h>dim</h>>>>>";
        String expected = "some\n" +
                "public\n" +
                "None\n" +
                "None\n" +
                "None\n" +
                "None\n" +
                "None\n" +
                "None\n" +
                "dim\n" +
                "dim\n";

        test(in, expected, testRun);
    }

    @Test
    public void test2_1() {
        String in = "1\n" +
                "qqoNVOmJDG@6IBDZoEmk9337LswEL&TQnLCuR`04XD%1t{G)Jmi_iNEXKwp&<iBKMbDGtF4v@coLsF1_LqgTJ3cSp& 3a~I&Q(j0h_w~Vk(oBZCL#vhYY9%c><wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF</wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>haZQKlWPxlRqXXkKHo=FDofc6$_S-GWA&m0zT*D~uorf_nAF^ym*U&6hGAI)s<XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><FbTSC#F104{py9Xl6s{yi-R~}k5Fv4i1kCgmBY7P=vVj-j48xUg8x9BCxl~Y><lyxRRMqnMBGj1_d7Qqh5Ebn7 aMb{Q0Dm){9~I0DTS8BZ7+bui~)rQ\"2Yb4f>EeZWvJvHIk</XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><BkkZV631Pnj}#%TWhZn@Y><kXjDpTvLA^tnXYb`h+cA J2";
        String expected = "bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF\n";

        test(in, expected, testRun);
    }

    @Test
    @Ignore
    public void test2() {
        String in = readResource("test2.in");
        String expected = readResource("test2.expected") + "\n";

        test(in, expected, testRun);
    }
}