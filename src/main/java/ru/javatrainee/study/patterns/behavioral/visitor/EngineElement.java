package ru.javatrainee.study.patterns.behavioral.visitor;

public class EngineElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
