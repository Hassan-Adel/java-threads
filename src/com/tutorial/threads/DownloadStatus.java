package com.tutorial.threads;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
  private int totalBytes;
  public int getTotalBytes() {
    return totalBytes;
  }

  public void incrementTotalBytes() {
    this.totalBytes++;
  }

}
