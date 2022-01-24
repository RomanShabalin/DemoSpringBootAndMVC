package com.roma.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.roma.springboot.entity.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
	
	/*@Query(value = "select brand from auto join auto_avenger on auto.id = auto_avenger.id_auto where id_avenger = ?1", nativeQuery = true)
	List<Auto> findAllByAvenger(Integer id);*/

}
