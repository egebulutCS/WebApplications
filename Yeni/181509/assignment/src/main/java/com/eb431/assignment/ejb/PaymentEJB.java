package com.eb431.assignment.ejb;

import com.eb431.assignment.entity.Notifications;
import com.eb431.assignment.entity.SystemUser;
import com.eb431.assignment.entity.TransactionHistory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author eb431
 */
@Stateless
@TransactionAttribute(REQUIRED)
public class PaymentEJB {

    @PersistenceContext
    EntityManager em;

    public PaymentEJB() {
    }

    public void sendPayment(String username, int amount, String targetUser) {
        Query q = em.createNativeQuery("SELECT ID FROM APP.SYSTEMUSER WHERE USERNAME = '" + username + "'");
        List l = q.getResultList();
        SystemUser e = em.find(SystemUser.class, l.get(0));
        if (e.getBalance() >= amount) {
            Query p = em.createNativeQuery("SELECT ID FROM APP.SYSTEMUSER WHERE USERNAME = '" + targetUser + "'");
            List k = p.getResultList();
            if (!k.isEmpty()) {
                e.setBalance(e.getBalance() - amount);
                SystemUser t = em.find(SystemUser.class, k.get(0));
                //currency conversion
                t.setBalance(t.getBalance() + amount);
                
                TransactionHistory th = new TransactionHistory(username, amount, targetUser);
                
                em.persist(t);
                em.persist(e);
                em.persist(th);
                em.flush();
            }
        }
    }

    public void requestPayment(String targetUser, int amount, String username) {
        List l = em.createNativeQuery("SELECT ID FROM APP.SYSTEMUSER WHERE USERNAME = '" + username + "'").getResultList();
        SystemUser e = em.find(SystemUser.class, l.get(0));
        List k = em.createNativeQuery("SELECT ID FROM APP.SYSTEMUSER WHERE USERNAME = '" + targetUser + "'").getResultList();
        if(!k.isEmpty()){

            Notifications n = new Notifications(username, amount, targetUser);
            em.persist(n);
            em.persist(e);
            em.flush();
        }
    }
    
    public void accept(String username, int amount, String requester){
        sendPayment(username, amount, requester);
        String sql = "DELETE FROM APP.NOTIFICATIONS WHERE REQUESTER = '" + requester + "' AND AMOUNT = " + amount + " AND TARGET = '" + username + "'";
        em.createNativeQuery(sql).executeUpdate();
    }
    
    public void reject(String username, int amount, String requester){
        String sql = "DELETE FROM APP.NOTIFICATIONS WHERE REQUESTER = '" + requester + "' AND AMOUNT = " + amount + " AND TARGET = '" + username + "'";
        em.createNativeQuery(sql).executeUpdate();
    }
    
    public double getUserBalance(String username){
        List l = em.createNativeQuery("SELECT ID FROM APP.SYSTEMUSER WHERE USERNAME = '" + username + "'").getResultList();
        long id = (long) l.get(0);
        SystemUser e = em.find(SystemUser.class, id);
        return e.getBalance();
    }
    
    public ArrayList getUserTransactions(String username){
        List l = em.createNativeQuery("SELECT SENDER, AMOUNT, TARGET FROM APP.TRANSACTIONHISTORY WHERE SENDER = '" + username + "'").getResultList();
        ArrayList n = new ArrayList();
        for(Object result : l){
            Object[] r = (Object[]) result;
            ArrayList m = new ArrayList();
            for (Object r1:r){
                System.out.println(r1.toString());
                m.add(r1.toString());
            }
            n.add(m);
        }
        return n;
    }
    
    public ArrayList getUserNotifications(String username){
        List l = em.createNativeQuery("SELECT REQUESTER, AMOUNT, TARGET FROM APP.NOTIFICATIONS WHERE TARGET = '" + username + "'").getResultList();
        ArrayList n = new ArrayList();
        for(Object result : l){
            Object[] r = (Object[]) result;
            ArrayList m = new ArrayList();
            for (Object r1:r){
                System.out.println(r1.toString());
                m.add(r1.toString());
            }
            n.add(m);
        }
        return n;
    }
    
    public ArrayList getAdminTransactions(){
        List l = em.createNativeQuery("SELECT SENDER, AMOUNT, TARGET FROM APP.TRANSACTIONHISTORY").getResultList();
        ArrayList n = new ArrayList();
        for(Object result : l){
            Object[] r = (Object[]) result;
            ArrayList m = new ArrayList();
            for (Object r1:r){
                System.out.println(r1.toString());
                m.add(r1.toString());
            }
            n.add(m);
        }
        return n;
    }
    
    public ArrayList getUserList(){
        List l = em.createNativeQuery("SELECT USERNAME, USERPASSWORD, CURRENCY, BALANCE FROM APP.SYSTEMUSER").getResultList();
        ArrayList n = new ArrayList();
        for(Object result : l){
            Object[] r = (Object[]) result;
            ArrayList m = new ArrayList();
            for (Object r1:r){
                System.out.println(r1.toString());
                m.add(r1.toString());
            }
            n.add(m);
        }
        return n;
    }
}
