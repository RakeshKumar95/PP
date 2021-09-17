package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Codeforces https://codeforces.com/problemset/problem/855/B#</a>
 * Professor Dumbledore is helping Harry destroy the Horcruxes. He went to Gaunt Shack as he suspected a
 * Horcrux to be present there.
 * He saw Marvolo Gaunt's Ring and identified it as a Horcrux. Although he destroyed it,
 * he is still affected by its curse.
 * Professor Snape is helping Dumbledore remove the curse. For this, he wants to give Dumbledore exactly x
 * drops of the potion he made.
 *
 * Value of x is calculated as maximum of p·a[i]+q·a[j]+r·a[k] for given p,q,r and array a[1],a[2],.. such
 * that 1≤i≤j≤k≤n. Help Snape find the value of x. Do note that the value of x may be negative.
 */
public class MarvoloRing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Size of array
        String[] firstLine = br.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0].trim());
        long p = Long.parseLong(firstLine[1].trim());
        long q = Long.parseLong(firstLine[2].trim());
        long r = Long.parseLong(firstLine[3].trim());

        String[] secondLine = br.readLine().split(" ");

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(secondLine[i].trim());
        }
        // Input ends here

        String maxValue = getMaxValue(arr, p, q, r);
        System.out.println(maxValue);

    }

    private static String getMaxValue(long[] arr, long p, long q, long r) {

        BigInteger[] pMaxArr = getPrefixMax(arr, p);
        BigInteger[] sMaxArr = getSuffixMax(arr, r);

        BigInteger maxValue = null;
        for (int i = 0; i < arr.length; i++) {
            BigInteger temp = pMaxArr[i].add(BigInteger.valueOf(q * arr[i])).add(sMaxArr[i]);
            if (null == maxValue) {
                maxValue = temp;
            } else {
                maxValue = maxValue.max(temp);
            }
        }
        return (null == maxValue) ? "" : maxValue.toString();
    }

    private static BigInteger[] getPrefixMax(long[] arr, long multiplier) {
        // Creating prefix max for the array
        BigInteger[] pMax = new BigInteger[arr.length];
        pMax[0] = BigInteger.valueOf(multiplier).multiply(BigInteger.valueOf(arr[0]));

        for (int i = 1; i < arr.length; i++) {
            BigInteger temp =  BigInteger.valueOf(multiplier).multiply(BigInteger.valueOf(arr[i]));
            pMax[i] = new BigInteger(temp+"").max(pMax[i-1]);
        }
        return pMax;
    }

    private static BigInteger[] getSuffixMax(long[] arr, long multiplier) {
        // Creating suffix max for the array
        BigInteger[] sMax = new BigInteger[arr.length];
        sMax[arr.length - 1] = BigInteger.valueOf(multiplier).multiply(BigInteger.valueOf(arr[arr.length-1]));

        for (int i = arr.length - 2; i >= 0; i--) {
            BigInteger temp = BigInteger.valueOf(multiplier).multiply(BigInteger.valueOf(arr[i]));
            sMax[i] = new BigInteger(temp+"").max(sMax[i+1]);
        }
        return sMax;
    }



}
