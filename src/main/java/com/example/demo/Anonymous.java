package com.example.demo;
import javax.persistence.*;
@Entity
@Table
public class Anonymous {
@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column
private long id;

@Column(nullable = false)
private String postcolumn;


@Column(nullable = false)
private String time;

public long getId() {return id;}
public void setId(long id) {this.id = id;}

public String getPostcolumn() {return postcolumn;}
public void setPostcolumn(String postcolumn) {this.postcolumn = postcolumn;}

public String getTime() {return time;}
public void setTime(String time) {this.time = time;}


}
