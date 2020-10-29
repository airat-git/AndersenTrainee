package ru.javatrainee.study.patterns.structure.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrinterImpl implements Printer {

    private String word;

    @Override
    public void print() {
        System.out.println(word);
    }
}
