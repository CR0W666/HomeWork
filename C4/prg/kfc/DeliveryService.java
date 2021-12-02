package C4.prg.kfc;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    
    private List<FastFooD> stores;

    public DeliveryService() {
        this.stores = testStores();
    }

    public List<FastFooD> getStores() {
        return stores;
    }

    public void removeStore(int idx) {
        stores.remove(idx);
    }

    public void addStore(FastFooD store) {
        stores.add(store);
    }

    public void addStore(String name) {
        this.addStore(new FastFooD(name));
    }

    private List<FastFooD> testStores() {
        List<FastFooD> testStores = new ArrayList<>();
        stores.add(new FastFooD("KFC"));
        stores.add(new FastFooD("Mc Donalds"));
        stores.add(new FastFooD("Burger King"));
    
        return testStores;
    } 
    
}
