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
        
        int maxSubsequenceSum = arr.get(0) > 0 ? arr.get(0) : 0;
        int maxElement = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int val = arr.get(i);
            
            // Kadane's Algorithm for contiguous subarray
            currentSubarraySum = Math.max(val, currentSubarraySum + val);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
            
            // Track overall maximum element in case all values are negative
            maxElement = Math.max(maxElement, val);
            
            // Sum positive numbers for subsequence
            if (val > 0) {
                maxSubsequenceSum += val;
            }
        }

        // Handle case where all elements are negative
        if (maxElement < 0) {
            maxSubsequenceSum = maxElement;
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