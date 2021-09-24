package com.Identity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Identity.entity.IdentityCard;

public interface IdentityRepository extends JpaRepository<IdentityCard,String>{
	List<IdentityCard> findByName(String name);
	Optional<IdentityCard> findByPhoneNo(long number);

}
