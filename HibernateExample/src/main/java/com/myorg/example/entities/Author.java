package com.myorg.example.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Table(name="AUTHOR")
@Entity
public class Author implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long authorId;	
	@Column(name="AUTHOR_FIRST_NAME")
	private String firstName;
	@Column(name="AUTHOR_LAST_NAME")
	private String lastName;
	@OneToMany(mappedBy="author",cascade=CascadeType.ALL)	
	private Set<Address> Addressess;
	@Version
	private long version;
	
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Address> getAddressess() {
		return Addressess;
	}
	public void setAddressess(Set<Address> addressess) {
		Addressess = addressess;
	}
	
	

}
