package ru.javatrainee.study.patterns.behavioral.visitor;

public interface Visitor {

    void visit (EngineElement engineElement);

    void visit(BodyElement bodyElement);
}
