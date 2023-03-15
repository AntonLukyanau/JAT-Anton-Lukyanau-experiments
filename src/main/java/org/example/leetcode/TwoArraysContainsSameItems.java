package org.example.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoArraysContainsSameItems {
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {1,2,2,2,2,2,3,4};
        System.out.println(isContainsSame(arr1, arr2));
    }

    private static boolean isContainsSame(Integer[] arr1, Integer[] arr2) {
        Set<Integer> items1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> items2 = new HashSet<>(Arrays.asList(arr2));
        if (items1.size() != items2.size()) {
            return false;
        }
        items1.removeAll(items2);
        return items1.size() == 0;
    }
}
