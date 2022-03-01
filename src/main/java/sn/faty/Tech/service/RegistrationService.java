package sn.faty.Tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.Tech.entity.User;
import sn.faty.Tech.repositry.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepo;

    public User save(User user)
    {
        return registrationRepo.save(user);
    }

    public User fetchByLogin(String login)
    {
      return  this.registrationRepo.findByLogin(login);
    }

}
