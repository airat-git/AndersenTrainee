package ru.javatrainee.study.patterns.structure.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Decorator implements Printer {

    protected Printer printer;
}
