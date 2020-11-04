package ru.javatrainee.study.patterns.behavioral.chain;

public abstract class Logger {

    public int priority;
    public Logger next;
    public void setNext(Logger next){
        this.next = next;
    }

    public Logger(int priority) {
        this.priority = priority;
    }

    public void writeMessage(String message,int level){
        if (level <= priority){
            write(message);
        }
        if (next!= null){
            next.writeMessage(message,level);
        }
    }

    public abstract void write(String message);

}
