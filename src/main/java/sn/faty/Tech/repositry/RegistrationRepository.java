package sn.faty.Tech.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.Tech.entity.User;

public interface RegistrationRepository extends JpaRepository<User,Long>
{
    User findByLogin (String login) ;
}
