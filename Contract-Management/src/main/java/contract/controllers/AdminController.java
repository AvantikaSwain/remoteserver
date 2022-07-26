package contract.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import contract.models.AdminUser;
import contract.models.Supplier;
import contract.services.AdminuserService;

@Controller
public class AdminController {
	
	@Autowired AdminuserService asrv;
	
	@GetMapping("/adminlogin")
	public String contractadminlogin() {
		return "adminlogin";
	}
	
	@PostMapping("/adminlogin")
	public String validate(String userid,String pwd,RedirectAttributes ra) {
		AdminUser ad=asrv.Validate(userid, pwd);
		if(ad==null) {
			ra.addFlashAttribute("error", "Invalid username or password");
			return "redirect:/adminlogin";
		}else {
			ra.addFlashAttribute("error", "Welcome "+ad.getName());
			return "redirect:/adminlogin";
		}
	}
}
