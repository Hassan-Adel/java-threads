package com.tutorial.threads;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("Downloading a file : " + Thread.currentThread().getName() + " - " + timeStamp);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download completed: " + Thread.currentThread().getName());
    }
}
