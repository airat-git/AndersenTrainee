package ru.javatrainee.study.multithreading.threading;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsActivity {

    public static void main(String[] args) throws InterruptedException {

        DataClass dataClass = new DataClass();
        ExecutorService fixedPool = Executors.newFixedThreadPool(10,Thread::new);

        for (int i = 65; i < 70 ; i++){
            fixedPool.submit(new ThreadWrapper(dataClass));
        }

        fixedPool.shutdown();
        Thread.sleep(1000);

        for (Map.Entry<String,String> entry : DataClass.changeLog.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
