package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxTrappedWater {

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

        int maxValue = trap(arr);
        System.out.println(maxValue);
    }

    public static int trap(int[] height) {
        int[] pMax = getPrefixMax(height);
        int[] sMax = getSuffixMax(height);

        int trappedWater = 0;
        for (int i = 1; i < height.length-1; i++) {
            int decidingHeight = Math.min(pMax[i-1], sMax[i+1]);
            if (decidingHeight > height[i]) {
                trappedWater += (decidingHeight-height[i]);
            }
        }
        return trappedWater;
    }

    private static int[] getPrefixMax(int[] arr) {
        int[] pMax = new int[arr.length];
        pMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pMax[i] = Math.max(pMax[i-1], arr[i]);
        }
        return pMax;
    }

    private static int[] getSuffixMax(int[] arr) {
        int[] sMax = new int[arr.length];
        sMax[arr.length-1] = arr[arr.length-1];

        for (int i = arr.length-2; i >= 0; i--) {
            sMax[i] = Math.max(sMax[i+1], arr[i]);
        }
        return sMax;
    }


}
