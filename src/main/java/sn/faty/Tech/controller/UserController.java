package sn.faty.Tech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.faty.Tech.entity.User;
import sn.faty.Tech.service.UserService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService serviceUser;

	@PostMapping("/ajoutUser")

	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		  return serviceUser.saveUser(user);
		  
	}
	@PutMapping("/modifierUser")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		return serviceUser.updateUser(user);
	}
	@GetMapping("/rechercheToutUser")

	public List<User> rechercheToutUtilisatur()
	{
	 return	serviceUser.getAllUtilisateur();
	}
	 @GetMapping("/user/{id}")
	public ResponseEntity<User> getOneUserById(@PathVariable Long id)
	 {
		 return serviceUser.getOneUserById(id);
	 }

	 @DeleteMapping("/deleteAllUser")
	public ResponseEntity<String> deleteAllUser()
	 {
		 return serviceUser.deleteAllUser();
	 }

	 @DeleteMapping("/deleteOneUser/{id}")
	public Map<String,Boolean> deleteOneUser(@PathVariable(value = "id") Long id)

	 {
		return  serviceUser.deleteOneUser(id);

	 }
}
