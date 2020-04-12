package com.tutorial.threads;

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
}
