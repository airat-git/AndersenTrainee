package ru.javatrainee.study.chat.server.bot;

import java.util.HashMap;

public class MapKeyWords{

    private HashMap<String,String> helloBye = new HashMap<>();
    private HashMap<String,String> prepositions = new HashMap<>();
    private HashMap<String,String> activity = new HashMap<>();
    private HashMap<String,String> responseWords = new HashMap<>();


    public MapKeyWords(){
        addWords();
    }

    public HashMap<String, String> getHelloBye() {
        return helloBye;
    }

    public HashMap<String, String> getPrepositions() {
        return prepositions;
    }

    public HashMap<String, String> getActivity() {
        return activity;
    }

    public HashMap<String, String> getResponseWords() {
        return responseWords;
    }

    private void addWords(){
        addKeyWords();
        addResponseWords();
    }

    private void addKeyWords(){
        helloBye.put("привет","1");
        helloBye.put("пока","2");

        prepositions.put("как","1");
        prepositions.put("что","2");
        prepositions.put("кто","3");

        activity.put("дела","1");
        activity.put("делаешь","2");
        activity.put("тебя","3");
        activity.put("зовут","4");
        activity.put("ты","5");
        activity.put("говоришь","6");
        activity.put("умеешь","7");
        activity.put("по","8");
        activity.put("жизни","9");
    }

    private void addResponseWords(){
        responseWords.put("1","ну привет!:)");
        responseWords.put("2","пока((");
        responseWords.put("11","все отлично!) спасибо");
        responseWords.put("134","меня зовут Бибигоч");
        responseWords.put("22","работаю любимую работу");
        responseWords.put("156","Айрат меня научил");
        responseWords.put("257","пока только отвечать на глупые вопросы))");
        responseWords.put("252","работаю любимую работу");
        responseWords.put("3589","типа тамагочи");
    }
}
