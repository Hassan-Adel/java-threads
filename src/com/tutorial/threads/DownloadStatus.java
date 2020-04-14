package com.tutorial.threads;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
  private int totalBytes;
  private int totalFiles;
  private Object totalBytesLock = new Object();
  private Object totalFilesLock = new Object();


  public int getTotalBytes() {
    return totalBytes;
  }

  public void incrementTotalBytes() {
    //every java object has a built in lock (monitor object)
    synchronized (totalBytesLock){
      this.totalBytes++;
    }
  }

  public int getTotalFiles() {
    return totalFiles;
  }

  public void incrementTotalFiles() {
    synchronized (totalFilesLock){
      this.totalFiles++;
    }
  }

    //same as using synchronized(this)
    public synchronized void incrementTotalFilesByTwo(){
        this.totalFiles+=2;
    }

}
