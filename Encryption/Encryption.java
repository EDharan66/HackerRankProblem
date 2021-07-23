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

class Result6 {

    /**
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here

        int rowString = (int) Math.floor(Math.sqrt(s.length()));
        int columnString = (int) Math.ceil(Math.sqrt(s.length()));
        String encryptedStr = "";

        for (int i = 0; i < columnString; i++) {

            if(rowString!=columnString){
                for (int j = i; j < s.length(); j += rowString+1) {
                    encryptedStr += s.charAt(j);
                }
            }else {
                for (int j = i; j < s.length(); j += rowString) {
                    encryptedStr += s.charAt(j);
                }
            }
            encryptedStr += " ";
        }

        return encryptedStr;
    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result6.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
