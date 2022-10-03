package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadBuzz extends Thread {

  private AtomicInteger number;
  private final BlockingQueue<String> queue;

  public ThreadBuzz(AtomicInteger number, BlockingQueue<String> queue) {
    this.number = number;
    this.queue = queue;
  }

  @Override
  public void run() {
    synchronized (queue) {
      if (queue.isEmpty() && buzz()) {
        queue.add("buzz");
      }
    }
  }

  private boolean buzz() {
    return number.get() % 5 == 0;
  }
}
