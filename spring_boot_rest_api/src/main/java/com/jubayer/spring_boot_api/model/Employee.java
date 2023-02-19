package com.jubayer.spring_boot_api.model;

import lombok.Setter;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "age")
    private Long age;
	
	@NotEmpty(message = "empty data of name fill now")
	@Column(name = "name")
    private String name;

	@NotEmpty(message = "empty data of email fill now")
	@Column(name = "email")
    private String email;

	@NotEmpty(message = "empty data of department fill now")
	@Column(name = "department")
    private String department;
	
	@Column(name = "location")
    private String location;
	
	
	@CreationTimestamp
	@Column(name = "create_at", nullable = false,updatable = false)
	private Date createAt;
	
	@UpdateTimestamp
	@Column(name  = "update_at")
	private Date updateAt;
	
	
	

}

//insert into employee(age,name,email,department,location) values(30,'utsso','utsso@hmail.com','SWE','India');