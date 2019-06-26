package contact.application;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("valueSession2")
public class GreetingController {

	private int value=42;
	private int valueSession2=1;
	
	@ModelAttribute("value")
	public int getValue()
	{
		return value;
	}
	
	@ModelAttribute("valueSession2")
	public int getValueSession2()
	{
		return valueSession2;
	}
	
    @GetMapping("/greeting")
    public String greeting(HttpSession session, HttpServletResponse response,@CookieValue(value = "foo", defaultValue = "hello") String fooCookie,@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        session.setAttribute("valueSession", 50);
        response.addCookie(new Cookie("foo", "jihesrfkhbepijf"));
    	model.addAttribute("name", name);
    	System.out.println("salut");
        return "greeting";
    }

    @ModelAttribute("someList")
    public List<String> getSomeList(){
    	return Arrays.asList("Element 1", "Element 2", "Element 3");
    }
    
    @RequestMapping("/endsession")
    public String endSession(SessionStatus status) {
    	status.setComplete();
    	System.out.println("vidé");
    	return "redirect:greeting";
    }
    
}