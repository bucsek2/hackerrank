package hu.bucsek2.algorithms.implementation.between_two_sets;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int f = lcm(a);
        int l = gcd(b);

        int count = 0;
        for (int i = f, j = 2; i <= l; i = f * j, j++) {
            if (l % i == 0) {
                count++;
            }
        }

        return count;
    }

    private static int lcm(List<Integer> inputs) {
        int result = inputs.get(0);
        for (int input : inputs) {
            result = lcm(result, input);
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private static int gcd(List<Integer> inputs) {
        int result = inputs.get(0);
        for (int input : inputs) {
            result = gcd(result, input);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
