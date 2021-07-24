import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result9 {

    /**
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        // Write your code here
        List<String> stringList = new ArrayList<>(Arrays.asList(
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
                "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight",
                "twenty nine"));

        String timeInWord = "";



        if(m<=30){
            if(m==0){
                timeInWord = stringList.get(h)+" o\' clock";
            }else if(m==30){
                timeInWord = "half past " + stringList.get(h);
            }else if(m==15){
                timeInWord = "quarter past " + stringList.get(h) ;
            }else if(m<10){
                timeInWord = stringList.get(m)+" minute past "+stringList.get(h);
            }else{
                timeInWord = stringList.get(m)+" minutes past "+stringList.get(h);
            }
        }else {
            if(m==45){
                timeInWord = "quarter to " + stringList.get(h+1);
            }else {
                timeInWord = stringList.get(30-m%30)+" minutes to "+stringList.get(h+1);
            }
        }

        return timeInWord;
    }

}

public class TimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result9.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
