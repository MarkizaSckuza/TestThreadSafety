import java.util.concurrent.TimeUnit;

/**
 * Created by Margo on 22.11.2015.
 */
public class Remover implements Runnable {


    @Override
    public void run() {
        while (SharedCollection.iterator.hasNext()) {
            System.out.println("Removing " + SharedCollection.iterator.next());
            SharedCollection.iterator.remove();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
