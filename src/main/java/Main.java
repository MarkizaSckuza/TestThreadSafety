import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Margo on 22.11.2015.
 */
public class Main {

    public static void main(String[] args) {

        SharedCollection.initialize();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Reader());
        executor.execute(new Remover());
        executor.shutdown();
    }
}
