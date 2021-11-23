package com.bridgelabz.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.dto.BookDetailsDTO;
import com.bridgelabz.bookstore.model.BookDetails;

@Repository
public interface IBookRepository extends JpaRepository<BookDetails,Integer>
{
	public Optional<BookDetails> findByBookName(String name);
	
}
