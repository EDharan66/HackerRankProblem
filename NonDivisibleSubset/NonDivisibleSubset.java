import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int num, List<Integer> asList) {
        // Write your code here
        int[] sizeArr = new int[num];
        int result = 0;

        for (int x : asList) {
            sizeArr[x % num] = sizeArr[x % num] + 1;
        }
        result = Math.min(sizeArr[0], 1);
        for (int i = 1; i < (num / 2) + 1; i++) {
            if (i != num - i) {
                result = result + Math.max(sizeArr[i], sizeArr[num - i]);
            } else {
                result = result + Math.min(sizeArr[i], 1);
            }
        }
        return result;
    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
