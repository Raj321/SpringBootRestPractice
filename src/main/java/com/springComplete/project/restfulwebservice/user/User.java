package com.springComplete.project.restfulwebservice.user;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.assertj.core.description.Description;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="This is the USER details ")
@Entity
public class User {
	
 
	@Id
	@GeneratedValue
  private Integer id;
  
  
  @Size(min=2, message="name should have atleast 2 character")
 // @ApiModelProperty(notes="Name should have atleast  2 character ")
  private String name;
  
  @Past
 // @ApiModelProperty(notes="birthdate can not be in past")
  private Date birthDate;
  
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

protected User() {
	
}

public User(Integer id, String name, Date birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getBirthDate() {
	return birthDate;
}

public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
}


	
	
}
