package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(4, true);

    static class AtmThread extends Thread {
        String name = "";

        public AtmThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " : acquiring lock");
                System.out.println(name + " : available semaphore permits now : "
                        + semaphore.availablePermits());
                semaphore.acquire();
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(name
                                + " : is performing operation"
                                + i
                                + ", available semaphore permits : "
                                + semaphore.availablePermits());
                        Thread.sleep(1000);
                    }
                } finally {
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available semaphore permits now : "
                            + semaphore.availablePermits());
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Total available semaphore permits : "
                + semaphore.availablePermits());

        AtmThread threadA = new AtmThread("A");
        threadA.start();
        AtmThread threadB = new AtmThread("B");
        threadB.start();
        AtmThread threadC = new AtmThread("C");
        threadC.start();
        AtmThread threadD = new AtmThread("D");
        threadD.start();
        AtmThread threadE = new AtmThread("E");
        threadE.start();
    }
}



