package ru.javatrainee.study.funcint;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class Main {

    public static void main(String[] args) {

        Predicate<String> predicate = x -> x.equals("A");
        String s = "B";
        log.info("predicate - значение '{}' равно 'A': {}",s,predicate.test(s));

        UnaryOperator<Integer> unaryOperator = x -> x*x;
        int x = 5;
        log.info("unaryOperation - значение '{}' возводится во вторую степень: {}",x,unaryOperator.apply(x));

        Function <String,Integer> function = a -> Integer.parseInt(a) + x;
        String d = "2";
        log.info("function - строка '{}' переобразуется в число и увеличивается на {}: {}",d,x,function.apply(d));

        List<Integer> list = Stream.iterate(1,n -> n+=1)
                .limit(4)
                .collect(Collectors.toList());
        Consumer <List<Integer>> consumer = l -> l.add(x);
        consumer.accept(list);
        log.info("consumer - в список добавляется новый элемент '{}': {}",x,list);

        Supplier<String> supplier = () -> "new String from suppler";
        log.info("supplier - возвращает новую строку: {}",supplier.get());
    }
}
