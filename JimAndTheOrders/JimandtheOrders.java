import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result11 {

    /**
     * Complete the 'jimOrders' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY orders as parameter.
     */

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        // Write your code here

        Map<Integer, List<Integer>> listMap = new TreeMap<Integer, List<Integer>>();
        List<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < orders.size(); i++) {
            List<Integer> list = new ArrayList<>();
            int sum = (orders.get(i).get(0) + orders.get(i).get(1));
            if (listMap.containsKey(sum)) {
                list = listMap.get(sum);
                list.add(i + 1);
            } else {
                list.add(i + 1);
            }


            listMap.put(sum, list);
        }

        for (List<Integer> x : listMap.values()) {
            for (Integer y : x) {

                resultList.add(Integer.valueOf(y));
            }
        }

        return resultList;
    }

}

public class JimandtheOrders {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> orders = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                orders.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result11.jimOrders(orders);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
