package contact.application.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Adress implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String adress;
    
    @ManyToMany(mappedBy = "adresses", cascade=CascadeType.ALL)
    private Collection<Person> persons;
    
    protected Adress() {}

    public Adress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return String.format(
                "Mail[id=%d, Adress='%s']",
                id, adress);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
    
    
    
}
