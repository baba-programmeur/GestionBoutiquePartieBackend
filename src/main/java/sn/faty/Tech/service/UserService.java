package sn.faty.Tech.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.faty.Tech.Exception.RessourceNotFoundException;
import sn.faty.Tech.entity.User;
import sn.faty.Tech.repositry.UserRepository;

@Service
public class UserService 

{
  //methode globale transactionnelle @transact
	
	@Autowired

	private  UserRepository userRepo;
  public ResponseEntity <User> saveUser(User user)
	{
    User user1= this.userRepo.save(user);
		
   if(user1 !=null)
   {
	return new ResponseEntity<>(HttpStatus.OK);
   }
   else
   {
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
	}

  public List<User> getAllUtilisateur()
  {
	  return userRepo.findAll();
  }

  public ResponseEntity<User> getOneUserById(Long Id) throws RessourceNotFoundException 
  
  {
	  User Utilisateur = userRepo.findById(Id).orElseThrow(() -> new RessourceNotFoundException("Utilisateur not found  id :: " + Id));
	  
		return ResponseEntity.ok().body(Utilisateur);
  }
	public User getUserByName(String name)
	{
		return this.userRepo.findUserByNom(name);
	}

	public ResponseEntity <User> updateUser(User user )
	{
		//User user
	//Optional<User> user= userRepo.findById(user.getIdUser()).orElse(null);
		
Optional<User> UserAModif=this.userRepo.findById(user.getIdUser());
  
    if( UserAModif.isPresent())
    {
    User existingUser =  UserAModif.get();
  
    existingUser.setLogin(user.getLogin());
    
    existingUser.setMdp(user.getMdp());

    existingUser.setNom(user.getNom());

    existingUser.setPrenom(user.getPrenom());
    
    existingUser.setTel(user.getTel());
    
  //  existingUser.setEmail(user.getEmail())

    return new ResponseEntity<>(this.userRepo.save(existingUser), HttpStatus.OK);
    }
    else
    {
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	}
	public Map<String, Boolean> deleteOneUser(Long id) throws RessourceNotFoundException
    {
        User user = this.userRepo.findById(id).orElseThrow(() -> new  RessourceNotFoundException("Utilisateur n'est pas trouvé:" + id));

        this.userRepo.deleteById(user.getIdUser());

        Map<String, Boolean> response = new HashMap<>();

        response.put("delete", Boolean.TRUE);

        return response;
    }
    public ResponseEntity<String> deleteAllUser()
    {
        this.userRepo.deleteAll();

        return  new ResponseEntity("All Users have been deleted", HttpStatus.OK);
    }
}