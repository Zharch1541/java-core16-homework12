package task1;

public class CurrentTime extends Thread {
    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Минуло 5 секунд");
        }
    }

    public static void main(String[] args) {

        CurrentTime thread = new CurrentTime();
        thread.start();

        long start = System.currentTimeMillis();

            while (true) {
                long end = System.currentTimeMillis();

                long time = (end - start) / 1000;

                System.out.println(time);

                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}
