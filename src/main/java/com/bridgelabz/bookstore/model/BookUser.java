package com.bridgelabz.bookstore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.bookstore.dto.BookUserDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users_list")
@Data
@NoArgsConstructor
public class BookUser 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id")
	private long id;
	private String fullName;
	@Column(name = "user_DOB")
	private LocalDate dob;
	private String address;
	private LocalDate registerDate;
	private LocalDate updatedDate ;
	private String emailId;
	private String password;


	/**
	 * Conturctor for updating exiting user Data
	 */
	public BookUser(long userid,BookUserDTO dto) {
		super();
		this.id = id;
		this.fullName = dto.getFullName();
		this.dob = dto.getDob();
		this.address = dto.getAddress();
		this.updatedDate = dto.getUpdatedDate().now();
		this.emailId = dto.getEmailId();
	}

	
	/**
	 * Constructor for Creating new user via registration
	 * @param dto ---> geting data from userdto and setting-up values here for creation
	 */
	
	public BookUser(BookUserDTO dto)
	{
		this.id = id;
		this.fullName = dto.getFullName();
		this.dob = dto.getDob();
		this.address = dto.getAddress();
		this.registerDate = dto.getRegisterDate().now();
		this.emailId = dto.getEmailId();
		this.password = dto.getPassword();
	}
	
	/**
	 * Resting user Password
	 * @param user ----> settingup previous view as it is
	 * @param newPassword -----> settingup new password by this variable
	 */
	
	public BookUser(BookUser user,String password)
	{
		this.id = user.id;
		this.fullName = user.fullName;
		this.dob = user.dob;
		this.address = user.address;
		this.registerDate = user.registerDate;
		this.updatedDate = user.registerDate;
		this.emailId = user.emailId;
		this.password = password;
	}
}
