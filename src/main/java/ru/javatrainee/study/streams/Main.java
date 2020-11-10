package ru.javatrainee.study.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Создание списка стримом путем итерации до 40:");
        List<Integer> integerList = Stream.iterate(1, n -> n = n + 1)
                .limit(40)
                .collect(Collectors.toList());
        System.out.println(integerList);

        System.out.println("filter() - все нечетные числа:\n" + integerList.stream().
                filter(n -> n%2!= 0).collect(Collectors.toList()));

        System.out.println("map() - все нечетные числа были множены на 3:\n" + integerList.stream().filter(n -> n%2!= 0)
                .map(n -> n*3).collect(Collectors.toList()));

        int [][] array = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
        System.out.println("flatMap() - преобразование двумерного массива чисел в одномерный:");
        int [] array2 = Arrays.stream(array)
                .flatMapToInt(Arrays::stream).toArray();
        System.out.println(Arrays.toString(array2));

        System.out.println("peek() - просмотр всех чисел списка от 1 до 10:");
        integerList.stream().limit(10).
                peek(n -> System.out.println("Число: " + n)).collect(Collectors.toList());

        System.out.println("findFirst() - первый элемент списка:\n" + integerList.stream().findFirst().get());

        System.out.println("findAny() - любой элемент списка:\n" + integerList.stream().findAny().get());

        System.out.println("collect(Collectors.toMap()) - преобразование двумерного массива в мапу:");
        Map <Integer,Integer> integerMap = Arrays.stream(array).collect(Collectors.
                toMap(n -> n[0], n -> n[1]));
        System.out.println(integerMap);

        System.out.println("collect(Collectors.toSet()) - преобразование списка в сет:\n" +
                integerList.stream().collect(Collectors.
                toSet()));

        System.out.println("collect(Collectors.groupingBy()) - группировка моделей телефонов по изготовителям:\n");
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone X", "Apple", 600),
                new Phone("5610", "Nokia", 50),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany));

        for(Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()){
            System.out.println(item.getKey());
            for(Phone phone : item.getValue()){
                System.out.println(phone.getName());
            }
            System.out.println("---------");
        }

        System.out.println("forEach() - все нечетные числа листа выводятся на экран:");
        integerList.stream().filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }
}
