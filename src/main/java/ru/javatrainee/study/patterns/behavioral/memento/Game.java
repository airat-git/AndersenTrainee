package ru.javatrainee.study.patterns.behavioral.memento;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Game {

    private String level;
    private int time;

    public void set(String level,int time) {
        this.level = level;
        this.time = time;
    }

    public Save save(){
        return new Save(this.level,this.time);
    }

    public void load(Save save){
        this.level = save.getLevel();
        this.time = save.getTime();
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}
