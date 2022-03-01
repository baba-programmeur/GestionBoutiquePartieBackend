package sn.faty.Tech.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.faty.Tech.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>
{
      User findUserByNom(String nom);

    Long deleteByIdUser(User user);

    // Optional<User> findById(Long idUser);
   
  //   User save(User user);

 // String deleteById(long userId);
   
  User findByIdUser(Long id);

}
