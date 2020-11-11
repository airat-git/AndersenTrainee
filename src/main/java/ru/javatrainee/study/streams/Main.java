package ru.javatrainee.study.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = Stream.iterate(1, n -> n = n + 1)
                .limit(40)
                .collect(Collectors.toList());
        log.info("Создание списка стримом путем итерации до 40: {}", integerList);
        log.info("filter() - все нечетные числа: {}",integerList.stream().
                filter(n -> n%2!= 0).collect(Collectors.toList()));
        log.info("map() - все нечетные числа были множены на 3: {}",integerList.stream().filter(n -> n % 2 != 0)
                .map(n -> n * 3).collect(Collectors.toList()));
        int [][] array = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
        int [] array2 = Arrays.stream(array).flatMapToInt(Arrays::stream).toArray();
        log.info("flatMap() - преобразование двумерного массива чисел в одномерный: {}", Arrays.toString(array2));
        log.info("peek() - просмотр всех чисел списка от 1 до 10:");
        integerList.stream().limit(10).
                peek(n -> log.debug("Число: {}",n)).collect(Collectors.toList());
        log.info("findFirst() - первый элемент списка: {}", integerList.stream().findFirst().get());
        log.info("findAny() - любой элемент списка: {}", integerList.stream().findAny().get());

        Map <Integer,Integer> integerMap = Arrays.stream(array).collect(Collectors.
                toMap(n -> n[0], n -> n[1]));
        log.info("collect(Collectors.toMap()) - преобразование двумерного массива в мапу: {}", integerMap);
        Set <Integer> integerSet = integerList.stream().collect(Collectors.toSet());
        log.info("collect(Collectors.toSet()) - преобразование списка в сет: {}", integerSet);

        log.info("collect(Collectors.groupingBy()) - группировка моделей телефонов по изготовителям:");
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone X", "Apple", 600),
                new Phone("5610", "Nokia", 50),
                new Phone("iPhone 8", "Apple",450),
                new Phone("Galaxy S9", "Samsung", 440),
                new Phone("Galaxy S8", "Samsung", 340));

        Map<String, List<Phone>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone::getCompany));

        for(Map.Entry<String, List<Phone>> item : phonesByCompany.entrySet()){
            log.info("Изготовитель: {}",item.getKey());
            for(Phone phone : item.getValue()){
                log.info("Модель: {}",phone.getName());
            }
            log.info("---------");
        }
        log.info("forEach() - все нечетные числа листа выводятся на экран:");
        integerList.stream().filter(n -> n % 2 != 0)
                .forEach(n -> log.debug(String.valueOf(n)));
    }
}
