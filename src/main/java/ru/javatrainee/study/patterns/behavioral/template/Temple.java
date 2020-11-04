package ru.javatrainee.study.patterns.behavioral.template;

public abstract class Temple {

    public void print (){
        System.out.print("Шаблонная часть '1', ");
        custom();
        System.out.print(", Шаблонная часть '2'");
        System.out.println();
    }

    public abstract void custom();
}
