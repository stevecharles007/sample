package com.dealer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dealer.Dao.DealerDao;
import com.dealer.Entity.Dealer;
import com.dealer.exception.CustomRatingException;
import com.dealer.exception.IdNotFoundException;
import com.dealer.exception.nameNotFoundExcp;

@Service
public class DealerService {
	@Autowired
	DealerDao dd;

	public String setDealer(Dealer d) {
		return dd.setDealer(d);
	}

	public List<Dealer> setAllDealer(List<Dealer> d) {
		return dd.setAllDealer(d);
	}

	public Optional<Dealer> getById(int id) {
		return dd.getById(id);
	}

	public List<Dealer> getAllDealers() {
		return dd.getAllDealers();
	}

	public String deleteById(int id) {
		return dd.deleteById(id);
	}

	public String deleteAllVendors() {
		return dd.deleteAllVendors();
	}

	public String updateDealer(int a, Dealer d) {
		return dd.updateDealer(a, d);
	}

	public List<Dealer> getValuesDb(int a) {
		return dd.getValuesDb(a);
	}

	public List<Dealer> getByrating(float a) {
		return dd.getByrating(a);
	}

	public List<Dealer> getByChar(String a) {
		return dd.getByChar(a);
	}

	public String getException(Dealer d) throws CustomRatingException {
		try {
			if (d.getRating() > 0 && d.getRating() < 6) {
				return dd.getException(d);
			} else {
				throw new CustomRatingException("give rating 1 to 8");

			}
		} catch (Exception e) {
			return ("exception handled");
		}

	}

	public List<Dealer> getByName(String name) throws nameNotFoundExcp {
		if(dd.getByName(name).isEmpty()) {
			throw new nameNotFoundExcp("there is no data in this name");
		}else {
			return dd.getByName(name);
		}
		
	}

	public Optional<Dealer> findByUserId(int id) throws IdNotFoundException {
		if(dd.findByUserId(id).isEmpty()) {
			throw new IdNotFoundException("entered id is not found");
		}else {
			return dd.findByUserId(id);
		}
		
	}
	
}
