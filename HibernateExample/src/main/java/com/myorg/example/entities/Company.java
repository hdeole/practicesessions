package com.myorg.example.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Company implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	@SequenceGenerator(name="company_seq",sequenceName="company_seq")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="company_seq")
	private long companyId;
	@Column(name="COMAPNY_NAME")
	private String companyName;
	@Column(name="REVENUE")
	private double revenue;	
	@Version
	private long version;
	@OneToMany(mappedBy="company")
	private Set<Address> addresses;
	
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}	
	
}
