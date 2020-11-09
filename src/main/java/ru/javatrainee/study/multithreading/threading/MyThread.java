package ru.javatrainee.study.multithreading.threading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyThread extends Thread{

    private final DataClass dataClass;
    private static int incrementCount = 1;

    public MyThread(DataClass dataClass,String name) {
        super(name);
        this.dataClass = dataClass;
    }

    @Override
    public void run() {
        synchronized (dataClass) {
            String startTime = getCurrentTime();
            int oldValue = dataClass.getOldValue();
            dataClass.setNewValue(dataClass.getValue() + MyThread.incrementCount);
            fixChanges(oldValue);
            display(startTime);
            incrementCount++;
        }
    }

    private void fixChanges(int oldValue){
        DataClass.changeLog.put("Поток - " + Thread.currentThread().getName(), ". Старое значение: " +
                oldValue + ", прибавил: " + MyThread.incrementCount + ", новое значение: " + dataClass.getValue());
    }

    private void display(String startTime){
        System.out.println("Поток '" + Thread.currentThread().getName() + "' начал работу в " +
                startTime + ", закончил работу в " + getCurrentTime());
    }

    private String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("H часов m минут s секунд SSSS"));
    }
}
