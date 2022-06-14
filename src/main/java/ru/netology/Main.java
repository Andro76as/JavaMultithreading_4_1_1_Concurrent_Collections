package ru.netology;

public class Main {
    public static final int calls = 60;
    public static final int specialist = 4;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        for (int i = 1; i <= calls; i++) {
            new Thread(null, center::call, "№ " + i).start();
        }

        for (int i = 1; i <= specialist; i++) {
            new Thread(null, center::takeTheCall, "№ " + i).start();
        }
    }
}