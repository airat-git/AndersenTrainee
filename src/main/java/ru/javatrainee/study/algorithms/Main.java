package ru.javatrainee.study.algorithms;

import ru.javatrainee.study.algorithms.sort.*;

public class Main {

    public static void main(String[] args) {

        new BubbleSortAlgorithm().setFullReverseArray().sort();
        new InsertionSortAlgorithm().setFullReverseArray().sort();
        new SelectSortAlgorithm().setFullReverseArray().sort();
        new ShellSortAlgorithm().setFullReverseArray().sort();
        new ShuttleSortAlgorithm().setFullReverseArray().sort();

    }
}
