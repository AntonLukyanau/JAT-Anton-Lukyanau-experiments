package org.example.core;

public class BitOperators {

    public static void main(String... args) {
        byte byteVar1 = -127;//               1 111 1111 = 0 + 64 + 32 + 16 + 8 + 4 + 2 + 1 = 127
        int shiftedBytes = byteVar1 >> 1;// сдвиг на 3: 0 000 1111 = 0 + 0 + 0 + 0 + 8 + 4 + 2 + 1 = 15
        System.out.println(~-64);

        byte byteVar2 = -128;// 1111 1111 =
        int shiftedWithSignBit = byteVar2 >>> 1;
        System.out.println(shiftedWithSignBit);
    }

    public static class IntegerPool {
        public static void main(String[] args) {
            Integer first = 300;
            Integer second = 300;
            System.out.println(first == second);
        }
    }
}
