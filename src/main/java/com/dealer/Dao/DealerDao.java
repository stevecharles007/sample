package com.dealer.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dealer.Entity.Dealer;
import com.dealer.Repository.DealerRepository;

@Repository
public class DealerDao {
	@Autowired
	DealerRepository dr;

	public String setDealer(Dealer d) {
		dr.save(d);
		return "Saved a dealer";
	}

	public List<Dealer> setAllDealer(List<Dealer> d) {
		return dr.saveAll(d);

	}

	public Optional<Dealer> getById(int id) {
		return dr.findById(id);
	}

	public List<Dealer> getAllDealers() {
		return dr.findAll();
	}

	public String deleteById(int id) {
		dr.deleteById(id);
		return "Deleted a dealer";
	}

	public String deleteAllVendors() {
		dr.deleteAll();
		return "Deleted all Dealers";
	}

	public String updateDealer(int a, Dealer d) {
		Dealer d1=dr.findById(a).get();
		d1.setName(d.getName());
		dr.save(d1);
		return "Updated";
	}

	public List<Dealer> getValuesDb(int a) {	
		return dr.getValuesDb(a);
	}

	public List<Dealer> getByrating(float a) {
		return dr.getByrating(a);
	}

	public List<Dealer> getByChar(String a) {
		return dr.getByChar(a);
	}

	public String getException(Dealer d) {
		dr.save(d);
		return "Successfully saved";
	}

	public List<Dealer> getByName(String name) {
		return dr.getByName(name);
		
	}

	public Optional<Dealer> findByUserId(int id) {
		
		return dr.findById(id);
	}

}
