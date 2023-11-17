package task2;


import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.IntConsumer;


public class FizzBazz {
    private int number;
    int n = 1;

    public FizzBazz(int number) {
        this.number = number;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (n <= number) {
            if (n % 3 == 0 && n % 5 != 0) {
                printFizz.run();
                n++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (n <= number) {
            if (n % 5 == 0 && n % 3 != 0) {
                printBuzz.run();
                n++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (n <= number) {
            if (n % 15 == 0) {
                printFizzBuzz.run();
                n++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (n <= number) {
            if (n % 3 != 0 && n % 5 != 0) {
                printNumber.accept(n);
                n++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}