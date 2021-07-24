import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result8 {

    /**
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        int ifExist = 0;
        for (long i = p; i <= q; i++) {

            String st = String.valueOf(i*i);
            String leftPart = (st.length()==1)?"0":st.substring(0,st.length()/2);
            String rightPart = st.substring(st.length()/2);
            long sum = Integer.parseInt(leftPart.trim()) +
                    Integer.parseInt(rightPart.trim());

            if(sum == i){
                System.out.print(i+" ");
                ifExist=1;
            }

        }

        if(ifExist == 0){
            System.out.println("INVALID RANGE");
        }
    }

}

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result8.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
