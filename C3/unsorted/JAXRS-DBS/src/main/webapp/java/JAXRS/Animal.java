package webapp;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class Animal implements Serializable {
    private String id, name, birthdate, species, weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
