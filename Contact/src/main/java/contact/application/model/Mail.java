package contact.application.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Mail implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="person_fk")
    private Person person;
	
    private String mail;

    protected Mail() {}

    public Mail(Person person, String mail) {
        this.person = person;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format(
                "Mail[id=%d, idUser='%s', Mail='%s']",
                id, person, mail);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
    
    
    
}
