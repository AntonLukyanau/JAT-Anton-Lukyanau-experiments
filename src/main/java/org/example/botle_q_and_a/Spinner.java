package org.example.botle_q_and_a;

import java.util.*;

public class Spinner {

    private static List<String> players = Arrays.asList(
            "Sergei Razuev",
            "Vadzim Kuzmenka",
            "Anton Lukyanau",
            "Yauheni Shadura",
            "Mikhail Kozyrev",
            "Mikhail Bouzdalkin",
            "Aliaksandra Zhuk",
            "Vitali Vikhliayeu"
            );

    public static void main(String[] args) {
        Collections.shuffle(players);
        Scanner scan = new Scanner(System.in);
        String timeIsOut = scan.nextLine();
        mark:
        while(!timeIsOut.contains("stop")) {
            for (int i = 0; i < players.size() - 1; i++) {
                System.out.printf("%s is asking a question to %s!", players.get(i), players.get(i + 1));
                timeIsOut = scan.nextLine();
                if (timeIsOut.contains("stop")) {
                    System.out.println("Have a good one!");
                    break mark;
                }
            }
            System.out.printf("%s is asking a question to %s!", players.get(players.size() - 1), players.get(0));
            timeIsOut = scan.nextLine();
        }

    }
}
