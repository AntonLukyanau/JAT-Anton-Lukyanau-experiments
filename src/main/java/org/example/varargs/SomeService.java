package org.example.varargs;

public class SomeService {

    public static void method2(int... nums) {
        System.out.println("That is VARARGS");
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void method(int... nums) {
        System.out.println("That is VARARGS");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void method(int[] nums, int additionalNum) {
        System.out.println("That is ARRAY with additional num");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("additional num = " + additionalNum);
    }


}
