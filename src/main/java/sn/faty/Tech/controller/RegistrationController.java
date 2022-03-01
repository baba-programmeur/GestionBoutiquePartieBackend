package sn.faty.Tech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.faty.Tech.entity.User;
import sn.faty.Tech.service.RegistrationService;

@RestController
@RequestMapping("/api/v1/")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService ;
    @PostMapping("/register")
    public User register(@RequestBody User user ) throws  Exception {
        String login = user.getLogin();

        if (login != null && !"".equals(login))
        {
            User userObj = registrationService.fetchByLogin(login);

            if (userObj != null)
            {
                throw new Exception("lutilisatur avec le login" + login + "existe deja");
            }
        }
            User userObj = null;
            userObj = registrationService.save(user);
            return userObj ;
    }
}
