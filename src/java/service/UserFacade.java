/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "ReviewProductPU")
    private EntityManager em;
    
     @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    

     public User findBylogin(String username) {
        return findBy("email", username);
    }
    
    public void save(User user) {
        create(user);
    }

    public int seConnecter(String email, String password) {
        User loadedUser = findBylogin(email);
        if (loadedUser == null) {
            return -1;
        } else if (!loadedUser.getPassword().equals(password)) {
            return -2;
        } else {
            return 1;
        }
    }

    public int seEnregister(User user) {
        create(user);
        User loadedUser = findBylogin(user.getEmail());
        if (loadedUser == null) {
            return -1;
        } else {
            return 1;
        }
    }

   
}
