package contract.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contract.models.Supplier;
import contract.repos.SupplierRepository;

@Service
public class SupplierService {

	@Autowired SupplierRepository repo;
	
	public void saveSupplier(Supplier sup) {
		repo.save(sup);
	}
	
	public List<Supplier> allsuppliers(){
		return repo.findAll();
	}
	
	public Supplier findSupplierById(String supid) {
		return repo.getById(supid);
	}
	
	public long countSuppliers() {
		return repo.count();
	}
	
	public String generateId() {
		return "supplier"+(repo.count()+1);
	}
	
	public Supplier Validate(String userid,String pwd) {
		Optional<Supplier> sup=repo.findById(userid);
		if(sup.isPresent()) {
			if(sup.get().getPwd().equals(pwd)) {
				return sup.get();
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
