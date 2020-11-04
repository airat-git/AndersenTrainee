package ru.javatrainee.study.algorithms.sort;

import java.util.Arrays;

public abstract class SortAlgorithm {

    protected int[] array = new int[2];
    protected int countOfSwaps = 0;
    protected int countOfRuns = 0;

    protected void simpleSwap(int first, int second){
        int save = array[first];
        array[first] = array[second];
        array[second] = save;
        countOfSwaps++;
    }

    public abstract void sort();

    protected void displayResult(){
        displayName();
        System.out.println("Количество перестановок: " + countOfSwaps);
        System.out.println("Количество проходов: " + countOfRuns);
        System.out.println(Arrays.toString(array));
        System.out.println("______________________________________");
    }

    protected abstract void displayName();

    public SortAlgorithm setCustomArray(int[] customArray){
        array = customArray;
        return this;
    }

    public SortAlgorithm setFullReverseArray(){
        array = new int[]{10,9,8,7,6,5,4,3,2,1};
        return this;
    }

    public SortAlgorithm setHalfReverseArray(){
        array = new int[]{1,2,3,4,5,10,9,8,7};
        return this;
    }

    public SortAlgorithm setSortedArray(){
        array = new int[]{1,2,3,4,5,10,9,8,7};
        return this;
    }
}
