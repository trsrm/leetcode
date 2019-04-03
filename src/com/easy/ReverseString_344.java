// https://leetcode.com/problems/reverse-string/
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