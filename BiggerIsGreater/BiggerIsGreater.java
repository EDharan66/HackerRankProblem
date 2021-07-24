import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result7 {

    /**
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String s) {
        // Write your code here
        char[] stringList = s.toCharArray();
        int i = stringList.length - 2;
        String st = "";
        System.out.println("s = " + s);
        for (; i >= 0; i--) {

            if ((int) stringList[i] < (int) stringList[i + 1]) {
                int j = stringList.length-1;
                while (stringList[i]>=stringList[j]){
                    j--;
                }
                char temp = stringList[i];
                stringList[i] = stringList[j];
                stringList[j] = temp;

                st = String.valueOf(Arrays.copyOfRange(stringList,0,i+1))+
                        new StringBuilder(String.valueOf(Arrays.copyOfRange(stringList,i+1,stringList.length))).reverse().toString();
                break;
            }

        }

        if(i<0){
            return "no answer";
        }else {
            return String.join("", st);
        }
    }

}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result7.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
