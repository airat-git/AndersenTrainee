package ru.javatrainee.study.patterns.generative.prototype;

public class CopyFactory {

    private Human human;

    public CopyFactory setPrototype(Human human){
        this.human = human;
        return this;
    }

    public Human makeCopy(){
        return (Human) this.human.copy();
    }
}
