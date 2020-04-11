package com.tutorial.threads;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        System.out.println("Downloading a file : " + Thread.currentThread().getName() + " - " + timeStamp);
    }
}
