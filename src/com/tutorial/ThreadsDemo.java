package com.tutorial;

public class ThreadsDemo {
    public static void showCount(){
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
