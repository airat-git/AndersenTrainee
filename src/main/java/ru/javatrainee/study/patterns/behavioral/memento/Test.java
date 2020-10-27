package ru.javatrainee.study.patterns.behavioral.memento;

public class Test {

    public static void main(String[] args) {

        Game game = new Game("LEVEL 1",10000);
        System.out.println(game);
        File file = new File(game.save());
        game.set("LEVEL 2",200000);
        System.out.println(game);
        game.load(file.getSave());
        System.out.println(game);
    }
}
