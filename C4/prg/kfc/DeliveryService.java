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

    private List<FastFooD> testStores() {
        List<FastFooD> _stores = new ArrayList<>();
        stores.add(new FastFooD("KFC"));
        stores.add(new FastFooD("Mc Donalds"));
        stores.add(new FastFooD("Burger King"));
    
        return _stores;
    } 
    
}
