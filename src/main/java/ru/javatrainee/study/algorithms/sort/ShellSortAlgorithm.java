package ru.javatrainee.study.algorithms.sort;

public class ShellSortAlgorithm extends SortAlgorithm {

    public void sort() {
        int gap = array.length / 2;
        while (gap >= 1){
            for (int i = 0; i < array.length;i++){
                for (int j = i - gap; j >= 0; j-=gap){
                    if (array[j] > array[j + gap]) {
                        simpleSwap(j, j + gap);
                    }
                    countOfRuns++;
                }
            }
            gap = gap/2;
        }
        displayResult();
    }

    @Override
    protected void displayName() {
        System.out.println("______________ShellSort_______________");
    }
}
