/*
    Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
        Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
        Strings consists of lowercase English letters only.
        The length of both strings s and p will not be larger than 20100.
        The order of output does not matter.

    Input: s: "cbaebabacd" p: "abc"

    Output: [0, 6]

    Notes:
        1. Make the histogram of letters from "p":
            - Each char can be converted to number that can be used as index;
        2. Iterate through each char in "s":
            a) make a copy of the histogram
            b) check if the following substring uses all characters from the histogram
 */

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
