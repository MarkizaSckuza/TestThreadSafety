/**
 * Created by Margo on 22.11.2015.
 */
public class ListModifier {

    public static void modifyList() {
        int position = SharedCollection.list.size() / 2;

        SharedCollection.list.remove(position);
    }
}
