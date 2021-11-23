package com.bridgelabz.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.model.BookUser;

@Repository
public interface IUserRepository extends JpaRepository<BookUser,Long>
{
	public Optional<BookUser> findByEmailIdAndPassword(String emailId,String password);
	public Optional<BookUser> findByEmailId(String emailId);
}
