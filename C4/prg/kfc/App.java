package C4.prg.kfc;

import java.util.List;

public class App {
    protected static final DeliveryService provider = new DeliveryService();
    protected static final List<FastFooD> stores = provider.getStores();

    public static void main(String[] args) {
        //TODO
    }
}
