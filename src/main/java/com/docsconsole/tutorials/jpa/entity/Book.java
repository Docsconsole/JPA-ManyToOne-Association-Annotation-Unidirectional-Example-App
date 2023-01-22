package com.docsconsole.tutorials.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@Getter
@Setter

public class Book {

	public Book() {
	}

	public Book( String bookName, Double bookPrice,Author author) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "BOOK_PRICE")
	private Double bookPrice;

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID", nullable = false,foreignKey = @ForeignKey(name = "BOOKS_FK"))
	private Author author;
}