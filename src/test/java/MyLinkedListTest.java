import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javatrainee.study.mylist.MyLinkedList;

import java.util.LinkedList;

/**
 * Тест, предназаченный для тестрования MyLinkedList, путем сравнения результов вызова
 * его методов с резлультатами вызова методов оригинального LinkedList
 */
public class MyLinkedListTest {

    MyLinkedList <String> myLinkedList = new MyLinkedList<>();
    LinkedList<String> linkedListForCheck = new LinkedList<>();
    String [] params = new String[]{"Element One","Element Two","Element Three","Element Four", "Element Five"};

    @BeforeEach
    public void beforeEach(){
        for(String param : params){
            myLinkedList.add(param);
            linkedListForCheck.add(param);
        }
    }

    @Test
    public void toStringCompareTest(){
        Assertions.assertEquals(linkedListForCheck.toString(),myLinkedList.toString(),"Неверное отображение" +
                " MyLinkedList!");
    }

    @Test
    public void addElementTest(){
        Assertions.assertEquals(linkedListForCheck.add("Element Six"),myLinkedList.add("Element Six"),
                "Элемент 'Element Six" + "' в MyLinkedList не был добавлен!");
        sizeTestAfterAdd("Element Six");
    }

    @Test
    public void peekTest(){
        Assertions.assertEquals(linkedListForCheck.peek(),myLinkedList.peek(),"Первые элементы не совпадают!");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void getElementTest(int index){
        Assertions.assertEquals(linkedListForCheck.get(index),myLinkedList.get(index),
                "Элемент по индексу '" + index + "' не совпадают!");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void compareAfterAddTest(int index){
        elementsAdd();
        Assertions.assertEquals(linkedListForCheck.get(index),myLinkedList.get(index),
                "Элемент по индексу '" + index + "' не совпадают!");
    }

    @Test
    public void pollTest(){
        Assertions.assertEquals(linkedListForCheck.poll(),myLinkedList.poll(),"Элемент не был удален!");
        sizeTestAfterRemoveByIndex(0);
    }

    @Test
    public void removeByIndexFromHeadTest(){
        Assertions.assertEquals(linkedListForCheck.remove(0),myLinkedList.remove(0),
                "Элемент по индексу '0' не был удален!");
        sizeTestAfterRemoveByIndex(0);
    }

    @Test
    public void removeByIndexFromMiddleTest(){
        Assertions.assertEquals(linkedListForCheck.remove(2),myLinkedList.remove(2),
                "Элемент по индексу '2' не был удален!");
        sizeTestAfterRemoveByIndex(2);
    }

    @Test
    public void removeByIndexFromTaleTest(){
        Assertions.assertEquals(linkedListForCheck.remove(4),myLinkedList.remove(4),
                "Элемент по индексу '4' не был удален!");
        sizeTestAfterRemoveByIndex(4);
    }

    @Test
    public void compareAfterRemoveByIndexTest(){
        elementsRemove();
        Assertions.assertEquals(linkedListForCheck.get(0),myLinkedList.get(0),
                "Элемент по индексу '" + 0 + "' не совпадают!");
        Assertions.assertEquals(linkedListForCheck.get(1),linkedListForCheck.get(1),
                "Элемент по индексу '" + 1 + "' не совпадают!");
    }


    @Test
    public void removeByObjectFromHeadTest(){
        Assertions.assertEquals(linkedListForCheck.remove("Element One"),myLinkedList.remove("Element One"),
                "Элемент 'Element One' не был удален!");
        sizeTestAfterRemoveByObject("Element One");
    }

    @Test
    public void removeByObjectFromMiddleTest(){
        Assertions.assertEquals(linkedListForCheck.remove("Element Three"),myLinkedList.
                        remove("Element Three"), "Элемент 'Element Three' не был удален!");
        sizeTestAfterRemoveByObject("Element Three");
    }

    @Test
    public void removeByObjectFromTaleTest(){
        Assertions.assertEquals(linkedListForCheck.remove("Element Five"),myLinkedList.remove("Element Five"),
                "Элемент 'Element Five' не был удален!");
        sizeTestAfterRemoveByObject("Element Five");
    }

    @Test
    public void removeTest(){
        Assertions.assertEquals(linkedListForCheck.remove(),myLinkedList.remove(), "Первый элемент " +
                "MyLinkedList не был удален!");
        sizeTestAfterRemoveByIndex(0);
    }

    @Test
    public void sequentialRemoveByIndexTest(){
        elementsAdd();
        int len = 7;
        for (int i = 0; i < 3 ; i++){
            int randomIndex = (int) (Math.random() * len);
            Assertions.assertEquals(linkedListForCheck.remove(randomIndex),myLinkedList.remove(randomIndex),
                    "Элемент по индексу '" + randomIndex + "'не был удален!");
            sizeTestAfterRemoveByIndex(randomIndex);
            len--;
        }
        Assertions.assertEquals(linkedListForCheck.size(), myLinkedList.size(),"Проблема с размером " +
                "MyLinkedList после последовательного удаления элементов по индексу");
    }

    @Test
    public void removeIncorrectElementTest(){
        Assertions.assertEquals(linkedListForCheck.remove("Incorrect Element"),myLinkedList.
                        remove("Incorrect Element"), "Элемент 'Incorrect Element' был удален!");
        sizeTestAfterRemoveByObject("Incorrect Element");
    }

    public void sizeTestAfterAdd(Object object){
        Assertions.assertEquals(linkedListForCheck.size(), myLinkedList.size(),"Проблема с размером " +
                "MyLinkedList после добавления элемента: '" + object + "'!");
    }

    public void sizeTestAfterRemoveByObject(Object object){
        Assertions.assertEquals(linkedListForCheck.size(), myLinkedList.size(),"Проблема с размером " +
                "MyLinkedList после удаления элемента: '" + object + "'!");
    }
    public void sizeTestAfterRemoveByIndex(Integer index){
        Assertions.assertEquals(linkedListForCheck.size(), myLinkedList.size(),"Проблема с размером " +
                "MyLinkedList после удаления элемента по индексу: '" + index + "'!");
    }

    public void elementsAdd(){
        linkedListForCheck.add("Element Six");
        linkedListForCheck.add("Element Seven");
        linkedListForCheck.add("Element Eight");

        myLinkedList.add("Element Six");
        myLinkedList.add("Element Seven");
        myLinkedList.add("Element Eight");
    }

    public void elementsRemove(){
        linkedListForCheck.remove(0);
        linkedListForCheck.remove(1);
        linkedListForCheck.remove(2);

        myLinkedList.remove(0);
        myLinkedList.remove(1);
        myLinkedList.remove(2);
    }
}
