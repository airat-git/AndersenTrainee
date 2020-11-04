package ru.javatrainee.study.algorithms.sort;

/**
 * Сортировка методом вставки - сортировка, при котором происходит перемещение 'помеченного' элемента
 * с правой не отсортированной части на левую часть
 * Перебор начинаеися с крайнего левого элемента (внешний цикл), который 'помечается'
 * Далее идет перебор всех элементов, которые находятся до 'помеченного' элемента (внутренний цикл) до тех пор,
 * пока не найдется элемент меньше 'помеченного', при этом перемещая элемент на одну позицию вправо.
 * После того, как был найден элемент меньше 'помеченного',перед ним вставлеяется 'помеченный' элемент
 */
public class InsertionSortAlgorithm extends SortAlgorithm {

    public void sort() {
        for (int i = 0; i < array.length;i++){
            int element = array[i];
            int j = i - 1;

            for (; j >= 0; j--){
                if (element < array[j]){
                    array[j+1] = array[j];
                    countOfSwaps++;
                }
                else {
                    break;
                }
                countOfRuns++;
            }
            array[j+1] = element;
        }
        displayResult();
    }

    @Override
    protected void displayName() {
        System.out.println("_____________InsertionSort____________");
    }
}
