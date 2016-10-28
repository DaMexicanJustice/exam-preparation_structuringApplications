/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

/**
 *
 * @author xboxm
 */
public class mytest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("smpu");
        EntityManager em = emf.createEntityManager();
        
        User tmp = em.createNamedQuery("User.findByUserName", User.class).setParameter("userName", "user").getSingleResult();
        
        System.out.println("password is " + tmp.getPassword());
        try {
            System.out.println(PasswordStorage.verifyPassword("test", tmp.getPassword()));
        } catch (Exception ex) {
            System.out.println("fuck");
        }
    }
}
