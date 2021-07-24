import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result5 {

    /**
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> asList) {
        // Write your code here
        long[] container = new long[asList.size()];
        long[] convertedBall = new long[asList.size()];
        for (int i = 0; i < asList.size(); i++) {
            long tempContainerSum = 0;
            long tempBall = 0;
            for (int j = 0; j < asList.get(i).size(); j++) {
                tempContainerSum = tempContainerSum + asList.get(i).get(j);
                tempBall = tempBall + asList.get(j).get(i);
            }
            convertedBall[i] = tempBall;
            container[i] = tempContainerSum;
        }

        Arrays.sort(container);
        Arrays.sort(convertedBall);


        if (Arrays.equals(container, convertedBall)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

}

public class OrganizingContainersOfBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result5.organizingContainers(container);

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
