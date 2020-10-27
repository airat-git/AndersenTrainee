package ru.javatrainee.study.patterns.behavioral.state;

public class Test {

    public static void main(String[] args) {
        Human human = new Human();
        for (int i = 0; i < 4; i++){
            human.doSomeThing();
        }
    }
}
