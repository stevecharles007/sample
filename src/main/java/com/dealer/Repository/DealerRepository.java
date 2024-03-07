package com.dealer.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealer.Entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {
//	it is jpa queries 
	@Query(value="select d from Dealer d where d.id=:id1")
	List<Dealer> getValuesDb(@Param (value="id1") int id1);
	
	@Query(value="select e from Dealer e where e.rating>=:rating ")
	List<Dealer> getByrating(@Param(value="rating")float rating);
	
	@Query(value="select e from Dealer e where e.name=:name")
	List<Dealer> getByChar(@Param(value="name")String name);


	@Query(value="select d from Dealer d where d.name=:name")
	public List<Dealer> getByName(@Param(value="name")String name);

	

	
	
}
