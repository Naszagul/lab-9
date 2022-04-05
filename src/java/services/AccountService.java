package services;

import dataaccess.UserDB;
import models.User;

public class AccountService {

    public static boolean forgotPassword(String email) {

        UserDB userDB = new UserDB();

        try {

            User user = userDB.get(email);
            String subject="Password Recovery";
            String body=String.format("Hi %s %s,%nHere are your credentials:%nEmail Address: %s%nPassword: %s", user.getFirstName(), user.getLastName(), user.getEmail(),user.getPassword());
            GmailService.sendMail(user.getEmail(), subject, body, true);

        } catch (Exception e) {
            return false;
            }
        return true;
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
