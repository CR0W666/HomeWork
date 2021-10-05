package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ApplicationScoped
public class UsersManager implements Serializable {

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getAllUsernames(){
        return userList;
    }

    public boolean createUser(User user) {
        user.setId(userList.size());
        return userList.add(user);
    }

    public User getUsername(int id) {
        return userList.stream()
                .filter(userListStream -> id == userListStream.getId())
                .findAny()
                .orElse(null);
    }

    public User getUserLevel(int id){
        return userList.stream()
                .filter(userListStream -> id == userListStream.getId())
                .findAny()
                .orElse(null);
    }

    public User getUserByName(String name) {
        return userList.stream()
                .filter(userListStream -> name.equals(userListStream.getUsername()))
                .findAny()
                .orElse(null);
    }

    public boolean removeUserName(int id){
        return  userList.remove(getUsername(id));
    }

}
