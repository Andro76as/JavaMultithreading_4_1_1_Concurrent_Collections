package ru.netology;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class CallCenter {

    public static final int calls = 15;
    public static final int specialist = 4;

    // 1 блокировка потоков
    // 2 честные блокировки (следит зо очередью)
    private static final Queue<String> phoneCalls = new ArrayBlockingQueue<>(calls); // размер буфера

    public void call() {
        //phoneCalls.offer(Thread.currentThread().getName());
        for (int i = 1; i <= calls; i++) {
            String call = "запрос " + i;
            phoneCalls.add(call);
            System.out.printf("%s звонок добавлен в очередь %s\n", Thread.currentThread().getName(), call);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Звонок " + Thread.currentThread().getName());
    }

    public void takeTheCall() {
        try {
            Thread.sleep(2000);
            while (true) {

                if (phoneCalls.isEmpty()) {
                    break;
                } else {
                    System.out.println("Специалист " + Thread.currentThread().getName() + " ответил на звонок " + phoneCalls.poll());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
