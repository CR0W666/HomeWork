public class SpaceShip {
    String shipName;
    int range, speed;

    public SpaceShip(String shipName, int range, int speed) {
        this.shipName = shipName;
        this.range = range;
        this.speed = speed;
    }

    public String getName() {
        return this.shipName;
    }

    public int getRange() {
        return this.range;
    }

    public int getSpeed() {
        return this.speed;
    }
}