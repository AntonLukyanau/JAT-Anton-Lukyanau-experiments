package org.example.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Solution {
    public long distinctNames(String[] ideas) {
        SortedSet<String> sortedIdeas = new TreeSet<>(Arrays.asList(ideas));
        Set<Thread> threads = new HashSet<>();
        for (String ideaA : sortedIdeas) {
            Thread thread = new Thread(new PairsGenerator(ideaA, sortedIdeas));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return pairSet.size();

    }

    private class PairsGenerator implements Runnable {
        private String ideaA;
        private SortedSet<String> ideas;

        public PairsGenerator(String ideaA, SortedSet<String> ideas) {
            this.ideaA = ideaA;
            this.ideas = ideas;
        }

        @Override
        public void run() {
            for (String ideaB : ideas) {
                if (!ideaA.equals(ideaB)) {
                    String swappedIdeaA = ideaB.charAt(0) + ideaA.substring(1);
                    String swappedIdeaB = ideaA.charAt(0) + ideaB.substring(1);
                    if (!(ideas.contains(swappedIdeaA) || ideas.contains(swappedIdeaB))) {
                        pairSet.add(swappedIdeaA + " " + swappedIdeaB);
                    }
                }
            }
        }
    }

    private final Set<String> pairSet = new ConcurrentSkipListSet<>();

    private Map<String, String> pairs = new ConcurrentHashMap<>();

    private static class IdeaPair {
        private final String ideaA;
        private final String ideaB;

        public IdeaPair(String ideaA, String ideaB) {
            String swappedIdeaA = ideaB.charAt(0) + ideaA.substring(1);
            String swappedIdeaB = ideaA.charAt(0) + ideaB.substring(1);
            this.ideaA = swappedIdeaA;
            this.ideaB = swappedIdeaB;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IdeaPair ideaPair)) return false;
            return Objects.equals(ideaA, ideaPair.ideaA) && Objects.equals(ideaB, ideaPair.ideaB);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ideaA, ideaB);
        }

        public String getIdeaA() {
            return ideaA;
        }

        public String getIdeaB() {
            return ideaB;
        }
    }
    //        return distinctIdeas.parallelStream()
//                .flatMap(ideaA ->
//                        distinctIdeas.parallelStream()
//                                .filter(ideaB -> !ideaB.equals(ideaA))
//                                .map(ideaB -> new IdeaPair(ideaA, ideaB)))
//                .filter(pair -> !distinctIdeas.contains(pair.getIdeaA()) && !distinctIdeas.contains(pair.getIdeaB()))
//                .map(pair -> pair.getIdeaA() + " " + pair.getIdeaB())
//                .distinct()
//                .count();
}
