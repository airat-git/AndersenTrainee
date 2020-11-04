import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.javatrainee.study.mycollections.mylist.MyArrayList;
import ru.javatrainee.study.mycollections.mylist.MyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест, предназаченный для тестрования MyArrayList, путем сравнения результов вызова
 * его методов с резлультатами вызова методов оригинального ArrayList
 */
public class MyArrayListTest {

    MyList<String> myArrayList = new MyArrayList<>();
    List<String> arrayListForCheck = new ArrayList<>();
    String [] params = new String[]{"Element One","Element Two","Element Three","Element Four", "Element Five"};

    @BeforeEach
    public void beforeEach(){
        for(String param : params){
            myArrayList.add(param);
            arrayListForCheck.add(param);
        }
    }

    @Test
    public void toStringCompareTest(){
        Assertions.assertEquals(arrayListForCheck.toString(),myArrayList.toString(),"Неверное отображение" +
                " MyArrayList!");
    }

    @Test
    public void addElementTest(){
        Assertions.assertEquals(arrayListForCheck.add("Element Six"),myArrayList.add("Element Six"), "Элемент '" +
                "Element Six" + "' в MyArrayList не был добавлен!");
        sizeTestAfterAdd("Element Six");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void getElementTest(int index){
        Assertions.assertEquals(arrayListForCheck.get(index),myArrayList.get(index),
                "Элемент по индексу '" + index + "' не совпадают!");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void compareAfterAddTest(int index){
        elementsAdd();
        Assertions.assertEquals(arrayListForCheck.get(index),myArrayList.get(index),
                "Элемент по индексу '" + index + "' не совпадают!");
    }

    @Test
    public void removeByIndexFromHeadTest(){
        Assertions.assertEquals(arrayListForCheck.remove(0),myArrayList.remove(0),
                "Элемент по индексу '0' не был удален!");
        sizeTestAfterRemoveByIndex(0);
    }

    @Test
    public void removeByIndexFromMiddleTest(){
        Assertions.assertEquals(arrayListForCheck.remove(2),myArrayList.remove(2),
                "Элемент по индексу '2' не был удален!");
        sizeTestAfterRemoveByIndex(2);
    }

    @Test
    public void removeByIndexFromTaleTest(){
        Assertions.assertEquals(arrayListForCheck.remove(4),myArrayList.remove(4),
                "Элемент по индексу '4' не был удален!");
        sizeTestAfterRemoveByIndex(4);
    }

    @Test
    public void removeElementExceptionTest(){
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> arrayListForCheck.remove(100),
                ()->myArrayList.remove(100));
        sizeTestAfterRemoveByIndex(100);
    }

    @Test
    public void compareAfterRemoveByIndexTest(){
        elementsRemove();
        Assertions.assertEquals(arrayListForCheck.get(0),myArrayList.get(0),
                "Элемент по индексу '" + 0 + "' не совпадают!");
        Assertions.assertEquals(arrayListForCheck.get(1),myArrayList.get(1),
                "Элемент по индексу '" + 1 + "' не совпадают!");
    }

    @Test
    public void removeByObjectFromHeadTest(){
        Assertions.assertEquals(arrayListForCheck.remove("Element One"),myArrayList.remove("Element One"),
                "Элемент 'Element One' не был удален!");
        sizeTestAfterRemoveByObject("Element One");
    }

    @Test
    public void removeByObjectFromMiddleTest(){
        Assertions.assertEquals(arrayListForCheck.remove("Element Three"),myArrayList.remove("Element Three"),
                "Элемент 'Element Three' не был удален!");
        sizeTestAfterRemoveByObject("Element Three");
    }

    @Test
    public void removeByObjectFromTaleTest(){
        Assertions.assertEquals(arrayListForCheck.remove("Element Five"),myArrayList.remove("Element Five"),
                    "Элемент 'Element Five' не был удален!");
        sizeTestAfterRemoveByObject("Element Five");
    }

    @Test
    public void sequentialRemoveByIndexTest(){
        elementsAdd();
        int len = 7;
        int randomIndex = (int) (Math.random() * len);
        Assertions.assertEquals(arrayListForCheck.remove(randomIndex),myArrayList.remove(randomIndex),
                "Элемент по индексу '" + randomIndex + "'не был удален!");
        sizeTestAfterRemoveByIndex(randomIndex);

        len--;
        randomIndex = (int) (Math.random() * len);
        Assertions.assertEquals(arrayListForCheck.remove(randomIndex),myArrayList.remove(randomIndex),
                "Элемент по индексу '" + randomIndex + "'не был удален!");
        sizeTestAfterRemoveByIndex(randomIndex);

        len--;
        randomIndex = (int) (Math.random() * len);
        Assertions.assertEquals(arrayListForCheck.remove(randomIndex),myArrayList.remove(randomIndex),
                "Элемент по индексу '" + randomIndex + "'не был удален!");
        sizeTestAfterRemoveByIndex(randomIndex);

        Assertions.assertEquals(arrayListForCheck.size(), myArrayList.size(),"Проблема с размером " +
                "MyArrayList после последовательного удаления элементов по индексу");
    }

    @Test
    public void removeIncorrectElementTest(){
        Assertions.assertEquals(arrayListForCheck.remove("Incorrect Element"),myArrayList.remove("Incorrect Element"),
                "Элемент 'Incorrect Element' был удален!");
        sizeTestAfterRemoveByObject("Incorrect Element");
    }

    public void sizeTestAfterAdd(Object object){
        Assertions.assertEquals(arrayListForCheck.size(), myArrayList.size(),"Проблема с размером " +
                "MyArrayList после добавления элемента: '" + object + "'!");
    }

    public void sizeTestAfterRemoveByObject(Object object){
        Assertions.assertEquals(arrayListForCheck.size(), myArrayList.size(),"Проблема с размером " +
                "MyArrayList после удаления элемента: '" + object + "'!");
    }
    public void sizeTestAfterRemoveByIndex(int index){
        Assertions.assertEquals(arrayListForCheck.size(), myArrayList.size(),"Проблема с размером " +
                "MyArrayList после удаления элемента по индексу: '" + index + "'!");
    }

    public void elementsAdd(){
        arrayListForCheck.add("Element Six");
        arrayListForCheck.add("Element Seven");
        arrayListForCheck.add("Element Eight");

        myArrayList.add("Element Six");
        myArrayList.add("Element Seven");
        myArrayList.add("Element Eight");
    }

    public void elementsRemove(){
        arrayListForCheck.remove(0);
        arrayListForCheck.remove(1);
        arrayListForCheck.remove(2);

        myArrayList.remove(0);
        myArrayList.remove(1);
        myArrayList.remove(2);
    }
}
