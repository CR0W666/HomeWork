package webapp;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class Main {


    public static void main(String[] args) {
        public ArrayList<Animal> animals = new ArrayList<>();
        databaseResource = new DatabaseResource();
        animals = databaseResource.getAllAnimals();

        System.out.println(animals);

    }
}
