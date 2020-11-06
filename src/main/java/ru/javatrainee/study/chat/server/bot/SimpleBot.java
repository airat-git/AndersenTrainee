package ru.javatrainee.study.chat.server.bot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * Бот перехватывает сообщения пользователя, которые начинаются со слова бот. При обращении к боту
 * не нужно использовать знаки препинания (напр. 'бот привет').
 * Между смысловыми фразами обятельно соблюдать знаки препинания (напр. 'привет. что делаешь?'),
 * пробел после знака препинания не обязательно
 * За словарный запас отвечает класс MapKeyWords.
 * Логика ответа бота очень проста и примитивна: каждая сказанная ему смысловая фраза приобразуется
 * в последовательность чисел в формате String, по которым идет поиск соответствующего ответа (см.MapKeyWords)
 * (напр. 'как дела' -> 11 -> 'все отлично!) спасибо'). Данный механизм приметивен и требует изменения/доработки
 */
public class SimpleBot implements Bot{

    private static final MapKeyWords MAP_KEY_WORDS = new MapKeyWords();

    private final HashMap<String,String> helloBye;
    private final HashMap<String,String> prepositions;
    private final HashMap<String,String> activity;
    private final HashMap<String,String> words;

    public SimpleBot() {
        helloBye = MAP_KEY_WORDS.getHelloBye();
        prepositions = MAP_KEY_WORDS.getPrepositions();
        activity = MAP_KEY_WORDS.getActivity();
        words = MAP_KEY_WORDS.getResponseWords();
    }

    public String checkWord(String message){
        if (message.split(" ")[0].equalsIgnoreCase("бот")) {
            return botMessageFormat(getResponse(message));
        }
        return null;
    }

    public String getResponse(String message){
        return findKeyWords(symbolsIgnore(message));
    }

    private String findKeyWords(String [] messageArray){
        StringBuilder hb = new StringBuilder();
        StringBuilder act = new StringBuilder();

        for (int i = 0; i < messageArray.length;i++){
            String word = messageArray[i];
            if (helloBye.containsKey(word)){
                hb.append(helloBye.get(word));
            }
            if (prepositions.containsKey(word)){
                act.append(prepositions.get(word));
            }
            if (activity.containsKey(word)){
                act.append(activity.get(word));
            }
            if (word.equals("")){
                act.append(" ");
            }
        }
        if (hb.toString().equals("") & act.toString().equals("")){
            return null;
        }
        return decodeKeyWords(hb.toString(), act.toString());
    }

    private String decodeKeyWords(String hb,String act){
        StringBuilder response = new StringBuilder();
        if (hb.equals("2")){
            return words.get("2");
        }
        else if (hb.equals("1")){
            response.append(words.get(hb)).append(" ");
        }
        String[] wordsArray = act.split(" ");
        for (String word : wordsArray){
            if (words.containsKey(word)){
                response.append(words.get(word)).append(". ");
            }
        }
        return response.toString().equals("") ? "Извини, я тебя не понял" : response.toString();
    }

    private String [] symbolsIgnore(String message){
        String[] words = message.toLowerCase().split(" ");
        StringBuilder newMessage = new StringBuilder();
        for (String word : words) {
            if (!word.equals("бот")) {
                char[] chars = word.toCharArray();
                for (char c : chars) {
                    if (Character.isAlphabetic(c)) {
                        newMessage.append(c);
                    } else {
                        newMessage.append("  ");
                    }
                }
                newMessage.append(" ");
            }
        }
        return newMessage.toString().split(" ");
    }

    private static String botMessageFormat(String message){
        if (Objects.nonNull(message)){
            Date date = new Date();
            String dateTime = new SimpleDateFormat().format(date);
            return dateTime + " Message from bot:'"
                    + message + "'";
        }
        return null;
    }
}
