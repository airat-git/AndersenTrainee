import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javatrainee.study.mycollections.mydeque.MyArrayDeque;

import java.util.ArrayDeque;
/**
 * Тест, предназаченный для тестрования MyArrayDeque, путем сравнения результов вызова
 * его методов с резлультатами вызова методов оригинального ArrayDeque
 */
public class MyArrayDequeTest {

    MyArrayDeque<String> myArrayDeque = new MyArrayDeque<>();
    ArrayDeque<String> arrayDequeForCheck = new ArrayDeque<>();
    String [] params = new String[]{"Element One","Element Two","Element Three","Element Four", "Element Five"};

    @BeforeEach
    public void beforeEach(){
        for(String param : params){
            myArrayDeque.add(param);
            arrayDequeForCheck.add(param);
        }
    }

    @Test
    public void toStringCompareTest(){
        Assertions.assertEquals(arrayDequeForCheck.toString(),myArrayDeque.toString(),"Неверное отображение" +
                " MyArrayDeque!");
    }

    @Test
    public void addElementTest(){
        Assertions.assertEquals(arrayDequeForCheck.add("Element Six"),myArrayDeque.add("Element Six"),
                "Элемент 'Element Six" + "' в MyArrayDeque не был добавлен!");
        sizeTestAfterAdd("Element Six");
    }

    @Test
    public void offerElementTest(){
        Assertions.assertEquals(arrayDequeForCheck.offer("Element Six"),myArrayDeque.offer("Element Six"),
                "Элемент 'Element Six" + "' в MyArrayDeque не был добавлен!");
        sizeTestAfterAdd("Element Six");
    }

    @Test
    public void peekTest(){
        Assertions.assertEquals(arrayDequeForCheck.peek(),myArrayDeque.peek(),"Первые элементы не совпадают!");
    }

    @Test
    public void peekLastTest(){
        Assertions.assertEquals(arrayDequeForCheck.peekLast(),myArrayDeque.peekLast(),"Последние элементы не совпадают!");
    }

    @Test
    public void addFirstTest(){
        String newFirst = "New First";
        arrayDequeForCheck.addFirst(newFirst);
        myArrayDeque.addFirst(newFirst);
        Assertions.assertEquals(arrayDequeForCheck.peek(),myArrayDeque.peek(),"Первые элементы не совпадают!");
        sizeTestAfterAdd(newFirst);
    }

    @Test
    public void pollTest(){
        Assertions.assertEquals(arrayDequeForCheck.poll(),myArrayDeque.poll(),"Элемент не был удален!");
        sizeTestAfterRemoveByIndex(0);
    }

    @Test
    public void sequentialPollTest(){
        elementsAdd();
        for(int i = 0; i < 3;i++){
            Assertions.assertEquals(arrayDequeForCheck.poll(),myArrayDeque.poll(),"Элемент не был удален!");
        }
        sizeTestAfterRemoveByIndex(0);
    }

    public void sizeTestAfterAdd(Object object){
        Assertions.assertEquals(arrayDequeForCheck.size(), myArrayDeque.size(),"Проблема с размером " +
                "MyArrayDeque после добавления элемента: '" + object + "'!");
    }

    public void sizeTestAfterRemoveByIndex(int index){
        Assertions.assertEquals(arrayDequeForCheck.size(), myArrayDeque.size(),"Проблема с размером " +
                "MyArrayDeque после удаления элемента по индексу: '" + index + "'!");
    }

    public void elementsAdd(){
        arrayDequeForCheck.add("Element Six");
        arrayDequeForCheck.add("Element Seven");
        arrayDequeForCheck.add("Element Eight");

        myArrayDeque.add("Element Six");
        myArrayDeque.add("Element Seven");
        myArrayDeque.add("Element Eight");
    }
}
