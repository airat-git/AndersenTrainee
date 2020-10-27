package ru.javatrainee.study.patterns.behavioral.strategy;

import java.util.Arrays;

public class BubbleSort implements Sortable{

    @Override
    public void sort(int[] arr) {
        System.out.println("До сортровки пузырьком " + Arrays.toString(arr));
        for (int j = arr.length-1; j >=0; j--){
            for (int i = 0; i < j;i++){
                if (arr[i] > arr[i+1]){
                    int save = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = save;
                }
            }
        }
        System.out.println("После сортировки пузырьком " + Arrays.toString(arr));
    }
}
