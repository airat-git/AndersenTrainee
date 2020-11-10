package ru.javatrainee.study.multithreading.threading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWrapper implements Runnable{

    private final DataClass dataClass;
    private static AtomicInteger incrementCount = new AtomicInteger(0);

    public ThreadWrapper(DataClass dataClass) {
        this.dataClass = dataClass;
    }

    @Override
    public void run() {
        synchronized (dataClass) {
            String startTime = getCurrentTime();
            int oldValue = dataClass.getValue();
            dataClass.setNewValue(dataClass.getValue() + ThreadWrapper.incrementCount.incrementAndGet());
            fixChanges(oldValue);
            display(startTime);
        }
    }

    private void fixChanges(int oldValue){
        DataClass.changeLog.put("Поток - " + Thread.currentThread().getName(), ". Старое значение: " +
                oldValue + ", прибавил: " + ThreadWrapper.incrementCount.get() + ", новое значение: " + dataClass.getValue());
    }

    private void display(String startTime){
        System.out.println("Поток '" + Thread.currentThread().getName() + "' начал работу в " +
                startTime + ", закончил работу в " + getCurrentTime());
    }

    private String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("H часов m минут s секунд SSSS"));
    }
}
