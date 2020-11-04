package ru.javatrainee.study.polygon;

import ru.javatrainee.study.mymap.MyHashMap;

public class MyHashMapTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        MyHashMap<String, Integer> myMap = new MyHashMap<>();
        System.out.println("Моя мапа пуста");
        System.out.println(myMap);
        for (int i = 65; i <= 90; i++){
            myMap.put((char)i + "",i);
        }
        System.out.println("Моя мапа после добавления английского алфавита (буква = числовое значение):" );
        System.out.println(myMap);
        System.out.println("Размер мапы: " + myMap.size());
        for (int i = 65; i <= 90; i++){
            myMap.put((char)i + "",55);
        }
        System.out.println("Моя мапа после добавления английского алфавита (буква = число 55):" );
        System.out.println(myMap);
        for (int i = 65; i <= 90; i++){
            myMap.put((char)i + "",i);
        }
        System.out.println("Моя мапа после добавления английского алфавита (буква = числовое значение):" );
        System.out.println(myMap);
        System.out.println("Значение ключа 'F': " + myMap.get("F"));
        System.out.println("Моя мапа после удаления значения по ключу 'R' - " + myMap.remove("R"));
        System.out.println(myMap);
        System.out.println("Размер мапы: " + myMap.size());
    }
}
