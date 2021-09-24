package com.Identity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Identity.dto.IdentityDto;
import com.Identity.entity.IdentityCard;
import com.Identity.exceptions.ExceptionConstants;
import com.Identity.exceptions.IdentityException;
import com.Identity.repository.IdentityRepository;

@Service
public class IdentityService {
	
	@Autowired
	IdentityRepository idRepo;
	
	@Autowired
	Validation validate;
	//creates new ID record
	public String createIdValidationInController(IdentityDto dto) {
		//Validation Performed in Controller
		String idFromDto=dto.getIdNumber();
		boolean alreadyExists=idRepo.existsById(idFromDto);
		if(alreadyExists==true) {
			return "Id Exists Already Can't Create New Identity";
		}
		IdentityCard newlyCreated=idRepo.saveAndFlush(IdentityDto.prepareEntity(dto));
		return "New Id :- " + newlyCreated.toString() + "Created";
	}
	//creates new ID record
	public boolean createIdValidationAtServiceLayer(IdentityDto dto) throws IdentityException{
		//Validation Performed in Service Layer
		boolean isNameValid,isIdValid;
		isIdValid=validate.validateIdentityNumber(dto.getIdNumber());
		isNameValid=validate.validateName(dto.getName());
		if(isIdValid&&isNameValid) {
			boolean idAlreadyExists=idRepo.existsById(dto.getIdNumber());
			if(idAlreadyExists) {
				throw new IdentityException(ExceptionConstants.IDENTITY_NUMBER_ALREADY_EXISTS.toString());
			}
			idRepo.saveAndFlush(IdentityDto.prepareEntity(dto));
		}
		return true;
	}
	
	public IdentityDto getById(String Id) throws IdentityException{
		boolean isIdValid=validate.validateIdentityNumber(Id);
		boolean ExistsWithId=idRepo.existsById(Id);
		if(ExistsWithId==false) {
			throw new IdentityException(ExceptionConstants.ID_NOT_FOUND.toString());
		}
		Optional<IdentityCard> IdEntityObject=idRepo.findById(Id);
		IdentityDto ans=new IdentityDto(IdEntityObject.get());
		return ans;
	}
	
	public List<IdentityDto> getAllByName(String name) throws IdentityException{
		boolean isNameValid=validate.validateName(name);
		List<IdentityCard> l=idRepo.findByName(name);
		if(l.isEmpty()) {
			throw new IdentityException(ExceptionConstants.NAME_NOT_FOUND.toString());
		}
		List<IdentityDto> ans= new ArrayList<>();
		for(IdentityCard i:l) {
			ans.add(new IdentityDto(i));
		}
		return ans;
	}
	
	public IdentityDto getByPhone(long number) throws IdentityException{
		Optional<IdentityCard> l=idRepo.findByPhoneNo(number);
		if(l.isEmpty()) {
			throw new IdentityException(ExceptionConstants.PHONE_NOT_FOUND.toString());
		}
		IdentityDto ans= new IdentityDto(l.get());
		return ans;
	}
	
	public IdentityDto updateAddress(String id,String address) throws IdentityException {
		boolean isIdValid=validate.validateIdentityNumber(id);
		boolean ExistsWithId=idRepo.existsById(id);
		if(ExistsWithId==false) {
			throw new IdentityException(ExceptionConstants.ID_NOT_FOUND.toString());
		}
		IdentityCard idEntityObject=idRepo.findById(id).get();
		idEntityObject.setAddress(address);
		idRepo.saveAndFlush(idEntityObject);
		return new IdentityDto(idEntityObject);
		
		
	}
	public String deleteById(String id) throws IdentityException{
		boolean isIdValid=validate.validateIdentityNumber(id);
		boolean ExistsWithId=idRepo.existsById(id);
		if(ExistsWithId==false) {
			throw new IdentityException(ExceptionConstants.ID_NOT_FOUND.toString());
		}
		idRepo.deleteById(id);
		return "Id Record Deleted Successfully";
	}
}
