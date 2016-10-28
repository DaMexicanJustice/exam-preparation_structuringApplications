package facades;

import security.IUserFacade;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    /*When implementing your own database for this seed, you should NOT touch any of the classes in the security folder
    Make sure your new facade implements IUserFacade and keeps the name UserFacade, and that your Entity User class implements 
    IUser interface, then security should work "out of the box" with users and roles stored in your database */
    //private final  Map<String, IUser> users = new HashMap<>();
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("smpu");
    private static EntityManager em = emf.createEntityManager();

    public UserFacade() {
        //Test Users
        /*
    User user = new User("user","test");
    user.addRole("User");
    users.put(user.getUserName(),user );
    User admin = new User("admin","test");
    admin.addRole("Admin");
    users.put(admin.getUserName(),admin);
    
    User both = new User("user_admin","test");
    both.addRole("User");
    both.addRole("Admin");
    users.put(both.getUserName(),both );
         */
    }

    @Override
    public IUser getUserByUserId(String id) {
        //return users.get(id);
        IUser tmp = em.createNamedQuery("User.findByUserName", User.class).setParameter("userName", id).getSingleResult();
        return tmp;
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        User tmp = em.createNamedQuery("User.findByUserName", User.class).setParameter("userName", userName).getSingleResult();

        if (tmp == null) {
            return null;
        }

        try {
            if (PasswordStorage.verifyPassword(password, tmp.getPassword())) {
                return tmp.getRoles();
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;

    }

}
