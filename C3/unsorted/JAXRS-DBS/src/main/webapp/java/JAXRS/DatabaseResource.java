package webapp;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;

@Produces(MediaType.APPLICATION_JSON)
@Path("zoo")
public class DatabaseResource {

    @GET
    public Response getAllAnimals() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/c3zoo", "root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT Z.id, Z.jmeno, Z.narozen, D.nazev, Z.vaha FROM zvirata AS Z JOIN druhy AS D ON (D.id = Z.druh)");
        ArrayList<Animal> animals = new ArrayList<>();
        String id, name, species, weight, birthdate;

        while(result.next()) {
            Animal animal = new Animal();

            id = result.getString("id");
            animal.setId(id);
            
            name = result.getString("jmeno");
            animal.setName(name);

            species = result.getString("nazev");
            animal.setSpecies(species);

            weight = result.getString("vaha");
            animal.setId(id);

            birthdate = result.getString("narozen");
            animal.setId(id);

            animals.add(animal);
        }
        
        connection.close();
        return Response.ok(animals).build();
    }
}
