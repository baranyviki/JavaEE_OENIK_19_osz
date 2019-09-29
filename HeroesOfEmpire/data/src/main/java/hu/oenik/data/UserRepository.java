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

    public void registration(String fullName,String userName, String pPassword) throws RegistrationException {
        for (User u : users) {
            if (u.getName().equals(userName)) {
                throw new RegistrationException();
            }
        }
        User nUser = new User(fullName,userName, pPassword, false);
        users.add(nUser);
    }

    public User login(String pUserName, String pPass) throws LoginException{
        for (User u : users) {
            if (u.GetUserName().equals(pUserName) && u.getPassword().equals(pPass)) {
                return u;
            }
        }
        throw new LoginException();
    }

    public UserRepository() {
        users.add(new User("Eleven","el","11",false));
        
    }

}
