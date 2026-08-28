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

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
    int maxSubarraySum = arr.get(0);
        int currentSubarraySum = arr.get(0);

        // 2. Calculate Maximum Subsequence Sum
        int maxElem = arr.get(0);
        int maxSubsequenceSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);

            // Kadane's update logic
            if (i > 0) {
                currentSubarraySum = Math.max(num, currentSubarraySum + num);
                maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
            }

            // Track overall maximum element in case all numbers are negative
            maxElem = Math.max(maxElem, num);

            // Sum up only positive numbers for subsequence
            if (num > 0) {
                maxSubsequenceSum += num;
            }
        }

        // If all numbers are negative, subsequence sum should be the largest negative element
        if (maxElem < 0) {
            maxSubsequenceSum = maxElem;
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
