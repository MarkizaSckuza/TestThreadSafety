import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Margo on 22.11.2015.
 */
public class SharedCollection {

    public static List<Integer> list;
    public static Iterator<Integer> iterator;
    public static Enumeration<Integer> enumerator;


    public static void initialize() {
        list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        iterator = list.iterator();

    }
}
