package ru.netology;

import static ru.netology.CallCenter.specialist;

public class Main {


    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        Thread atc = new Thread(center::call, "Колл-центр ");

//        for (int i = 1; i <= calls; i++) {
//            new Thread(null, center::call, "№ " + i).start();
//        }

        for (int i = 1; i <= specialist; i++) {
            new Thread(null, center::takeTheCall, "№ " + i).start();
        }
        atc.start();
    }
}