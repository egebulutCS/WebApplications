package com.eb431.assignment.ejb;

import com.eb431.assignment.entity.SystemUser;
import com.eb431.assignment.entity.SystemUserGroup;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eb431
 */
@Stateless
public class AdminService {

    @PersistenceContext
    EntityManager em;

    public AdminService() {
    }

    public void registerAdmin(String username, String userpassword) {
        try {
            SystemUser sys_user;
            SystemUserGroup sys_user_group;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = userpassword;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String paswdToStoreInDB = sb.toString();      
            
            sys_user = new SystemUser(username, paswdToStoreInDB, "Pounds", 1000000);
            sys_user_group = new SystemUserGroup(username, "admins");
            
            em.persist(sys_user);
            em.persist(sys_user_group);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

