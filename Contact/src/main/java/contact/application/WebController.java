package contact.application;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import contact.application.model.Person;
import contact.application.model.PersonRepository;

@Controller
public class WebController implements WebMvcConfigurer {
	PersonForm personForm;
	@Autowired
	private PersonRepository personRepository;
	
	@ModelAttribute("firstName")
	public String getName()
	{
		if (personForm==null)
			return null;
		return personForm.getFirstName();
	}

    @GetMapping("/")
    public String showForm(Model model) {
    	
    	model.addAttribute("listPersons",personRepository.findAll());
        return "list";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/list")
    public String list(Model model) {
    	
    	model.addAttribute("listPersons",personRepository.findAll());
    	
        return "list";
    }
    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable long id) {
    	
    	model.addAttribute("person",personRepository.findById(id).get());
    	
        return "details";
    }
    
    @PostMapping("/details/")
    public String detailsModifier(BindingResult bindingResult) {

    	
    	
        return "details";
    }
    
    @GetMapping("/addPerson")
    public String addPerson2(PersonForm personForm) {

      
        return "personForm";
    }
    
    @GetMapping("/addPerson/")
    public String addPerson(@Valid PersonForm personForm,BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "personForm";
        }
        this.personForm=personForm;
        Person p = new Person(personForm.getFirstName(), personForm.getLastName());
        personRepository.save(p);
        model.addAttribute("listPersons",personRepository.findAll());
        return "list";
    }
    
    @GetMapping("/results")
    public String resultsForm(Model model) {
        return "results";
    }

    
}