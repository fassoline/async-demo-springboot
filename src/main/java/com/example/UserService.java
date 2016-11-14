package com.example;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private ADService adService;

    public User findUser(String login) {

        if (login.equals("admin")) {

            User user = new User("admin");

            setUserPasswdExpirationDate(user);

            return user;
        }

        return null;

    }

    private void setUserPasswdExpirationDate(User user) {

        Future<Calendar> future = adService.getExpirationDateFromLogin(user.getName());

        if (future != null) {
            try {
                Calendar expirationDate = future.get(1, TimeUnit.SECONDS);
                user.setPasswdExpirationDate(expirationDate);
            } catch (InterruptedException | ExecutionException | TimeoutException ex) {
                java.util.logging.Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
