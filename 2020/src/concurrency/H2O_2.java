package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * using reentrant lock
 */
public class H2O_2 {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int hCount = 0;
    private int oCount = 0;

    public H2O_2() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            lock.lock();
            while (hCount >= 2) {
                condition.await();
            }
            releaseHydrogen.run();
            hCount++;
            makeH2O();
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        try {
            lock.lock();
            while (oCount >= 1) {
                condition.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oCount++;
            makeH2O();
        } finally {
            lock.unlock();
        }

    }

    private void makeH2O() {
        while (hCount >= 2 && oCount >= 1) {
            hCount -= 2;
            oCount--;
        }
    }
}