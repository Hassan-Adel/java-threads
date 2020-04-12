package com.tutorial.threads;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("Downloading a file : " + Thread.currentThread().getName() + " - " + timeStamp);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0 ; i<Integer.MAX_VALUE; i++) {
            //check for an interruption request
            if (Thread.currentThread().isInterrupted())
                return;
            System.out.println("Downloading byte " + i);
        }
        System.out.println("Download completed: " + Thread.currentThread().getName());
    }
}
