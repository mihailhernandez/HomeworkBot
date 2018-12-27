package mihailhernandez.homeworkBot.main;

import mihailhernandez.homeworkBot.bot.HomeworkBot;

public class Main {
    public static void main(String[] args) {
        HomeworkBot bot = HomeworkBot.getInstance();
        bot.start(args);
    }
}
