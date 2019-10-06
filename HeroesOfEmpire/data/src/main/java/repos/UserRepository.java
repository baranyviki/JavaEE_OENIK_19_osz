/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import exceptions.RegistrationException;
import exceptions.LoginException;
import hu.oenik.data.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viki
 */
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void registration(String fullName, String userName, String pPassword) throws RegistrationException {
        for (User u : users) {
            if (u.getName().equals(userName)) {
                throw new RegistrationException();
            }
        }
        User nUser = new User(fullName, userName, pPassword, false);
        users.add(nUser);
    }

    public User login(String pUserName, String pPass) throws LoginException {
        for (User u : users) {
            if (u.GetUserName().equals(pUserName) && u.getPassword().equals(pPass)) {
                return u;
            }
        }
        throw new LoginException();
    }

    public UserRepository() {

    }

    public void add(User u) {
        users.add(u);
    }
}
