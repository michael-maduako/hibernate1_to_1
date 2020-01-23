package com.michael;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_020")
public class Address {
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private long id;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address() {
	}

	public Address(String street, String city, String country) {
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public long getId() {
		return id;
	}
}
