package C4.prg.kfc;

// !! HAHA GET IT? fast-FOO-d ??? FOOl
// i have an ongoin toxic psychosis, please help, the voices never stop...
public class FastFooD {

    String name;
    int inStoreChicken;

    public FastFooD(String name, int inStoreChicken) {
        this.name = name;
        this.inStoreChicken = inStoreChicken;
    }
    public FastFooD(String name) {
        this.name = name;
        this.inStoreChicken = 0;
    }


    public String getName() { 
        return this.name;
    }

    public int getInStoreChicken() {
        return this.inStoreChicken;
    }

    public boolean sellChicken(int amount) {
        int temp = this.inStoreChicken - amount;
        
        if(temp < 0) return false;
        
        this.inStoreChicken = temp;
        return true;
    }

    public void stockStore(int amount) {
        this.inStoreChicken += amount;

    }
}
