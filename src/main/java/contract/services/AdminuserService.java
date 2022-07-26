package contract.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contract.models.AdminUser;
import contract.models.Supplier;
import contract.repos.AdminUserRepository;

@Service
public class AdminuserService {

	@Autowired AdminUserRepository repo;
	
	public void saveAdmin(AdminUser user) {
		repo.save(user);
	}
	
	public long countUser() {
		return repo.count();
	}
	
	public AdminUser Validate(String userid,String pwd) {
		Optional<AdminUser> sup=repo.findById(userid);
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
