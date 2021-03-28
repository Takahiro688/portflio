package com.example.demo;

import javax.persistence.*;
//import javax.persistence.OneToMany;
import java.util.List;
@Entity
@Table
public class LIbraryDB {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column
	private long id;
	
	@Column(length = 20 ,nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String streetadress;
	
	@Column(length=20, nullable = false)
	private String contact;
	
	@Column(length = 50, nullable =false)
	private String mail;
	
	@Column(nullable = false)
	private String gender;
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getStreetadress() {return streetadress;}
	public void setStreetadress(String streetadress) {this.streetadress = streetadress;}
	
	public String getContact() {return contact;}
	public void setContact(String contact) {this.contact = contact;}
	
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	@OneToMany(mappedBy = "libraryDB")
	private List<UserDB> userDB;

	public List<UserDB> getUserDB() {
		return userDB;
	}
	public void setUserDB(List<UserDB> userDB) {
		this.userDB = userDB;
	}
	
	
}
