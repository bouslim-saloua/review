/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import javax.ejb.Stateless;

@Stateless
public class AuthUser {

    private User curUser;
    
    public void signOut() {
        curUser = null;
    }

    public void signIn(User user) {
        curUser = user;
    }

    public User getCurUser() {
        return curUser;
    }

    public void setCurUser(User curUser) {
        this.curUser = curUser;
    }

}
