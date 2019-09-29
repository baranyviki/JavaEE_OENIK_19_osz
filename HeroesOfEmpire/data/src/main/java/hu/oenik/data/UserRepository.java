/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

/**
 *
 * @author Viki
 */
//@Singleton
public class UserRepository {

    public static final UserRepository instance = new UserRepository();
    private List<User> users = new ArrayList<>();

    public void registration(String pName, String pPassword) throws RegistrationException {
        for (User u : users) {
            if (u.getName().equals(pName)) {
                throw new RegistrationException();
            }
        }
        User nUser = new User(pName, pPassword, false);
        users.add(nUser);
    }

    public boolean login(String pName, String pPass) {
        for (User u : users) {
            if (u.getName().equals(pName) && u.getPassword().equals(pPass)) {
                return true;
            }
        }
        return false;
    }

}
