package ru.javatrainee.study.patterns.behavioral.visitor;

public class Test {

    public static void main(String[] args) {

        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor visitor  = new HooliganVisitor();
        body.accept(visitor);
        engine.accept(visitor);
        visitor = new EngineVisitor();
        body.accept(visitor);
        engine.accept(visitor);
    }
}
