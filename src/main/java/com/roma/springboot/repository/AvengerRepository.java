package com.roma.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.roma.springboot.entity.Avenger;

@Repository
public interface AvengerRepository extends JpaRepository<Avenger, Integer> {
	
	/*@Override
	@Query(value = "select * from avenger order by id", nativeQuery = true)
	List<Avenger> findAll();*/

}
