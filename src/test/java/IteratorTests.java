import org.junit.Ignore;
import org.junit.Test;
import runnables.Reader;
import sharedResources.SharedCollection;

import java.util.Iterator;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Margo on 22.11.2015.
 */

public class IteratorTests {

    @Test
    public void testIsThrSafeWhenModifyFirstElement() {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        SharedCollection.initializeList();
        int expected = 49;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(new Reader(countDownLatch));

        executorService.execute(() -> {
            try {
                countDownLatch.await();
                SharedCollection.list.remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

        try {
            int actual = future.get();
            assertEquals(expected, actual);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIsThrSafeWhenModifyLastElement() {

        SharedCollection.initializeList();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int expected = 49;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(new Reader(countDownLatch));

        executorService.execute(() -> {
            try {
                countDownLatch.await();
                SharedCollection.list.remove(SharedCollection.list.size() - 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

        try {
            int actual = future.get();
            assertEquals(expected, actual);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIsThrSafeWhenModifyMiddleElement() {

        SharedCollection.initializeList();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int expected = 49;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(new Reader(countDownLatch));

        executorService.execute(() -> {
            try {
                countDownLatch.await();
                SharedCollection.list.remove(SharedCollection.list.size() / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

        try {
            int actual = future.get();
            assertEquals(expected, actual);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
