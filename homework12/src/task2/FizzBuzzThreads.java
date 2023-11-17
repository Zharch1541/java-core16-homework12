package task2;

import java.util.function.IntConsumer;

public class FizzBuzzThreads {
    public static void main(String[] args) throws InterruptedException {
        FizzBazz fizzbazz = new FizzBazz(30);
        Runnable printFizz = () -> System.out.println("fizz");
        Runnable printBuzz = () -> System.out.println("buzz");
        Runnable printFizzBuzz = () -> System.out.println("fizzbuzz");
        IntConsumer printNumber = n -> System.out.println(n);

        Thread threadA = new Thread(() -> {
            try {
                fizzbazz.fizz(printFizz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzbazz.buzz(printBuzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzbazz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzbazz.number(printNumber);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
