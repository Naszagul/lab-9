package services;

import dataaccess.UserDB;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {

    public static boolean forgotPassword(String email, String path) {

        UserDB userDB = new UserDB();

        try {
            //User user = userDB.get(email);
            String to = email; //user.getEmail();
            String subject = "Notes App Login";
            String template = path + "/emailtemplates/email.html";

            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", "matt");//user.getFirstName());
            tags.put("lastname", "lipsy");//user.getLastName());
            tags.put("date", (new java.util.Date()).toString());

            GmailService.sendMail(to, subject, template, tags);
           
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
