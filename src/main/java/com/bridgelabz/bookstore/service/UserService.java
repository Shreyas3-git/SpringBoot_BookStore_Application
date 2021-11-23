package com.bridgelabz.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookstore.dto.BookUserDTO;
import com.bridgelabz.bookstore.dto.ForgotPasswordDTO;
import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.model.BookUser;
import com.bridgelabz.bookstore.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements IUserService
{
	@Autowired
	private IUserRepository userRepository;

	
	@Override
	public List<BookUser> findAllUsers() 
	{
		List<BookUser> allUsers = new ArrayList<>();
		userRepository.findAll().forEach(allUsers :: add);
		return allUsers;
	}

	
	@Override
	public BookUser registerNewUser(BookUserDTO dto,long id) 
	{
		Optional<BookUser> users = userRepository.findById(id);
		
		if (users.isPresent()) 
		{
			log.error("User already exist Exception:");
			return null;
		}
		else 
		{
			BookUser user = new BookUser();
			user.setFullName(dto.getFullName());
			user.setAddress(dto.getAddress());
			user.setDob(dto.getDob());
			user.setEmailId(dto.getEmailId());
			user.setPassword(dto.getPassword());
			user.setRegisterDate(dto.getRegisterDate().now());
			userRepository.save(user);
			return user;
		}
		
	}

	@Override
	public Optional<BookUser> UserLogin(LoginDTO dto) 
	{
		Optional<BookUser> userLogin = userRepository.findByEmailIdAndPassword(dto.emailId, dto.password);
		
		if (userLogin.isPresent()) 
		{
			log.info("user logged in successfully");
		}
		else 
		{
			log.error("User not Found Exception:");
		}
		return null;
	}

	@Override
	public Optional<BookUser> updateUser(BookUserDTO dto,long id) 
	{
		Optional<BookUser> user = userRepository.findById(id);
		if (user.isPresent()) 
		{			
			user.get().setFullName(dto.getFullName());
			user.get().setDob(dto.getDob());
			user.get().setAddress(dto.getAddress());
			user.get().setEmailId(dto.getEmailId());
			user.get().setUpdatedDate(dto.getUpdatedDate().now());
			userRepository.save(user.get());
			return user;
		}
		else 
		{
			log.error("User not found Exception:");
			return null;
		}
	}

	@Override
	public Optional<BookUser> forgotPassword(ForgotPasswordDTO dto) 
	{
		if (dto.getNewPassword().equals(dto.getConfirmPassword())) 
		{
			Optional<BookUser> user = userRepository.findByEmailId(dto.getEmailId());
			if (user.isPresent()) 
			{
				user.get().setPassword(dto.getNewPassword());
				userRepository.save(user.get());
				return user;
			} 
			else 
			{
				log.error("User not found Exception:");
			}
			return null;
		}
		else
		{
			log.error("Entered password is not correct:");
			return null;
		}
	}

	@Override
	public Optional<BookUser> deleteUser(long id) 
	{
		Optional<BookUser> deleteuser = userRepository.findById(id);
		if (deleteuser.isPresent()) 
		{
			userRepository.delete(deleteuser.get());
			return null;
		}
		else 
		{
			log.error("User not found Exception:");
			return null;
		}
	}
	
}
