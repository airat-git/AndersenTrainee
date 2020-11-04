import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javatrainee.study.mycollections.mymap.MyHashMap;

public class MyHashMapTest {

    MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
    String toStringValue = "{A=65, B=66, C=67, D=68, E=69, F=70, G=71, H=72, I=73, J=74, K=75, " +
            "L=76, M=77, N=78, O=79, P=80, Q=81, R=82, S=83, T=84, U=85, V=86, W=87, X=88, Y=89, Z=90}";

    @BeforeEach
    public void beforeEach(){
        for (int i = 65; i <= 90; i++){
            myHashMap.put((char)i + "",i);
        }
    }

    @Test
    public void toStringTest(){
        Assertions.assertEquals(toStringValue,myHashMap.toString(),"Неверное отображение MyHashMap!");
    }

    @Test
    public void getElementTest(){
        Assertions.assertEquals(82,myHashMap.get("R"),"Неверное значение элемента" +
                " по ключу 'R'");
    }

    @Test
    public void addElementTest(){
        int expectedSize = myHashMap.size() + 1;
        myHashMap.put("New Element",500);
        Assertions.assertEquals(500,myHashMap.get("New Element"),"Неверное значение " +
                "элемента по ключу 'New Element'");
        sizeTestAfterAdd(expectedSize);
    }

    @Test
    public void addExistingElementTest(){
        int expectedSize = myHashMap.size();
        myHashMap.put("M",500);
        Assertions.assertEquals(500,myHashMap.get("M"),"Неверное значение " +
                "элемента по ключу 'M'");
        sizeTestAfterAdd(expectedSize);
    }

    @Test
    public void sequentialAddTest(){
        int expectedSize = myHashMap.size() + 3;
        myHashMap.put("New Element One",50);
        myHashMap.put("New Element One",100);
        myHashMap.put("New Element Two",200);
        myHashMap.put("New Element Three",300);
        myHashMap.put("K",400);
        Assertions.assertEquals(100,myHashMap.get("New Element One"),"Неверное значение " +
                "элемента по ключу 'New Element One'");
        Assertions.assertEquals(200,myHashMap.get("New Element Two"),"Неверное значение " +
                "элемента по ключу 'New Element Two'");
        Assertions.assertEquals(300,myHashMap.get("New Element Three"),"Неверное значение " +
                "элемента по ключу 'New Element Three'");
        Assertions.assertEquals(400,myHashMap.get("K"),"Неверное значение " +
                "элемента по ключу 'K");
        sizeTestAfterAdd(expectedSize);
    }

    @Test
    public void removeTest(){
        int expectedSize = myHashMap.size() - 1;
        Assertions.assertEquals(87,myHashMap.remove("W"), "Неверно / не удален элемент " +
                "с ключом 'W'!");
        sizeTestAfterRemove(expectedSize);
    }

    @Test
    public void sequentialRemoveTest(){
        for (int i = 65; i <= 90; i++){
            myHashMap.remove((char)i + "");
            Assertions.assertNull(myHashMap.get((char)i + ""), "Элемент с ключом '" + (char)i +
                    "' не был удален!");
        }
        sizeTestAfterRemove(0);
    }
    
    public void sizeTestAfterAdd(int expectedSize){
        Assertions.assertEquals(expectedSize,myHashMap.size(), "Проблема с размером MyHashMap после " +
                "добавления элемента");
    }

    public void sizeTestAfterRemove(int exceptedSize){
        Assertions.assertEquals(exceptedSize,myHashMap.size(), "Проблема с размером MyHashMap после " +
                "удаления элемента");
    }
}
