package ru.javatrainee.study.patterns.structure.proxy;

public class ImageProxy implements Image  {

    private String file;
    private ImageImpl image;

    public ImageProxy(String file) {
        this.file = file;
    }

    @Override
    public void show() {
        if (image == null){
            image = new ImageImpl(file);
        }
        image.show();
    }
}
