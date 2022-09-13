package SpringBoot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/") 
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/pagina1/index.html");
		modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT); 		
		return modelAndView;
	}
	
	@GetMapping("/1")
	public ModelAndView D() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/pagina2/index.html");
		return modelAndView;
	}
	@GetMapping("/2")
	public ModelAndView E() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("testo1.html");
		return modelAndView;
	}
	
}
