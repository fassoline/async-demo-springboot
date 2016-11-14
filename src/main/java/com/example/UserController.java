package com.example;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{login}", method = GET)
    public User get(@PathVariable String login, HttpServletResponse response) {

        User user = userService.findUser(login);

        if (user == null) {
            response.setStatus(404);
        }

        return user;
    }

}
