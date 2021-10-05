import java.util.Random;

class NumGenerator {
    int min,max;
    public NumGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int generate() {

        if (this.min >= this.max) {
            System.err.println("error666: min je >= nez max");
            return 666;
        } else {
            Random r = new Random();
            int result = r.nextInt((this.max - this.min) + 1) + this.min;
            return result;
        }


        
    }
}