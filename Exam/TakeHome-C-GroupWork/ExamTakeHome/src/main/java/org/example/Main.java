package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> initialFeelings = new ArrayList<>(Arrays.asList(-1, -1, 0, 0, 1, 1, -1, 1, 0, -1, 1, 0, 1, 1, -1, 0, 1, -1));
        List<Integer> transformedFeelings = beHappy(initialFeelings);
        System.out.println(transformedFeelings);
    }

    public static int findSadFeeling(List<Integer> feelings, Integer startingPosition) {
        if (startingPosition < 0 || startingPosition >= feelings.size()) {
            return -1;
        }
        var index = -1;
        for (int i = 0; i < feelings.size(); i++) {
            if (feelings.get(i) > 1 || feelings.get(i) < -1) {
                return -1;
            }
            if (index != -1) {
                continue;
            }
            if (feelings.get(i) == -1 && i >= startingPosition) {
                index = i;
            }
        }
        return index;
    }

    public static Boolean checkNeighbours(List<Integer> feelings, Integer position) {
        if (position < 0 || position >= feelings.size()) {
            return false;
        }
        if (feelings.get(position) != -1) {
            return false;
        }
        if (position == 0) {
            return true;
        }
        if (position + 1 >= feelings.size()) {
            return true;
        }
        if (feelings.get(position - 1) != 1 || feelings.get(position + 1) != 1) {
            return true;
        }
        return false;
    }

    public static void insertHappyFeelings(List<Integer> feelings, Integer position) {
        if (position < 0 || position >= feelings.size()) {
            return;
        }
        if (feelings.get(position) == -1) {
            if (position + 1 < feelings.size()) {
                if (feelings.get(position + 1) != 1) {
                    feelings.add(position + 1, 1);
                }
            } else {
                feelings.add(feelings.size(), 1);
            }
            if (position == 0) {
                feelings.add(position, 1);
            } else if (feelings.get(position - 1) != 1) {
                feelings.add(position, 1);
            }
        }
    }

    public static List<Integer> beHappy(List<Integer> feelings) {
        int position = findSadFeeling(feelings, 0);
        while (position != -1) {
            if (checkNeighbours(feelings, position)) {
                insertHappyFeelings(feelings, position);
            }
            position = findSadFeeling(feelings, position + 2);
        }
        return feelings;
    }
}