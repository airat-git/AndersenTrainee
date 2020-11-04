package ru.javatrainee.study.algorithms.sort;

/**
 * Сортировка пузырьком - сортировка путем сравнения двух элементов, при котором наибольший элемент сдвигается вправо
 * Перебор начинаеися с крайнего левого элемента
 * Наибольший элемент сдвигается направо до тех пор, пока он не окажется в самом конца (внутренний цикл),
 * затем начинается повторный перебор (внешний цикл), пока все наибольшие элементы не окажутся справа
 */
public class BubbleSortAlgorithm extends SortAlgorithm {

    public void sort() {
        for (int i = array.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    simpleSwap(j,j+1);
                }
                countOfRuns++;
            }
        }
        displayResult();
    }

    @Override
    protected void displayName() {
        System.out.println("______________BubbleSort______________");
    }
}
