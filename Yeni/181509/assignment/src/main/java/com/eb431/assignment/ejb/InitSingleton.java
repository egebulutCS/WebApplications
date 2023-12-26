package com.eb431.assignment.ejb;

import com.eb431.assignment.entity.SystemUser;
import com.eb431.assignment.entity.SystemUserGroup;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*This EJB will be instantiated only once when the applciation is deployed - @Startup and @Singleton respectively*/
@Startup
@Singleton
public class InitSingleton {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void dbInit() {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = "admin";
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String paswdToStoreInDB = sb.toString();  
        
            SystemUser sys_user = new SystemUser("admin", paswdToStoreInDB, "Pounds", 1000000);
            SystemUserGroup sys_user_group = new SystemUserGroup("admin", "admins");
            
            em.persist(sys_user);
            em.persist(sys_user_group);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
