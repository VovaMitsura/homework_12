package task2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {

  public static void main(String[] args) {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
    AtomicInteger integer = new AtomicInteger(1);

    Thread threadA;
    Thread threadB;
    Thread threadC;

    for (int i = 0; i < 30; i++) {
      threadC = new ThreadFizzBuzz(integer, queue);
      threadC.start();
      try {
        threadC.join();
      } catch (InterruptedException e) {
        System.err.println("InterruptedException occur in Thread C");
        Thread.currentThread().interrupt();
      }

      threadA = new ThreadFizz(integer, queue);
      threadA.start();
      try {
        threadA.join();
      } catch (InterruptedException e) {
        System.err.println("InterruptedException occur in Thread A");
        Thread.currentThread().interrupt();
      }

      threadB = new ThreadBuzz(integer, queue);
      threadB.start();
      try {
        threadB.join();
      } catch (InterruptedException e) {
        System.err.println("InterruptedException occur in Thread C");
        Thread.currentThread().interrupt();
      }

      System.out.print(number(queue, integer) + " ");
      integer.getAndIncrement();
    }
  }

  private static String number(BlockingQueue<String> queue, AtomicInteger integer) {
    if (queue.isEmpty()) {
      return integer.toString();
    } else {
      return queue.poll();
    }
  }
}