package com.Identity.controller;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Identity.dto.IdentityDto;
import com.Identity.exceptions.IdentityException;
import com.Identity.service.IdentityService;

@RestController
@RequestMapping("/id")
public class IdentityController {

	@Autowired
	IdentityService idServ;
	
	@PostMapping("/vc/create")
	public ResponseEntity<String> createIdControllerLayerValidation(@Valid @RequestBody IdentityDto dto,Errors errors){
		//Validation Performed in Controller
		if(errors.hasErrors()) {
			String err=errors.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("-&&-"));
			return new ResponseEntity<String>(err,HttpStatus.BAD_REQUEST);
		}
		String responseFromServiceLayer = idServ.createIdValidationInController(dto);
		return ResponseEntity.ok(responseFromServiceLayer);
	
	}
	
	@PostMapping("/vs/create")
	public ResponseEntity<Boolean> createIdServiceLayerValidation(@RequestBody IdentityDto dto) throws IdentityException{
		//Validation Performed in Service Layer
		boolean result=false;
		result=idServ.createIdValidationAtServiceLayer(dto);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<IdentityDto> getById(@PathVariable("Id") String id) throws IdentityException{
		//Validation Performed in Service Layer
		IdentityDto temp=idServ.getById(id);
		return new ResponseEntity<IdentityDto>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<IdentityDto>> getByName(@PathVariable String name) throws IdentityException{
		//Validation Performed in Service Layer
		List<IdentityDto> listDto= idServ.getAllByName(name);
		return new ResponseEntity<List<IdentityDto>>(listDto,HttpStatus.OK);
	}
	
	@GetMapping("/phone/{number}")
	public IdentityDto getByPhone(@PathVariable long number) throws IdentityException{
		//Validation Performed in Service Layer
		return idServ.getByPhone(number);
	}
	
	@PutMapping("/update")
	public ResponseEntity<IdentityDto> updateAddress(@RequestBody IdentityDto dto) throws IdentityException{
		//Validation Performed in Service Layer
		String id,address;
		id=dto.getIdNumber();
		address=dto.getAddress();
		return ResponseEntity.ok(idServ.updateAddress(id, address));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteId(@PathVariable String id) throws IdentityException{
		//Validation Performed in Service Layer
		return ResponseEntity.ok(idServ.deleteById(id));
	}
}
