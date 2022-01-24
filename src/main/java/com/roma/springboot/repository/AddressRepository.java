package com.roma.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.roma.springboot.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	@Query(value = "insert into address_avenger (id_avenger, id_address) values (?1, ?2)", nativeQuery = true)
	void saveAddressByAvenger(Integer idAvenger, Integer idAddress);

}
