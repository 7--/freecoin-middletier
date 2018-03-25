package tk.freecoin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import tk.freecoin.beans.*;
import tk.freecoin.repository.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class UsersController {

	@Autowired
	UsersDao usersDao;

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Users> getUsers() {
		List<Users> users = usersDao.findAllByOrderByCorrectAnswersDesc();
		return users;
	}

	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users login(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = false) String password) {
		Users myUser = usersDao.findByEmail(email);
		if (myUser == null) {
			// return "{\"validuser\":\"false\"}";
			return null;
		}
		String myPassword = myUser.getPassword();
		if (myPassword.equals(password)) {
			// return "{\"validuser\":\"true\"}";
			return myUser;
		} else {
			// return "{\"validuser\":\"false\"}";
			return null;
		}

	}

	@GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users register(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "fname", required = true) String fname,
			@RequestParam(value = "lname", required = true) String lname) {

		Users newuser = new Users(email, password, 0, 0, fname, lname);

		return usersDao.save(newuser);
	}

	@GetMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public void update_user(@RequestParam(value = "userid", required = true) int userid,
			@RequestParam(value = "correctAnswers", required = true) int correctAnswer,
			@RequestParam(value = "wrongAnswers", required = true) int wrongAnswer) {

		Users user = usersDao.findByUserid(userid);

		user.setCorrectAnswers(correctAnswer);
		user.setWrongAnswers(wrongAnswer);

		usersDao.save(user);
	}

	@GetMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete_user(@RequestParam(value = "userid", required = true) int userid) {

		Users user = usersDao.findByUserid(userid);
		usersDao.delete(user);
	}

}
