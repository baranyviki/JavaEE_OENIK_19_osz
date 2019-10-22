/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import exceptions.LoginException;
import exceptions.RegistrationException;
import hu.oenik.data.User;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;
import repos.UserRepository;

/**
 *
 * @author Viki
 */
@Singleton
public class UserService {

    @Inject
    UserRepository userRepository;

    public void registration( String userName, String pPassword)
    throws RegistrationException{
        try {
           User u =  userRepository.getUserByName(userName);
           if(u == null)
           {
               userRepository.add(new User(userName, pPassword, false));
           }
        } catch (Exception ex) {
               throw new RegistrationException();
        }

    }

    public User login(String pUserName, String pPass) throws LoginException {
        try {
            return userRepository.getUser(pUserName, pPass);
        } catch (Exception ex) {
            ex.getMessage();
            throw new LoginException();
        }

    }
}