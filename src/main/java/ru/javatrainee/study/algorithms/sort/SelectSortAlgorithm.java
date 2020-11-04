package ru.javatrainee.study.algorithms.sort;

/**
 * Сортировка методом выбора - сортировка, при котором наименьший элемент сдвигается влево
 * Перебор начинаеися с крайнего левого элемента
 * Сначала в качестве наименьшего элемента - 'маркера', выбирается первый элемент по индексу '0' внешнего цикла
 * Затем во внутреннем цикле идет поиск наименьшего элемента путем сравнения первоначального наименьшего элемента
 * Если такой элемент найден, то он записывается в качестве 'маркера'. Затем идет замена элемента внешнего
 * новым наименьшим элементом, пока все наименьшие элементы не окажутся слева
 */
public class SelectSortAlgorithm extends SortAlgorithm {

    public void sort() {
        for (int i = 0; i < array.length; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
                countOfRuns++;
            }
            simpleSwap(i,min);
        }
        displayResult();
    }

    @Override
    protected void displayName() {
        System.out.println("______________SelectedSort____________");
    }
}
