/*
    Problem: https://leetcode.com/problems/reverse-string/
        Write a function that reverses a string. The input string is given as an array of characters char[].
        Do not allocate extra space for another array.
        You must do this by modifying the input array in-place with O(1) extra memory.
        You may assume all the characters consist of printable ascii characters.

    Input: ["h","e","l","l","o"]

    Output: ["o","l","l","e","h"]
 */

package com.easy;

class ReverseString_344 {
    private static void reverseString(char[] s) {
        swap(s, 0, s.length - 1);
    }

    private static void swap(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        swap(s, ++left, --right);
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
    }
}