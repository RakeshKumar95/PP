package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i].trim());
        }

        int k = Integer.parseInt(br.readLine());
        // Input ends here

        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        if (k == 0) return;

        reverse(0, (nums.length - 1) - k, nums);
        reverse(nums.length-k, nums.length-1, nums);
        reverse(0, nums.length-1, nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
