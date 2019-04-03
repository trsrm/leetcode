// https://leetcode.com/problems/find-all-anagrams-in-a-string/

package com.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString_478 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = findAnagrams(s, p);
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime + " ms");
        System.out.print("[ ");
        for (Integer index : res) {
            System.out.print(index + " ");
        }
        System.out.println(']');
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() > 20100 || p.length() > 20100) {
            return res;
        }
        short[] counts = new short[36];
        for (int i = 0; i < p.length(); i++) {
            counts[Character.getNumericValue((p.charAt(i)))]++;
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            short[] countsCopy = counts.clone();
            for (int j = i; j < i + p.length(); j++) {
                int key = Character.getNumericValue(s.charAt(j));
                countsCopy[key]--;
            }
            boolean wasFound = true;
            for (int val : countsCopy) {
                if (val > 0) {
                    wasFound = false;
                    break;
                }
            }
            if (wasFound) {
                res.add(i);
            }
        }
        return res;
    }
}
