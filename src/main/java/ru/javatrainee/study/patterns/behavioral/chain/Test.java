package ru.javatrainee.study.patterns.behavioral.chain;

public class Test {

    public static void main(String[] args) {

        Logger sms = new SMSLog(Level.ERROR);
        Logger emailLog = new EmailLog(Level.DEBAG);
        Logger fileLog = new FileLog(Level.INFO);

        sms.setNext(emailLog);
        emailLog.setNext(fileLog);
        sms.writeMessage("Все ок",Level.INFO);
        sms.writeMessage("Идет дебаг",Level.DEBAG);
        sms.writeMessage("Ошибка!",Level.ERROR);
    }
}
