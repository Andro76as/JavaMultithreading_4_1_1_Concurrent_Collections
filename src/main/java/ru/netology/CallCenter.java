package ru.netology;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static ru.netology.Main.calls;

public class CallCenter {
    // 1 блокировка потоков
    // 2 честные блокировки (следит зо очередью)
    private static final Queue<String> phoneCalls = new ArrayBlockingQueue<>(calls); // размер буфера

    public void call() {
        phoneCalls.offer(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Звонок " + Thread.currentThread().getName());
    }

    public void takeTheCall() {
        while (!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Специалист " + Thread.currentThread().getName() + " ответил на звонок " + phoneCalls.poll());
        }
    }
}
