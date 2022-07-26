package contract.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import contract.models.Supplier;
import contract.services.RequirementService;
import contract.services.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired SupplierService ssrv;
	@Autowired RequirementService rsrv;
	@Autowired HttpSession session;
	
	@GetMapping("/supplier")
	public String supplierpage(Model model) {
		Supplier sup=new Supplier();
		sup.setSupid(ssrv.generateId());
		model.addAttribute("supplier", sup);
		return "supplier";
	}

	@PostMapping("/supplier")
	public String saveSupplier(@Valid Supplier sup,BindingResult br,Model model,RedirectAttributes redirAttrs) {
		boolean valid=true;
		if(br.hasErrors()) {
			valid=false;
		}		
		if(!sup.getCpwd().equals(sup.getPwd())) {
			br.rejectValue("cpwd","error.cpwd","Password not match");
			valid=false;
		}
		
		if(!valid) {
			model.addAttribute("user", sup);
			return "supplier";
		}
		else {
			ssrv.saveSupplier(sup);
			redirAttrs.addFlashAttribute("msg", "Supplier registerd successfully");
			return "redirect:/supplier";
		}
		
	}
	
	@GetMapping("/suplogin")
	public String supplierlogin() {
		return "suplogin";
	}
	
	@PostMapping("/suplogin")
	public String validate(String userid,String pwd,RedirectAttributes ra) {
		Supplier sup=ssrv.Validate(userid, pwd);
		if(sup==null) {
			ra.addFlashAttribute("error", "Invalid username or password");
			return "redirect:/suplogin";
		}else {
			session.setAttribute("userid", userid);
			session.setAttribute("uname", sup.getName());
			session.setAttribute("role", "Supplier");
			return "redirect:/dashboard";
		}
	}
}
