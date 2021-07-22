import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result1 {

    /**
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger fact = new BigInteger("1");
        for (int j = n; j > 0; j--) {
            fact = fact.multiply(BigInteger.valueOf(j));

        }
        System.out.println(fact);

    }
}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result1.extraLongFactorials(n);

        bufferedReader.close();
    }
}
