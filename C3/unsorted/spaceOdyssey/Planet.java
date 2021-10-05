public class Planet {
    String planetName;
    double temperature, gravity, distanceFromEarth;

    public Planet(String planetName, double distanceFromEarth, double gravity, double temperature) {
        this.planetName = planetName;
        this.distanceFromEarth = distanceFromEarth;
        this.gravity = gravity;
        this.temperature = temperature;
    }

    public String getName() {
        return this.planetName;
    }

    public double getDist() {
        return this.distanceFromEarth;
    }

    public double getGrav() {
        return this.gravity;
    }

    public double getTemp() {
        return this.temperature;
    }

}