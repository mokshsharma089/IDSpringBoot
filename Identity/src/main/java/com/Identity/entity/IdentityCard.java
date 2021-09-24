package com.Identity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdentityCard {

	@Id
	String idNumber;
	String name;
	String address;
	long phoneNo;
	public IdentityCard() {
		
	}
	public IdentityCard(String idNumber, String name, String address, long phoneNo) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "IdentityCard [idNumber=" + idNumber + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo
				+ "]";
	}
	
	
}
