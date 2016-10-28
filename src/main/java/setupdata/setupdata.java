/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setupdata;

import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

/**
 *
 * @author xboxm
 */
public class setupdata {
    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("smpu");
        EntityManager em = emf.createEntityManager();
        
        /* Create user */
        User u = new User();
        u.setUserName("Peter");
        u.setPassword(PasswordStorage.createHash("test"));
        List<String> uRoles = new ArrayList();
        uRoles.add("User");
        u.setRoles(uRoles);
        
        /* Create user */
        User a = new User();
        a.setUserName("Anne");
        a.setPassword(PasswordStorage.createHash("test"));
        List<String> aRoles = new ArrayList();
        aRoles.add("Admin");
        a.setRoles(aRoles);
        
        em.getTransaction().begin();
        
        em.persist(u);
        em.persist(a);
        
        em.getTransaction().commit();
        em.close();
    }
}
