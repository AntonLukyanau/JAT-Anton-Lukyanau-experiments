package org.example.java17;

import java.util.Random;

public class SwitchMain {
    public static void main(String[] args) {
        int a = new Random().nextInt(5);
        String res = switch (a) {
            case 1 -> "first";
            case 2, 3 -> "almost win";
            default -> "you are lose";
        };
    }
}
