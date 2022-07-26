package contract.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contract.models.Requirement;
import contract.repos.RequirementRepo;

@Service
public class RequirementService {

	@Autowired RequirementRepo repo;
	
	public void saveReq(Requirement req) {
		repo.save(req);
	}
	
	public List<Requirement> allreq(){
		return repo.findAll();
	}
	
	public Requirement findReq(String id) {
		return repo.getById(id);
	}
	
	public String generateId() {
		return "req"+(repo.count()+1);
	}
}
