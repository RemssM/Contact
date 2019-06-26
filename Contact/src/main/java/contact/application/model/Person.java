package contact.application.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person", cascade=CascadeType.ALL)
    private Collection<Mail> mails;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "ADRESSES")
    private Collection<Adress> adresses;
    
    protected Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Collection<Mail> getMails() {
		return mails;
	}

	public void setMails(Collection<Mail> mails) {
		this.mails = mails;
	}

	public Collection<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(Collection<Adress> adresses) {
		this.adresses = adresses;
	}
	
	
    
    
    
}
