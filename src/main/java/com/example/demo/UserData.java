package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

import javax.validation.constraints.Max ;
import javax.validation.constraints.Min ;
import javax.validation.constraints.NotNull ;
import javax.validation.constraints.Size ;
@SuppressWarnings("serial")
@Entity
@Table
public class UserData implements Serializable{
	
		@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column private long id;
		private static final long serialVersionUID = 1L;
		
		@Column(length = 20, nullable = false)
		private String name;
		@Column(length = 50, nullable = false)
		private String mail;
		@NotNull
		@Min(0)
		@Max(200)
		@Column(nullable = false)
		private Integer age;
		@Column(nullable = false)
		private String gender;
		@Column(nullable = false)
		private String pass;
		@Column(nullable = false)
		private String area;

		public long getId(){ return id; }
		public void setId(long id) { this.id = id; }
		public String getName(){ return name; }
		public void setName(String name) { this.name = name; }
		public String getMail(){ return mail; }
		public void setMail(String mail) { this.mail = mail; }
		public int getAge() { return age; }
		public void setAge(int age) {this.age = age;}
		public String getGender() {return gender;}
		public void setGender(String gender) {this.gender = gender;}
		public String getPass(){ return pass; }
		public void setPass(String pass) { this.pass = pass; }
		public String getArea() {return area;}
		public void setArea(String area) {this.area = area;}
}


