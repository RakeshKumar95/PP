package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxChunks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Size of array
        int n = Integer.parseInt(br.readLine().trim());

        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i].trim());
        }
        // Input ends here

        int maxValue = maxChunksToSorted(arr);
        System.out.println(maxValue);
    }

    public static int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] == 0) {
                    maxChunks++;
                }
                continue;
            }

            arr[i] = Math.max(arr[i-1], arr[i]);
            if (arr[i] == i) {
                maxChunks++;
            }
        }
        return maxChunks;
    }
}
