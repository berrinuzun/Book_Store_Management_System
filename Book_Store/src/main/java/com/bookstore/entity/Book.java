package com.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor	@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int ID;
	
	@Column(name = "Book Name", nullable = false)
	private String bookName;
	
	@Column(name = "Author Name", nullable = false)
	private String authorName;
	
	@Column(name = "Price", nullable = false)
	private double price;
	
	@Column(name = "Page")
	private int page;
	
	@Column(name = "Book Genre")
	private BookGenre bookGenre;
	
}
