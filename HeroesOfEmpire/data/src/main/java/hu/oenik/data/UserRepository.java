/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.data;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Viki
 */
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void add(User u) {
        users.add(u);
    }

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
}
