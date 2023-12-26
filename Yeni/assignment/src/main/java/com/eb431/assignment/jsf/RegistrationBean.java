package com.eb431.assignment.jsf;

import com.eb431.assignment.ejb.AdminService;
import com.eb431.assignment.entity.LoginBean;
import com.eb431.assignment.ejb.PaymentEJB;
import com.eb431.assignment.ejb.UserService;
import com.eb431.assignment.entity.Notifications;
import com.eb431.assignment.entity.SystemUser;
import com.eb431.assignment.entity.TransactionHistory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author eb431
 */
@Named(value = "registrationBean")
@SessionScoped
public class RegistrationBean implements Serializable{

    @EJB
    UserService usrSrv;
    
    @EJB
    AdminService adminSrv;
    
    String adminName;
    String adminPassword;
    
    String username;
    String userpassword;
    String currency;
    double balance;
    
    @EJB
    PaymentEJB paymentHndlr;
    
    long id;
    int amount;
    String targetUser;
    
    @PersistenceContext
    EntityManager em;
    
    @EJB
    LoginBean login;

    public RegistrationBean() {
        
    }
    
    public String register(){
        
        this.balance = 1000;
            switch (currency) {
                case "Pounds":
                    this.balance = 1000;
                    break;
                case "Dollars":
                    this.balance = 1000 * 1.24;
                    break;
                case "Euros":
                    this.balance = 1000 * 1.14;
                    break;
                default:
                    break;
            }
        
        usrSrv.registerUser(username, userpassword, currency, balance);
        return "index";
    }

    public UserService getUsrSrv() {
        return usrSrv;
    }
    
    public String registerAdmin(){
        adminSrv.registerAdmin(adminName, adminPassword);
        return "admin";
    }

    public void setUsrSrv(UserService usrSrv) {
        this.usrSrv = usrSrv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public double getUserBalance(){
        return paymentHndlr.getUserBalance(username);
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }

    public PaymentEJB getPaymentHndlr() {
        return paymentHndlr;
    }

    public void setPaymentHndlr(PaymentEJB paymentHndlr) {
        this.paymentHndlr = paymentHndlr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }
    
    public String send(){
        paymentHndlr.sendPayment(username, amount, targetUser);
        return "transactions";
    }
    
    public String request(){
        paymentHndlr.requestPayment(targetUser, amount, username);
        return "notifications";
    }
    
    public ArrayList getUserTransactions(){
        return paymentHndlr.getUserTransactions(username);
    }
    
    public ArrayList getAdminTransactions(){
        return paymentHndlr.getAdminTransactions();
    }
    
    public ArrayList getUserList(){
        return paymentHndlr.getUserList();
    }
    
    public ArrayList getUserNotifications(){
        return paymentHndlr.getUserNotifications(username);     
    }
    
    public String accept(){
        paymentHndlr.accept(username, amount, targetUser);
        return "transactions";
    }
    
    public String reject(){
        paymentHndlr.reject(username, amount, targetUser);
        return "transactions";
    }
    
    public String login(){
        login.login(username, userpassword);
        return "index";
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
