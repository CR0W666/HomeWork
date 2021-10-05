/**
 * Target
 */
public class Target {
    int height;
    String model[];
    public Target(int height, String[] model) {
        this.height = height;
        this.model = model;
    }
    int currLayer = 0;


    public String generateTarget(int layer) {
        currLayer++;
        return model[currLayer-1];
    }
    public void resetLayer() {
        currLayer = 0;
    }

}