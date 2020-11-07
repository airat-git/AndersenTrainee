package ru.javatrainee.study.chat.server.bot;

import org.apache.commons.lang3.StringUtils;

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
    private static final String WHITE_SPACE = " ";

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
        if (message.split(WHITE_SPACE)[0].equalsIgnoreCase("бот")) {
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

        for (String word : messageArray) {
            if (helloBye.containsKey(word)) {
                hb.append(helloBye.get(word));
            }
            if (prepositions.containsKey(word)) {
                act.append(prepositions.get(word));
            }
            if (activity.containsKey(word)) {
                act.append(activity.get(word));
            }
            if (word.equals(StringUtils.EMPTY)) {
                act.append(WHITE_SPACE);
            }
        }
        if (hb.toString().equals(StringUtils.EMPTY) && act.toString().equals(StringUtils.EMPTY)){
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
            response.append(words.get(hb)).append(WHITE_SPACE);
        }
        String[] wordsArray = act.split(WHITE_SPACE);
        for (String word : wordsArray){
            if (words.containsKey(word)){
                response.append(words.get(word)).append(". ");
            }
        }
        return response.toString().equals(StringUtils.EMPTY) ? "Извини, я тебя не понял" : response.toString();
    }

    private String [] symbolsIgnore(String message){
        String[] messageWords = message.toLowerCase().split(WHITE_SPACE);
        StringBuilder newMessage = new StringBuilder();
        for (String word : messageWords) {
            if (!word.equals("бот")) {
                char[] chars = word.toCharArray();
                for (char c : chars) {
                    if (Character.isAlphabetic(c)) {
                        newMessage.append(c);
                    } else {
                        newMessage.append("  ");
                    }
                }
                newMessage.append(WHITE_SPACE);
            }
        }
        return newMessage.toString().split(WHITE_SPACE);
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
