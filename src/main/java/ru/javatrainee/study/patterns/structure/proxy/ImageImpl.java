package ru.javatrainee.study.patterns.structure.proxy;

public class ImageImpl implements Image {

    private String file;

    public ImageImpl(String file) {
        this.file = file;
        load();
    }

    public void load(){
        System.out.println("Загрузка картинки " + file);
    }

    @Override
    public void show() {
        System.out.println("Показ картнки " + file);
    }
}
