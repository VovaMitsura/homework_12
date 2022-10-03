package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFizzBuzz extends Thread {

  private final AtomicInteger number;
  private final BlockingQueue<String> queue;


  public ThreadFizzBuzz(AtomicInteger number, BlockingQueue<String> queue) {
    this.number = number;
    this.queue = queue;
  }

  @Override
  public void run() {
    synchronized (queue) {
      if (queue.isEmpty() && fizzbuzz()) {
        queue.add("fizzbuzz");
      }
    }
  }

  private boolean fizzbuzz() {
    return number.get() % 3 == 0 && (number.get() % 5) == 0;
  }
}
