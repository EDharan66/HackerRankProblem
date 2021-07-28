import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result13 {

    /**
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int upperMatrixSize = matrix.size() / 2;
        int[][] upperMatrix = new int[upperMatrixSize][upperMatrixSize];
        int sum = 0;


        for (int i = 0; i < upperMatrixSize; i++) {

            for (int j = 0; j < upperMatrixSize; j++) {
                upperMatrix[i][j] = Math.max(
                        ( Math.max(matrix.get(i).get(j), matrix.get(i).get(matrix.size() - 1 - j)) ),
                        ( Math.max(matrix.get(matrix.size() - 1 - i).get(j), matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j)) )
                );
            }
        }

        for (int i = 0; i < upperMatrixSize; i++) {

            int finalI = i;
            sum = sum + Arrays.stream(upperMatrix).mapToInt(x->x[finalI]).sum();
        }

        return sum;
    }

}

public class FlippingtheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result13.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
