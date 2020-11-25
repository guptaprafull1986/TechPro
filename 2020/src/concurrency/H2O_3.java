package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * using semaphore lock
 */
public class H2O_3 {

    private Semaphore semaphoreH = new Semaphore(2, true);
    private Semaphore semaphoreO = new Semaphore(0, true);

    public H2O_3() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        semaphoreO.acquire(2);
        releaseOxygen.run();
        semaphoreH.release(2);

    }
}