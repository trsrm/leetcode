/*
    Problem: https://leetcode.com/problems/pascals-triangle/
        Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

    Input: 5

    Output: [
                 [1],
                [1,1],
               [1,2,1],
              [1,3,3,1],
             [1,4,6,4,1]
            ]

    Notes:
        1. Make empty rows and put "1" to the each of them.
        2. Start filling the triangle from the bottom:
            - Get the numbers recursively "f(x,y) = f(x-1, y-1) + f(x-1, y + 1)";
            - Exit from recursion if "x=0" or "y=0" or "y=x";
        3. Optimizations:
            - Push numbers to the triangle immediately and try to use existing numbers
              to not calculate them multiple times;
            - The rows are symmetrical, so just mirror them if they are filled to the half;
 */

package com.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(0);
        printOutput(triangle);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        if (numRows <= 0) {
            return triangle;
        }
        makeRows(triangle, numRows);
        return fill(triangle);
    }

    private static void makeRows(List<List<Integer>> triangle, int numRows) {
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(triangle.size() + 1);
            row.add(1);
            triangle.add(row);
        }
    }

    private static List<List<Integer>> fill(List<List<Integer>> triangle) {
        for (int i = 0; i <= triangle.size() / 2; i++) {
            getNumber(triangle.size() - 1, i, triangle);
        }
        return triangle;
    }

    private static int getNumber(int x, int y, List<List<Integer>> triangle) {
        int number = getExistingNumber(x, y, triangle);
        if (number > 0) {
            return number;
        }
        if (x == 0 || y == 0 || y == x) {
            number = 1;
        } else {
            number = getNumber(x - 1, y - 1, triangle) + getNumber(x - 1, y, triangle);
        }
        pushToTriangle(number, x, triangle);
        return number;
    }

    private static int getExistingNumber(int x, int y, List<List<Integer>> triangle) {
        List<Integer> row = triangle.get(x);
        return row.size() > y ? row.get(y) : 0;
    }

    private static void pushToTriangle(int number, int x, List<List<Integer>> triangle) {
        List<Integer> row = triangle.get(x);
        row.add(number);
        if (x == 2) {
            row.add(1);
        } else if (row.size() > x / 2 && row.size() < x + 1) {
            autoFillTheRow(row, x);
        }
    }

    private static void autoFillTheRow(List<Integer> row, int x) {
        int middle = row.size() - 1;
        if (x % 2 == 0) {
            middle--;
        }
        for (int i = middle; i >= 0; i--) {
            row.add(row.get(i));
        }
    }

    private static void printOutput(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.print("\n");
        }
    }

}
