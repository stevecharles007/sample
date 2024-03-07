package com.dealer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealer.Entity.Dealer;
import com.dealer.Service.DealerService;
import com.dealer.exception.CustomRatingException;
import com.dealer.exception.IdNotFoundException;
import com.dealer.exception.nameNotFoundExcp;

@RestController
@RequestMapping(value="/Dealer")
public class DealerController {
	@Autowired
	DealerService ds;
	
	@PostMapping("/setdealer")
	public String setDealer(@RequestBody Dealer d) {
		return ds.setDealer(d);
	}
	
	@PostMapping("/setAllDealer")
	public List<Dealer> setAllDealer(@RequestBody List<Dealer> d) {
		return ds.setAllDealer(d);
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Dealer> getById(@PathVariable int id) {
		return ds.getById(id);
	}
	
	@GetMapping("/getAllDealers")
	public List<Dealer> getAllDealers() {
		return ds.getAllDealers();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return ds.deleteById(id);
	}
	
	@DeleteMapping("/deleteAllVendors")
	public String deleteAllVendors() {
		return ds.deleteAllVendors();
	}
	
	@PutMapping("/updateDealer/{a}")
	public String updateDealer(@PathVariable int a,@RequestBody Dealer d ) {
		return ds.updateDealer(a,d);
	}
	
	@GetMapping("/getValuesDb/{a}")
	public List<Dealer> getValuesDb(@PathVariable int a){
		return ds.getValuesDb(a);
	}
	@GetMapping("/getByrating/{a}")
	public List<Dealer> getByrating(@PathVariable float a) {
		return ds.getByrating(a);
	}
	
	@GetMapping("/getByChar/{a}") // getting by name
	public List<Dealer> getByChar(@PathVariable String a) {
		return ds.getByChar(a);
	}
	
	@PostMapping("/getException")
	public String getException(@RequestBody Dealer d) throws CustomRatingException{
		return ds.getException(d);
		
	}
//	exception handling
	@GetMapping(value="/getByName/{name}")
	public List<Dealer> getByName(@PathVariable String name) throws nameNotFoundExcp {
		return ds.getByName(name);
	}
//	Exception handling (by id )
	@GetMapping(value="/findByUserId/{id}")
	public Optional<Dealer> findByUserId(@PathVariable int id) throws IdNotFoundException{
		return ds.findByUserId(id);
	}
	
}

