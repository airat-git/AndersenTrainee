package ru.javatrainee.study.patterns.behavioral.strategy;

import java.util.Arrays;

public class SelectSort implements Sortable{

    @Override
    public void sort(int[] arr) {
        System.out.println("До сортровки выборкой " + Arrays.toString(arr));
        for (int i = 0; i < arr.length;i++){
            for (int j = i+1; j < arr.length;j++){
                if (arr[i] > arr[j]){
                    int min = arr[i];
                    arr[i] = arr[j];
                    arr[j] = min;

                }
            }
        }
        System.out.println("После сортровки выборкой " + Arrays.toString(arr));
    }
}
