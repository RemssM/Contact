package Contact.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Mail {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long idUser;
    private String mail;

    protected Mail() {}

    public Mail(Long idUser, String mail) {
        this.idUser = idUser;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format(
                "Mail[id=%d, idUser='%s', Mail='%s']",
                id, idUser, mail);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
    
    
    
}
