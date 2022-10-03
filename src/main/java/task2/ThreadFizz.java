package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFizz extends Thread {

  private final AtomicInteger number;
  private final BlockingQueue<String> queue;

  public ThreadFizz(AtomicInteger number, BlockingQueue<String> queue) {
    this.number = number;
    this.queue = queue;
  }

  @Override
  public void run() {
    synchronized (queue) {
      if (queue.isEmpty() && fizz()) {
        queue.add("fizz");
      }
    }
  }

  private boolean fizz() {
    return number.get() % 3 == 0;
  }
}
