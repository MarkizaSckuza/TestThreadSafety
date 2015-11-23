package runnables;

import sharedResources.SharedCollection;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Margo on 23.11.2015.
 */
public class Reader implements Callable<Integer> {

    private CountDownLatch countDownLatch;

    public Reader(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public Integer call() throws Exception {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (SharedCollection.iterator.hasNext()) {
            sb.append(SharedCollection.iterator.next()).append(" ");
            if (count == SharedCollection.list.size() / 2) {
                countDownLatch.countDown();
            }
            count++;
        }
        return Integer.valueOf(count);
    }
}
