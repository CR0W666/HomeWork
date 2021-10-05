
import java.util.Iterator;

public class PrimesIterable implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator();
    }
}
