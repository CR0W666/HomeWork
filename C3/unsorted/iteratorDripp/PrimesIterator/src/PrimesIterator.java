import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimesIterator implements Iterator<Integer> {

    private List<Integer> primesCache = new ArrayList<>();
    private int i = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        do {
            i++;
        } while (!isPrime(i));
        return i;
    }

    // 101 | 2,3,5,7,11,13,17,19,23,29,31
    private boolean isPrime(int i) {
        int sqroot = (int) Math.sqrt(i);
        for (int j : primesCache) {
            if (j > sqroot) break;
            if (i % j == 0) {
                return false;
            }
        }
        primesCache.add(i);
        return true;
    }


    public static void main(String[] args) {
        for (int prime : new PrimesIterable()) {
            if (prime > 100) break;
            System.out.println(prime);
        }
    }
}
