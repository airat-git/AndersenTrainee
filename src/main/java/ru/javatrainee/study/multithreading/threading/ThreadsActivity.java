package ru.javatrainee.study.multithreading.threading;

import java.util.ArrayList;
import java.util.Map;

public class ThreadsActivity {

    public static void main(String[] args) throws Exception {

        DataClass dataClass = new DataClass();
        ArrayList<MyThread> threads = new ArrayList<>();

        for (int i = 65; i < 70 ; i++){
            threads.add(new MyThread(dataClass,(char)i+""));
        }
        threads.forEach(MyThread::start);
        Thread.sleep(1000);

        for (Map.Entry<String,String> entry : DataClass.changeLog.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
