package com.myorg.example.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
@Table(name = "ADDRESS")
@Entity
public class Address implements Serializable {

	@SequenceGenerator(name = "address_seq", schema = "public", sequenceName = "address_seq", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private long addressId;
	@Column(name = "STREET_NAME")
	private String street;
	@Column(name = "CITY_NAME")
	private String city;
	@Column(name = "STATE_NAME")
	private String state;
	@Column(name = "ZIP_NAME")
	private String zip;
	@ManyToOne	
	@JoinColumn(name="authorId")
	private Author author;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
 	@Override
	public int hashCode() {		 
		return Pojomatic.hashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return Pojomatic.equals(this,obj);
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}

}
