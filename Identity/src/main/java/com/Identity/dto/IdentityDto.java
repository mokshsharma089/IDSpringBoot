package com.Identity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.Identity.entity.IdentityCard;

public class IdentityDto {
//	Validation for this DTO would be done in Controller and Dto itself wheneve in controller we say @Valid in method ()
	@NotBlank(message="ID Number is a Mandatory Field")
	@Size(min=12,max=12,message="Id number should be of 12 digits")
	String idNumber;
	@NotBlank(message="Name is a Mandatory Field")
	@Pattern(regexp = "[a-zA-Z ]+",message="Name must be in Letters only")
	String name;
	String address;
	long phoneNo;
	public IdentityDto() {}
	public IdentityDto(
			@NotBlank(message = "ID Number is a Mandatory Field") @Size(min = 12, max = 12, message = "Id number should be of 12 digits") String idNumber,
			@NotBlank(message = "Name is a Mandatory Field") @Pattern(regexp = "[a-zA-Z]+", message = "Name must be in Letters only") String name,
			String address, long phoneNo) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public IdentityDto(String idNumber,String address) {
		this.idNumber = idNumber;
		this.address = address;
	}
	public IdentityDto(IdentityCard id) {
		super();
		this.idNumber=id.getIdNumber();
		this.name=id.getName();
		this.address=id.getAddress();
		this.phoneNo=id.getPhoneNo();
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
		return "IdentityDtoVC [idNumber=" + idNumber + ", name=" + name + ", address=" + address + ", phoneNo="
				+ phoneNo + "]";
	}
	public static IdentityCard prepareEntity(IdentityDto dto) {
		IdentityCard temp=new IdentityCard();
		temp.setIdNumber(dto.getIdNumber());
		temp.setName(dto.getName());
		temp.setAddress(dto.getAddress());
		temp.setPhoneNo(dto.getPhoneNo());
		return temp;
	}

}
