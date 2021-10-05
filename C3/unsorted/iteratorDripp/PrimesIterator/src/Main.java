import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"WhileLoopReplaceableByForEach"})
public class Main {



    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }
    }
}
