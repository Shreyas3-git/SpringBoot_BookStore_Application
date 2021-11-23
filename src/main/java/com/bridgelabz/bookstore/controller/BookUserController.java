package com.bridgelabz.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.bridgelabz.bookstore.dto.BookUserDTO;
import com.bridgelabz.bookstore.dto.ForgotPasswordDTO;
import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.model.BookUser;
import com.bridgelabz.bookstore.service.IUserService;

@RestController
public class BookUserController 
{
	
	@Autowired
	private IUserService  bookUserServce;
	
	
	@GetMapping("/allusers")
	public ResponseEntity<ResponseDTO> getAllUsers()
	{
		List<BookUser> retriveAll = bookUserServce.findAllUsers();
		ResponseDTO dto = new ResponseDTO("All Users fetch successfully:",retriveAll);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	
	@PostMapping("/registeruser/{id}")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody BookUserDTO userdto,@PathVariable int id)
	{
		BookUser addUser = bookUserServce.registerNewUser(userdto,id);
		ResponseDTO dto = new ResponseDTO("User registered successfully:",addUser);
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	@PostMapping("/userlogin")
	public ResponseEntity<ResponseDTO> userLogin(@RequestBody LoginDTO logindto)
	{
		Optional<BookUser> login = bookUserServce.UserLogin(logindto);
		ResponseDTO dto = new ResponseDTO("User login successfully:",login);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<ResponseDTO> updateUserDetails(@RequestBody BookUserDTO userdto,@PathVariable long id)
	{
		Optional<BookUser> updateUser = bookUserServce.updateUser(userdto, id);
		ResponseDTO dto = new ResponseDTO("User updated successfully:",updateUser);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/forgotpassword")
	public ResponseEntity<ResponseDTO> forgotUserPassword(@RequestBody ForgotPasswordDTO passwordDTO)
	{
		Optional<BookUser> forgotPassword = bookUserServce.forgotPassword(passwordDTO);
		ResponseDTO dto = new ResponseDTO("password updated successfully:",forgotPassword);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable long id)
	{
		Optional<BookUser> deleteUser = bookUserServce.deleteUser(id);
		ResponseDTO dto = new ResponseDTO("User deleted successfully:",deleteUser);
		return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
	}
}
