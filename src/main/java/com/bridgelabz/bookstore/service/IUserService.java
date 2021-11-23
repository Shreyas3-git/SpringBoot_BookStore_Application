package com.bridgelabz.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.bookstore.dto.BookUserDTO;
import com.bridgelabz.bookstore.dto.ForgotPasswordDTO;
import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.model.BookUser;

public interface IUserService 
{
	public abstract List<BookUser> findAllUsers();
	public abstract BookUser registerNewUser(BookUserDTO dto,long id);
	public abstract Optional<BookUser> UserLogin(LoginDTO dto);
	public abstract Optional<BookUser> updateUser(BookUserDTO dto,long id);
	public abstract Optional<BookUser> forgotPassword(ForgotPasswordDTO dto);
	public abstract Optional<BookUser> deleteUser(long id);
}
