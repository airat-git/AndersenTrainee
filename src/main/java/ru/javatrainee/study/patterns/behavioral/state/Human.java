package ru.javatrainee.study.patterns.behavioral.state;

public class Human {

    private Activity activity = new Relax();

    public void doSomeThing(){
        activity.doIt(this);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
