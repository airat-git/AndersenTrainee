package ru.javatrainee.study.algorithms.sort;

/**
 * Сортировка челночнным способом - сортировка, при итерации которой происходит повторное
 * перемещение предыдущих элементов
 * Перебор начинаеися с второго левого элемента
 * В случае, если первый элемент меньше предыдущего, они меняются местами (внешний цикл)
 * Далее идет перебор всех предыдущих элементов (внутренний цикл), выполняя предыдущие условия перестановки
 */
public class ShuttleSortAlgorithm extends SortAlgorithm {

    public void sort() {
        for (int i = 1; i < array.length; i++){
            if (array[i] < array[i-1]){
                simpleSwap(i,i-1);
                for (int j = i-1; (j-1) >= 0; j-- ){
                    countOfRuns++;
                    if (array[j] < array[j-1]){
                        simpleSwap(j,j-1);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        displayResult();
    }

    @Override
    protected void displayName() {
        System.out.println("_____________ShuttleSort______________");
    }
}
