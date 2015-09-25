package firstDb.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import firstDb.modal.User;
import firstDb.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	//private List<User> userList = null;

	@RequestMapping(method=RequestMethod.GET)
	public List<User> getUserList() {
		return userRepo.findAll();
	}

	

	@RequestMapping(method = RequestMethod.POST)
	public User addItem(@RequestBody User user) {
		user.setId(null);
		return userRepo.saveAndFlush(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findUser(@PathVariable Integer id){
		return userRepo.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User updateItem(@RequestBody User updatedUser, @PathVariable Integer id) {
		User user = userRepo.getOne(id);
		user.setEmail(updatedUser.getEmail());
		user.setMobile(updatedUser.getMobile());
		user.setName(updatedUser.getName());
		user.setPassword(updatedUser.getPassword());
		user.setSex(updatedUser.isSex());
		user.setBirthday(updatedUser.getBirthday());
		return userRepo.saveAndFlush(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable Integer id) {
		userRepo.delete(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { EmptyResultDataAccessException.class, EntityNotFoundException.class })
	public void handleNotFound() {
	}

}
