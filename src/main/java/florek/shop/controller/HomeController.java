package florek.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Sklep internetowy");
		model.addAttribute("tagline", "Spring Framework");
		
		return "welcome";
	}
}
