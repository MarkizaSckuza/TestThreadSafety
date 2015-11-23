package sharedResources;

import java.util.*;

/**
 * Created by Margo on 22.11.2015.
 */
public class SharedCollection {

    public static List<Integer> list;
    public static Vector<Integer> vector;
    public static Iterator<Integer> iterator;
    public static Enumeration<Integer> enumerator;


    public static void initializeList() {
        list = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        iterator = list.iterator();
    }

    public static void initializeVector() {
        vector = new Vector<Integer>();
        for (int i = 0; i < 50; i++) {
            vector.add(i);
        }

        enumerator = vector.elements();
    }
}
