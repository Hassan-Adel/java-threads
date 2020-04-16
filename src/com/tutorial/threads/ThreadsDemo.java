package com.tutorial.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadsDemo {
    public static void showCount(){
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    public static void show(){
        System.out.println(Thread.currentThread().getName());
        for (int i = 0 ; i<10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }
    public static void pauseThread(){
        for (int i = 0 ; i<10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }
    public static void joinThread(){
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();
        //wait for the thread to finish
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned");
    }

    public static void interruptThread() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void raceCondition(){
        var status = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i<10 ; i++){
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());

    }

    public static void Confinement(){
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (int i = 0; i<10 ; i++){
            var task = new DownloadFileTask();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalBytes = tasks.stream().map(t -> t.getStatus().getTotalBytes()).reduce(0, (a, b) -> a+b);

        System.out.println(totalBytes);

    }

    public static void volatileKeyword(){
        DownloadStatus status = new DownloadStatus();
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
           while(!status.isDone()){}
            System.out.println(status.getTotalBytes());
        });
        thread1.start();
        thread2.start();
    }

    public static void waitAndNotify(){
        DownloadStatus status = new DownloadStatus();
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while(!status.isDone()){
                //java expects a sync block to surround the object that will change
                synchronized(status){
                    try {
                        //so we dont waste CPU cycles in the while loop
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });
        thread1.start();
        thread2.start();
    }
}
