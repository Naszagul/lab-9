package services;

import dataaccess.UserDB;
import models.User;

public class AccountService {

    public static boolean forgotPassword(String email) {

        UserDB userDB = new UserDB();

        try {
            //User user = userDB.get(email);
            String subject="test";
            String body="something";
            GmailService.sendMail(email, subject, body, true);
            return true;

        } catch (Exception e) {

            }
        return false;
    }
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
}
