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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
  HashMap<Integer, Integer> map = new HashMap<>();
    for (int x : a) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    
    // contains distinct, sorted numbers
    List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());
    
    int maxCount = Collections.max(map.values());
    for (int i = 0, n = keys.size() - 1; i < n; i++)  {
        int curr = keys.get(i);
        int next = keys.get(i + 1);
        
        if (Math.abs(curr - next) <= 1) {
            int count = map.get(curr) + map.get(next);
            if (count > maxCount) {
                maxCount = count;
                }
            }
        }
        return maxCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
