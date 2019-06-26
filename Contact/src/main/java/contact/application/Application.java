package contact.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import contact.application.model.Adress;
import contact.application.model.Mail;
import contact.application.model.Person;
import contact.application.model.PersonRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			// save a couple of person
			Person temp;
			Person p=new Person("Jean", "Neige");
			Adress ad1=new Adress("address Jean 1");
			ad1.setPersons(Arrays.asList(p));
			
			Adress ad2=new Adress("address Jean 2");
			ad2.setPersons(Arrays.asList(p));
			p.setAdresses(Arrays.asList(ad1, ad2));
			
			Mail mail = new Mail(p, "jeanjean@neige.vroum");
			
			p.setMails(Arrays.asList(mail));
			
			temp = p;
			repository.save(p);
			
			p=new Person("Michmich", "Michou");
			ad1=new Adress("address Mich 1");
			ad1.setPersons(Arrays.asList(p));
			ad2=new Adress("address Mich 2");
			ad2.setPersons(Arrays.asList(p));
			p.setAdresses(Arrays.asList(ad1, ad2));
			repository.save(p);
			
			p=new Person("Jeanine", "Neige");
			ad1=new Adress("address Jeanine 1");
			ad1.setPersons(Arrays.asList(p));
			ad2=new Adress("address Jeanine 2");
			ad2.setPersons(Arrays.asList(p));
			p.setAdresses(Arrays.asList(ad1, ad2));
			repository.save(p);
			
			List<Adress> l = new ArrayList<>(temp.getAdresses());
			l.add(ad1);
			temp.setAdresses(l);
			repository.save(temp);
		};
	}

}