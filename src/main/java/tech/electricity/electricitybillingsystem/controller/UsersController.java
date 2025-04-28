package tech.electricity.electricitybillingsystem.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.electricity.electricitybillingsystem.exception.DataNotFounException;
import tech.electricity.electricitybillingsystem.model.ElecBillModel;
import tech.electricity.electricitybillingsystem.model.UserModel;
import tech.electricity.electricitybillingsystem.services.UserService;

@RestController

@RequestMapping("/users")
@ControllerAdvice
public class UsersController {
	@Autowired
	private UserService userService;

	@GetMapping("/allusers")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		List<UserModel> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/find/{userid}")
	public ResponseEntity<UserModel> getUserById(@Valid @PathVariable("userid") Long id) throws DataNotFounException {
		System.out.print(id);
		UserModel user = userService.findUsersById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/findbills")
	public ResponseEntity<Map<UserModel, List<ElecBillModel>>> UserBills() {
		Map<UserModel, List<ElecBillModel>> userbills = userService.UserBills();
		return new ResponseEntity<>(userbills, HttpStatus.OK);
	}
	
	@GetMapping("/findbills/{userid}")
	public ResponseEntity<List<ElecBillModel>> UserBillsById(@Valid @PathVariable("userid") Long id) throws DataNotFounException {
		List<ElecBillModel>  userbills = userService.UserBillsById(id);
		return new ResponseEntity<>(userbills, HttpStatus.OK);
		
	}

	@PostMapping("/add")
	public ResponseEntity<UserModel> addUser(@Valid @RequestBody UserModel user) {
		UserModel newUser = userService.addUser(user);
		return new ResponseEntity<UserModel>(newUser, HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<UserModel> updateUser(@Valid @RequestBody UserModel user) throws DataNotFounException {
		UserModel updateuser = userService.updateUser(user);
		return new ResponseEntity<UserModel>(updateuser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable("userid") Long id) throws DataNotFounException {
		userService.deleteUser(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserModel> LoginByIdPass(@RequestBody UserModel user) {
		UserModel fetchedUser = userService.loginByIdPass(user);
		if (fetchedUser != null) {
			return new ResponseEntity<UserModel>(fetchedUser, HttpStatus.OK);
		}
		return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.UNAUTHORIZED);
	}
	
		
}
