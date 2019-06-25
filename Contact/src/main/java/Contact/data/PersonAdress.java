package Contact.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PersonAdress {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long idUser;
    private Long idAdress;

    protected PersonAdress() {}

    public PersonAdress(Long idUser, Long idAdress) {
        this.idUser = idUser;
        this.idAdress = idAdress;
    }

    @Override
    public String toString() {
        return String.format(
                "Mail[id=%d, idUser='%s', idAdress='%s']",
                id, idUser, idAdress);
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

	public Long getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(Long idAdress) {
		this.idAdress = idAdress;
	}
    
    
}
