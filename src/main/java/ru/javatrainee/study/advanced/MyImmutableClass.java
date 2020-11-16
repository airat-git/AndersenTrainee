package ru.javatrainee.study.advanced;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class MyImmutableClass {

    public static final int CONSTANT_VALUE = 100500;

    @Getter
    private final int value;

    public MyImmutableClass(int value) {
        this.value = value;
    }

    public MyImmutableClass setValue(int value){
        return new MyImmutableClass(value);
    }

    public final void foo(){
        log.info("This is my Immutable class: {}, and my constant: {}",this.getClass().getSimpleName(),CONSTANT_VALUE);
    }
}
