package com.example.demo;

import javax.persistence.*;
//import javax.persistence.ManyToOne;

@Entity
@Table
public class UserDB {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column
	private long id;
	
	@Column(length = 20 , nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String loandate;
	
	@Column(nullable = false)
	private String returndate;
	
	@Column(nullable = false)
	private String bookname;
	
	@Column(nullable = false)
	private String bookid;
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getLoandate() {return loandate;}
	public void setLoandate(String loandate) {this.loandate = loandate;}
	
	public String getReturndate() {return returndate;}
	public void setReturndate(String returndate) {this.returndate = returndate;}
	
	public String getBookname() {return bookname;}
	public void setBookname(String bookname) {this.bookname = bookname;}
	
	public String getBookid() {return bookid;}
	public void setBookid(String bookid) {this.bookid = bookid;}
	
	@ManyToOne
	private LIbraryDB libraryDB;

	public LIbraryDB getLibraryDB() {
		return libraryDB;
	}
	public void setLibraryDB(LIbraryDB libraryDB) {
		this.libraryDB = libraryDB;
	}
	
	
}
